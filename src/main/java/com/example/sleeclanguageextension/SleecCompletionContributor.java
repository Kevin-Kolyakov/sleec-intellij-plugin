package com.example.sleeclanguageextension;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;

final class SleecCompletionContributor extends CompletionContributor {

    SleecCompletionContributor() {
        extend(CompletionType.BASIC, PlatformPatterns.psiElement(SleecTypes.VALUE),
                new CompletionProvider<>() {
            //TODO: Change from resultsets to keyword reference like: autocompletion of def_start at beginning of string
            //https://www.jetbrains.com/help/idea/auto-completing-code.html#smart_type_matching_completion
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               @NotNull ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        resultSet.addElement(LookupElementBuilder.create("def_start"));
                        resultSet.addElement(LookupElementBuilder.create("def_start"));
                        resultSet.addElement(LookupElementBuilder.create("event"));
                        resultSet.addElement(LookupElementBuilder.create("measure"));
                        resultSet.addElement(LookupElementBuilder.create("boolean"));
                        resultSet.addElement(LookupElementBuilder.create("def_end"));
                        resultSet.addElement(LookupElementBuilder.create("rule_start"));
                        resultSet.addElement(LookupElementBuilder.create("rule_end"));
                        resultSet.addElement(LookupElementBuilder.create("when"));
                        resultSet.addElement(LookupElementBuilder.create("then"));
                        resultSet.addElement(LookupElementBuilder.create("not"));
                        resultSet.addElement(LookupElementBuilder.create("within"));
                        resultSet.addElement(LookupElementBuilder.create("minutes"));
                        resultSet.addElement(LookupElementBuilder.create("constant"));
                        resultSet.addElement(LookupElementBuilder.create("numeric"));
                        resultSet.addElement(LookupElementBuilder.create("unless"));
                        resultSet.addElement(LookupElementBuilder.create("hours"));
                        resultSet.addElement(LookupElementBuilder.create("seconds"));
                        resultSet.addElement(LookupElementBuilder.create("days"));
                        resultSet.addElement(LookupElementBuilder.create("scale"));
                        resultSet.addElement(LookupElementBuilder.create("concern_start"));
                        resultSet.addElement(LookupElementBuilder.create("concern_end"));
                        resultSet.addElement(LookupElementBuilder.create("exists"));
                        resultSet.addElement(LookupElementBuilder.create("purpose_start"));
                        resultSet.addElement(LookupElementBuilder.create("purpose_end"));
                        resultSet.addElement(LookupElementBuilder.create("meanwhile"));
                        resultSet.addElement(LookupElementBuilder.create("and"));
                        resultSet.addElement(LookupElementBuilder.create("eventually"));
                        resultSet.addElement(LookupElementBuilder.create("else"));
                        resultSet.addElement(LookupElementBuilder.create("otherwise"));
                        resultSet.addElement(LookupElementBuilder.create("or"));

                    }
                }
        );
    }

}
