package com.example.sleeclanguageextension;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.util.xmlb.XmlSerializerUtil;

public class SleecSettings implements PersistentStateComponent<SleecSettings> {
    public String runnerPath = "";

    public static SleecSettings getInstance() {
        return ServiceManager.getService(SleecSettings.class);
    }

    @Override
    public SleecSettings getState() {
        return this;
    }

    @Override
    public void loadState(SleecSettings state) {
        XmlSerializerUtil.copyBean(state, this);
    }
}

