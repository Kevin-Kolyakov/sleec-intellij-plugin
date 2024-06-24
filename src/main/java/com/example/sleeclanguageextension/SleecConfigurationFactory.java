package com.example.sleeclanguageextension;

import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.ConfigurationType;
import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.openapi.components.BaseState;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SleecConfigurationFactory extends ConfigurationFactory {

    protected SleecConfigurationFactory(ConfigurationType type) {
        super(type);
    }

    @Override
    public @NotNull String getId() {
        return null;
    }

    @NotNull
    @Override
    public RunConfiguration createTemplateConfiguration(
            @NotNull Project project) {
        return new SleecRunConfiguration(project, this, "Demo");
    }

    @Nullable
    @Override
    public Class<? extends BaseState> getOptionsClass() {
        return SleecRunConfigurationOptions.class;
    }

}