package com.kevink.sleeclanguageextension;

import com.kevink.sleeclanguageextension.psi.SleecRule;
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
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SleecToolWindowPanel extends JBPanel<SleecToolWindowPanel> {
    private final Project project;
    private final JTextPane textPane;
    private final StyledDocument doc;

    public SleecToolWindowPanel(Project project, ToolWindow toolWindow) {
        this.project = project;
        this.textPane = new JTextPane();
        this.doc = textPane.getStyledDocument();

        textPane.setEditable(false); // Make the text pane read-only

        setLayout(new BorderLayout());
        add(new JBScrollPane(textPane), BorderLayout.CENTER);

        setupStyles();
    }

    private void setupStyles() {
        // Regular style
        Style defaultStyle = StyleContext.getDefaultStyleContext().getStyle(StyleContext.DEFAULT_STYLE);
        Style regular = doc.addStyle("regular", defaultStyle);
        StyleConstants.setFontFamily(defaultStyle, "JetBrains Mono");
        StyleConstants.setFontSize(defaultStyle, 12);

        // Style for keywords
        Style keywordStyle = doc.addStyle("keyword", regular);
        StyleConstants.setForeground(keywordStyle, new Color(201, 3, 201));
        StyleConstants.setBold(keywordStyle, true);

        // Style for events
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
        StyleConstants.setForeground(stringStyle, new Color(0, 128, 0));

        // Style for time conditions (e.g., 10 minutes)
        Style timeStyle = doc.addStyle("time", regular);
        StyleConstants.setForeground(timeStyle, JBColor.YELLOW);
        StyleConstants.setBold(timeStyle, true);
        StyleConstants.setBackground(timeStyle, JBColor.BLACK);

        Style numberStyle = doc.addStyle("number", regular);
        StyleConstants.setForeground(numberStyle, JBColor.YELLOW);

        Style highlightStyle = textPane.addStyle("HighlightStyle", null);
        StyleConstants.setBackground(highlightStyle, new Color(250, 248, 132));
        StyleConstants.setFontFamily(highlightStyle, "JetBrains Mono");
    }

    public void print(String text) {
        int sitConflicts = 0;
        int highlightOffset = 0;
        try {
            // Clear the current content
            doc.remove(0, doc.getLength());

            // Split the text into lines for easier processing
            String[] lines = text.split("\n");
            boolean foundInterestingMessage = false;
            boolean isConcern = false;
            Set<String> relevantMeasures;
            Set<String> relevantMeasures1;
            Set<String> eventsToCheck = new HashSet<>(); // To store all events found

            for (String line : lines) {
                // Start capturing only after "Very interesting message here" kind of gimmicky but it works
                if (line.startsWith("Very interesting message here")) {
                    foundInterestingMessage = true;
                    continue; // Skip this line, as we want to start printing from the next one
                }

                // If we've found the interesting message, print the subsequent lines
                if (foundInterestingMessage) {
                    line = line.trim(); // Trim the line to remove trailing spaces

                    // Detect if a trigger and response are mentioned and capture relevant measures
                    relevantMeasures = extractCurlyBraces(text);
                    relevantMeasures1 = extractCurlyBraces(text);

                    // Collect all events after "exists" keyword
                    if (line.contains("exists")) {
                        String event = extractEventAfterKeyword(line, "exists");
                        if (!event.isEmpty()) {
                            eventsToCheck.add(event);
                        }
                    }

                    // Collect all events after "then" or "then not"
                    if (line.contains("then ")) {
                        String event = extractEventAfterKeyword(line, "then");
                        if (!event.isEmpty()) {
                            eventsToCheck.add(event);
                        }
                    }
                    if (line.contains("when ")) {
                        String event = extractEventAfterKeyword(line, "when");
                        if (!event.isEmpty()) {
                            eventsToCheck.add(event);
                        }
                    }

                    // Check if this line is related to a concern being raised
                    if (line.contains("Concern is raised")) {
                        isConcern = true;  // Mark that a concern is being handled
                    } else if (line.contains("Situational conflict")) {
                        sitConflicts++;
                    }


                    if (isConcern) {
                        for (String event : eventsToCheck) {
                            printRulesWithEvent(event);
                        }
                        eventsToCheck.clear();
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
                    } else if ((sitConflicts == 1) && line.startsWith("at time") && line.contains("Measure")) {
                        // Record the original length of the line before any modifications
                        int originalLength = line.length();

                        // Extract the content inside Measure(...)
                        String measureContent = line.substring(line.indexOf("Measure(") + 8, line.indexOf(")")).trim();
                        String[] measureTokens = measureContent.split(", ");

                        // Create the filtered measures string
                        StringBuilder filteredMeasures1 = new StringBuilder("Measure(");

                        for (String measure : measureTokens) {
                            if (isRelevantMeasure(measure, relevantMeasures1)) {
                                filteredMeasures1.append(measure).append(", ");
                            }
                        }

                        // Remove the trailing comma and space
                        if (filteredMeasures1.length() > 8) {
                            filteredMeasures1.setLength(filteredMeasures1.length() - 2);
                        }

                        filteredMeasures1.append(")");

                        // The text that will actually be inserted includes the prefix "at time 0: "
                        String insertedText = "at time 0: " + filteredMeasures1.toString();

                        // Insert the formatted text into the document
                        insertFormattedText(insertedText);

                        // Calculate the new length (the length of the entire inserted text)
                        int newLength = insertedText.length();

                        // Calculate the difference between the original and new lengths
                        int lengthDifference = originalLength - newLength;

                        // Update the highlightOffset by adding the length difference
                        highlightOffset += lengthDifference;
                    } else {
                        insertFormattedText(line);
                    }
                }
            }

            // Highlight the specific ranges at the end of the text
            highlightWords(highlightOffset);

            textPane.setCaretPosition(doc.getLength()); // Scroll to the bottom
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }


    private String extractEventAfterKeyword(String line, String keyword) {
        Pattern pattern = Pattern.compile(keyword + "\\s+(not\\s+)?(\\w+)");
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
            return matcher.group(2); // Returns the event after "exists", "then", or "then not"
        }
        return "";
    }

    private void printRulesWithEvent(String event) throws BadLocationException {
        Set<String> rulesWithEvent = getRulesWithEvent(event);

        if (!rulesWithEvent.isEmpty() && rulesWithEvent.size() > 1) {
            String rulesText = "Rules with " + event + ": " + String.join(", ", rulesWithEvent);
            insertFormattedText(rulesText);
        } else if (!rulesWithEvent.isEmpty()) {
            printFullRules(rulesWithEvent, event);
        } else {
            insertFormattedText("No rules found with " + event);
        }
    }
    private void printFullRules(Set<String> rulesWithEvent, String event) throws BadLocationException {
        PsiFile psiFile = getPsiFileFromEditor();

        if (psiFile != null) {
            // Traverse the PSI tree to find rule definitions that correspond to the rulesWithEvent
            Collection<PsiElement> ruleElements = PsiTreeUtil.findChildrenOfType(psiFile, SleecRule.class);

            for (PsiElement ruleElement : ruleElements) {
                // Extract the full rule text
                String ruleName = getRuleName(ruleElement);

                // Check if the rule name is in the rulesWithEvent set
                if (rulesWithEvent.contains(ruleName)) {
                    // Get the full text of the rule (this assumes the ruleElement's text contains the full rule content)
                    String fullRuleText = ruleElement.getText();

                    // Insert the full rule content into the text pane
                    insertFormattedText("Rule with " + event + ": " + fullRuleText);
                }
            }
        } else {
            // If no PSI file is available, insert a message indicating that no file was found
            insertFormattedText("No PSI file found in the editor to retrieve rules.");
        }
    }

    private Set<String> getRulesWithEvent(String event) {
        Set<String> rules = new HashSet<>();

        PsiFile psiFile = getPsiFileFromEditor();
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
        return ruleElement.getText().contains(event);
    }

    private String getRuleName(PsiElement ruleElement) {
        return ruleElement.getFirstChild().getText();
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
    private boolean isRelevantMeasure(String measure, Set<String> relevantMeasures) {
        for (String relevant : relevantMeasures) {
            if (measure.contains(relevant)) {
                return true;
            }
        }
        return false;
    }

    public  Set<String> extractCurlyBraces(String text) {
        Set<String> matches = new HashSet<>();

        // Regular expression to find text within curly braces
        Pattern pattern = Pattern.compile("\\{(.*?)\\}");
        Matcher matcher = pattern.matcher(text);

        // Find all matches and add them to the set
        while (matcher.find()) {
            matches.add(matcher.group(1));
        }
        System.out.println(matches);
        return matches;
    }
    private void insertFormattedText(String line) throws BadLocationException {
        // Split line into tokens, preserving the space after the last token, if any
        line = line.replaceAll("\\\\ ", "\\\\\\\\\\\\");
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

    public void highlightWords(int highlightOffset) {
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
                    doc.setCharacterAttributes(start + 8 - highlightOffset, end - start, doc.getStyle("HighlightStyle"), false);
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
