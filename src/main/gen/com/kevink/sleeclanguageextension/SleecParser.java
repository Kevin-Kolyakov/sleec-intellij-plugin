// This is a generated file. Not intended for manual editing.
package com.kevink.sleeclanguageextension;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.kevink.sleeclanguageextension.SleecTypes.*;
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
    b = adapt_builder_(t, b, this, null);
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

  /* ********************************************************** */
  // otherwise InnerResponse
  public static boolean Alternative(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Alternative")) return false;
    if (!nextTokenIs(b, OTHERWISE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OTHERWISE);
    r = r && InnerResponse(b, l + 1);
    exit_section_(b, m, ALTERNATIVE, r);
    return r;
  }

  /* ********************************************************** */
  // "+" | "-" | "*"
  public static boolean BinaryArth(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BinaryArth")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BINARY_ARTH, "<binary arth>");
    r = consumeToken(b, OP_1);
    if (!r) r = consumeToken(b, OP_2);
    if (!r) r = consumeToken(b, OP_3);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ScalarBinaryOp | BoolBinaryOp | NumericalOp
  public static boolean BinaryOp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BinaryOp")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BINARY_OP, "<binary op>");
    r = ScalarBinaryOp(b, l + 1);
    if (!r) r = BoolBinaryOp(b, l + 1);
    if (!r) r = NumericalOp(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "(" BoolExp BoolOp BoolExp ")"
  public static boolean BoolBinaryOp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BoolBinaryOp")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BOOL_BINARY_OP, "<bool binary op>");
    r = consumeToken(b, "(");
    r = r && BoolExp(b, l + 1);
    r = r && BoolOp(b, l + 1);
    r = r && BoolExp(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // Negation | BinaryOp | BoolTerminal
  public static boolean BoolExp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BoolExp")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BOOL_EXP, "<bool exp>");
    r = Negation(b, l + 1);
    if (!r) r = BinaryOp(b, l + 1);
    if (!r) r = BoolTerminal(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // measure BoolName Colon BooleanRule
  public static boolean BoolMeasure(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BoolMeasure")) return false;
    if (!nextTokenIs(b, MEASURE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, BOOL_MEASURE, null);
    r = consumeToken(b, MEASURE);
    r = r && BoolName(b, l + 1);
    p = r; // pin = 2
    r = r && report_error_(b, Colon(b, l + 1));
    r = p && BooleanRule(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // measure_id
  public static boolean BoolName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BoolName")) return false;
    if (!nextTokenIs(b, MEASURE_ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MEASURE_ID);
    exit_section_(b, m, BOOL_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // and | or
  public static boolean BoolOp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BoolOp")) return false;
    if (!nextTokenIs(b, "<bool op>", AND, OR)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BOOL_OP, "<bool op>");
    r = consumeToken(b, AND);
    if (!r) r = consumeToken(b, OR);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "{" BoolName "}" | BoolValue
  public static boolean BoolTerminal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BoolTerminal")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BOOL_TERMINAL, "<bool terminal>");
    r = BoolTerminal_0(b, l + 1);
    if (!r) r = BoolValue(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // "{" BoolName "}"
  private static boolean BoolTerminal_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BoolTerminal_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "{");
    r = r && BoolName(b, l + 1);
    r = r && consumeToken(b, "}");
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // true | false
  public static boolean BoolValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BoolValue")) return false;
    if (!nextTokenIs(b, "<bool value>", FALSE, TRUE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BOOL_VALUE, "<bool value>");
    r = consumeToken(b, TRUE);
    if (!r) r = consumeToken(b, FALSE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // boolean
  public static boolean BooleanRule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BooleanRule")) return false;
    if (!nextTokenIs(b, BOOLEAN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BOOLEAN);
    exit_section_(b, m, BOOLEAN_RULE, r);
    return r;
  }

  /* ********************************************************** */
  // ":"
  public static boolean Colon(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Colon")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COLON, "<colon>");
    r = consumeToken(b, ":");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ConcernName "exists" Trigger ("and" MBoolExpr)? ("while" ExtendedResponse)? (meanwhile '(' Headless_Concern ')' )? |
  //     ConcernName "when" Trigger ("and" MBoolExpr)? ("then" ExtendedResponse)? (meanwhile '(' Headless_Concern ')' )?
  public static boolean Concern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Concern")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONCERN, "<concern>");
    r = Concern_0(b, l + 1);
    if (!r) r = Concern_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ConcernName "exists" Trigger ("and" MBoolExpr)? ("while" ExtendedResponse)? (meanwhile '(' Headless_Concern ')' )?
  private static boolean Concern_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Concern_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ConcernName(b, l + 1);
    r = r && consumeToken(b, EXISTS);
    r = r && Trigger(b, l + 1);
    r = r && Concern_0_3(b, l + 1);
    r = r && Concern_0_4(b, l + 1);
    r = r && Concern_0_5(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ("and" MBoolExpr)?
  private static boolean Concern_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Concern_0_3")) return false;
    Concern_0_3_0(b, l + 1);
    return true;
  }

  // "and" MBoolExpr
  private static boolean Concern_0_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Concern_0_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, AND);
    r = r && MBoolExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ("while" ExtendedResponse)?
  private static boolean Concern_0_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Concern_0_4")) return false;
    Concern_0_4_0(b, l + 1);
    return true;
  }

  // "while" ExtendedResponse
  private static boolean Concern_0_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Concern_0_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, WHILE);
    r = r && ExtendedResponse(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (meanwhile '(' Headless_Concern ')' )?
  private static boolean Concern_0_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Concern_0_5")) return false;
    Concern_0_5_0(b, l + 1);
    return true;
  }

  // meanwhile '(' Headless_Concern ')'
  private static boolean Concern_0_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Concern_0_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MEANWHILE);
    r = r && consumeToken(b, "(");
    r = r && Headless_Concern(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // ConcernName "when" Trigger ("and" MBoolExpr)? ("then" ExtendedResponse)? (meanwhile '(' Headless_Concern ')' )?
  private static boolean Concern_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Concern_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ConcernName(b, l + 1);
    r = r && consumeToken(b, WHEN);
    r = r && Trigger(b, l + 1);
    r = r && Concern_1_3(b, l + 1);
    r = r && Concern_1_4(b, l + 1);
    r = r && Concern_1_5(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ("and" MBoolExpr)?
  private static boolean Concern_1_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Concern_1_3")) return false;
    Concern_1_3_0(b, l + 1);
    return true;
  }

  // "and" MBoolExpr
  private static boolean Concern_1_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Concern_1_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, AND);
    r = r && MBoolExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ("then" ExtendedResponse)?
  private static boolean Concern_1_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Concern_1_4")) return false;
    Concern_1_4_0(b, l + 1);
    return true;
  }

  // "then" ExtendedResponse
  private static boolean Concern_1_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Concern_1_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, THEN);
    r = r && ExtendedResponse(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (meanwhile '(' Headless_Concern ')' )?
  private static boolean Concern_1_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Concern_1_5")) return false;
    Concern_1_5_0(b, l + 1);
    return true;
  }

  // meanwhile '(' Headless_Concern ')'
  private static boolean Concern_1_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Concern_1_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MEANWHILE);
    r = r && consumeToken(b, "(");
    r = r && Headless_Concern(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // "concern_start" Concern* "concern_end"
  public static boolean ConcernBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConcernBlock")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, CONCERN_BLOCK, "<concern block>");
    r = consumeToken(b, CONCERN_START);
    p = r; // pin = 1
    r = r && report_error_(b, ConcernBlock_1(b, l + 1));
    r = p && consumeToken(b, CONCERN_END) && r;
    exit_section_(b, l, m, r, p, SleecParser::ConcernBlock_recover);
    return r || p;
  }

  // Concern*
  private static boolean ConcernBlock_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConcernBlock_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Concern(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ConcernBlock_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // !(concern_end | def_start | rule_start | purpose_start | <<eof>>)
  static boolean ConcernBlock_recover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConcernBlock_recover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !ConcernBlock_recover_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // concern_end | def_start | rule_start | purpose_start | <<eof>>
  private static boolean ConcernBlock_recover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConcernBlock_recover_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CONCERN_END);
    if (!r) r = consumeToken(b, DEF_START);
    if (!r) r = consumeToken(b, RULE_START);
    if (!r) r = consumeToken(b, PURPOSE_START);
    if (!r) r = eof(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // id | measure_id | constant_id | event_id
  public static boolean ConcernName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConcernName")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONCERN_NAME, "<concern name>");
    r = consumeToken(b, ID);
    if (!r) r = consumeToken(b, MEASURE_ID);
    if (!r) r = consumeToken(b, CONSTANT_ID);
    if (!r) r = consumeToken(b, EVENT_ID);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // constant_id
  public static boolean ConstantName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConstantName")) return false;
    if (!nextTokenIs(b, CONSTANT_ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CONSTANT_ID);
    exit_section_(b, m, CONSTANT_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // constant ConstantName "=" number
  public static boolean ConstantRule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConstantRule")) return false;
    if (!nextTokenIs(b, CONSTANT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, CONSTANT_RULE, null);
    r = consumeToken(b, CONSTANT);
    r = r && ConstantName(b, l + 1);
    p = r; // pin = 2
    r = r && report_error_(b, consumeToken(b, "="));
    r = p && consumeToken(b, NUMBER) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // "def_start" Definition* "def_end"
  public static boolean Defblock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Defblock")) return false;
    if (!nextTokenIs(b, DEF_START)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DEF_START);
    r = r && Defblock_1(b, l + 1);
    r = r && consumeToken(b, DEF_END);
    exit_section_(b, m, DEFBLOCK, r);
    return r;
  }

  // Definition*
  private static boolean Defblock_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Defblock_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Definition(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Defblock_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // UnlessRule MBoolExpr (then InnerResponse)?
  public static boolean Defeater(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Defeater")) return false;
    if (!nextTokenIs(b, UNLESS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = UnlessRule(b, l + 1);
    r = r && MBoolExpr(b, l + 1);
    r = r && Defeater_2(b, l + 1);
    exit_section_(b, m, DEFEATER, r);
    return r;
  }

  // (then InnerResponse)?
  private static boolean Defeater_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Defeater_2")) return false;
    Defeater_2_0(b, l + 1);
    return true;
  }

  // then InnerResponse
  private static boolean Defeater_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Defeater_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, THEN);
    r = r && InnerResponse(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // MeasureRule | ConstantRule | EventRule
  public static boolean Definition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Definition")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DEFINITION, "<definition>");
    r = MeasureRule(b, l + 1);
    if (!r) r = ConstantRule(b, l + 1);
    if (!r) r = EventRule(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // event_id
  public static boolean EventName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EventName")) return false;
    if (!nextTokenIs(b, EVENT_ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EVENT_ID);
    exit_section_(b, m, EVENT_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // event EventName
  public static boolean EventRule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EventRule")) return false;
    if (!nextTokenIs(b, EVENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EVENT);
    r = r && EventName(b, l + 1);
    exit_section_(b, m, EVENT_RULE, r);
    return r;
  }

  /* ********************************************************** */
  // Response ("while" ExtendedResponse)?
  public static boolean ExtendedResponse(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExtendedResponse")) return false;
    if (!nextTokenIs(b, "<extended response>", EVENT_ID, NOT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXTENDED_RESPONSE, "<extended response>");
    r = Response(b, l + 1);
    r = r && ExtendedResponse_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ("while" ExtendedResponse)?
  private static boolean ExtendedResponse_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExtendedResponse_1")) return false;
    ExtendedResponse_1_0(b, l + 1);
    return true;
  }

  // "while" ExtendedResponse
  private static boolean ExtendedResponse_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExtendedResponse_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, WHILE);
    r = r && ExtendedResponse(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // exists Trigger (and MBoolExpr)? (while ExtendedResponse)? (meanwhile '(' Headless_Concern ')' )? |
  //     when Trigger (and MBoolExpr)? (then ExtendedResponse)? (meanwhile '(' Headless_Concern ')' )?
  public static boolean Headless_Concern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Headless_Concern")) return false;
    if (!nextTokenIs(b, "<headless concern>", EXISTS, WHEN)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, HEADLESS_CONCERN, "<headless concern>");
    r = Headless_Concern_0(b, l + 1);
    if (!r) r = Headless_Concern_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // exists Trigger (and MBoolExpr)? (while ExtendedResponse)? (meanwhile '(' Headless_Concern ')' )?
  private static boolean Headless_Concern_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Headless_Concern_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EXISTS);
    r = r && Trigger(b, l + 1);
    r = r && Headless_Concern_0_2(b, l + 1);
    r = r && Headless_Concern_0_3(b, l + 1);
    r = r && Headless_Concern_0_4(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (and MBoolExpr)?
  private static boolean Headless_Concern_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Headless_Concern_0_2")) return false;
    Headless_Concern_0_2_0(b, l + 1);
    return true;
  }

  // and MBoolExpr
  private static boolean Headless_Concern_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Headless_Concern_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, AND);
    r = r && MBoolExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (while ExtendedResponse)?
  private static boolean Headless_Concern_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Headless_Concern_0_3")) return false;
    Headless_Concern_0_3_0(b, l + 1);
    return true;
  }

  // while ExtendedResponse
  private static boolean Headless_Concern_0_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Headless_Concern_0_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, WHILE);
    r = r && ExtendedResponse(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (meanwhile '(' Headless_Concern ')' )?
  private static boolean Headless_Concern_0_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Headless_Concern_0_4")) return false;
    Headless_Concern_0_4_0(b, l + 1);
    return true;
  }

  // meanwhile '(' Headless_Concern ')'
  private static boolean Headless_Concern_0_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Headless_Concern_0_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MEANWHILE);
    r = r && consumeToken(b, "(");
    r = r && Headless_Concern(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // when Trigger (and MBoolExpr)? (then ExtendedResponse)? (meanwhile '(' Headless_Concern ')' )?
  private static boolean Headless_Concern_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Headless_Concern_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, WHEN);
    r = r && Trigger(b, l + 1);
    r = r && Headless_Concern_1_2(b, l + 1);
    r = r && Headless_Concern_1_3(b, l + 1);
    r = r && Headless_Concern_1_4(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (and MBoolExpr)?
  private static boolean Headless_Concern_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Headless_Concern_1_2")) return false;
    Headless_Concern_1_2_0(b, l + 1);
    return true;
  }

  // and MBoolExpr
  private static boolean Headless_Concern_1_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Headless_Concern_1_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, AND);
    r = r && MBoolExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (then ExtendedResponse)?
  private static boolean Headless_Concern_1_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Headless_Concern_1_3")) return false;
    Headless_Concern_1_3_0(b, l + 1);
    return true;
  }

  // then ExtendedResponse
  private static boolean Headless_Concern_1_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Headless_Concern_1_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, THEN);
    r = r && ExtendedResponse(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (meanwhile '(' Headless_Concern ')' )?
  private static boolean Headless_Concern_1_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Headless_Concern_1_4")) return false;
    Headless_Concern_1_4_0(b, l + 1);
    return true;
  }

  // meanwhile '(' Headless_Concern ')'
  private static boolean Headless_Concern_1_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Headless_Concern_1_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MEANWHILE);
    r = r && consumeToken(b, "(");
    r = r && Headless_Concern(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // eventually
  public static boolean INF(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "INF")) return false;
    if (!nextTokenIs(b, EVENTUALLY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EVENTUALLY);
    exit_section_(b, m, INF, r);
    return r;
  }

  /* ********************************************************** */
  // "{" Occ (Alternative)? (ND)? ( (Defeater*) )? "}" | Occ (Alternative)? (ND)?
  public static boolean InnerResponse(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InnerResponse")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INNER_RESPONSE, "<inner response>");
    r = InnerResponse_0(b, l + 1);
    if (!r) r = InnerResponse_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // "{" Occ (Alternative)? (ND)? ( (Defeater*) )? "}"
  private static boolean InnerResponse_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InnerResponse_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "{");
    r = r && Occ(b, l + 1);
    r = r && InnerResponse_0_2(b, l + 1);
    r = r && InnerResponse_0_3(b, l + 1);
    r = r && InnerResponse_0_4(b, l + 1);
    r = r && consumeToken(b, "}");
    exit_section_(b, m, null, r);
    return r;
  }

  // (Alternative)?
  private static boolean InnerResponse_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InnerResponse_0_2")) return false;
    InnerResponse_0_2_0(b, l + 1);
    return true;
  }

  // (Alternative)
  private static boolean InnerResponse_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InnerResponse_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Alternative(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (ND)?
  private static boolean InnerResponse_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InnerResponse_0_3")) return false;
    InnerResponse_0_3_0(b, l + 1);
    return true;
  }

  // (ND)
  private static boolean InnerResponse_0_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InnerResponse_0_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ND(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( (Defeater*) )?
  private static boolean InnerResponse_0_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InnerResponse_0_4")) return false;
    InnerResponse_0_4_0(b, l + 1);
    return true;
  }

  // Defeater*
  private static boolean InnerResponse_0_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InnerResponse_0_4_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Defeater(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "InnerResponse_0_4_0", c)) break;
    }
    return true;
  }

  // Occ (Alternative)? (ND)?
  private static boolean InnerResponse_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InnerResponse_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Occ(b, l + 1);
    r = r && InnerResponse_1_1(b, l + 1);
    r = r && InnerResponse_1_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (Alternative)?
  private static boolean InnerResponse_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InnerResponse_1_1")) return false;
    InnerResponse_1_1_0(b, l + 1);
    return true;
  }

  // (Alternative)
  private static boolean InnerResponse_1_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InnerResponse_1_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Alternative(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (ND)?
  private static boolean InnerResponse_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InnerResponse_1_2")) return false;
    InnerResponse_1_2_0(b, l + 1);
    return true;
  }

  // (ND)
  private static boolean InnerResponse_1_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InnerResponse_1_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ND(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // BoolExp
  public static boolean MBoolExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MBoolExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, M_BOOL_EXPR, "<m bool expr>");
    r = BoolExp(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // NumMeasure | ScalarMeasure | BoolMeasure
  public static boolean MeasureRule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MeasureRule")) return false;
    if (!nextTokenIs(b, MEASURE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = NumMeasure(b, l + 1);
    if (!r) r = ScalarMeasure(b, l + 1);
    if (!r) r = BoolMeasure(b, l + 1);
    exit_section_(b, m, MEASURE_RULE, r);
    return r;
  }

  /* ********************************************************** */
  // "else" InnerResponse
  public static boolean ND(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ND")) return false;
    if (!nextTokenIs(b, ELSE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSE);
    r = r && InnerResponse(b, l + 1);
    exit_section_(b, m, ND, r);
    return r;
  }

  /* ********************************************************** */
  // "(" "not" MBoolExpr ")"
  public static boolean Negation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Negation")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NEGATION, "<negation>");
    r = consumeToken(b, "(");
    r = r && consumeToken(b, NOT);
    r = r && MBoolExpr(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "(" NumExp BinaryArth NumExp ")"
  public static boolean NumBinOp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NumBinOp")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NUM_BIN_OP, "<num bin op>");
    r = consumeToken(b, "(");
    r = r && NumExp(b, l + 1);
    r = r && BinaryArth(b, l + 1);
    r = r && NumExp(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // NumBinOp | NumTerminal
  public static boolean NumExp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NumExp")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NUM_EXP, "<num exp>");
    r = NumBinOp(b, l + 1);
    if (!r) r = NumTerminal(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // measure NumName Colon NumericRule
  public static boolean NumMeasure(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NumMeasure")) return false;
    if (!nextTokenIs(b, MEASURE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MEASURE);
    r = r && NumName(b, l + 1);
    r = r && Colon(b, l + 1);
    r = r && NumericRule(b, l + 1);
    exit_section_(b, m, NUM_MEASURE, r);
    return r;
  }

  /* ********************************************************** */
  // measure_id
  public static boolean NumName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NumName")) return false;
    if (!nextTokenIs(b, MEASURE_ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MEASURE_ID);
    exit_section_(b, m, NUM_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // number | "{" NumName "}" | ConstantName
  public static boolean NumTerminal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NumTerminal")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NUM_TERMINAL, "<num terminal>");
    r = consumeToken(b, NUMBER);
    if (!r) r = NumTerminal_1(b, l + 1);
    if (!r) r = ConstantName(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // "{" NumName "}"
  private static boolean NumTerminal_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NumTerminal_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "{");
    r = r && NumName(b, l + 1);
    r = r && consumeToken(b, "}");
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // numeric
  public static boolean NumericRule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NumericRule")) return false;
    if (!nextTokenIs(b, NUMERIC)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NUMERIC);
    exit_section_(b, m, NUMERIC_RULE, r);
    return r;
  }

  /* ********************************************************** */
  // "(" NumExp RelOp NumExp ")"
  public static boolean NumericalOp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NumericalOp")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NUMERICAL_OP, "<numerical op>");
    r = consumeToken(b, "(");
    r = r && NumExp(b, l + 1);
    r = r && RelOp(b, l + 1);
    r = r && NumExp(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // not? Trigger (TimeLimit)? (INF)?
  public static boolean Occ(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Occ")) return false;
    if (!nextTokenIs(b, "<occ>", EVENT_ID, NOT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OCC, "<occ>");
    r = Occ_0(b, l + 1);
    r = r && Trigger(b, l + 1);
    r = r && Occ_2(b, l + 1);
    r = r && Occ_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // not?
  private static boolean Occ_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Occ_0")) return false;
    consumeToken(b, NOT);
    return true;
  }

  // (TimeLimit)?
  private static boolean Occ_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Occ_2")) return false;
    Occ_2_0(b, l + 1);
    return true;
  }

  // (TimeLimit)
  private static boolean Occ_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Occ_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = TimeLimit(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (INF)?
  private static boolean Occ_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Occ_3")) return false;
    Occ_3_0(b, l + 1);
    return true;
  }

  // (INF)
  private static boolean Occ_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Occ_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = INF(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // PurposeName exists Trigger (and MBoolExpr)? (while ExtendedResponse)? (meanwhile '(' Headless_Concern ')' )? |
  //     PurposeName when Trigger (and MBoolExpr)? (then ExtendedResponse)? (meanwhile '(' Headless_Concern ')' )?
  public static boolean Purpose(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Purpose")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PURPOSE, "<purpose>");
    r = Purpose_0(b, l + 1);
    if (!r) r = Purpose_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // PurposeName exists Trigger (and MBoolExpr)? (while ExtendedResponse)? (meanwhile '(' Headless_Concern ')' )?
  private static boolean Purpose_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Purpose_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = PurposeName(b, l + 1);
    r = r && consumeToken(b, EXISTS);
    r = r && Trigger(b, l + 1);
    r = r && Purpose_0_3(b, l + 1);
    r = r && Purpose_0_4(b, l + 1);
    r = r && Purpose_0_5(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (and MBoolExpr)?
  private static boolean Purpose_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Purpose_0_3")) return false;
    Purpose_0_3_0(b, l + 1);
    return true;
  }

  // and MBoolExpr
  private static boolean Purpose_0_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Purpose_0_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, AND);
    r = r && MBoolExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (while ExtendedResponse)?
  private static boolean Purpose_0_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Purpose_0_4")) return false;
    Purpose_0_4_0(b, l + 1);
    return true;
  }

  // while ExtendedResponse
  private static boolean Purpose_0_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Purpose_0_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, WHILE);
    r = r && ExtendedResponse(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (meanwhile '(' Headless_Concern ')' )?
  private static boolean Purpose_0_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Purpose_0_5")) return false;
    Purpose_0_5_0(b, l + 1);
    return true;
  }

  // meanwhile '(' Headless_Concern ')'
  private static boolean Purpose_0_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Purpose_0_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MEANWHILE);
    r = r && consumeToken(b, "(");
    r = r && Headless_Concern(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // PurposeName when Trigger (and MBoolExpr)? (then ExtendedResponse)? (meanwhile '(' Headless_Concern ')' )?
  private static boolean Purpose_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Purpose_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = PurposeName(b, l + 1);
    r = r && consumeToken(b, WHEN);
    r = r && Trigger(b, l + 1);
    r = r && Purpose_1_3(b, l + 1);
    r = r && Purpose_1_4(b, l + 1);
    r = r && Purpose_1_5(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (and MBoolExpr)?
  private static boolean Purpose_1_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Purpose_1_3")) return false;
    Purpose_1_3_0(b, l + 1);
    return true;
  }

  // and MBoolExpr
  private static boolean Purpose_1_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Purpose_1_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, AND);
    r = r && MBoolExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (then ExtendedResponse)?
  private static boolean Purpose_1_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Purpose_1_4")) return false;
    Purpose_1_4_0(b, l + 1);
    return true;
  }

  // then ExtendedResponse
  private static boolean Purpose_1_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Purpose_1_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, THEN);
    r = r && ExtendedResponse(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (meanwhile '(' Headless_Concern ')' )?
  private static boolean Purpose_1_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Purpose_1_5")) return false;
    Purpose_1_5_0(b, l + 1);
    return true;
  }

  // meanwhile '(' Headless_Concern ')'
  private static boolean Purpose_1_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Purpose_1_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MEANWHILE);
    r = r && consumeToken(b, "(");
    r = r && Headless_Concern(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // "purpose_start" Purpose* "purpose_end"
  public static boolean PurposeBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PurposeBlock")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, PURPOSE_BLOCK, "<purpose block>");
    r = consumeToken(b, PURPOSE_START);
    p = r; // pin = 1
    r = r && report_error_(b, PurposeBlock_1(b, l + 1));
    r = p && consumeToken(b, PURPOSE_END) && r;
    exit_section_(b, l, m, r, p, SleecParser::PurposeBlock_recover);
    return r || p;
  }

  // Purpose*
  private static boolean PurposeBlock_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PurposeBlock_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Purpose(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "PurposeBlock_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // !(purpose_end | def_start | rule_start | concern_start | <<eof>>)
  static boolean PurposeBlock_recover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PurposeBlock_recover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !PurposeBlock_recover_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // purpose_end | def_start | rule_start | concern_start | <<eof>>
  private static boolean PurposeBlock_recover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PurposeBlock_recover_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PURPOSE_END);
    if (!r) r = consumeToken(b, DEF_START);
    if (!r) r = consumeToken(b, RULE_START);
    if (!r) r = consumeToken(b, CONCERN_START);
    if (!r) r = eof(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // id | measure_id | constant_id | event_id
  public static boolean PurposeName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PurposeName")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PURPOSE_NAME, "<purpose name>");
    r = consumeToken(b, ID);
    if (!r) r = consumeToken(b, MEASURE_ID);
    if (!r) r = consumeToken(b, CONSTANT_ID);
    if (!r) r = consumeToken(b, EVENT_ID);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "<=" | ">=" | "<>" | "<" | ">" | "="
  public static boolean RelOp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RelOp")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, REL_OP, "<rel op>");
    r = consumeToken(b, "<=");
    if (!r) r = consumeToken(b, ">=");
    if (!r) r = consumeToken(b, "<>");
    if (!r) r = consumeToken(b, "<");
    if (!r) r = consumeToken(b, ">");
    if (!r) r = consumeToken(b, "=");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // Occ (Alternative)? (ND)? (Defeater*)?
  public static boolean Response(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Response")) return false;
    if (!nextTokenIs(b, "<response>", EVENT_ID, NOT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, RESPONSE, "<response>");
    r = Occ(b, l + 1);
    r = r && Response_1(b, l + 1);
    r = r && Response_2(b, l + 1);
    r = r && Response_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (Alternative)?
  private static boolean Response_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Response_1")) return false;
    Response_1_0(b, l + 1);
    return true;
  }

  // (Alternative)
  private static boolean Response_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Response_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Alternative(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (ND)?
  private static boolean Response_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Response_2")) return false;
    Response_2_0(b, l + 1);
    return true;
  }

  // (ND)
  private static boolean Response_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Response_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ND(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (Defeater*)?
  private static boolean Response_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Response_3")) return false;
    Response_3_0(b, l + 1);
    return true;
  }

  // Defeater*
  private static boolean Response_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Response_3_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Defeater(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Response_3_0", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // (id | measure_id | constant_id | event_id) when Trigger (and MBoolExpr)? then Response
  public static boolean Rule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Rule")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, RULE, "<rule>");
    r = Rule_0(b, l + 1);
    r = r && consumeToken(b, WHEN);
    r = r && Trigger(b, l + 1);
    r = r && Rule_3(b, l + 1);
    r = r && consumeToken(b, THEN);
    r = r && Response(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // id | measure_id | constant_id | event_id
  private static boolean Rule_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Rule_0")) return false;
    boolean r;
    r = consumeToken(b, ID);
    if (!r) r = consumeToken(b, MEASURE_ID);
    if (!r) r = consumeToken(b, CONSTANT_ID);
    if (!r) r = consumeToken(b, EVENT_ID);
    return r;
  }

  // (and MBoolExpr)?
  private static boolean Rule_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Rule_3")) return false;
    Rule_3_0(b, l + 1);
    return true;
  }

  // and MBoolExpr
  private static boolean Rule_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Rule_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, AND);
    r = r && MBoolExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // "rule_start" Rule* "rule_end"
  public static boolean RuleBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RuleBlock")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, RULE_BLOCK, "<rule block>");
    r = consumeToken(b, RULE_START);
    p = r; // pin = 1
    r = r && report_error_(b, RuleBlock_1(b, l + 1));
    r = p && consumeToken(b, RULE_END) && r;
    exit_section_(b, l, m, r, p, SleecParser::RuleBlock_recover);
    return r || p;
  }

  // Rule*
  private static boolean RuleBlock_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RuleBlock_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Rule(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "RuleBlock_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // !(rule_end | def_start | concern_start | purpose_start | <<eof>>)
  static boolean RuleBlock_recover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RuleBlock_recover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !RuleBlock_recover_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // rule_end | def_start | concern_start | purpose_start | <<eof>>
  private static boolean RuleBlock_recover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RuleBlock_recover_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RULE_END);
    if (!r) r = consumeToken(b, DEF_START);
    if (!r) r = consumeToken(b, CONCERN_START);
    if (!r) r = consumeToken(b, PURPOSE_START);
    if (!r) r = eof(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // "(" ScalarTerminal RelOp ScalarTerminal ")"
  public static boolean ScalarBinaryOp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ScalarBinaryOp")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SCALAR_BINARY_OP, "<scalar binary op>");
    r = consumeToken(b, "(");
    r = r && ScalarTerminal(b, l + 1);
    r = r && RelOp(b, l + 1);
    r = r && ScalarTerminal(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // measure ScalarName Colon ScaleRule
  public static boolean ScalarMeasure(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ScalarMeasure")) return false;
    if (!nextTokenIs(b, MEASURE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MEASURE);
    r = r && ScalarName(b, l + 1);
    r = r && Colon(b, l + 1);
    r = r && ScaleRule(b, l + 1);
    exit_section_(b, m, SCALAR_MEASURE, r);
    return r;
  }

  /* ********************************************************** */
  // measure_id
  public static boolean ScalarName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ScalarName")) return false;
    if (!nextTokenIs(b, MEASURE_ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MEASURE_ID);
    exit_section_(b, m, SCALAR_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // ("{" ScalarName "}") | ScaleParam
  public static boolean ScalarTerminal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ScalarTerminal")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SCALAR_TERMINAL, "<scalar terminal>");
    r = ScalarTerminal_0(b, l + 1);
    if (!r) r = ScaleParam(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // "{" ScalarName "}"
  private static boolean ScalarTerminal_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ScalarTerminal_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "{");
    r = r && ScalarName(b, l + 1);
    r = r && consumeToken(b, "}");
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // number | id | measure_id | constant_id | event_id
  public static boolean ScaleParam(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ScaleParam")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SCALE_PARAM, "<scale param>");
    r = consumeToken(b, NUMBER);
    if (!r) r = consumeToken(b, ID);
    if (!r) r = consumeToken(b, MEASURE_ID);
    if (!r) r = consumeToken(b, CONSTANT_ID);
    if (!r) r = consumeToken(b, EVENT_ID);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // scale "(" ScaleParam ("," ScaleParam)* ")"
  public static boolean ScaleRule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ScaleRule")) return false;
    if (!nextTokenIs(b, SCALE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SCALE);
    r = r && consumeToken(b, "(");
    r = r && ScaleParam(b, l + 1);
    r = r && ScaleRule_3(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, SCALE_RULE, r);
    return r;
  }

  // ("," ScaleParam)*
  private static boolean ScaleRule_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ScaleRule_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ScaleRule_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ScaleRule_3", c)) break;
    }
    return true;
  }

  // "," ScaleParam
  private static boolean ScaleRule_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ScaleRule_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && ScaleParam(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // within TimeValue | within "[" TimeValue "," TimeValue "]"
  public static boolean TimeLimit(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TimeLimit")) return false;
    if (!nextTokenIs(b, WITHIN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = TimeLimit_0(b, l + 1);
    if (!r) r = TimeLimit_1(b, l + 1);
    exit_section_(b, m, TIME_LIMIT, r);
    return r;
  }

  // within TimeValue
  private static boolean TimeLimit_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TimeLimit_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, WITHIN);
    r = r && TimeValue(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // within "[" TimeValue "," TimeValue "]"
  private static boolean TimeLimit_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TimeLimit_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, WITHIN);
    r = r && consumeToken(b, "[");
    r = r && TimeValue(b, l + 1);
    r = r && consumeToken(b, ",");
    r = r && TimeValue(b, l + 1);
    r = r && consumeToken(b, "]");
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // seconds | minutes | hours | days
  public static boolean TimeUnit(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TimeUnit")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TIME_UNIT, "<time unit>");
    r = consumeToken(b, SECONDS);
    if (!r) r = consumeToken(b, MINUTES);
    if (!r) r = consumeToken(b, HOURS);
    if (!r) r = consumeToken(b, DAYS);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // NumExp TimeUnit
  public static boolean TimeValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TimeValue")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TIME_VALUE, "<time value>");
    r = NumExp(b, l + 1);
    r = r && TimeUnit(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // EventName
  public static boolean Trigger(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Trigger")) return false;
    if (!nextTokenIs(b, EVENT_ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = EventName(b, l + 1);
    exit_section_(b, m, TRIGGER, r);
    return r;
  }

  /* ********************************************************** */
  // unless
  public static boolean UnlessRule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "UnlessRule")) return false;
    if (!nextTokenIs(b, UNLESS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, UNLESS);
    exit_section_(b, m, UNLESS_RULE, r);
    return r;
  }

  /* ********************************************************** */
  // Defblock RuleBlock (ConcernBlock)? (PurposeBlock)?
  public static boolean propert(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "propert")) return false;
    if (!nextTokenIs(b, DEF_START)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Defblock(b, l + 1);
    r = r && RuleBlock(b, l + 1);
    r = r && propert_2(b, l + 1);
    r = r && propert_3(b, l + 1);
    exit_section_(b, m, PROPERT, r);
    return r;
  }

  // (ConcernBlock)?
  private static boolean propert_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "propert_2")) return false;
    propert_2_0(b, l + 1);
    return true;
  }

  // (ConcernBlock)
  private static boolean propert_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "propert_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ConcernBlock(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (PurposeBlock)?
  private static boolean propert_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "propert_3")) return false;
    propert_3_0(b, l + 1);
    return true;
  }

  // (PurposeBlock)
  private static boolean propert_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "propert_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = PurposeBlock(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // !<<eof>> propert
  public static boolean property(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, PROPERTY, "<property>");
    r = property_0(b, l + 1);
    p = r; // pin = 1
    r = r && propert(b, l + 1);
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
    r = consumeToken(b, ";");
    if (!r) r = property_recover_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // id '='
  private static boolean property_recover_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_recover_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ID);
    r = r && consumeToken(b, "=");
    exit_section_(b, m, null, r);
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

}
