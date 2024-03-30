package com.example.sleeclanguageextension;

import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class SleecElementType extends IElementType {

    public SleecElementType(@NotNull @NonNls String debugName) {
        super(debugName, SleecLanguage.INSTANCE);
    }

}
