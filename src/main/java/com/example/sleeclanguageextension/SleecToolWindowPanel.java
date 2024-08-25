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
        StyleConstants.setFontFamily(defaultStyle, "JetBrains Mono");
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

        Style numberStyle = doc.addStyle("number", regular);
        StyleConstants.setForeground(numberStyle, JBColor.YELLOW);

        Style highlightStyle = textPane.addStyle("HighlightStyle", null);
        StyleConstants.setBackground(highlightStyle, new Color(246, 246, 246)); // Set the background color to yellow (or any color you prefer)
        StyleConstants.setFontFamily(highlightStyle, "JetBrains Mono"); // Set the font to JetBrains Mono, as required

    }

    public void print(String text) {
        try {
            // Clear the current content
            doc.remove(0, doc.getLength());

            // Split the text into lines for easier processing
            String[] lines = text.split("\n");
            boolean foundInterestingMessage = false;

            for (String line : lines) {
                // Start capturing only after "Very interesting message here"
                if (line.startsWith("Very interesting message here")) {
                    foundInterestingMessage = true;
                    continue; // Skip this line, as we want to start printing from the next one
                }

                // If we've found the interesting message, print the subsequent lines
                if (foundInterestingMessage) {
                    // Trim the line to remove trailing spaces
                    //line = line.trim();

                    insertFormattedText(line);
                }
            }

            // Highlight the specific ranges at the end of the text
            highlightWords();

            textPane.setCaretPosition(doc.getLength()); // Scroll to the bottom
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }




    private void insertFormattedText(String line) throws BadLocationException {
        // Split line into tokens, preserving the space after the last token, if any
        String[] tokens = line.split("\\s+");

        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            Style style = doc.getStyle("regular");

            // Apply styles based on token content
            if (isKeyword(token)) {
                style = doc.getStyle("keyword");
            } else if (isComment(token)) {
                style = doc.getStyle("comment");
            } else if (isStringLiteral(token)) {
                style = doc.getStyle("string");
            } else if (isTimeCondition(token)) {
                style = doc.getStyle("time");
            } else if (isNumberCondition(token)) {
                style = doc.getStyle("number");
            }

            // Insert token
            doc.insertString(doc.getLength(), token, style);

            // Only add space if it's not the last token
            if (i < tokens.length - 1) {
                doc.insertString(doc.getLength(), " ", doc.getStyle("regular"));
            }
        }

        // Insert newline at the end of each line
        doc.insertString(doc.getLength(), "\n", doc.getStyle("regular"));
    }


    private boolean isNumberCondition(String token) {
        return token.matches("\\d+(\\.\\d+)?");
    }


    private boolean isKeyword(String token) {
        String[] keywords = {"when", "then", "unless", "within", "minutes", "hours", "days", "True", "False", "and", "or", "exists"};
        for (String keyword : keywords) {
            if (token.equals(keyword)) {
                return true;
            }
        }
        return false;
    }

    public void highlightWords() {
        try {
            String text = textPane.getText();  // Get the full text from the document
            // Extract the list of ranges
            int lastParenIndex = text.lastIndexOf("]");
            int listStartIndex = text.indexOf("[");

            if (listStartIndex == -1 || lastParenIndex == -1) {
                System.out.println("No valid range list found");
                return; // No valid range list found
            }

            String rangesList = text.substring(listStartIndex + 1, lastParenIndex);

            // Parse and apply the highlights
            String[] rangePairs = rangesList.split("\\), \\(");

            for (String pair : rangePairs) {
                // Remove any remaining parenthesis
                pair = pair.replace("(", "").replace(")", "");

                String[] indices = pair.split(", ");

                int start = Integer.parseInt(indices[0].trim());
                int end = Integer.parseInt(indices[1].trim());

                if (start >= 0 && end > start) {
                    doc.setCharacterAttributes(start +8, end - start, doc.getStyle("HighlightStyle"), false);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private boolean isComment(String token) {
        return token.startsWith("//");
    }

    private boolean isStringLiteral(String token) {
        return token.startsWith("\"") && token.endsWith("\"");
    }


    private boolean isTimeCondition(String token) {
        // Check if the token is a time condition like "10 minutes"
        return token.matches("\\d+\\s*(minutes|seconds|hours|days)");
    }
}
