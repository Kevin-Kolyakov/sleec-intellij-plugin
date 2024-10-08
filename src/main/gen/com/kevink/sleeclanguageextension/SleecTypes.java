// This is a generated file. Not intended for manual editing.
package com.kevink.sleeclanguageextension;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.kevink.sleeclanguageextension.impl.*;

public interface SleecTypes {

  IElementType ALTERNATIVE = new SleecElementType("ALTERNATIVE");
  IElementType BINARY_ARTH = new SleecElementType("BINARY_ARTH");
  IElementType BINARY_OP = new SleecElementType("BINARY_OP");
  IElementType BOOLEAN_RULE = new SleecElementType("BOOLEAN_RULE");
  IElementType BOOL_BINARY_OP = new SleecElementType("BOOL_BINARY_OP");
  IElementType BOOL_EXP = new SleecElementType("BOOL_EXP");
  IElementType BOOL_MEASURE = new SleecElementType("BOOL_MEASURE");
  IElementType BOOL_NAME = new SleecElementType("BOOL_NAME");
  IElementType BOOL_OP = new SleecElementType("BOOL_OP");
  IElementType BOOL_TERMINAL = new SleecElementType("BOOL_TERMINAL");
  IElementType BOOL_VALUE = new SleecElementType("BOOL_VALUE");
  IElementType COLON = new SleecElementType("COLON");
  IElementType CONCERN = new SleecElementType("CONCERN");
  IElementType CONCERN_BLOCK = new SleecElementType("CONCERN_BLOCK");
  IElementType CONCERN_NAME = new SleecElementType("CONCERN_NAME");
  IElementType CONSTANT_NAME = new SleecElementType("CONSTANT_NAME");
  IElementType CONSTANT_RULE = new SleecElementType("CONSTANT_RULE");
  IElementType DEFBLOCK = new SleecElementType("DEFBLOCK");
  IElementType DEFEATER = new SleecElementType("DEFEATER");
  IElementType DEFINITION = new SleecElementType("DEFINITION");
  IElementType EVENT_NAME = new SleecElementType("EVENT_NAME");
  IElementType EVENT_RULE = new SleecElementType("EVENT_RULE");
  IElementType EXTENDED_RESPONSE = new SleecElementType("EXTENDED_RESPONSE");
  IElementType HEADLESS_CONCERN = new SleecElementType("HEADLESS_CONCERN");
  IElementType INF = new SleecElementType("INF");
  IElementType INNER_RESPONSE = new SleecElementType("INNER_RESPONSE");
  IElementType MEASURE_RULE = new SleecElementType("MEASURE_RULE");
  IElementType M_BOOL_EXPR = new SleecElementType("M_BOOL_EXPR");
  IElementType ND = new SleecElementType("ND");
  IElementType NEGATION = new SleecElementType("NEGATION");
  IElementType NUMERICAL_OP = new SleecElementType("NUMERICAL_OP");
  IElementType NUMERIC_RULE = new SleecElementType("NUMERIC_RULE");
  IElementType NUM_BIN_OP = new SleecElementType("NUM_BIN_OP");
  IElementType NUM_EXP = new SleecElementType("NUM_EXP");
  IElementType NUM_MEASURE = new SleecElementType("NUM_MEASURE");
  IElementType NUM_NAME = new SleecElementType("NUM_NAME");
  IElementType NUM_TERMINAL = new SleecElementType("NUM_TERMINAL");
  IElementType OCC = new SleecElementType("OCC");
  IElementType PROPERT = new SleecElementType("PROPERT");
  IElementType PROPERTY = new SleecElementType("PROPERTY");
  IElementType PURPOSE = new SleecElementType("PURPOSE");
  IElementType PURPOSE_BLOCK = new SleecElementType("PURPOSE_BLOCK");
  IElementType PURPOSE_NAME = new SleecElementType("PURPOSE_NAME");
  IElementType REL_OP = new SleecElementType("REL_OP");
  IElementType RESPONSE = new SleecElementType("RESPONSE");
  IElementType RULE = new SleecElementType("RULE");
  IElementType RULE_BLOCK = new SleecElementType("RULE_BLOCK");
  IElementType SCALAR_BINARY_OP = new SleecElementType("SCALAR_BINARY_OP");
  IElementType SCALAR_MEASURE = new SleecElementType("SCALAR_MEASURE");
  IElementType SCALAR_NAME = new SleecElementType("SCALAR_NAME");
  IElementType SCALAR_TERMINAL = new SleecElementType("SCALAR_TERMINAL");
  IElementType SCALE_PARAM = new SleecElementType("SCALE_PARAM");
  IElementType SCALE_RULE = new SleecElementType("SCALE_RULE");
  IElementType TIME_LIMIT = new SleecElementType("TIME_LIMIT");
  IElementType TIME_UNIT = new SleecElementType("TIME_UNIT");
  IElementType TIME_VALUE = new SleecElementType("TIME_VALUE");
  IElementType TRIGGER = new SleecElementType("TRIGGER");
  IElementType UNLESS_RULE = new SleecElementType("UNLESS_RULE");

  IElementType AND = new SleecTokenType("and");
  IElementType BOOLEAN = new SleecTokenType("boolean");
  IElementType COMMENT = new SleecTokenType("comment");
  IElementType CONCERN_END = new SleecTokenType("concern_end");
  IElementType CONCERN_START = new SleecTokenType("concern_start");
  IElementType CONSTANT = new SleecTokenType("constant");
  IElementType CONSTANT_ID = new SleecTokenType("constant_id");
  IElementType DAYS = new SleecTokenType("days");
  IElementType DEF_END = new SleecTokenType("def_end");
  IElementType DEF_START = new SleecTokenType("def_start");
  IElementType ELSE = new SleecTokenType("else");
  IElementType EVENT = new SleecTokenType("event");
  IElementType EVENTUALLY = new SleecTokenType("eventually");
  IElementType EVENT_ID = new SleecTokenType("event_id");
  IElementType EXISTS = new SleecTokenType("exists");
  IElementType FALSE = new SleecTokenType("false");
  IElementType HOURS = new SleecTokenType("hours");
  IElementType ID = new SleecTokenType("id");
  IElementType MEANWHILE = new SleecTokenType("meanwhile");
  IElementType MEASURE = new SleecTokenType("measure");
  IElementType MEASURE_ID = new SleecTokenType("measure_id");
  IElementType MINUTES = new SleecTokenType("minutes");
  IElementType NOT = new SleecTokenType("not");
  IElementType NUMBER = new SleecTokenType("number");
  IElementType NUMERIC = new SleecTokenType("numeric");
  IElementType OP_1 = new SleecTokenType("+");
  IElementType OP_2 = new SleecTokenType("-");
  IElementType OP_3 = new SleecTokenType("*");
  IElementType OP_4 = new SleecTokenType("/");
  IElementType OP_5 = new SleecTokenType("!");
  IElementType OR = new SleecTokenType("or");
  IElementType OTHERWISE = new SleecTokenType("otherwise");
  IElementType PURPOSE_END = new SleecTokenType("purpose_end");
  IElementType PURPOSE_START = new SleecTokenType("purpose_start");
  IElementType RULE_END = new SleecTokenType("rule_end");
  IElementType RULE_START = new SleecTokenType("rule_start");
  IElementType SCALE = new SleecTokenType("scale");
  IElementType SECONDS = new SleecTokenType("seconds");
  IElementType STRING = new SleecTokenType("string");
  IElementType THEN = new SleecTokenType("then");
  IElementType TRUE = new SleecTokenType("true");
  IElementType UNLESS = new SleecTokenType("unless");
  IElementType WHEN = new SleecTokenType("when");
  IElementType WHILE = new SleecTokenType("while");
  IElementType WITHIN = new SleecTokenType("within");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ALTERNATIVE) {
        return new SleecAlternativeImpl(node);
      }
      else if (type == BINARY_ARTH) {
        return new SleecBinaryArthImpl(node);
      }
      else if (type == BINARY_OP) {
        return new SleecBinaryOpImpl(node);
      }
      else if (type == BOOLEAN_RULE) {
        return new SleecBooleanRuleImpl(node);
      }
      else if (type == BOOL_BINARY_OP) {
        return new SleecBoolBinaryOpImpl(node);
      }
      else if (type == BOOL_EXP) {
        return new SleecBoolExpImpl(node);
      }
      else if (type == BOOL_MEASURE) {
        return new SleecBoolMeasureImpl(node);
      }
      else if (type == BOOL_NAME) {
        return new SleecBoolNameImpl(node);
      }
      else if (type == BOOL_OP) {
        return new SleecBoolOpImpl(node);
      }
      else if (type == BOOL_TERMINAL) {
        return new SleecBoolTerminalImpl(node);
      }
      else if (type == BOOL_VALUE) {
        return new SleecBoolValueImpl(node);
      }
      else if (type == COLON) {
        return new SleecColonImpl(node);
      }
      else if (type == CONCERN) {
        return new SleecConcernImpl(node);
      }
      else if (type == CONCERN_BLOCK) {
        return new SleecConcernBlockImpl(node);
      }
      else if (type == CONCERN_NAME) {
        return new SleecConcernNameImpl(node);
      }
      else if (type == CONSTANT_NAME) {
        return new SleecConstantNameImpl(node);
      }
      else if (type == CONSTANT_RULE) {
        return new SleecConstantRuleImpl(node);
      }
      else if (type == DEFBLOCK) {
        return new SleecDefblockImpl(node);
      }
      else if (type == DEFEATER) {
        return new SleecDefeaterImpl(node);
      }
      else if (type == DEFINITION) {
        return new SleecDefinitionImpl(node);
      }
      else if (type == EVENT_NAME) {
        return new SleecEventNameImpl(node);
      }
      else if (type == EVENT_RULE) {
        return new SleecEventRuleImpl(node);
      }
      else if (type == EXTENDED_RESPONSE) {
        return new SleecExtendedResponseImpl(node);
      }
      else if (type == HEADLESS_CONCERN) {
        return new SleecHeadlessConcernImpl(node);
      }
      else if (type == INF) {
        return new SleecInfImpl(node);
      }
      else if (type == INNER_RESPONSE) {
        return new SleecInnerResponseImpl(node);
      }
      else if (type == MEASURE_RULE) {
        return new SleecMeasureRuleImpl(node);
      }
      else if (type == M_BOOL_EXPR) {
        return new SleecMBoolExprImpl(node);
      }
      else if (type == ND) {
        return new SleecNdImpl(node);
      }
      else if (type == NEGATION) {
        return new SleecNegationImpl(node);
      }
      else if (type == NUMERICAL_OP) {
        return new SleecNumericalOpImpl(node);
      }
      else if (type == NUMERIC_RULE) {
        return new SleecNumericRuleImpl(node);
      }
      else if (type == NUM_BIN_OP) {
        return new SleecNumBinOpImpl(node);
      }
      else if (type == NUM_EXP) {
        return new SleecNumExpImpl(node);
      }
      else if (type == NUM_MEASURE) {
        return new SleecNumMeasureImpl(node);
      }
      else if (type == NUM_NAME) {
        return new SleecNumNameImpl(node);
      }
      else if (type == NUM_TERMINAL) {
        return new SleecNumTerminalImpl(node);
      }
      else if (type == OCC) {
        return new SleecOccImpl(node);
      }
      else if (type == PROPERT) {
        return new SleecPropertImpl(node);
      }
      else if (type == PROPERTY) {
        return new SleecPropertyImpl(node);
      }
      else if (type == PURPOSE) {
        return new SleecPurposeImpl(node);
      }
      else if (type == PURPOSE_BLOCK) {
        return new SleecPurposeBlockImpl(node);
      }
      else if (type == PURPOSE_NAME) {
        return new SleecPurposeNameImpl(node);
      }
      else if (type == REL_OP) {
        return new SleecRelOpImpl(node);
      }
      else if (type == RESPONSE) {
        return new SleecResponseImpl(node);
      }
      else if (type == RULE) {
        return new SleecRuleImpl(node);
      }
      else if (type == RULE_BLOCK) {
        return new SleecRuleBlockImpl(node);
      }
      else if (type == SCALAR_BINARY_OP) {
        return new SleecScalarBinaryOpImpl(node);
      }
      else if (type == SCALAR_MEASURE) {
        return new SleecScalarMeasureImpl(node);
      }
      else if (type == SCALAR_NAME) {
        return new SleecScalarNameImpl(node);
      }
      else if (type == SCALAR_TERMINAL) {
        return new SleecScalarTerminalImpl(node);
      }
      else if (type == SCALE_PARAM) {
        return new SleecScaleParamImpl(node);
      }
      else if (type == SCALE_RULE) {
        return new SleecScaleRuleImpl(node);
      }
      else if (type == TIME_LIMIT) {
        return new SleecTimeLimitImpl(node);
      }
      else if (type == TIME_UNIT) {
        return new SleecTimeUnitImpl(node);
      }
      else if (type == TIME_VALUE) {
        return new SleecTimeValueImpl(node);
      }
      else if (type == TRIGGER) {
        return new SleecTriggerImpl(node);
      }
      else if (type == UNLESS_RULE) {
        return new SleecUnlessRuleImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
