package com.example.sleeclanguageextension;

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
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class PythonRun4 extends AnAction {
    String pythonExecutable = findPythonExecutable();

    private static String findPythonExecutable() {
        // Check if "python3" is available
        if (isExecutableAvailable("python3")) {
            return "python3";
        }
        // Check if "python" is available
        if (isExecutableAvailable("python")) {
            return "python";
        }
        // Neither executable is available
        return null;
    }
    private static boolean isExecutableAvailable(String executableName) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder(executableName, "--version");
            Process process = processBuilder.start();
            int exitCode = process.waitFor();
            return exitCode == 0;
        } catch (IOException | InterruptedException e) {
            return false;
        }
    }
    @Override
    public void actionPerformed(AnActionEvent e) {
        Project project = e.getProject();
        if (project == null) {
            return;
        }

        // Define what files can be selected
        FileChooserDescriptor descriptor = new FileChooserDescriptor(true, false, false, false, false, false);
        descriptor.setTitle("Select a SLEEC File");

        // Open the file chooser dialog
        VirtualFile file = FileChooser.chooseFile(descriptor, project, null);
        if (file != null) {
            // Read the file content
            Path filePath = Path.of(file.getPath());
            try {
                String content = Files.readString(filePath);

                // Get the ToolWindow instance
                ToolWindow toolWindow = ToolWindowManager.getInstance(project).getToolWindow("SleecToolWindow");
                if (toolWindow != null) {
                    SleecToolWindowPanel panel = (SleecToolWindowPanel) toolWindow.getContentManager().getContent(0).getComponent();

                    // Process the file content (e.g., call your check_concern function)
                    String response = checkConcernWithPython(content, panel);

                    // Print the response to the console
                    panel.print(processResponse(response));
                } else {
                    Messages.showErrorDialog(project, "Tool window not found", "Error");
                    return;
                }
            } catch (IOException ioException) {
                Messages.showErrorDialog(project, "Error reading file: " + ioException.getMessage(), "Error");
            }
        }
    }

    private String checkConcernWithPython(String content, SleecToolWindowPanel panel) throws IOException {
        // Create a temporary directory
        File tempDir = Files.createTempDirectory("sleec_scripts").toFile();
        tempDir.deleteOnExit();

        // List of files to copy from resources to the temporary directory
        List<String> filesToCopy = Arrays.asList(
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
                "scripts/runSleec4.py",
                "scripts/simplified.txt",
                "scripts/sleec-gramar.tx",
                "scripts/sleecFrontEnd.py",
                "scripts/SleecNorm.py",
                "scripts/sleecParser.py"
        );

        // Copy each file from resources to the temporary directory
        for (String resourcePath : filesToCopy) {
            copyResourceToDirectory(resourcePath, tempDir);
        }

        // Write content to a temporary file
        File tempContentFile = File.createTempFile("sleec_content", ".sleec", tempDir);
        try (FileWriter writer = new FileWriter(tempContentFile)) {
            writer.write(content);
        }

        // Path to the main script to run
        File mainScript = new File(tempDir, "runSleec4.py");

        // Execute the temporary Python script with the path to the content file
        ProcessBuilder processBuilder = new ProcessBuilder(pythonExecutable, mainScript.getAbsolutePath(), tempContentFile.getAbsolutePath());
        processBuilder.directory(tempDir);  // Set the working directory to the temp directory
        processBuilder.redirectErrorStream(true);
        Process process = processBuilder.start();

        StringBuilder output = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }
        }

        return output.toString();
    }

    private void copyResourceToDirectory(String resourcePath, File destinationDir) throws IOException {
        InputStream resourceStream = getClass().getClassLoader().getResourceAsStream(resourcePath);
        if (resourceStream == null) {
            throw new FileNotFoundException("Resource not found: " + resourcePath);
        }

        File destinationFile = new File(destinationDir, new File(resourcePath).getName());
        destinationFile.deleteOnExit();

        try (InputStream inStream = resourceStream;
             OutputStream outStream = new FileOutputStream(destinationFile)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inStream.read(buffer)) != -1) {
                outStream.write(buffer, 0, bytesRead);
            }
        }
    }

    private String processResponse(String response) {
        response = response.replace("\\n", "\n");
        response = response.replace("\\t", "\\");
        return response;
    }
}