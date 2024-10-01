package com.kevink.sleeclanguageextension.reference;
import com.kevink.sleeclanguageextension.SleecTypes;
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

        Set<String> definedBools = definitionVisitor.getDefinedBools();
        Set<String> definedNums = definitionVisitor.getDefinedNums();
        Set<String> definedEvents = definitionVisitor.getDefinedEvents();
        Set<String> definedConsts = definitionVisitor.getDefinedConsts();
        Set<String> definedScales = definitionVisitor.getDefinedScales();
        Set<String> definedScaleVals = definitionVisitor.getDefinedScaleVals();

        if (element.getNode().getElementType() == SleecTypes.TRIGGER) {
            String elementText = element.getText();
            if (!definedEvents.contains(elementText)) {
                holder.newAnnotation(HighlightSeverity.ERROR, "Undefined or incorrect type: " + elementText + " (expected event)")
                        .range(element)
                        .create();
            }
        } else if (element.getNode().getElementType() == SleecTypes.BOOL_NAME) {
            String elementText = element.getText();
            if (!definedBools.contains(elementText)) {
                holder.newAnnotation(HighlightSeverity.ERROR, "Undefined or incorrect type: " + elementText + " (expected boolean)")
                        .range(element)
                        .create();
            }
        } else if (element.getNode().getElementType() == SleecTypes.NUM_NAME) {
            String elementText = element.getText();
            if (!definedNums.contains(elementText) && !definedConsts.contains(elementText)) {
                holder.newAnnotation(HighlightSeverity.ERROR, "Undefined or incorrect type: " + elementText + " (expected numeric or constant)")
                        .range(element)
                        .create();
            }
        } else if (element.getNode().getElementType() == SleecTypes.SCALAR_NAME) {
            String elementText = element.getText();
            if (!definedScales.contains(elementText) && !definedConsts.contains(elementText) && !definedNums.contains(elementText) && !isNumeric(elementText)) {
                holder.newAnnotation(HighlightSeverity.ERROR, "Undefined or incorrect type: " + elementText)
                        .range(element)
                        .create();
            }
        } else if (element.getNode().getElementType() == SleecTypes.SCALE_PARAM) {
            String elementText = element.getText();
                if (!(definedScaleVals.contains(elementText))&& !(definedScales.contains(elementText)) && !(definedConsts.contains(elementText)) && !(definedNums.contains(elementText))&& !(isNumeric(elementText))) {
                    holder.newAnnotation(HighlightSeverity.ERROR, "Undefined or incorrect type: " + elementText + " (expected scale value or scalar or constant)")
                            .range(element)
                            .create();
                }
        }
    }
    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}


