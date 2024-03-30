package com.example.sleeclanguageextension;

import com.intellij.psi.tree.TokenSet;

public interface SleecTokenSets {

    TokenSet IDENTIFIERS = TokenSet.create(SleecTypes.KEY);

    TokenSet COMMENTS = TokenSet.create(SleecTypes.COMMENT);

}