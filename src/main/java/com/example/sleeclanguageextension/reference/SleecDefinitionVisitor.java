package com.example.sleeclanguageextension.reference;

import com.example.sleeclanguageextension.psi.SleecDefblock;
import com.example.sleeclanguageextension.SleecTypes;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiRecursiveElementVisitor;

import java.util.HashSet;
import java.util.Set;

public class SleecDefinitionVisitor extends PsiRecursiveElementVisitor {
    private final Set<String> definedDefs = new HashSet<>();
    private boolean inDefblock = false;

    @Override
    public void visitElement(PsiElement element) {
        if (element instanceof SleecDefblock) {
            inDefblock = true;
            super.visitElement(element);
            inDefblock = false;
        } else if (inDefblock && element.getNode().getElementType() == SleecTypes.ID) {
            definedDefs.add(element.getText());
        } else {
            super.visitElement(element);
        }
    }

    public Set<String> getDefinedDefs() {
        return definedDefs;
    }
}
