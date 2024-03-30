package com.example.sleeclanguageextension;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public final class SleecFileType extends LanguageFileType {

    public static final SleecFileType INSTANCE = new SleecFileType();

    private SleecFileType() {
        super(SleecLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "Sleec File";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Sleec language file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "sleec";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return SleecIcons.FILE;
    }

}