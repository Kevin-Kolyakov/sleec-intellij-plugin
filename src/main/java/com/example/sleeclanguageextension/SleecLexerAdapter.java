package com.example.sleeclanguageextension;

import com.intellij.lexer.FlexAdapter;

public class SleecLexerAdapter extends FlexAdapter {

    public SleecLexerAdapter() {
        super(new _SleecLexer(null));
    }

}
