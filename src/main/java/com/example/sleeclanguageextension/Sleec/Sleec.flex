// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package com.example.sleeclanguageextension;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.example.sleeclanguageextension.SleecTypes;
import com.intellij.psi.TokenType;

%%

%class SleecLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

CRLF=\R
//WHITE_SPACE=[\ \n\t\f]
WHITE_SPACE=[\n\t\f]
FIRST_VALUE_CHARACTER=[^ \n\f\\] | "\\"{CRLF} | "\\".
VALUE_CHARACTER=[^\n\f\\] | "\\"{CRLF} | "\\".
END_OF_LINE_COMMENT=("//")[^\r\n]*
SEPARATOR=[:= ]
KEY_CHARACTER=[^:=\ \n\t\f\\] | "\\ "
DEF = "event"| "measure" | "constant"

%state WAITING_VALUE

%%

<YYINITIAL> {END_OF_LINE_COMMENT}                           { yybegin(YYINITIAL); return SleecTypes.COMMENT; }

<YYINITIAL> {DEF}+                                          { yybegin(YYINITIAL); return SleecTypes.DEF; }

<YYINITIAL> {SEPARATOR}                                     { yybegin(WAITING_VALUE); return SleecTypes.SEPARATOR; }

<WAITING_VALUE> {CRLF}({CRLF}|{WHITE_SPACE})+               { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }

<WAITING_VALUE> {WHITE_SPACE}+                              { yybegin(WAITING_VALUE); return TokenType.WHITE_SPACE; }

<WAITING_VALUE> {FIRST_VALUE_CHARACTER}{VALUE_CHARACTER}*   { yybegin(YYINITIAL); return SleecTypes.VALUE; }

({CRLF}|{WHITE_SPACE})+                                     { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }

[^]                                                         { return TokenType.BAD_CHARACTER; }