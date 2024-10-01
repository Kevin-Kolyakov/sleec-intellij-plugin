package com.kevink.sleeclanguageextension;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;

public class SleecFile extends PsiFileBase {

    public SleecFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, SleecLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return SleecFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "Sleec File";
    }

}