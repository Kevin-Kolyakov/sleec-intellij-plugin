package com.example.sleeclanguageextension.finder;

import com.intellij.codeInsight.navigation.actions.GotoDeclarationHandler;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiRecursiveElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.openapi.actionSystem.DataContext;
import org.jetbrains.annotations.Nullable;
import com.example.sleeclanguageextension.SleecTypes;
import com.intellij.psi.tree.IElementType;

public class SleecGotoDeclarationHandler implements GotoDeclarationHandler {
    @Nullable
    @Override
    public PsiElement[] getGotoDeclarationTargets(@Nullable PsiElement sourceElement, int offset, Editor editor) {
        if (sourceElement == null) {
            return PsiElement.EMPTY_ARRAY;
        }

        String idText = sourceElement.getText();
        PsiFile file = sourceElement.getContainingFile();
        IElementType elementType = sourceElement.getNode().getElementType();

        // Find the first target element with the same id
           PsiElement targetElement = findFirstTargetElement(file, idText, elementType);

        if (targetElement != null && targetElement.getNode().getElementType()== SleecTypes.ID) {
            return new PsiElement[]{targetElement};
        }

        return PsiElement.EMPTY_ARRAY;
    }

    @Nullable
    private PsiElement findFirstTargetElement(PsiFile file, String idText, IElementType elementType) {
        PsiElement[] result = new PsiElement[1];
        file.accept(new PsiRecursiveElementVisitor() {
            @Override
            public void visitElement(PsiElement element) {
                if (result[0] == null && elementType.equals(element.getNode().getElementType()) && idText.equals(element.getText())) {
                    result[0] = element;
                }
                super.visitElement(element);
            }
        });
        return result[0];
    }

    @Nullable
    @Override
    public String getActionText(DataContext context) {
        return null;
    }
}
