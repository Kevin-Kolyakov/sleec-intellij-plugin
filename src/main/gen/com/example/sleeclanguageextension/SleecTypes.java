// This is a generated file. Not intended for manual editing.
package com.example.sleeclanguageextension;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.example.sleeclanguageextension.impl.*;

public interface SleecTypes {

  IElementType PROPERTY = new SleecElementType("PROPERTY");

  IElementType COMMENT = new SleecTokenType("COMMENT");
  IElementType CRLF = new SleecTokenType("CRLF");
  IElementType KEY = new SleecTokenType("KEY");
  IElementType SEPARATOR = new SleecTokenType("SEPARATOR");
  IElementType VALUE = new SleecTokenType("VALUE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == PROPERTY) {
        return new SleecPropertyImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
