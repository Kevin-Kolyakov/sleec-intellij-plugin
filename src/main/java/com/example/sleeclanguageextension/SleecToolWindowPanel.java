package com.example.sleeclanguageextension;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.ui.components.JBPanel;
import com.intellij.ui.components.JBScrollPane;

import javax.swing.*;
import java.awt.*;

public class SleecToolWindowPanel extends JBPanel<SleecToolWindowPanel> {
    private final Project project;
    private final ToolWindow toolWindow;
    private final JTextArea textArea;

    public SleecToolWindowPanel(Project project, ToolWindow toolWindow) {
        this.project = project;
        this.toolWindow = toolWindow;
        this.textArea = new JTextArea();
        setLayout(new BorderLayout());
        add(new JBScrollPane(textArea), BorderLayout.CENTER);
    }

    public void print(String text) {
        textArea.append(text + "\n");
    }
}