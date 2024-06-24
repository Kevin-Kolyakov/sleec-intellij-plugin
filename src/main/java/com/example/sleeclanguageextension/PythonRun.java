package com.example.sleeclanguageextension;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;

import java.io.BufferedReader;
import java.io.IOException;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.vfs.VirtualFile;

import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Paths;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.fileChooser.FileChooser;
import com.intellij.openapi.fileChooser.FileChooserDescriptor;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.vfs.VirtualFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class PythonRun extends AnAction {
    @Override
    public void actionPerformed(AnActionEvent e) {
        // Define what files can be selected
        FileChooserDescriptor descriptor = new FileChooserDescriptor(true, false, false, false, false, false);
        descriptor.setTitle("Select a SLEEC File");

        // Open the file chooser dialog
        VirtualFile file = FileChooser.chooseFile(descriptor, e.getProject(), null);
        if (file != null) {
            // Read the file content
            Path filePath = Paths.get(file.getPath());
            try {
                String content = new String(Files.readAllBytes(filePath));
                // Process the file content (e.g., call your check_concern function)
                String response = checkConcernWithPython(content);
                // Display the response
                Messages.showMessageDialog(e.getProject(), response, "SLEEC Check Result", Messages.getInformationIcon());
            } catch (IOException ioException) {
                Messages.showErrorDialog(e.getProject(), "Error reading file: " + ioException.getMessage(), "Error");
            }
        }
    }

    private String checkConcernWithPython(String content) throws IOException {
        // Get the path to the Python script from resources
        String scriptContent = new String(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("scripts/runSleec.py")).readAllBytes());

        // Write the script to a temporary file
        File tempScript = File.createTempFile("runSleec", ".py");
        tempScript.deleteOnExit();
        try (FileWriter writer = new FileWriter(tempScript)) {
            writer.write(scriptContent);
        }

        // Execute the temporary Python script
        ProcessBuilder processBuilder = new ProcessBuilder("python", tempScript.getAbsolutePath(), content);
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

}






