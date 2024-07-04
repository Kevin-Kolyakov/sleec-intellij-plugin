package com.example.sleeclanguageextension;

import com.intellij.lang.ASTNode;
import com.intellij.lang.folding.FoldingBuilderEx;
import com.intellij.lang.folding.FoldingDescriptor;
import com.intellij.openapi.editor.Document;
import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.containers.ContainerUtil;
import com.example.sleeclanguageextension.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class SleecFoldingBuilder extends FoldingBuilderEx {
    @NotNull
    @Override
    public FoldingDescriptor[] buildFoldRegions(@NotNull PsiElement root, @NotNull Document document, boolean quick) {
        List<FoldingDescriptor> descriptors = new ArrayList<>();

        // Collect folding regions for defblock
        for (SleecDefblock defblock : PsiTreeUtil.findChildrenOfType(root, SleecDefblock.class)) {
            descriptors.add(new FoldingDescriptor(defblock.getNode(), defblock.getTextRange()));
        }

        // Collect folding regions for rule blocks
        for (SleecRuleBlock ruleBlock : PsiTreeUtil.findChildrenOfType(root, SleecRuleBlock.class)) {
            descriptors.add(new FoldingDescriptor(ruleBlock.getNode(), ruleBlock.getTextRange()));
        }

        // Collect folding regions for concern blocks
        for (SleecConcernBlock concernBlock : PsiTreeUtil.findChildrenOfType(root, SleecConcernBlock.class)) {
            descriptors.add(new FoldingDescriptor(concernBlock.getNode(), concernBlock.getTextRange()));
        }

        // Collect folding regions for purpose blocks
        for (SleecPurposeBlock purposeBlock : PsiTreeUtil.findChildrenOfType(root, SleecPurposeBlock.class)) {
            descriptors.add(new FoldingDescriptor(purposeBlock.getNode(), purposeBlock.getTextRange()));
        }

        return descriptors.toArray(FoldingDescriptor.EMPTY);
    }

    @Nullable
    @Override
    public String getPlaceholderText(@NotNull ASTNode node) {
        PsiElement element = node.getPsi();
        if (element instanceof SleecDefblock) {
            return "defblock...";
        } else if (element instanceof SleecRuleBlock) {
            return "rule block...";
        } else if (element instanceof SleecConcernBlock) {
            return "concern block...";
        } else if (element instanceof SleecPurposeBlock) {
            return "purpose block...";
        }
        return "...";
    }

    @Override
    public boolean isCollapsedByDefault(@NotNull ASTNode node) {
        return false;
    }
}
