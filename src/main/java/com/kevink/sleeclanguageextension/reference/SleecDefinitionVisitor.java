package com.kevink.sleeclanguageextension.reference;

import com.kevink.sleeclanguageextension.psi.SleecDefblock;
import com.kevink.sleeclanguageextension.SleecTypes;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiRecursiveElementVisitor;

import java.util.HashSet;
import java.util.Set;

public class SleecDefinitionVisitor extends PsiRecursiveElementVisitor {
    private final Set<String> definedBools = new HashSet<>();
    private final Set<String> definedNums = new HashSet<>();
    private final Set<String> definedEvents = new HashSet<>();
    private final Set<String> definedConsts = new HashSet<>();
    private final Set<String> definedScales = new HashSet<>();
    private final Set<String> definedScaleVals = new HashSet<>();
    private boolean inDefblock = false;

    @Override
    public void visitElement(PsiElement element) {
        if (element instanceof SleecDefblock) {
            inDefblock = true;
            super.visitElement(element);
            inDefblock = false;
        } else if (inDefblock && element.getNode().getElementType() == SleecTypes.BOOL_NAME) {
            definedBools.add(element.getText());
        } else if(inDefblock && element.getNode().getElementType() == SleecTypes.NUM_NAME){
            definedNums.add(element.getText());
        } else if(inDefblock && element.getNode().getElementType() == SleecTypes.EVENT_NAME){
            definedEvents.add(element.getText());
        } else if(inDefblock && element.getNode().getElementType() == SleecTypes.CONSTANT_NAME){
            definedConsts.add(element.getText());
        }else if(inDefblock && element.getNode().getElementType() == SleecTypes.SCALAR_NAME){
            definedScales.add(element.getText());
        } else if (inDefblock && element.getNode().getElementType() == SleecTypes.SCALE_PARAM){
            definedScaleVals.add(element.getText());
        }else {
            super.visitElement(element);
        }
    }

    public Set<String> getDefinedBools() {
        return definedBools;
    }
    public Set<String> getDefinedNums() {
        return definedNums;
    }
    public Set<String> getDefinedEvents() {
        return definedEvents;
    }
    public Set<String> getDefinedConsts() {
            return definedConsts;
        }
    public Set<String> getDefinedScales() {
            return definedScales;
        }
    public Set<String> getDefinedScaleVals() {
            return definedScaleVals;
        }
}
