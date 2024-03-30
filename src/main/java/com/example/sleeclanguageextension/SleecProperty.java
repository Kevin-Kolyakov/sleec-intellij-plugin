// This is a generated file. Not intended for manual editing.
package com.example.sleeclanguageextension;

import java.util.List;

import com.intellij.navigation.ItemPresentation;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SleecProperty extends SleecNamedElement {

    String getKey();

    String getValue();

    String getName();

    PsiElement setName(@NotNull String newName);

    PsiElement getNameIdentifier();

    ItemPresentation getPresentation();

}
