package com.example.sleeclanguageextension;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PythonRun extends AnAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        String command = "python Check.py";
        System.out.println("Running command: " + command);
        try {
            // Create a process builder
            ProcessBuilder processBuilder = new ProcessBuilder(command.split(" "));
            processBuilder.redirectErrorStream(true); // Merge stdout and stderr
            Process process = processBuilder.start();

            // Capture the output of the process
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            // Read the output from the command
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Wait for the process to complete
            int exitCode = process.waitFor();
            System.out.println("Exited with code: " + exitCode);
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
