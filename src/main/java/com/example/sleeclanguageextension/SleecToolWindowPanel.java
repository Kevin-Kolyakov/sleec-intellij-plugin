package com.example.sleeclanguageextension;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.ui.JBColor;
import com.intellij.ui.components.JBPanel;
import com.intellij.ui.components.JBScrollPane;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class SleecToolWindowPanel extends JBPanel<SleecToolWindowPanel> {
    private final Project project;
    private final ToolWindow toolWindow;
    private final JTextPane textPane;
    private final StyledDocument doc;

    public SleecToolWindowPanel(Project project, ToolWindow toolWindow) {
        this.project = project;
        this.toolWindow = toolWindow;
        this.textPane = new JTextPane();
        this.doc = textPane.getStyledDocument();

        textPane.setEditable(false); // Make the text pane read-only

        setLayout(new BorderLayout());
        add(new JBScrollPane(textPane), BorderLayout.CENTER);

        setupStyles();
    }

    private void setupStyles() {
        // Regular text style
        Style defaultStyle = StyleContext.getDefaultStyleContext().getStyle(StyleContext.DEFAULT_STYLE);
        Style regular = doc.addStyle("regular", defaultStyle);
        StyleConstants.setFontFamily(defaultStyle, "Courier New");
        StyleConstants.setFontSize(defaultStyle, 12);

        // Style for keywords (e.g., when, then, unless, within)
        Style keywordStyle = doc.addStyle("keyword", regular);
        StyleConstants.setForeground(keywordStyle, new Color(201, 3, 201)); // Purple
        StyleConstants.setBold(keywordStyle, true);

        // Style for events (e.g., PatientFallen, ProvideCompanionship)
        Style eventStyle = doc.addStyle("event", regular);
        StyleConstants.setForeground(eventStyle, JBColor.RED);
        StyleConstants.setBold(eventStyle, true);

        // Style for conditions (e.g., {patientNotDeaf})
        Style conditionStyle = doc.addStyle("condition", regular);
        StyleConstants.setForeground(conditionStyle, JBColor.ORANGE);
        StyleConstants.setBold(conditionStyle, true);

        // Style for comments
        Style commentStyle = doc.addStyle("comment", regular);
        StyleConstants.setForeground(commentStyle, JBColor.GRAY);
        StyleConstants.setItalic(commentStyle, true);

        // Style for string literals
        Style stringStyle = doc.addStyle("string", regular);
        StyleConstants.setForeground(stringStyle, new Color(0, 128, 0)); // Dark green

        // Style for time conditions (e.g., 10 minutes)
        Style timeStyle = doc.addStyle("time", regular);
        StyleConstants.setForeground(timeStyle, JBColor.YELLOW);
        StyleConstants.setBold(timeStyle, true);
        StyleConstants.setBackground(timeStyle, JBColor.BLACK); // Black background to mimic highlighting
    }


    public void print(String text) {
        try {
            // Split the text into lines for easier processing
            String[] lines = text.split("\n");
            boolean inRelevantSection = false;
            boolean captureBecauseSection = false;

            for (String line : lines) {
                // Start capturing relevant sections
                if (line.startsWith("Situational conflict under situation :")) {
                    inRelevantSection = true;
                }

                // Start capturing "Because of" section
                if (line.startsWith("Because of the following SLEEC rule:")) {
                    captureBecauseSection = true;
                    inRelevantSection = true;
                }

                // Stop capturing after the relevant section ends
                if (inRelevantSection && line.startsWith("----------------------------------------------------------------------------------------------------") && !captureBecauseSection) {
                    inRelevantSection = false;
                }

                // Stop capturing after the "Because of" section ends
                if (captureBecauseSection && line.startsWith("----------------------------------------------------------------------------------------------------")) {
                    captureBecauseSection = false;
                }

                // If the line is part of the relevant sections, process and format it
                if (inRelevantSection || captureBecauseSection) {
                    String[] tokens = line.split("\\s+");

                    for (String token : tokens) {
                        Style style = doc.getStyle("regular");

                        // Apply styles based on token content
                        if (isKeyword(token)) {
                            style = doc.getStyle("keyword");
                        } else if (isEvent(token)) {
                            style = doc.getStyle("event");
                        } else if (isCondition(token)) {
                            style = doc.getStyle("condition");
                        } else if (isComment(token)) {
                            style = doc.getStyle("comment");
                        } else if (isConflict(line)) {
                            style = doc.getStyle("conflict");
                        } else if (isStringLiteral(token)) {
                            style = doc.getStyle("string");
                        } else if (isTimeCondition(token)) {
                            style = doc.getStyle("time");
                        }

                        doc.insertString(doc.getLength(), token + " ", style);
                    }
                    doc.insertString(doc.getLength(), "\n", doc.getStyle("regular"));
                }
            }

            textPane.setCaretPosition(doc.getLength()); // Scroll to the bottom
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }


    private boolean isKeyword(String token) {
        String[] keywords = {"when", "then", "unless", "within"};
        for (String keyword : keywords) {
            if (token.equals(keyword)) {
                return true;
            }
        }
        return false;
    }

    private boolean isEvent(String token) {
        // Example events used in the Sleec code
        String[] events = {"OpenCurtainRequest", "SignalOpenCurtain", "OpenCurtain", "LeavePatient", "UserFallen",
                "SupportCalled", "PatientFallen", "ProvideCompanionship", "CallSupport"};
        for (String event : events) {
            if (token.equals(event)) {
                return true;
            }
        }
        return false;
    }

    private boolean isCondition(String token) {
        // Example conditions (these should match your measure names or other conditions)
        String[] conditions = {"underDressed", "patientNotDeaf"};
        for (String condition : conditions) {
            if (token.equals(condition) || token.contains("{") && token.contains("}")) {
                return true;
            }
        }
        return false;
    }

    private boolean isComment(String token) {
        return token.startsWith("//");
    }

    private boolean isStringLiteral(String token) {
        return token.startsWith("\"") && token.endsWith("\"");
    }

    private boolean isConflict(String line) {
        // Basic check for conflict sections (you might need more complex logic based on your actual output)
        return line.contains("Conflict detected") || line.contains("UNSAT CORE") || line.contains("Situational conflict");
    }

    private boolean isTimeCondition(String token) {
        // Check if the token is a time condition like "10 minutes"
        return token.matches("\\d+\\s*(minutes|seconds|hours|days)");
    }

}
