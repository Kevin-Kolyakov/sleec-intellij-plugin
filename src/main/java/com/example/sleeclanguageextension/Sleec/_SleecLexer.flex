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

  ";"                  { return SEMI; }
  "def_start"          { return DEF_START; }
  "def_end"            { return DEF_END; }
  "rule_start"         { return RULE_START; }
  "rule_end"           { return RULE_END; }
  "concern_start"      { return CONCERN_START; }
  "concern_end"        { return CONCERN_END; }
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
