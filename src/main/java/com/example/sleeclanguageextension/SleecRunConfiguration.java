package com.example.sleeclanguageextension;

import com.intellij.execution.ExecutionException;
import com.intellij.execution.Executor;
import com.intellij.execution.configurations.*;
import com.intellij.execution.process.OSProcessHandler;
import com.intellij.execution.process.ProcessHandler;
import com.intellij.execution.process.ProcessHandlerFactory;
import com.intellij.execution.process.ProcessTerminatedListener;
import com.intellij.execution.runners.ExecutionEnvironment;
import com.intellij.openapi.fileEditor.FileDocumentManager;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.options.SettingsEditor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;

public class SleecRunConfiguration extends RunConfigurationBase<SleecRunConfigurationOptions> {
    private String scriptName;

    protected SleecRunConfiguration(Project project, ConfigurationFactory factory, String name) {
        super(project, factory, name);
    }

    public String getScriptName() {
        return scriptName;
    }

    public void setScriptName(String scriptName) {
        this.scriptName = scriptName;
    }

    @Override
    public void checkConfiguration() throws RuntimeConfigurationException {
        if (scriptName == null || scriptName.isEmpty()) {
            throw new RuntimeConfigurationException("Script file is not specified.");
        }
        if (!new File(scriptName).canExecute()) {
            throw new RuntimeConfigurationException("Script file is not executable.");
        }
    }

    @Override
    public RunProfileState getState(Executor executor, ExecutionEnvironment environment) throws ExecutionException {
        return new CommandLineState(environment) {
            @Override
            protected ProcessHandler startProcess() throws ExecutionException {
                Project project = environment.getProject();
                VirtualFile[] selectedFiles = FileEditorManager.getInstance(project).getSelectedFiles();
                if (selectedFiles.length == 0) {
                    throw new ExecutionException("No file is currently selected.");
                }
                VirtualFile file = selectedFiles[0];
                if (file == null || !file.exists()) {
                    throw new ExecutionException("Selected file does not exist.");
                }
                String filePath = file.getPath();
                String runnerPath = getScriptName();
                if (runnerPath == null || runnerPath.isEmpty()) {
                    throw new ExecutionException("Sleec runner path is not configured.");
                }
                GeneralCommandLine commandLine = new GeneralCommandLine(runnerPath, filePath);
                return new OSProcessHandler(commandLine);
            }
        };
    }

    @Override
    public @NotNull SettingsEditor<? extends RunConfiguration> getConfigurationEditor() {
        return new SleecSettingsEditor();
    }
}


