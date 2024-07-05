package com.example.sleeclanguageextension.reference;
import com.example.sleeclanguageextension.SleecTypes;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class SleecAnnotator implements Annotator {

    @Override
    public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        PsiFile file = element.getContainingFile();
        SleecDefinitionVisitor definitionVisitor = new SleecDefinitionVisitor();
        file.accept(definitionVisitor);

        Set<String> definedDefs = definitionVisitor.getDefinedDefs();

        if (element.getNode().getElementType() == SleecTypes.TRIGGER || element.getNode().getElementType() == SleecTypes.BOOL_EXP_VALUE) {
            String elementText = element.getText();
            if (!definedDefs.contains(elementText)) {
                holder.newAnnotation(HighlightSeverity.ERROR, "Undefined definition")
                        .range(element)
                        .create();
            }
        }
    }
}
