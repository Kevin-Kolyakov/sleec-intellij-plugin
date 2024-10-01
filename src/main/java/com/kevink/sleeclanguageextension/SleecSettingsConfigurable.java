package com.kevink.sleeclanguageextension;

import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.util.NlsContexts;

import javax.swing.*;

public class SleecSettingsConfigurable implements Configurable {
    private JPanel myPanel;
    private JTextField pathField;

    @Override
    public JComponent createComponent() {
        return myPanel;
    }

    @Override
    public boolean isModified() {
        return !pathField.getText().equals(SleecSettings.getInstance().runnerPath);
    }

    @Override
    public void apply() {
        SleecSettings.getInstance().runnerPath = pathField.getText();
    }

    @Override
    public void reset() {
        pathField.setText(SleecSettings.getInstance().runnerPath);
    }

    @Override
    public @NlsContexts.ConfigurableName String getDisplayName() {
        return null;
    }
}
