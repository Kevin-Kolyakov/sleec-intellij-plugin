package com.kevink.sleeclanguageextension;

import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory;
import com.intellij.openapi.options.SettingsEditor;
import com.intellij.openapi.ui.TextFieldWithBrowseButton;
import com.intellij.util.ui.FormBuilder;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class SleecSettingsEditor extends SettingsEditor<SleecRunConfiguration> {

    private final JPanel myPanel;
    private final TextFieldWithBrowseButton scriptPathField;

    public SleecSettingsEditor() {
        scriptPathField = new TextFieldWithBrowseButton();
        scriptPathField.addBrowseFolderListener("Select Script File", null, null,
                FileChooserDescriptorFactory.createSingleFileDescriptor());
        myPanel = FormBuilder.createFormBuilder()
                .addLabeledComponent("Script file", scriptPathField)
                .getPanel();
    }

    @Override
    protected void resetEditorFrom(SleecRunConfiguration sleecRunConfiguration) {
        scriptPathField.setText(sleecRunConfiguration.getScriptName());
    }

    @Override
    protected void applyEditorTo(@NotNull SleecRunConfiguration sleecRunConfiguration) {
        sleecRunConfiguration.setScriptName(scriptPathField.getText());
    }

    @NotNull
    @Override
    protected JComponent createEditor() {
        return myPanel;
    }
}
