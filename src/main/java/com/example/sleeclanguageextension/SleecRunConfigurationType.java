package com.example.sleeclanguageextension;

import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.ConfigurationTypeBase;
import com.intellij.execution.configurations.ConfigurationTypeUtil;
import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.icons.AllIcons;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.IconLoader;
import com.intellij.openapi.util.NotNullLazyValue;

public class SleecRunConfigurationType extends ConfigurationTypeBase {
    protected SleecRunConfigurationType() {
        super("SleecRunConfiguration", "Sleec", "Run Sleec Scripts",
                NotNullLazyValue.createValue(() -> IconLoader.getIcon("/icons/sleec_icon.png")));
        addFactory(new ConfigurationFactory(this) {
            @Override
            public RunConfiguration createTemplateConfiguration(Project project) {
                return new SleecRunConfiguration(project, this, "Sleec");
            }
        });
    }

    public static SleecRunConfigurationType getInstance() {
        return ConfigurationTypeUtil.findConfigurationType(SleecRunConfigurationType.class);
    }
}


