// This is a generated file. Not intended for manual editing.
package com.example.sleeclanguageextension;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.example.sleeclanguageextension.SleecTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class SleecParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, EXTENDS_SETS_);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return root(b, l + 1);
  }

  public static final TokenSet[] EXTENDS_SETS_ = new TokenSet[] {
    create_token_set_(EXPR, FACTORIAL_EXPR, LITERAL_EXPR, MUL_EXPR,
      PAREN_EXPR, PLUS_EXPR, REF_EXPR),
  };

  /* ********************************************************** */
  // def_end
  public static boolean ender(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ender")) return false;
    if (!nextTokenIs(b, DEF_END)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DEF_END);
    exit_section_(b, m, ENDER, r);
    return r;
  }

  /* ********************************************************** */
  // factor plus_expr *
  public static boolean expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, EXPR, "<expression>");
    r = factor(b, l + 1);
    r = r && expr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // plus_expr *
  private static boolean expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!plus_expr(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "expr_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // primary mul_expr *
  static boolean factor(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "factor")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = primary(b, l + 1);
    r = r && factor_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // mul_expr *
  private static boolean factor_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "factor_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!mul_expr(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "factor_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // '!'
  public static boolean factorial_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "factorial_expr")) return false;
    if (!nextTokenIs(b, "<expression>", OP_5)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _LEFT_, FACTORIAL_EXPR, "<expression>");
    r = consumeToken(b, OP_5);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // number | string | float
  public static boolean literal_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literal_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LITERAL_EXPR, "<expression>");
    r = consumeToken(b, NUMBER);
    if (!r) r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, FLOAT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // mul_op primary
  public static boolean mul_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mul_expr")) return false;
    if (!nextTokenIs(b, "<expression>", OP_3, OP_4)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _LEFT_, MUL_EXPR, "<expression>");
    r = mul_op(b, l + 1);
    r = r && primary(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '*'|'/'
  static boolean mul_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mul_op")) return false;
    if (!nextTokenIs(b, "", OP_3, OP_4)) return false;
    boolean r;
    r = consumeToken(b, OP_3);
    if (!r) r = consumeToken(b, OP_4);
    return r;
  }

  /* ********************************************************** */
  // '(' expr ')'
  public static boolean paren_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paren_expr")) return false;
    if (!nextTokenIs(b, "<expression>", LP)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, PAREN_EXPR, "<expression>");
    r = consumeToken(b, LP);
    p = r; // pin = 1
    r = r && report_error_(b, expr(b, l + 1));
    r = p && consumeToken(b, RP) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // plus_op factor
  public static boolean plus_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "plus_expr")) return false;
    if (!nextTokenIs(b, "<expression>", OP_1, OP_2)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _LEFT_, PLUS_EXPR, "<expression>");
    r = plus_op(b, l + 1);
    r = r && factor(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '+'|'-'
  static boolean plus_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "plus_op")) return false;
    if (!nextTokenIs(b, "", OP_1, OP_2)) return false;
    boolean r;
    r = consumeToken(b, OP_1);
    if (!r) r = consumeToken(b, OP_2);
    return r;
  }

  /* ********************************************************** */
  // primary_inner factorial_expr ?
  static boolean primary(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primary")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = primary_inner(b, l + 1);
    r = r && primary_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // factorial_expr ?
  private static boolean primary_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primary_1")) return false;
    factorial_expr(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // literal_expr | ref_expr | paren_expr
  static boolean primary_inner(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primary_inner")) return false;
    boolean r;
    r = literal_expr(b, l + 1);
    if (!r) r = ref_expr(b, l + 1);
    if (!r) r = paren_expr(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // starter * properties* ender
  public static boolean propert(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "propert")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PROPERT, "<propert>");
    r = propert_0(b, l + 1);
    r = r && propert_1(b, l + 1);
    r = r && ender(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // starter *
  private static boolean propert_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "propert_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!starter(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "propert_0", c)) break;
    }
    return true;
  }

  // properties*
  private static boolean propert_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "propert_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!properties(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "propert_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // id '=' expr ';'
  public static boolean properties(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "properties")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, PROPERTIES, null);
    r = consumeTokens(b, 2, ID, EQ);
    p = r; // pin = 2
    r = r && report_error_(b, expr(b, l + 1));
    r = p && consumeToken(b, SEMI) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // !<<eof>> propert*
  public static boolean property(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, PROPERTY, "<property>");
    r = property_0(b, l + 1);
    p = r; // pin = 1
    r = r && property_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // !<<eof>>
  private static boolean property_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !eof(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // propert*
  private static boolean property_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!propert(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "property_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // !(';' | id '=')
  static boolean property_recover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_recover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !property_recover_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ';' | id '='
  private static boolean property_recover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_recover_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SEMI);
    if (!r) r = parseTokens(b, 0, ID, EQ);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // id
  public static boolean ref_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ref_expr")) return false;
    if (!nextTokenIs(b, "<expression>", ID)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, REF_EXPR, "<expression>");
    r = consumeToken(b, ID);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // root_item *
  static boolean root(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "root")) return false;
    while (true) {
      int c = current_position_(b);
      if (!root_item(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "root", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // property
  static boolean root_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "root_item")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_);
    r = property(b, l + 1);
    exit_section_(b, l, m, r, false, SleecParser::property_recover);
    return r;
  }

  /* ********************************************************** */
  // def_start|rule_start|concern_start
  static boolean starter(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "starter")) return false;
    boolean r;
    r = consumeToken(b, DEF_START);
    if (!r) r = consumeToken(b, RULE_START);
    if (!r) r = consumeToken(b, CONCERN_START);
    return r;
  }

}
