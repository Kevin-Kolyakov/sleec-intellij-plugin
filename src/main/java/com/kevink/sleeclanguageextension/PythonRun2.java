package com.kevink.sleeclanguageextension;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.fileChooser.FileChooser;
import com.intellij.openapi.fileChooser.FileChooserDescriptor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowManager;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

public class PythonRun2 extends AnAction {

    private static final String TOOLWINDOW_ID = "SleecToolWindow";

    // Resource/script paths (match your src/main/resources/scripts/ layout)
    private static final String MAIN_SCRIPT_RESOURCE = "scripts/runSleec2.py";
    private static final String WORKDIR_REL = "scripts";

    // Python command selected at runtime
    private final List<String> pythonCmd = findPythonCommand();

    @Override
    public void actionPerformed(AnActionEvent e) {
        Project project = e.getProject();
        if (project == null) return;

        // 1) Ensure Python exists
        if (pythonCmd == null) {
            String msg = "Python not found. Install Python and ensure it's on PATH.";
            Messages.showErrorDialog(project, msg, "Python Not Found");
            return;
        }

        // 2) Choose file
        FileChooserDescriptor descriptor = new FileChooserDescriptor(true, false, false, false, false, false);
        descriptor.setTitle("Select a SLEEC File");
        VirtualFile file = FileChooser.chooseFile(descriptor, project, null);
        if (file == null) return;

        // 3) Get ToolWindow panel (optional)
        SleecToolWindowPanel panel = getPanel(project);

        try {
            // 4) Read selected content
            Path filePath = Paths.get(file.getPath());
            String content = Files.readString(filePath, StandardCharsets.UTF_8);

            // 5) Run python
            String response = runSleecPython(content);

            // 6) Print response
            if (panel != null) {
                panel.print(processResponse(response));
            } else {
                Messages.showInfoMessage(project, response, "Sleec Output");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            Messages.showErrorDialog(project, ex.toString(), "Run Sleec Failed");
        }
    }

    /**
     * Main pipeline:
     *  - Extract resources to temp dir, preserving directory structure
     *  - Write selected .sleec content to temp file
     *  - Run: python scripts/runSleec2.py <temp_content_file>
     *  - Capture stdout+stderr and return
     */
    private String runSleecPython(String content) throws Exception {
        // Create temp root
        Path tempRoot = Files.createTempDirectory("sleec_scripts_");
        tempRoot.toFile().deleteOnExit();

        // Resources to extract
        List<String> resourcesToCopy = Arrays.asList(
                "scripts/Analyzer/__init__.py",
                "scripts/Analyzer/abstraction.py",
                "scripts/Analyzer/analyzer.py",
                "scripts/Analyzer/CHC_interpolate.py",
                "scripts/Analyzer/COMM_NET_domain.py",
                "scripts/Analyzer/constraint_solver.py",
                "scripts/Analyzer/derivation_rule.py",
                "scripts/Analyzer/domain.py",
                "scripts/Analyzer/logic_operator.py",
                "scripts/Analyzer/proof_reader.py",
                "scripts/Analyzer/read_trace.py",
                "scripts/Analyzer/resource_type.py",
                "scripts/Analyzer/routes.py",
                "scripts/Analyzer/sleecOp.py",
                "scripts/Analyzer/template_domain.py",
                "scripts/Analyzer/template_rules.py",
                "scripts/Analyzer/test_domain.py",
                "scripts/Analyzer/test_rules.py",
                "scripts/Analyzer/trace_ult.py",
                "scripts/Analyzer/type_constructor.py",
                "scripts/Analyzer/type_query.py",
                "scripts/commandline_tool.py",
                "scripts/launch_perf_exp.py",
                "scripts/proof.txt",
                "scripts/runSleec2.py",
                "scripts/simplified.txt",
                "scripts/sleec-gramar.tx",
                "scripts/sleecFrontEnd.py",
                "scripts/SleecNorm.py",
                "scripts/sleecParser.py"
        );

        for (String resourcePath : resourcesToCopy) {
            copyResourcePreservePath(resourcePath, tempRoot);
        }

        // Write content to temp file
        Path tempContentFile = Files.createTempFile(tempRoot, "sleec_content_", ".sleec");
        Files.writeString(tempContentFile, content, StandardCharsets.UTF_8);

        // Resolve main script path
        Path mainScriptOnDisk = tempRoot.resolve(MAIN_SCRIPT_RESOURCE);
        if (!Files.exists(mainScriptOnDisk)) {
            throw new FileNotFoundException("Main script not found after extraction: " + mainScriptOnDisk);
        }

        // Build command
        List<String> cmd = new ArrayList<>();
        cmd.addAll(pythonCmd);
        cmd.add(mainScriptOnDisk.toAbsolutePath().toString());
        cmd.add(tempContentFile.toAbsolutePath().toString());

        // Run from tempRoot/scripts
        Path workDir = tempRoot.resolve(WORKDIR_REL);

        ProcessBuilder pb = new ProcessBuilder(cmd);
        pb.directory(workDir.toFile());
        pb.redirectErrorStream(true);

        Process process = pb.start();

        String output;
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(process.getInputStream(), StandardCharsets.UTF_8))) {
            output = reader.lines().collect(Collectors.joining("\n"));
        }

        int exitCode = process.waitFor();

        if (output.trim().isEmpty()) {
            output = "[INFO] Python produced no output.\n";
        }
        output += "\n\n[DEBUG] Exit code: " + exitCode + "\n";
        output += "[DEBUG] Temp root: " + tempRoot + "\n";

        return output;
    }

    private void copyResourcePreservePath(String resourcePath, Path tempRoot) throws IOException {
        InputStream in = getClass().getClassLoader().getResourceAsStream(resourcePath);
        if (in == null) throw new FileNotFoundException("Resource not found on classpath: " + resourcePath);

        Path dest = tempRoot.resolve(resourcePath);
        Files.createDirectories(dest.getParent());

        try (in; OutputStream out = Files.newOutputStream(dest,
                StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)) {
            in.transferTo(out);
        }

        dest.toFile().deleteOnExit();
    }

    /** Finds a working python command. Returns command tokens (e.g., ["python"], or ["py","-3"]) or null. */
    private static List<String> findPythonCommand() {
        boolean isWindows = System.getProperty("os.name").toLowerCase().contains("win");
        List<List<String>> candidates = new ArrayList<>();

        // Prefer your known-good python (the one where pysmt is installed)
        //candidates.add(Collections.singletonList("C:\\Python313\\python.exe"));

        if (isWindows) {
            candidates.add(Arrays.asList("py", "-3"));
            candidates.add(Arrays.asList("py", "-3.11"));
            candidates.add(Arrays.asList("py", "-3.10"));
        }

        candidates.add(Collections.singletonList("python3"));
        candidates.add(Collections.singletonList("python"));



        for (List<String> cand : candidates) {
            if (isPythonWorking(cand)) return cand;
        }
        return null;
    }

    private static boolean isPythonWorking(List<String> pythonCmd) {
        try {
            List<String> cmd = new ArrayList<>(pythonCmd);
            cmd.add("--version");
            Process p = new ProcessBuilder(cmd).redirectErrorStream(true).start();
            int exit = p.waitFor();
            return exit == 0;
        } catch (Exception ignored) {
            return false;
        }
    }

    private SleecToolWindowPanel getPanel(Project project) {
        ToolWindow toolWindow = ToolWindowManager.getInstance(project).getToolWindow(TOOLWINDOW_ID);
        if (toolWindow == null) return null;

        var cm = toolWindow.getContentManager();
        for (int i = 0; i < cm.getContentCount(); i++) {
            var c = cm.getContent(i);
            if (c == null) continue;
            var comp = c.getComponent();
            if (comp instanceof SleecToolWindowPanel) {
                return (SleecToolWindowPanel) comp;
            }
        }
        return null;
    }

    private String processResponse(String response) {
        response = response.replace("\\n", "\n");
        response = response.replace("\\t", "\\");
        return response;
    }
}