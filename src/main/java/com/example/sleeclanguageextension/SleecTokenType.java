package com.example.sleeclanguageextension;

import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class SleecTokenType extends IElementType {

    public SleecTokenType(@NotNull @NonNls String debugName) {
        super(debugName, SleecLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "SleecTokenType." + super.toString();
    }

}
