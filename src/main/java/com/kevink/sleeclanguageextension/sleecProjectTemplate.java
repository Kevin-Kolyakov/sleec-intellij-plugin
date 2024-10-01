package com.kevink.sleeclanguageextension;

import com.intellij.ide.util.projectWizard.ModuleBuilder;
import com.intellij.openapi.ui.ValidationInfo;
import com.intellij.platform.ProjectTemplate;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class sleecProjectTemplate implements ProjectTemplate {

    @NotNull
    @Override
    public String getName() {
        return "Sleec Project Template";
    }

    @Override
    public String getDescription() {
        return "A simple project template for Sleec language.";
    }

    @Override
    public Icon getIcon() {
        return null; // You can return an icon here if you have one
    }

    @Override
    public ModuleBuilder createModuleBuilder() {
        return new SleecModuleBuilder();
    }

    @Override
    public @Nullable ValidationInfo validateSettings() {
        // Add any settings validation if required
        return null;
    }
}
