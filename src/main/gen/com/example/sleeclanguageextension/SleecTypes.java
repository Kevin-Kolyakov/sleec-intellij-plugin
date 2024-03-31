// This is a generated file. Not intended for manual editing.
package com.example.sleeclanguageextension;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.example.sleeclanguageextension.impl.*;

public interface SleecTypes {

  IElementType EXPR = new SleecElementType("EXPR");
  IElementType FACTORIAL_EXPR = new SleecElementType("FACTORIAL_EXPR");
  IElementType LITERAL_EXPR = new SleecElementType("LITERAL_EXPR");
  IElementType MUL_EXPR = new SleecElementType("MUL_EXPR");
  IElementType PAREN_EXPR = new SleecElementType("PAREN_EXPR");
  IElementType PLUS_EXPR = new SleecElementType("PLUS_EXPR");
  IElementType PROPERTY = new SleecElementType("PROPERTY");
  IElementType REF_EXPR = new SleecElementType("REF_EXPR");

  IElementType COMMENT = new SleecTokenType("comment");
  IElementType CONCERN_END = new SleecTokenType("concern_end");
  IElementType CONCERN_START = new SleecTokenType("concern_start");
  IElementType DEF_END = new SleecTokenType("def_end");
  IElementType DEF_START = new SleecTokenType("def_start");
  IElementType EQ = new SleecTokenType("=");
  IElementType FLOAT = new SleecTokenType("float");
  IElementType ID = new SleecTokenType("id");
  IElementType LP = new SleecTokenType("(");
  IElementType NUMBER = new SleecTokenType("number");
  IElementType OP_1 = new SleecTokenType("+");
  IElementType OP_2 = new SleecTokenType("-");
  IElementType OP_3 = new SleecTokenType("*");
  IElementType OP_4 = new SleecTokenType("/");
  IElementType OP_5 = new SleecTokenType("!");
  IElementType RP = new SleecTokenType(")");
  IElementType RULE_END = new SleecTokenType("rule_end");
  IElementType RULE_START = new SleecTokenType("rule_start");
  IElementType SEMI = new SleecTokenType(";");
  IElementType STRING = new SleecTokenType("string");
  IElementType VALUE = new SleecTokenType("value");
  IElementType KEY = new SleecTokenType("key");

  IElementType SEPARATOR = new SleecTokenType("SEPARATOR");
  IElementType ENDER = new SleecTokenType("ENDER");
  IElementType PROPERT = new SleecTokenType("PROPERT");
  IElementType PROPERTIES = new SleecTokenType("PROPERTIES");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ENDER) {
        return new SleecEnderImpl(node);
      }
      else if (type == FACTORIAL_EXPR) {
        return new SleecFactorialExprImpl(node);
      }
      else if (type == LITERAL_EXPR) {
        return new SleecLiteralExprImpl(node);
      }
      else if (type == MUL_EXPR) {
        return new SleecMulExprImpl(node);
      }
      else if (type == PAREN_EXPR) {
        return new SleecParenExprImpl(node);
      }
      else if (type == PLUS_EXPR) {
        return new SleecPlusExprImpl(node);
      }
      else if (type == PROPERT) {
        return new SleecPropertImpl(node);
      }
      else if (type == PROPERTIES) {
        return new SleecPropertiesImpl(node);
      }
      else if (type == PROPERTY) {
        return new SleecPropertyImpl(node);
      }
      else if (type == REF_EXPR) {
        return new SleecRefExprImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
