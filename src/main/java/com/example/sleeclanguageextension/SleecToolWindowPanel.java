package com.example.sleeclanguageextension;

import com.example.sleeclanguageextension.psi.SleecRule;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.ui.JBColor;
import com.intellij.ui.components.JBPanel;
import com.intellij.ui.components.JBScrollPane;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
            boolean isConcern = false;
            Set<String> relevantMeasures = new HashSet<>();
            Set<String> eventsToCheck = new HashSet<>(); // To store all events found

            for (String line : lines) {
                // Start capturing only after "Very interesting message here"
                if (line.startsWith("Very interesting message here")) {
                    foundInterestingMessage = true;
                    continue; // Skip this line, as we want to start printing from the next one
                }

                // If we've found the interesting message, print the subsequent lines
                if (foundInterestingMessage) {
                    line = line.trim(); // Trim the line to remove trailing spaces

                    // Detect if a trigger and response are mentioned and capture relevant measures
                    relevantMeasures = extractCurlyBraces(text);

                    // Collect all events after "exists" keyword
                    if (line.contains("exists")) {
                        String event = extractEventAfterExists(line);
                        if (!event.isEmpty()) {
                            eventsToCheck.add(event);
                        }
                    }

                    // Check if this line is related to a concern being raised
                    if (line.contains("Concern is raised")) {
                        isConcern = true;  // Mark that a concern is being handled
                    }

                    // If the line contains a measure and it's a concern, filter and print relevant ones
                    if (isConcern && line.startsWith("at time") && line.contains("Measure")) {
                        String measureContent = line.substring(line.indexOf("Measure(") + 8, line.indexOf(")")).trim();
                        String[] measureTokens = measureContent.split(", ");
                        StringBuilder filteredMeasures = new StringBuilder("Measure(");

                        for (String measure : measureTokens) {
                            if (isRelevantMeasure(measure, relevantMeasures)) {
                                filteredMeasures.append(measure).append(", ");
                            }
                        }

                        // Remove the trailing comma and space
                        if (filteredMeasures.length() > 8) {
                            filteredMeasures.setLength(filteredMeasures.length() - 2);
                        }

                        filteredMeasures.append(")");
                        insertFormattedText("at time 0: " + filteredMeasures.toString());

                        // Reset isConcern after processing relevant measures
                        isConcern = false;
                    } else {
                        insertFormattedText(line);
                    }
                }
            }

            // Print rules for each event found
            for (String event : eventsToCheck) {
                printRulesWithEvent(event);
            }

            // Highlight the specific ranges at the end of the text
            highlightWords();

            textPane.setCaretPosition(doc.getLength()); // Scroll to the bottom
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }

    private String extractEventAfterExists(String line) {
        Pattern pattern = Pattern.compile("exists\\s+(\\w+)");
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return "";
    }

    private void printRulesWithEvent(String event) throws BadLocationException {
        // Assume we have a method to get all rule names and their corresponding triggers
        Set<String> rulesWithEvent = getRulesWithEvent(event); // This should be your logic to fetch rules containing the event

        if (!rulesWithEvent.isEmpty()) {
            String rulesText = "Rules with " + event + ": " + String.join(", ", rulesWithEvent);
            insertFormattedText(rulesText);
        }
    }

    private Set<String> getRulesWithEvent(String event) {
        Set<String> rules = new HashSet<>();

        PsiFile psiFile = getPsiFileFromEditor(); // Get the PsiFile from the editor
        if (psiFile != null) {
            // Traverse the PSI tree to find rule definitions that contain the specified event
            Collection<PsiElement> ruleElements = PsiTreeUtil.findChildrenOfType(psiFile, SleecRule.class);

            for (PsiElement ruleElement : ruleElements) {
                // Check if the rule contains the specific event
                if (containsEvent(ruleElement, event)) {
                    // Get the rule name
                    String ruleName = getRuleName(ruleElement);
                    if (ruleName != null) {
                        rules.add(ruleName);
                    }
                }
            }
        }

        return rules;
    }

    private boolean containsEvent(PsiElement ruleElement, String event) {
        // Implement logic to check if the ruleElement contains the specified event
        // This may involve traversing children elements and checking their text
        return ruleElement.getText().contains(event);
    }

    private String getRuleName(PsiElement ruleElement) {
        // Implement logic to extract the rule name from the PsiElement representing a rule
        // This will depend on your PSI structure and how rules are represented
        return ruleElement.getFirstChild().getText(); // Adjust as necessary
    }



    private PsiFile getPsiFileFromEditor() {
        if (project != null) {
            FileEditorManager fileEditorManager = FileEditorManager.getInstance(project);
            VirtualFile[] selectedFiles = fileEditorManager.getSelectedFiles();

            if (selectedFiles.length > 0) {
                return PsiManager.getInstance(project).findFile(selectedFiles[0]);
            }
        }
        return null;
    }
    // Helper method to determine if a measure is relevant
    private boolean isRelevantMeasure(String measure, Set<String> relevantMeasures) {
        for (String relevant : relevantMeasures) {
            if (measure.contains(relevant)) {
                return true;
            }
        }
        return false;
    }

    public  Set<String> extractCurlyBraces(String text) {
        // Set to store matches (ensures uniqueness)
        Set<String> matches = new HashSet<>();

        // Regular expression to find text within curly braces
        Pattern pattern = Pattern.compile("\\{(.*?)\\}");
        Matcher matcher = pattern.matcher(text);

        // Find all matches and add them to the set
        while (matcher.find()) {
            matches.add(matcher.group(1));
        }

        return matches;
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
                    doc.setCharacterAttributes(start + 8, end - start, doc.getStyle("HighlightStyle"), false);
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
