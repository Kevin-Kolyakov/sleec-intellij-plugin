package com.example.sleeclanguageextension;

import com.example.sleeclanguageextension.impl.SleecDefblockImpl;
import com.example.sleeclanguageextension.psi.SleecConcern;
import com.example.sleeclanguageextension.psi.SleecPurpose;
import com.example.sleeclanguageextension.psi.SleecRuleBlock;
import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;
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
                        PsiElement element = parameters.getPosition();
                        if (isInsideDefBlock(element)) {
                            addEvents(resultSet);
                            addMeasures(resultSet);
                            addConstants(resultSet);
                        } else if (isInsideRuleBlock(element)) {
                            addRuleSuggestions(resultSet);
                        } else if (isInsidePurposeBlock(element)) {
                            addPurposeSuggestions(resultSet);
                        } else if (isInsideConcernBlock(element)) {
                            addConcernSuggestions(resultSet);
                        }
                        if (isAfterThenClause(element)) {
                            addUnlessSuggestions(resultSet);
                        }
                        if (isAfterAndCondition(element)||isAfterUnlessCondition(element)) {
                            addAndSuggestions(resultSet);
                        }
                        if (isAfterAndOrCondition(element) || isAfterAndCondition(element)) {
                            addThenSuggestions(resultSet);
                        }

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
                        //resultSet.addElement(LookupElementBuilder.create("when"));
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
    private void addAndSuggestions(CompletionResultSet resultSet) {
        // Suggest a basic 'and' condition
        resultSet.addElement(LookupElementBuilder.create("and {Condition}")
                .withInsertHandler((context, item) -> {
                    context.getEditor().getCaretModel().moveCaretRelatively(-1, 0, false, false, true); // Position the caret inside the braces
                })
        );

        // Suggest an 'and' condition with a comparison
        resultSet.addElement(LookupElementBuilder.create("and ({Condition} = Value)")
                .withInsertHandler((context, item) -> {
                    context.getEditor().getCaretModel().moveCaretRelatively(-7, 0, false, false, true); // Position the caret inside the braces
                })
        );
    }

    private void addThenSuggestions(CompletionResultSet resultSet) {
        // Suggest a basic 'and' condition
        resultSet.addElement(LookupElementBuilder.create("then Action")
                .withInsertHandler((context, item) -> {
                    context.getEditor().getCaretModel().moveCaretRelatively(-1, 0, false, false, true); // Position the caret inside the braces
                })
        );
    }

    private void addUnlessSuggestions(CompletionResultSet resultSet) {
        // Basic unless clause suggestion
        resultSet.addElement(LookupElementBuilder.create("unless {Condition}")
                .withInsertHandler((context, item) -> {
                    context.getEditor().getCaretModel().moveCaretRelatively(-1, 0, false, false, true); // Position the caret inside the braces
                })
        );

        // unless clause with a comparison
        resultSet.addElement(LookupElementBuilder.create("unless ({Condition} = Value)")
                .withInsertHandler((context, item) -> {
                    context.getEditor().getCaretModel().moveCaretRelatively(-7, 0, false, false, true); // Position the caret inside the braces
                })
        );

        // Specific example with unless
        resultSet.addElement(LookupElementBuilder.create("unless {riskLevel} = r_low")
                .withInsertHandler((context, item) -> {
                    context.getEditor().getCaretModel().moveCaretRelatively(-7, 0, false, false, true); // Position the caret inside the braces
                })
        );

        resultSet.addElement(LookupElementBuilder.create("unless {notVisible}")
                .withInsertHandler((context, item) -> {
                    context.getEditor().getCaretModel().moveCaretRelatively(-1, 0, false, false, true); // Position the caret inside the braces
                })
        );
    }

    private boolean isInsideDefBlock(PsiElement element) {
        // Traverse up the tree to see if we are inside a DEF_BLOCK
        return !((PsiTreeUtil.getParentOfType(element, SleecRuleBlock.class) != null) || (PsiTreeUtil.getParentOfType(element, SleecConcern.class) != null) || (PsiTreeUtil.getParentOfType(element, SleecPurpose.class) != null));
    }

    private boolean isInsideRuleBlock(PsiElement element) {
        // Traverse up the tree to see if we are inside a RULE_BLOCK
        return PsiTreeUtil.getParentOfType(element, SleecRuleBlock.class) != null;
    }

    private boolean isAfterThenClause(PsiElement element) {
        PsiElement prevElement = PsiTreeUtil.prevLeaf(element);
        int wordCount = 0;

        while (prevElement != null) {
            if (!prevElement.getText().trim().isEmpty()) {
                wordCount++;
                if (wordCount == 2 && prevElement.getText().equals("then")) {
                    return true;
                }
            }
            prevElement = PsiTreeUtil.prevLeaf(prevElement);
        }
        return false;
    }
    private boolean isAfterAndCondition(PsiElement element) {
        PsiElement prevElement = PsiTreeUtil.prevLeaf(element);
        int wordCount = 0;

        while (prevElement != null) {
            if (!prevElement.getText().trim().isEmpty()) {
                wordCount++;
                if (wordCount == 2 && prevElement.getText().equals("when")) {
                    return true;
                }
            }
            prevElement = PsiTreeUtil.prevLeaf(prevElement);
        }
        return false;
    }
    private boolean isAfterAndOrCondition(PsiElement element) {
        PsiElement prevElement = PsiTreeUtil.prevLeaf(element);
        int wordCount = 0;

        while (prevElement != null) {
            if (!prevElement.getText().trim().isEmpty()) {
                wordCount++;
                if (wordCount == 2 && prevElement.getText().equals("and")) {
                    return true;
                }
            }
            prevElement = PsiTreeUtil.prevLeaf(prevElement);
        }
        return false;
    }

    private boolean isAfterUnlessCondition(PsiElement element) {
        PsiElement prevElement = PsiTreeUtil.prevLeaf(element);
        int wordCount = 0;

        while (prevElement != null) {
            if (!prevElement.getText().trim().isEmpty()) {
                wordCount++;
                if (wordCount == 4 && prevElement.getText().equals("unless")) {
                    return true;
                }
            }
            prevElement = PsiTreeUtil.prevLeaf(prevElement);
        }
        return false;
    }

    private void addRuleSuggestions(CompletionResultSet resultSet) {

        // Basic rule template without RuleName
        resultSet.addElement(LookupElementBuilder.create("when Trigger then Response")
                .withInsertHandler((context, item) -> {
                    context.getEditor().getCaretModel().moveCaretRelatively(-17, 0, false, false, true); // Position the caret after 'when'
                })
        );

        // Rule with a simple condition
        resultSet.addElement(LookupElementBuilder.create("when Trigger and {Condition} then Response")
                .withInsertHandler((context, item) -> {
                    context.getEditor().getCaretModel().moveCaretRelatively(-28, 0, false, false, true); // Position the caret after 'when'
                })
        );

        // Rule with a comparison condition
        resultSet.addElement(LookupElementBuilder.create("when Trigger and ({Condition} = Value) then Response")
                .withInsertHandler((context, item) -> {
                    context.getEditor().getCaretModel().moveCaretRelatively(-37, 0, false, false, true); // Position the caret after 'when'
                })
        );

        // Rule with multiple conditions
        resultSet.addElement(LookupElementBuilder.create("when Trigger and ({Condition1} and {Condition2}) then Response")
                .withInsertHandler((context, item) -> {
                    context.getEditor().getCaretModel().moveCaretRelatively(-47, 0, false, false, true); // Position the caret after 'when'
                })
        );

//        // Specific condition templates
//        resultSet.addElement(LookupElementBuilder.create("and {riskLevel} = r_low")
//                .withInsertHandler((context, item) -> {
//                    context.getEditor().getCaretModel().moveCaretRelatively(-10, 0, false, false, true); // Position the caret after 'when'
//                })
//        );

        resultSet.addElement(LookupElementBuilder.create("when {notVisible} then StopAction")
                .withInsertHandler((context, item) -> {
                    context.getEditor().getCaretModel().moveCaretRelatively(-12, 0, false, false, true); // Position the caret after 'when'
                })
        );

        resultSet.addElement(LookupElementBuilder.create("when Trigger and ({Condition} = true) then InformUserThisIsAgentnotHuman")
                .withInsertHandler((context, item) -> {
                    context.getEditor().getCaretModel().moveCaretRelatively(-37, 0, false, false, true); // Position the caret after 'when'
                })
        );

        resultSet.addElement(LookupElementBuilder.create("when Trigger then (if {Condition1} then Action1)")
                .withInsertHandler((context, item) -> {
                    context.getEditor().getCaretModel().moveCaretRelatively(-28, 0, false, false, true); // Position the caret after 'when'
                })
        );
    }

    private boolean isInsidePurposeBlock(PsiElement element) {
        return PsiTreeUtil.getParentOfType(element, SleecPurpose.class) != null;
    }

    private boolean isInsideConcernBlock(PsiElement element) {
        return PsiTreeUtil.getParentOfType(element, SleecConcern.class) != null;
    }

    private void addPurposeSuggestions(CompletionResultSet resultSet) {
        // Suggest a basic purpose template
        resultSet.addElement(LookupElementBuilder.create("when Trigger then Action")
                .withInsertHandler((context, item) -> {
                    context.getEditor().getCaretModel().moveCaretRelatively(-12, 0, false, false, true);
                })
        );

        // Purpose with a condition
        resultSet.addElement(LookupElementBuilder.create("when Trigger and {Condition} then Action")
                .withInsertHandler((context, item) -> {
                    context.getEditor().getCaretModel().moveCaretRelatively(-23, 0, false, false, true);
                })
        );

        // Purpose with multiple conditions
        resultSet.addElement(LookupElementBuilder.create("when Trigger and ({Condition1} and {Condition2}) then Action")
                .withInsertHandler((context, item) -> {
                    context.getEditor().getCaretModel().moveCaretRelatively(-33, 0, false, false, true);
                })
        );

        // Specific purpose condition
        resultSet.addElement(LookupElementBuilder.create("when {sensitiveInformation} exists then SecureData")
                .withInsertHandler((context, item) -> {
                    context.getEditor().getCaretModel().moveCaretRelatively(-30, 0, false, false, true);
                })
        );

        resultSet.addElement(LookupElementBuilder.create("when {userAssent} = true then ProceedWithAction")
                .withInsertHandler((context, item) -> {
                    context.getEditor().getCaretModel().moveCaretRelatively(-28, 0, false, false, true);
                })
        );
    }

    private void addConcernSuggestions(CompletionResultSet resultSet) {
        // Suggest a basic concern template
        resultSet.addElement(LookupElementBuilder.create("when Trigger then MitigateRisk")
                .withInsertHandler((context, item) -> {
                    context.getEditor().getCaretModel().moveCaretRelatively(-14, 0, false, false, true);
                })
        );

        // Concern with a condition
        resultSet.addElement(LookupElementBuilder.create("when Trigger and {Condition} then MitigateRisk")
                .withInsertHandler((context, item) -> {
                    context.getEditor().getCaretModel().moveCaretRelatively(-25, 0, false, false, true);
                })
        );

        // Concern with multiple conditions
        resultSet.addElement(LookupElementBuilder.create("when Trigger and ({Condition1} and {Condition2}) then MitigateRisk")
                .withInsertHandler((context, item) -> {
                    context.getEditor().getCaretModel().moveCaretRelatively(-35, 0, false, false, true);
                })
        );

        // Specific concern condition
        resultSet.addElement(LookupElementBuilder.create("and {unauthorizedAccess} then AlertSecurity")
                .withInsertHandler((context, item) -> {
                    context.getEditor().getCaretModel().moveCaretRelatively(-28, 0, false, false, true);
                })
        );

        resultSet.addElement(LookupElementBuilder.create("and {healthRisk} = high then ActivateEmergencyProtocol")
                .withInsertHandler((context, item) -> {
                    context.getEditor().getCaretModel().moveCaretRelatively(-34, 0, false, false, true);
                })
        );
    }


}
