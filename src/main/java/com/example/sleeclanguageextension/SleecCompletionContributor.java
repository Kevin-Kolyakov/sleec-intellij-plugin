package com.example.sleeclanguageextension;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;

public class SleecCompletionContributor extends CompletionContributor {
    public SleecCompletionContributor() {
        extend(CompletionType.BASIC, PlatformPatterns.psiElement().withLanguage(SleecLanguage.INSTANCE),
                new CompletionProvider<CompletionParameters>() {
                    @Override
                    protected void addCompletions(@NotNull CompletionParameters parameters, @NotNull ProcessingContext context, @NotNull CompletionResultSet resultSet) {
                        // Keywords
                        resultSet.addElement(LookupElementBuilder.create("def_start"));
                        resultSet.addElement(LookupElementBuilder.create("def_end"));
                        resultSet.addElement(LookupElementBuilder.create("rule_start"));
                        resultSet.addElement(LookupElementBuilder.create("rule_end"));
                        resultSet.addElement(LookupElementBuilder.create("concern_start"));
                        resultSet.addElement(LookupElementBuilder.create("concern_end"));
                        resultSet.addElement(LookupElementBuilder.create("purpose_start"));
                        resultSet.addElement(LookupElementBuilder.create("purpose_end"));

                        // Keywords for rules
                        resultSet.addElement(LookupElementBuilder.create("when"));
                        resultSet.addElement(LookupElementBuilder.create("unless"));
                        resultSet.addElement(LookupElementBuilder.create("then"));
                        resultSet.addElement(LookupElementBuilder.create("unless"));
                        resultSet.addElement(LookupElementBuilder.create("eventually"));
                        resultSet.addElement(LookupElementBuilder.create("within"));
                        resultSet.addElement(LookupElementBuilder.create("and"));
                        resultSet.addElement(LookupElementBuilder.create("or"));
                        resultSet.addElement(LookupElementBuilder.create("not"));
                        resultSet.addElement(LookupElementBuilder.create("exists"));
                        resultSet.addElement(LookupElementBuilder.create("while"));
                        resultSet.addElement(LookupElementBuilder.create("meanwhile"));
                        resultSet.addElement(LookupElementBuilder.create("otherwise"));
                        resultSet.addElement(LookupElementBuilder.create("else"));

                        // Boolean literals
                        resultSet.addElement(LookupElementBuilder.create("true"));
                        resultSet.addElement(LookupElementBuilder.create("false"));

                        // Sample events and measures from the example
                        addEvents(resultSet);
                        addMeasures(resultSet);
                        addConstants(resultSet);
                    }

                    private void addEvents(CompletionResultSet resultSet) {
                            resultSet.addElement(LookupElementBuilder.create("event"));
                    }

                    private void addMeasures(CompletionResultSet resultSet) {
                            resultSet.addElement(LookupElementBuilder.create("measure"));
                    }

                    private void addConstants(CompletionResultSet resultSet) {
                            resultSet.addElement(LookupElementBuilder.create("constant"));
                    }
                });
    }
}
