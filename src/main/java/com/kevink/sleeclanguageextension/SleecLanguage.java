package com.kevink.sleeclanguageextension;

import com.intellij.lang.Language;

public class SleecLanguage extends Language {

    public static final SleecLanguage INSTANCE = new SleecLanguage();

    private SleecLanguage() {
        super("sleec");
    }

}