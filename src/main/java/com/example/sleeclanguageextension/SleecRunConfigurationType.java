package com.example.sleeclanguageextension;

import com.intellij.execution.configurations.ConfigurationTypeBase;
import com.intellij.icons.AllIcons;
import com.intellij.openapi.util.NotNullLazyValue;

final class SleecRunConfigurationType extends ConfigurationTypeBase {

    static final String ID = "DemoRunConfiguration";

    SleecRunConfigurationType() {
        super(ID, "Demo", "Demo run configuration type",
                NotNullLazyValue.createValue(() -> AllIcons.Nodes.Console));
        addFactory(new SleecConfigurationFactory(this));
    }

}
