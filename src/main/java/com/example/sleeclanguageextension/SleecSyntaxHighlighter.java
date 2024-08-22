package com.example.sleeclanguageextension;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class SleecSyntaxHighlighter extends SyntaxHighlighterBase {

    public static final TextAttributesKey KEYWORDS =
            createTextAttributesKey("SLEEC_KEYWORDS", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey COLON =
            createTextAttributesKey("SLEEC_COLON", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey ID =
            createTextAttributesKey("SLEEC_ID", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey VALUE =
            createTextAttributesKey("SLEEC_VALUE", DefaultLanguageHighlighterColors.CONSTANT);
    public static final TextAttributesKey COMMENT =
            createTextAttributesKey("SLEEC_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey BAD_CHARACTER =
            createTextAttributesKey("SLEEC_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);


    private static final TextAttributesKey[] BAD_CHAR_KEYS = new TextAttributesKey[]{BAD_CHARACTER};
    private static final TextAttributesKey[] KEYWORDS_KEYS = new TextAttributesKey[]{KEYWORDS};
    private static final TextAttributesKey[] COLON_KEYS = new TextAttributesKey[]{COLON};
    private static final TextAttributesKey[] ID_KEYS = new TextAttributesKey[]{ID};
    private static final TextAttributesKey[] VALUE_KEYS = new TextAttributesKey[]{VALUE};
    private static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT};
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new SleecLexerAdapter();
    }

    @Override
    public TextAttributesKey @NotNull [] getTokenHighlights(IElementType tokenType) {
        if (tokenType.equals(SleecTypes.ID)||tokenType.equals(SleecTypes.CONSTANT_ID)||tokenType.equals(SleecTypes.EVENT_ID)||tokenType.equals(SleecTypes.MEASURE_ID)) {
            return ID_KEYS;
        }
        if (tokenType.equals(SleecTypes.UNLESS)|tokenType.equals(SleecTypes.BOOLEAN)|tokenType.equals(SleecTypes.NUMERIC)|tokenType.equals(SleecTypes.SCALE)|tokenType.equals(SleecTypes.MEASURE)|tokenType.equals(SleecTypes.STRING)|tokenType.equals(SleecTypes.CONSTANT)|tokenType.equals(SleecTypes.EVENT)|tokenType.equals(SleecTypes.TRUE)|tokenType.equals(SleecTypes.FALSE)|tokenType.equals(SleecTypes.WITHIN)|tokenType.equals(SleecTypes.EVENTUALLY)|tokenType.equals(SleecTypes.SECONDS)|tokenType.equals(SleecTypes.MINUTES)|tokenType.equals(SleecTypes.HOURS)|tokenType.equals(SleecTypes.DAYS)|tokenType.equals(SleecTypes.NOT)|tokenType.equals(SleecTypes.AND)|tokenType.equals(SleecTypes.OR)|tokenType.equals(SleecTypes.WHEN)|tokenType.equals(SleecTypes.THEN)|tokenType.equals(SleecTypes.EXISTS)|tokenType.equals(SleecTypes.WHILE)|tokenType.equals(SleecTypes.MEANWHILE)|tokenType.equals(SleecTypes.OTHERWISE)|tokenType.equals(SleecTypes.ELSE)) {
            return KEYWORDS_KEYS;
        }
        if (tokenType.equals(SleecTypes.NUMBER)) {
            return VALUE_KEYS;
        }
        if (tokenType.equals(SleecTypes.COMMENT)) {
            return COMMENT_KEYS;
        }
        return EMPTY_KEYS;
    }

}