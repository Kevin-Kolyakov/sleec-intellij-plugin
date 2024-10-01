package com.kevink.sleeclanguageextension;

import com.intellij.openapi.module.ModuleType;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class SleecModuleType extends ModuleType<SleecModuleBuilder> {

    private static final String ID = "SLEEC_MODULE";

    protected SleecModuleType() {
        super(ID);
    }

    @NotNull
    public static SleecModuleType getInstance() {
        return new SleecModuleType();
    }

    @NotNull
    @Override
    public SleecModuleBuilder createModuleBuilder() {
        return new SleecModuleBuilder();
    }

    @NotNull
    @Override
    public String getName() {
        return "Sleec Module";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Module type for Sleec language.";
    }

    @Override
    public Icon getNodeIcon(boolean isOpened) {
        return null; // You can return an icon here if you have one
    }
}
