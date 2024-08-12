package com.example.sleeclanguageextension;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.util.ProcessingContext;
import com.intellij.psi.PsiFile;
import com.example.sleeclanguageextension.reference.SleecDefinitionVisitor;
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

                        // Generic grammar suggestions
                        resultSet.addElement(LookupElementBuilder.create("event"));
                        resultSet.addElement(LookupElementBuilder.create("measure"));
                        resultSet.addElement(LookupElementBuilder.create("constant"));
                        resultSet.addElement(LookupElementBuilder.create("boolean"));
                        resultSet.addElement(LookupElementBuilder.create("scale"));
                        resultSet.addElement(LookupElementBuilder.create("numeric"));
                        resultSet.addElement(LookupElementBuilder.create("true"));
                        resultSet.addElement(LookupElementBuilder.create("false"));
                        resultSet.addElement(LookupElementBuilder.create("when"));
                        resultSet.addElement(LookupElementBuilder.create("then"));
                        resultSet.addElement(LookupElementBuilder.create("unless"));
                        resultSet.addElement(LookupElementBuilder.create("and"));
                        resultSet.addElement(LookupElementBuilder.create("or"));
                        resultSet.addElement(LookupElementBuilder.create("not"));
                        resultSet.addElement(LookupElementBuilder.create("exists"));
                        resultSet.addElement(LookupElementBuilder.create("within"));
                        resultSet.addElement(LookupElementBuilder.create("eventually"));
                        resultSet.addElement(LookupElementBuilder.create("while"));
                        resultSet.addElement(LookupElementBuilder.create("meanwhile"));
                        resultSet.addElement(LookupElementBuilder.create("otherwise"));
                        resultSet.addElement(LookupElementBuilder.create("else"));

                        // Operators
                        resultSet.addElement(LookupElementBuilder.create("+"));
                        resultSet.addElement(LookupElementBuilder.create("-"));
                        resultSet.addElement(LookupElementBuilder.create("*"));
                        resultSet.addElement(LookupElementBuilder.create("/"));
                        resultSet.addElement(LookupElementBuilder.create("<"));
                        resultSet.addElement(LookupElementBuilder.create(">"));
                        resultSet.addElement(LookupElementBuilder.create("="));
                        resultSet.addElement(LookupElementBuilder.create("<="));
                        resultSet.addElement(LookupElementBuilder.create(">="));
                        resultSet.addElement(LookupElementBuilder.create("<>"));

                        // Sample events and measures from the example
                        addEvents(resultSet);
                        addMeasures(resultSet);
                        addConstants(resultSet);

                        // Add previously defined variables
                        addDefinedVariables(parameters, resultSet);
                    }

                    private void addEvents(CompletionResultSet resultSet) {
                        // Suggest event declaration format
                        resultSet.addElement(LookupElementBuilder.create("event EventName"));
                    }

                    private void addMeasures(CompletionResultSet resultSet) {
                        // Suggest measure declaration formats
                        resultSet.addElement(LookupElementBuilder.create("measure MeasureName: boolean"));
                        resultSet.addElement(LookupElementBuilder.create("measure MeasureName: scale(param1, param2, ...)"));
                        resultSet.addElement(LookupElementBuilder.create("measure MeasureName: numeric"));
                    }

                    private void addConstants(CompletionResultSet resultSet) {
                        // Suggest constant declaration format
                        resultSet.addElement(LookupElementBuilder.create("constant ConstantName = value"));
                    }

                    private void addDefinedVariables(@NotNull CompletionParameters parameters, @NotNull CompletionResultSet resultSet) {
                        PsiFile file = parameters.getOriginalFile();
                        SleecDefinitionVisitor visitor = new SleecDefinitionVisitor();
                        file.accept(visitor);

                        visitor.getDefinedBools().forEach(var -> resultSet.addElement(LookupElementBuilder.create(var)));
                        visitor.getDefinedNums().forEach(var -> resultSet.addElement(LookupElementBuilder.create(var)));
                        visitor.getDefinedEvents().forEach(var -> resultSet.addElement(LookupElementBuilder.create(var)));
                        visitor.getDefinedConsts().forEach(var -> resultSet.addElement(LookupElementBuilder.create(var)));
                        visitor.getDefinedScales().forEach(var -> resultSet.addElement(LookupElementBuilder.create(var)));
                        visitor.getDefinedScaleVals().forEach(var -> resultSet.addElement(LookupElementBuilder.create(var)));
                    }
                });
    }
}
