package com.example.sleeclanguageextension.Sleec;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static com.example.sleeclanguageextension.SleecTypes.*;

%%

%{
  public _SleecLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class _SleecLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL=\R
WHITE_SPACE=\s+

SPACE=[ \t\n\x0B\f\r]+
COMMENT="//".*
NUMBER=[0-9]+(\.[0-9]*)?
ID=[:letter:][a-zA-Z_0-9]*
STRING=('([^'\\]|\\.)*'|\"([^\"\\]|\\.)*\")

%%
<YYINITIAL> {
  {WHITE_SPACE}        { return WHITE_SPACE; }

  "def_start"          { return DEF_START; }
  "def_end"            { return DEF_END; }
  "rule_start"         { return RULE_START; }
  "rule_end"           { return RULE_END; }
  "concern_start"      { return CONCERN_START; }
  "concern_end"        { return CONCERN_END; }
  "purpose_start"      { return PURPOSE_START; }
  "purpose_end"        { return PURPOSE_END; }
  "boolean"            { return BOOLEAN; }
  "unless"             { return UNLESS; }
  "numeric"            { return NUMERIC; }
  "scale"              { return SCALE; }
  "measure"            { return MEASURE; }
  "constant"           { return CONSTANT; }
  "event"              { return EVENT; }
  "true"               { return TRUE; }
  "false"              { return FALSE; }
  "within"             { return WITHIN; }
  "eventually"         { return EVENTUALLY; }
  "seconds"            { return SECONDS; }
  "minutes"            { return MINUTES; }
  "hours"              { return HOURS; }
  "days"               { return DAYS; }
  "not"                { return NOT; }
  "and"                { return AND; }
  "or"                 { return OR; }
  "when"               { return WHEN; }
  "then"               { return THEN; }
  "exists"             { return EXISTS; }
  "while"              { return WHILE; }
  "meanwhile"          { return MEANWHILE; }
  "otherwise"          { return OTHERWISE; }
  "else"               { return ELSE; }
  "+"                  { return OP_1; }
  "-"                  { return OP_2; }
  "*"                  { return OP_3; }
  "/"                  { return OP_4; }
  "!"                  { return OP_5; }

  {SPACE}              { return SPACE; }
  {COMMENT}            { return COMMENT; }
  {NUMBER}             { return NUMBER; }
  {ID}                 { return ID; }
  {STRING}             { return STRING; }

}

[^] { return BAD_CHARACTER; }
