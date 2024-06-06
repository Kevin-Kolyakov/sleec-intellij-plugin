package com.example.sleeclanguageextension;

import com.intellij.ide.util.projectWizard.WizardContext;
import com.intellij.platform.ProjectTemplate;
import com.intellij.platform.ProjectTemplatesFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SleecTemplatesFactory extends ProjectTemplatesFactory {

    @Override
    public String @NotNull [] getGroups() {
        return new String[]{"Sleec Templates"};
    }

    @Override
    public ProjectTemplate @NotNull [] createTemplates(@Nullable String group, @NotNull WizardContext context) {
        if ("Sleec Templates".equals(group)) {
            return new ProjectTemplate[]{new sleecProjectTemplate()};
        }
        return new ProjectTemplate[0];
    }
}
