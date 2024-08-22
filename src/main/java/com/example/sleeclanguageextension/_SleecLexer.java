/* The following code was generated by JFlex 1.7.0 tweaked for IntelliJ platform */

package com.example.sleeclanguageextension;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.example.sleeclanguageextension.SleecTypes.*;
import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.7.0
 * from the specification file <tt>_SleecLexer.flex</tt>
 */
public class _SleecLexer implements FlexLexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   * Chosen bits are [12, 6, 3]
   * Total runtime size is 16640 bytes
   */
  public static int ZZ_CMAP(int ch) {
    return ZZ_CMAP_A[(ZZ_CMAP_Y[(ZZ_CMAP_Z[ch>>9]<<6)|((ch>>3)&0x3f)]<<3)|(ch&0x7)];
  }

  /* The ZZ_CMAP_Z table has 2176 entries */
  static final char ZZ_CMAP_Z[] = zzUnpackCMap(
    "\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1"+
    "\20\1\21\1\22\3\21\1\23\1\24\1\25\1\21\14\26\1\27\50\26\1\30\2\26\1\31\1\32"+
    "\1\33\1\34\25\26\1\35\20\21\1\36\1\37\1\40\1\41\1\42\1\43\1\44\1\45\1\46\1"+
    "\47\1\50\1\21\1\51\1\52\1\53\1\54\1\55\1\56\1\57\1\21\1\26\1\60\1\61\5\21"+
    "\2\26\1\62\7\21\1\26\1\63\20\21\1\26\1\64\1\21\1\65\13\26\1\66\1\26\1\67\22"+
    "\21\1\70\5\21\1\71\13\21\1\72\1\73\4\21\1\74\3\21\1\75\2\21\1\76\1\77\7\21"+
    "\123\26\1\100\7\26\1\101\1\102\12\26\1\103\24\21\1\26\1\104\u0702\21");

  /* The ZZ_CMAP_Y table has 4416 entries */
  static final char ZZ_CMAP_Y[] = zzUnpackCMap(
    "\1\0\1\1\2\0\1\2\1\3\1\4\1\5\1\6\2\7\1\10\1\11\1\12\1\13\1\14\1\15\3\0\1\16"+
    "\1\17\1\20\1\17\2\21\1\22\3\21\1\22\71\21\1\23\1\21\1\24\1\0\1\25\1\26\12"+
    "\0\1\27\5\0\1\30\1\31\1\32\1\33\2\21\1\34\11\21\1\35\21\21\1\24\1\36\24\21"+
    "\1\37\3\21\1\22\1\40\1\37\4\21\5\0\1\41\1\42\1\43\1\0\3\21\2\44\3\0\1\41\1"+
    "\45\5\21\1\46\1\41\1\47\1\41\1\50\1\51\13\21\1\52\1\53\1\54\1\55\1\41\1\56"+
    "\2\0\1\57\3\21\2\41\1\0\1\60\12\21\1\61\1\41\1\62\1\0\1\41\1\63\3\21\1\44"+
    "\1\64\1\17\2\21\1\61\1\65\1\66\1\67\2\0\3\21\1\70\10\0\2\21\1\30\1\71\2\0"+
    "\1\72\1\41\1\73\1\74\2\41\1\75\6\21\1\76\1\41\1\77\1\100\1\21\1\101\1\41\1"+
    "\37\1\21\1\102\1\103\1\104\2\21\1\105\1\106\1\107\1\110\1\111\1\112\1\113"+
    "\1\101\1\41\1\24\1\0\1\114\1\115\1\104\2\21\1\105\1\116\1\117\1\120\1\121"+
    "\1\122\1\123\1\124\1\41\1\125\1\0\1\114\1\35\1\34\2\21\1\105\1\126\1\107\1"+
    "\42\1\127\1\70\1\0\1\101\1\41\1\0\1\40\1\114\1\103\1\104\2\21\1\105\1\126"+
    "\1\107\1\110\1\121\1\124\1\113\1\101\1\41\1\40\1\0\1\130\1\131\1\132\1\133"+
    "\1\134\1\131\1\21\1\117\1\135\1\136\1\137\1\0\1\124\1\41\2\0\1\140\1\30\1"+
    "\105\2\21\1\105\1\21\1\107\1\77\1\136\1\141\1\44\1\101\1\41\2\0\1\102\1\30"+
    "\1\105\2\21\1\105\1\142\1\107\1\77\1\136\1\141\1\32\1\101\1\41\1\143\1\0\1"+
    "\114\1\30\1\105\4\21\1\144\1\77\1\145\1\146\1\147\1\101\1\41\1\0\1\36\1\150"+
    "\1\21\1\22\1\36\2\21\1\34\1\151\1\22\1\112\1\152\1\41\1\124\1\41\1\153\1\0"+
    "\1\37\5\21\1\154\1\45\1\22\1\27\1\41\1\74\4\0\1\155\1\156\1\157\1\37\1\160"+
    "\1\161\1\154\1\162\1\163\1\27\1\41\1\164\4\0\1\70\3\0\1\41\1\74\2\0\1\21\1"+
    "\37\3\21\1\25\1\47\1\41\1\74\1\165\1\41\1\47\3\41\1\53\10\0\5\21\1\46\1\166"+
    "\1\167\1\41\1\74\1\61\1\170\1\171\1\172\1\173\1\21\1\174\1\32\1\41\1\175\4"+
    "\21\1\35\1\20\5\21\1\176\51\21\1\132\1\22\1\132\5\21\1\132\4\21\1\132\1\22"+
    "\1\132\1\21\1\22\7\21\1\132\10\21\1\177\4\0\2\21\2\0\12\21\2\71\1\37\114\21"+
    "\1\103\2\21\1\200\2\21\1\44\11\21\1\201\1\51\1\70\1\21\1\30\1\202\1\0\2\21"+
    "\1\202\1\0\2\21\1\202\1\0\1\21\1\30\1\203\1\0\6\21\1\204\2\41\1\205\1\147"+
    "\1\206\1\41\1\74\4\0\1\41\1\74\13\21\1\0\1\207\4\21\1\210\10\21\1\71\1\0\3"+
    "\21\1\22\1\41\1\211\1\41\1\205\1\124\1\41\3\21\1\71\1\25\1\0\5\21\1\212\3"+
    "\21\1\24\1\41\1\74\4\0\2\21\1\213\1\211\6\21\1\165\1\166\1\47\1\41\1\53\1"+
    "\0\1\41\1\74\1\41\1\74\1\147\13\0\1\214\5\21\1\215\1\41\1\140\1\212\1\41\1"+
    "\74\4\0\1\216\3\21\1\217\1\220\1\41\1\63\4\21\1\221\1\41\1\74\1\0\4\21\1\222"+
    "\1\41\1\223\1\0\1\41\1\224\1\41\1\63\3\21\1\71\1\21\1\70\13\0\1\225\1\226"+
    "\1\0\30\21\4\0\1\112\1\41\1\53\1\0\42\21\2\71\4\21\2\71\1\21\1\227\3\21\1"+
    "\71\6\21\1\30\1\163\1\230\1\25\1\231\1\212\1\21\1\25\1\230\1\25\1\232\1\233"+
    "\3\0\1\234\5\0\1\235\2\0\1\40\1\147\2\0\1\21\1\25\14\0\1\236\1\36\1\151\1"+
    "\237\1\26\1\240\1\21\1\241\1\60\1\242\2\0\4\41\1\243\1\205\144\0\1\124\6\41"+
    "\1\74\42\0\5\21\1\22\5\21\1\22\20\21\1\25\1\244\1\245\1\0\4\21\1\35\1\20\7"+
    "\21\1\147\2\0\2\21\1\22\1\0\10\22\4\41\5\0\1\147\72\0\1\246\3\0\1\47\1\74"+
    "\1\237\1\247\1\37\11\21\1\22\1\60\1\37\12\21\1\176\1\60\4\21\1\71\1\37\12"+
    "\21\1\22\2\0\3\21\1\44\6\0\170\21\1\71\11\0\72\21\1\71\5\0\21\21\1\25\10\0"+
    "\5\21\1\71\41\21\1\25\2\21\1\41\1\250\2\0\5\21\1\22\1\72\1\251\3\21\1\61\10"+
    "\21\1\61\1\41\4\0\1\147\1\21\1\36\14\21\1\104\3\21\1\22\1\21\7\0\1\147\1\21"+
    "\1\252\1\176\2\21\1\46\3\0\6\21\1\212\1\0\1\63\5\21\1\222\1\41\1\253\1\0\1"+
    "\41\1\74\2\0\1\36\1\254\1\41\1\63\2\21\1\61\1\45\2\21\1\213\1\41\1\45\1\0"+
    "\3\21\1\25\1\75\5\21\1\255\1\41\1\0\1\147\1\41\1\74\1\30\1\21\1\41\1\256\5"+
    "\21\1\217\1\166\1\0\1\257\1\260\1\41\1\74\2\21\1\22\1\261\6\21\1\262\1\263"+
    "\1\264\2\0\1\265\1\21\1\46\1\266\1\0\3\267\1\0\2\22\5\21\1\176\1\71\1\0\16"+
    "\21\1\46\1\45\1\41\1\74\64\21\1\212\1\0\2\21\1\22\1\270\5\21\1\212\40\0\55"+
    "\21\1\71\15\21\1\24\4\0\1\22\1\0\1\270\1\271\1\21\1\105\1\22\1\163\1\272\15"+
    "\21\1\24\3\0\1\270\54\21\1\71\2\0\10\21\1\36\6\21\5\0\1\21\1\212\16\0\1\30"+
    "\20\21\1\25\2\0\1\41\1\74\1\37\2\21\1\44\1\37\2\21\1\44\1\273\12\21\1\22\3"+
    "\36\1\274\4\0\1\21\1\142\2\21\1\22\2\21\1\275\1\21\1\71\1\21\1\71\4\0\17\21"+
    "\1\44\10\0\6\41\1\53\41\0\3\21\1\25\6\21\1\70\5\0\4\21\2\0\2\21\1\57\1\276"+
    "\4\21\1\61\1\45\3\21\1\71\4\21\1\212\1\21\1\277\5\0\23\21\1\71\1\41\1\74\4"+
    "\21\1\212\4\21\1\212\5\21\1\0\6\21\1\212\23\0\46\21\1\22\1\0\2\21\1\71\1\0"+
    "\1\21\23\0\1\71\1\105\4\21\1\35\1\300\2\21\1\71\1\0\2\21\1\22\1\0\3\21\1\22"+
    "\10\0\2\21\1\301\1\0\2\21\1\71\1\0\3\21\1\24\10\0\7\21\1\273\10\0\1\302\1"+
    "\72\1\142\1\37\2\21\1\212\5\0\3\21\1\25\3\21\1\25\4\0\1\21\1\37\2\21\1\25"+
    "\3\0\6\21\1\71\1\0\2\21\1\71\1\0\2\21\1\44\1\0\2\21\1\24\15\0\11\21\1\70\6"+
    "\0\6\21\1\44\1\0\6\21\1\44\41\0\1\216\6\21\1\41\1\223\3\0\1\124\1\41\2\0\1"+
    "\303\5\21\1\41\1\205\2\0\3\21\1\70\1\41\1\74\1\216\3\21\1\213\1\41\1\135\1"+
    "\41\2\0\4\21\1\304\1\0\1\216\5\21\1\46\1\41\1\305\1\0\1\41\1\306\4\0\2\21"+
    "\1\34\2\21\1\222\1\110\1\307\10\0\1\22\1\240\1\21\1\35\1\21\1\70\5\21\1\213"+
    "\1\41\1\205\1\41\1\74\1\140\1\103\1\104\2\21\1\105\1\126\1\107\1\110\1\121"+
    "\1\137\1\60\1\202\23\0\6\21\1\165\1\41\1\310\1\44\1\41\1\74\4\0\6\21\2\41"+
    "\1\311\1\0\1\41\1\74\24\0\5\21\1\213\1\223\1\166\3\0\1\260\4\0\6\21\1\41\1"+
    "\166\1\312\1\0\1\41\1\74\4\0\5\21\1\46\1\223\1\0\1\41\1\74\6\0\3\21\1\313"+
    "\1\41\1\45\1\41\1\74\54\0\10\21\1\41\1\74\1\0\1\147\70\0\7\21\1\70\40\0\1"+
    "\21\1\105\3\21\1\213\2\166\1\70\1\0\1\41\1\74\2\0\1\36\3\21\1\314\2\41\1\47"+
    "\1\166\51\0\63\21\1\24\14\0\15\41\1\166\2\0\30\21\1\212\27\0\5\21\1\22\72"+
    "\0\10\21\1\22\67\0\7\21\1\70\3\21\1\22\1\41\1\74\14\0\3\21\1\71\2\0\6\21\1"+
    "\166\1\0\1\212\1\0\1\41\1\74\1\270\2\21\1\60\2\21\56\0\10\21\1\25\1\0\1\217"+
    "\4\41\1\166\2\0\1\270\1\21\10\0\1\70\3\0\75\21\1\25\2\0\36\21\1\44\41\0\1"+
    "\24\77\0\15\21\1\44\1\21\1\25\1\21\1\70\1\21\1\315\54\0\12\21\1\30\10\21\1"+
    "\30\1\316\1\225\1\21\1\317\1\142\7\21\1\35\1\320\2\30\3\21\1\321\1\163\1\36"+
    "\1\105\51\21\1\71\3\21\1\105\2\21\1\176\3\21\1\176\2\21\1\30\3\21\1\30\2\21"+
    "\1\22\3\21\1\22\3\21\1\105\3\21\1\105\2\21\1\176\1\204\6\41\1\166\2\41\1\322"+
    "\1\323\1\45\72\0\30\21\1\25\7\0\10\21\1\324\1\0\1\41\1\74\24\0\1\142\3\21"+
    "\1\155\1\37\1\176\1\325\1\236\1\326\1\155\1\227\1\155\2\176\1\123\1\21\1\34"+
    "\1\21\1\212\1\327\1\34\1\21\1\212\116\0\3\41\1\74\3\41\1\74\3\41\1\74\16\0"+
    "\32\21\1\22\5\0\106\21\1\25\1\0\33\21\1\71\120\21\1\24\53\0\3\21\1\71\74\0");

  /* The ZZ_CMAP_A table has 1728 entries */
  static final char ZZ_CMAP_A[] = zzUnpackCMap(
    "\11\0\1\2\4\1\2\0\1\2\1\46\1\14\4\0\1\12\2\0\1\45\1\43\1\0\1\44\1\5\1\3\12"+
    "\4\7\0\22\6\1\0\1\13\2\0\1\7\1\0\1\23\1\33\1\30\1\16\1\17\1\20\1\11\1\40\1"+
    "\35\2\11\1\27\1\34\1\25\1\31\1\32\1\11\1\24\1\21\1\22\1\26\1\36\1\37\1\42"+
    "\1\41\1\11\12\0\1\1\2\0\1\2\11\0\1\15\12\0\1\15\2\0\17\15\1\0\2\15\4\0\4\15"+
    "\6\0\5\15\7\0\1\15\1\0\1\15\6\0\1\10\2\0\5\15\1\0\2\15\2\0\4\15\1\0\1\15\6"+
    "\0\1\15\1\0\3\15\1\0\1\15\1\0\4\15\1\0\13\15\1\0\1\15\2\0\6\15\1\0\7\15\1"+
    "\0\1\15\6\0\16\10\1\0\1\10\1\0\2\10\1\0\2\10\1\0\1\10\3\15\5\0\3\10\5\0\3"+
    "\15\5\10\1\0\11\10\4\0\2\15\1\10\13\15\1\0\1\15\7\10\4\0\4\10\2\15\2\10\4"+
    "\0\1\10\2\15\2\10\3\15\2\0\2\15\1\10\6\15\5\0\11\15\3\10\1\15\6\0\2\10\6\15"+
    "\4\0\2\15\4\0\1\15\11\10\1\15\3\10\1\15\4\10\3\0\1\15\7\0\6\15\6\0\4\10\3"+
    "\0\7\10\6\0\4\10\6\15\2\10\1\0\1\15\7\10\1\0\2\10\1\15\4\0\3\10\2\15\2\10"+
    "\2\0\2\10\1\15\3\10\1\0\10\15\2\0\2\15\2\0\6\15\1\0\7\15\1\0\1\15\3\0\4\15"+
    "\3\0\1\15\7\10\2\0\2\10\2\0\2\10\1\0\1\15\10\0\1\10\4\0\2\15\1\0\1\15\1\0"+
    "\3\10\1\0\6\15\4\0\2\15\1\0\2\15\1\0\2\15\1\0\2\15\4\0\5\10\4\0\2\10\2\0\2"+
    "\10\4\0\1\10\7\0\4\15\1\0\1\15\7\0\4\10\3\15\1\10\2\0\1\15\1\0\2\15\1\0\3"+
    "\15\2\10\1\0\2\10\5\0\1\10\1\15\1\0\6\15\3\0\3\15\1\0\4\15\3\0\2\15\1\0\1"+
    "\15\1\0\2\15\3\0\2\15\3\0\3\10\3\0\3\10\1\0\3\10\3\0\1\15\6\0\5\10\1\0\3\15"+
    "\5\0\2\10\1\0\4\15\1\0\3\15\1\0\2\15\5\0\3\15\2\0\1\15\3\10\1\0\3\10\1\0\1"+
    "\15\5\0\3\15\1\10\7\0\1\15\2\0\2\10\1\0\7\15\1\0\1\15\2\0\5\10\1\0\1\10\3"+
    "\0\2\10\4\0\1\15\1\10\2\15\4\10\1\0\2\15\1\0\1\15\2\0\2\15\1\0\1\15\2\0\1"+
    "\15\6\0\4\15\1\0\3\15\1\0\1\15\1\0\1\15\2\0\2\15\1\0\3\15\2\10\1\0\2\10\1"+
    "\15\2\0\5\15\1\0\1\15\1\0\2\10\2\0\11\15\12\10\1\0\1\10\2\0\4\10\1\15\2\10"+
    "\4\15\3\10\1\15\1\10\2\0\2\15\2\10\5\0\3\15\4\10\5\15\5\10\1\0\2\10\2\0\2"+
    "\10\2\0\3\15\1\0\7\15\4\0\1\10\1\2\12\15\3\0\2\10\2\15\2\10\4\0\1\15\1\0\2"+
    "\10\4\0\4\15\2\0\3\10\13\0\1\15\3\0\5\15\2\10\2\15\1\10\1\15\5\0\4\10\4\0"+
    "\4\15\4\0\7\15\6\10\7\15\1\0\6\10\6\15\11\10\2\0\2\10\10\15\1\0\1\10\4\15"+
    "\12\10\2\0\2\10\3\0\3\15\1\0\4\15\1\0\4\15\2\10\1\0\2\15\2\0\1\15\1\0\1\15"+
    "\1\0\1\15\1\0\1\15\2\0\3\15\1\0\6\15\2\0\2\15\13\2\5\0\2\1\5\0\1\2\7\0\1\2"+
    "\2\0\1\15\4\0\1\15\1\0\5\15\2\0\1\15\1\0\4\15\1\0\3\15\2\0\6\15\4\0\1\15\1"+
    "\0\3\10\2\15\3\10\3\0\4\15\3\0\2\15\4\0\1\2\4\0\2\15\4\10\2\15\3\0\2\10\2"+
    "\15\4\0\4\10\3\0\3\15\1\0\3\15\1\0\1\15\4\10\1\0\1\10\5\0\1\15\1\0\1\15\2"+
    "\0\3\15\1\0\6\10\5\15\1\0\3\15\1\10\10\15\2\10\4\0\1\15\3\0\2\15\1\10\1\15"+
    "\3\10\2\15\2\10\5\15\1\10\1\0\1\15\1\0\1\15\10\0\3\15\4\0\3\15\1\10\3\0\6"+
    "\15\4\0\5\15\5\0\1\15\1\10\3\15\1\0\2\15\1\0\2\15\6\0\2\15\2\0\3\15\3\0\3"+
    "\15\1\0\2\15\1\0\3\15\1\10\6\0\5\10\2\0\1\15\3\0\1\15\2\0\4\15\1\0\2\15\2"+
    "\0\1\15\3\10\1\0\2\10\3\0\1\10\10\15\3\0\1\15\2\0\4\15\3\0\2\10\1\15\1\0\1"+
    "\15\11\0\1\10\1\0\2\10\1\0\3\10\1\0\1\15\2\10\2\0\2\15\1\0\1\15\1\10\3\0\1"+
    "\15\3\0\2\15\3\0\3\10\2\0\6\10\2\15\4\0\1\10\3\0\1\15\2\0\2\15\1\0\2\15\1"+
    "\0\1\15\1\0\6\15\2\0\5\15\1\0\4\15\1\0\1\10\2\0\7\10\1\0\2\10\1\0\2\10\4\15"+
    "\3\0\1\10\1\0\1\15\1\0\1\15\5\0\1\15\1\0\1\15\1\0\3\15\1\0\3\15\1\0\3\15");

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\1\4\1\5\1\6\2\1"+
    "\1\7\20\6\1\10\1\11\1\12\1\13\1\14\1\4"+
    "\1\15\1\0\1\16\3\0\21\6\1\17\21\6\1\20"+
    "\2\6\1\21\14\6\1\22\1\23\5\6\1\24\1\25"+
    "\14\6\1\26\4\6\1\27\1\6\1\30\1\6\1\31"+
    "\14\6\1\32\1\33\3\6\1\34\4\6\1\35\10\6"+
    "\1\36\1\37\2\6\1\40\2\6\1\41\4\6\1\42"+
    "\1\43\1\6\1\44\2\6\1\45\1\6\1\46\4\6"+
    "\1\47\4\6\1\50\2\6\1\51\1\52\1\53\4\6"+
    "\1\54\1\6\1\55\3\6\1\56\1\57";

  private static int [] zzUnpackAction() {
    int [] result = new int[199];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\47\0\116\0\165\0\234\0\303\0\352\0\u0111"+
    "\0\u0138\0\u015f\0\u0186\0\u01ad\0\u01d4\0\u01fb\0\u0222\0\u0249"+
    "\0\u0270\0\u0297\0\u02be\0\u02e5\0\u030c\0\u0333\0\u035a\0\u0381"+
    "\0\u03a8\0\u03cf\0\47\0\47\0\47\0\47\0\u03f6\0\u041d"+
    "\0\u0444\0\u0111\0\47\0\u046b\0\u0138\0\u0492\0\u04b9\0\u04e0"+
    "\0\u0507\0\u052e\0\u0555\0\u057c\0\u05a3\0\u05ca\0\u05f1\0\u0618"+
    "\0\u063f\0\u0666\0\u068d\0\u06b4\0\u06db\0\u0702\0\u0729\0\352"+
    "\0\u0750\0\u0777\0\u079e\0\u07c5\0\u07ec\0\u0813\0\u083a\0\u0861"+
    "\0\u0888\0\u08af\0\u08d6\0\u08fd\0\u0924\0\u094b\0\u0972\0\u0999"+
    "\0\u09c0\0\352\0\u09e7\0\u0a0e\0\352\0\u0a35\0\u0a5c\0\u0a83"+
    "\0\u0aaa\0\u0ad1\0\u0af8\0\u0b1f\0\u0b46\0\u0b6d\0\u0b94\0\u0bbb"+
    "\0\u0be2\0\352\0\352\0\u0c09\0\u0c30\0\u0c57\0\u0c7e\0\u0ca5"+
    "\0\352\0\352\0\u0ccc\0\u0cf3\0\u0d1a\0\u0d41\0\u0d68\0\u0d8f"+
    "\0\u0db6\0\u0ddd\0\u0e04\0\u0e2b\0\u0e52\0\u0e79\0\352\0\u0ea0"+
    "\0\u0ec7\0\u0eee\0\u0f15\0\u0f3c\0\u0f63\0\352\0\u0f8a\0\352"+
    "\0\u0fb1\0\u0fd8\0\u0fff\0\u1026\0\u104d\0\u1074\0\u109b\0\u10c2"+
    "\0\u10e9\0\u1110\0\u1137\0\u115e\0\352\0\352\0\u1185\0\u11ac"+
    "\0\u11d3\0\352\0\u11fa\0\u1221\0\u1248\0\u126f\0\352\0\u1296"+
    "\0\u12bd\0\u12e4\0\u130b\0\u1332\0\u1359\0\u1380\0\u13a7\0\352"+
    "\0\352\0\u13ce\0\u13f5\0\352\0\u141c\0\u1443\0\352\0\u146a"+
    "\0\u1491\0\u14b8\0\u14df\0\352\0\352\0\u1506\0\352\0\u152d"+
    "\0\u1554\0\352\0\u157b\0\352\0\u15a2\0\u15c9\0\u15f0\0\u1617"+
    "\0\352\0\u163e\0\u1665\0\u168c\0\u16b3\0\352\0\u16da\0\u1701"+
    "\0\352\0\352\0\352\0\u1728\0\u174f\0\u1776\0\u179d\0\352"+
    "\0\u17c4\0\352\0\u17eb\0\u1812\0\u1839\0\352\0\352";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[199];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\2\3\1\4\1\5\1\2\1\6\2\2\1\7"+
    "\1\10\1\2\1\11\1\12\1\13\1\14\1\15\1\16"+
    "\1\17\1\20\1\21\1\22\1\23\1\7\1\24\1\25"+
    "\1\26\1\27\1\30\2\7\1\31\1\32\2\7\1\33"+
    "\1\34\1\35\1\36\50\0\2\3\47\0\1\37\47\0"+
    "\1\5\1\40\45\0\1\41\1\0\2\6\2\41\3\0"+
    "\26\41\10\0\1\7\1\0\4\7\3\0\26\7\4\0"+
    "\12\42\1\43\1\44\33\42\13\45\1\46\1\43\32\45"+
    "\4\0\1\12\1\0\2\12\1\0\1\12\4\0\25\12"+
    "\10\0\1\7\1\0\4\7\3\0\2\7\1\47\3\7"+
    "\1\50\17\7\10\0\1\7\1\0\4\7\3\0\12\7"+
    "\1\51\6\7\1\52\3\7\1\53\10\0\1\7\1\0"+
    "\4\7\3\0\6\7\1\54\17\7\10\0\1\7\1\0"+
    "\4\7\3\0\2\7\1\55\10\7\1\56\12\7\10\0"+
    "\1\7\1\0\4\7\3\0\7\7\1\57\13\7\1\60"+
    "\2\7\10\0\1\7\1\0\4\7\3\0\10\7\1\61"+
    "\15\7\10\0\1\7\1\0\4\7\3\0\11\7\1\62"+
    "\14\7\10\0\1\7\1\0\4\7\3\0\11\7\1\63"+
    "\2\7\1\64\11\7\10\0\1\7\1\0\4\7\3\0"+
    "\10\7\1\65\15\7\10\0\1\7\1\0\4\7\3\0"+
    "\14\7\1\66\11\7\10\0\1\7\1\0\4\7\3\0"+
    "\5\7\1\67\1\7\1\70\16\7\10\0\1\7\1\0"+
    "\4\7\3\0\11\7\1\71\14\7\10\0\1\7\1\0"+
    "\4\7\3\0\14\7\1\72\11\7\10\0\1\7\1\0"+
    "\4\7\3\0\2\7\1\73\15\7\1\74\5\7\10\0"+
    "\1\7\1\0\4\7\3\0\20\7\1\75\2\7\1\76"+
    "\2\7\10\0\1\7\1\0\4\7\3\0\14\7\1\77"+
    "\11\7\4\0\1\37\1\0\45\37\4\0\1\40\46\0"+
    "\1\41\1\0\4\41\3\0\26\41\4\0\1\42\1\0"+
    "\45\42\1\45\1\0\45\45\4\0\1\7\1\0\4\7"+
    "\3\0\3\7\1\100\22\7\10\0\1\7\1\0\4\7"+
    "\3\0\24\7\1\101\1\7\10\0\1\7\1\0\4\7"+
    "\3\0\4\7\1\102\21\7\10\0\1\7\1\0\4\7"+
    "\3\0\2\7\1\103\23\7\10\0\1\7\1\0\4\7"+
    "\3\0\20\7\1\104\5\7\10\0\1\7\1\0\4\7"+
    "\3\0\12\7\1\105\13\7\10\0\1\7\1\0\4\7"+
    "\3\0\13\7\1\106\12\7\10\0\1\7\1\0\4\7"+
    "\3\0\6\7\1\107\17\7\10\0\1\7\1\0\4\7"+
    "\3\0\11\7\1\110\14\7\10\0\1\7\1\0\4\7"+
    "\3\0\2\7\1\111\23\7\10\0\1\7\1\0\4\7"+
    "\3\0\1\7\1\112\24\7\10\0\1\7\1\0\4\7"+
    "\3\0\12\7\1\113\13\7\10\0\1\7\1\0\4\7"+
    "\3\0\17\7\1\114\6\7\10\0\1\7\1\0\4\7"+
    "\3\0\5\7\1\115\20\7\10\0\1\7\1\0\4\7"+
    "\3\0\12\7\1\116\13\7\10\0\1\7\1\0\4\7"+
    "\3\0\10\7\1\117\15\7\10\0\1\7\1\0\4\7"+
    "\3\0\23\7\1\120\2\7\10\0\1\7\1\0\4\7"+
    "\3\0\7\7\1\121\16\7\10\0\1\7\1\0\4\7"+
    "\3\0\14\7\1\122\11\7\10\0\1\7\1\0\4\7"+
    "\3\0\6\7\1\123\17\7\10\0\1\7\1\0\4\7"+
    "\3\0\10\7\1\124\15\7\10\0\1\7\1\0\4\7"+
    "\3\0\5\7\1\125\20\7\10\0\1\7\1\0\4\7"+
    "\3\0\2\7\1\126\15\7\1\127\5\7\10\0\1\7"+
    "\1\0\4\7\3\0\11\7\1\130\14\7\10\0\1\7"+
    "\1\0\1\7\1\131\2\7\3\0\26\7\10\0\1\7"+
    "\1\0\4\7\3\0\4\7\1\132\21\7\10\0\1\7"+
    "\1\0\4\7\3\0\2\7\1\133\23\7\10\0\1\7"+
    "\1\0\4\7\3\0\10\7\1\134\15\7\10\0\1\7"+
    "\1\0\4\7\3\0\4\7\1\135\21\7\10\0\1\7"+
    "\1\0\4\7\3\0\4\7\1\136\21\7\10\0\1\7"+
    "\1\0\4\7\3\0\14\7\1\137\11\7\10\0\1\7"+
    "\1\0\4\7\3\0\12\7\1\140\13\7\10\0\1\7"+
    "\1\0\4\7\3\0\2\7\1\141\23\7\10\0\1\7"+
    "\1\0\4\7\3\0\10\7\1\142\15\7\10\0\1\7"+
    "\1\0\4\7\3\0\2\7\1\143\23\7\10\0\1\7"+
    "\1\0\4\7\3\0\2\7\1\144\23\7\10\0\1\7"+
    "\1\0\4\7\3\0\2\7\1\145\23\7\10\0\1\7"+
    "\1\0\4\7\3\0\4\7\1\146\6\7\1\147\12\7"+
    "\10\0\1\7\1\0\4\7\3\0\2\7\1\150\23\7"+
    "\10\0\1\7\1\0\4\7\3\0\15\7\1\151\10\7"+
    "\10\0\1\7\1\0\4\7\3\0\12\7\1\152\13\7"+
    "\10\0\1\7\1\0\4\7\3\0\4\7\1\153\3\7"+
    "\1\154\15\7\10\0\1\7\1\0\4\7\3\0\11\7"+
    "\1\155\14\7\10\0\1\7\1\0\4\7\3\0\23\7"+
    "\1\156\2\7\10\0\1\7\1\0\4\7\3\0\10\7"+
    "\1\157\15\7\10\0\1\7\1\0\4\7\3\0\12\7"+
    "\1\160\13\7\10\0\1\7\1\0\4\7\3\0\7\7"+
    "\1\161\16\7\10\0\1\7\1\0\4\7\3\0\2\7"+
    "\1\162\1\7\1\163\21\7\10\0\1\7\1\0\4\7"+
    "\3\0\5\7\1\164\20\7\10\0\1\7\1\0\4\7"+
    "\3\0\5\7\1\165\20\7\10\0\1\7\1\0\4\7"+
    "\3\0\2\7\1\166\23\7\10\0\1\7\1\0\4\7"+
    "\3\0\10\7\1\167\15\7\10\0\1\7\1\0\4\7"+
    "\3\0\2\7\1\170\23\7\10\0\1\7\1\0\1\7"+
    "\1\171\2\7\3\0\26\7\10\0\1\7\1\0\4\7"+
    "\3\0\7\7\1\172\16\7\10\0\1\7\1\0\4\7"+
    "\3\0\4\7\1\173\21\7\10\0\1\7\1\0\4\7"+
    "\3\0\5\7\1\174\20\7\10\0\1\7\1\0\4\7"+
    "\3\0\2\7\1\175\23\7\10\0\1\7\1\0\4\7"+
    "\3\0\7\7\1\176\16\7\10\0\1\7\1\0\4\7"+
    "\3\0\14\7\1\177\11\7\10\0\1\7\1\0\4\7"+
    "\3\0\2\7\1\200\23\7\10\0\1\7\1\0\4\7"+
    "\3\0\11\7\1\201\14\7\10\0\1\7\1\0\4\7"+
    "\3\0\22\7\1\202\3\7\10\0\1\7\1\0\4\7"+
    "\3\0\5\7\1\203\20\7\10\0\1\7\1\0\4\7"+
    "\3\0\20\7\1\204\5\7\10\0\1\7\1\0\4\7"+
    "\3\0\2\7\1\205\23\7\10\0\1\7\1\0\4\7"+
    "\3\0\4\7\1\206\21\7\10\0\1\7\1\0\4\7"+
    "\3\0\10\7\1\207\15\7\10\0\1\7\1\0\4\7"+
    "\3\0\5\7\1\210\20\7\10\0\1\7\1\0\4\7"+
    "\3\0\11\7\1\211\14\7\10\0\1\7\1\0\4\7"+
    "\3\0\4\7\1\212\21\7\10\0\1\7\1\0\4\7"+
    "\3\0\1\7\1\213\24\7\10\0\1\7\1\0\4\7"+
    "\3\0\2\7\1\214\1\7\1\215\21\7\10\0\1\7"+
    "\1\0\4\7\3\0\20\7\1\216\5\7\10\0\1\7"+
    "\1\0\4\7\3\0\4\7\1\217\21\7\10\0\1\7"+
    "\1\0\4\7\3\0\6\7\1\220\17\7\10\0\1\7"+
    "\1\0\4\7\3\0\7\7\1\221\16\7\10\0\1\7"+
    "\1\0\4\7\3\0\22\7\1\222\3\7\10\0\1\7"+
    "\1\0\4\7\3\0\4\7\1\223\21\7\10\0\1\7"+
    "\1\0\4\7\3\0\6\7\1\224\17\7\10\0\1\7"+
    "\1\0\4\7\3\0\7\7\1\225\16\7\10\0\1\7"+
    "\1\0\4\7\3\0\23\7\1\226\2\7\10\0\1\7"+
    "\1\0\4\7\3\0\2\7\1\227\23\7\10\0\1\7"+
    "\1\0\4\7\3\0\10\7\1\230\15\7\10\0\1\7"+
    "\1\0\4\7\3\0\1\7\1\231\24\7\10\0\1\7"+
    "\1\0\4\7\3\0\6\7\1\232\17\7\10\0\1\7"+
    "\1\0\4\7\3\0\6\7\1\233\17\7\10\0\1\7"+
    "\1\0\4\7\3\0\4\7\1\234\21\7\10\0\1\7"+
    "\1\0\4\7\3\0\10\7\1\235\15\7\10\0\1\7"+
    "\1\0\4\7\3\0\5\7\1\236\20\7\10\0\1\7"+
    "\1\0\4\7\3\0\13\7\1\237\12\7\10\0\1\7"+
    "\1\0\4\7\3\0\10\7\1\240\15\7\10\0\1\7"+
    "\1\0\4\7\3\0\10\7\1\241\15\7\10\0\1\7"+
    "\1\0\4\7\3\0\20\7\1\242\5\7\10\0\1\7"+
    "\1\0\4\7\3\0\2\7\1\243\23\7\10\0\1\7"+
    "\1\0\4\7\3\0\10\7\1\244\15\7\10\0\1\7"+
    "\1\0\4\7\3\0\2\7\1\245\23\7\10\0\1\7"+
    "\1\0\4\7\3\0\20\7\1\246\5\7\10\0\1\7"+
    "\1\0\4\7\3\0\4\7\1\247\21\7\10\0\1\7"+
    "\1\0\4\7\3\0\7\7\1\250\16\7\10\0\1\7"+
    "\1\0\4\7\3\0\12\7\1\251\13\7\10\0\1\7"+
    "\1\0\4\7\3\0\1\7\1\252\24\7\10\0\1\7"+
    "\1\0\4\7\3\0\6\7\1\253\17\7\10\0\1\7"+
    "\1\0\4\7\3\0\5\7\1\254\20\7\10\0\1\7"+
    "\1\0\1\7\1\255\2\7\3\0\26\7\10\0\1\7"+
    "\1\0\4\7\3\0\4\7\1\256\21\7\10\0\1\7"+
    "\1\0\1\7\1\257\2\7\3\0\26\7\10\0\1\7"+
    "\1\0\4\7\3\0\12\7\1\260\13\7\10\0\1\7"+
    "\1\0\4\7\3\0\5\7\1\261\20\7\10\0\1\7"+
    "\1\0\4\7\3\0\12\7\1\262\13\7\10\0\1\7"+
    "\1\0\4\7\3\0\7\7\1\263\16\7\10\0\1\7"+
    "\1\0\4\7\3\0\2\7\1\264\1\7\1\265\21\7"+
    "\10\0\1\7\1\0\4\7\3\0\2\7\1\266\23\7"+
    "\10\0\1\7\1\0\4\7\3\0\2\7\1\267\1\7"+
    "\1\270\21\7\10\0\1\7\1\0\4\7\3\0\2\7"+
    "\1\271\23\7\10\0\1\7\1\0\4\7\3\0\24\7"+
    "\1\272\1\7\10\0\1\7\1\0\4\7\3\0\5\7"+
    "\1\273\20\7\10\0\1\7\1\0\4\7\3\0\10\7"+
    "\1\274\15\7\10\0\1\7\1\0\4\7\3\0\5\7"+
    "\1\275\20\7\10\0\1\7\1\0\4\7\3\0\10\7"+
    "\1\276\15\7\10\0\1\7\1\0\4\7\3\0\5\7"+
    "\1\277\20\7\10\0\1\7\1\0\4\7\3\0\1\7"+
    "\1\300\24\7\10\0\1\7\1\0\4\7\3\0\6\7"+
    "\1\301\17\7\10\0\1\7\1\0\4\7\3\0\1\7"+
    "\1\302\24\7\10\0\1\7\1\0\4\7\3\0\6\7"+
    "\1\303\17\7\10\0\1\7\1\0\4\7\3\0\7\7"+
    "\1\304\16\7\10\0\1\7\1\0\4\7\3\0\7\7"+
    "\1\305\16\7\10\0\1\7\1\0\4\7\3\0\5\7"+
    "\1\306\20\7\10\0\1\7\1\0\4\7\3\0\5\7"+
    "\1\307\20\7\4\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[6240];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String[] ZZ_ERROR_MSG = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\30\1\4\11\3\1\1\0\1\11\3\0"+
    "\241\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[199];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private CharSequence zzBuffer = "";

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /* user code: */
  public _SleecLexer() {
    this((java.io.Reader)null);
  }


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public _SleecLexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    int size = 0;
    for (int i = 0, length = packed.length(); i < length; i += 2) {
      size += packed.charAt(i);
    }
    char[] map = new char[size];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < packed.length()) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }

  public final int getTokenStart() {
    return zzStartRead;
  }

  public final int getTokenEnd() {
    return getTokenStart() + yylength();
  }
  boolean zzAtBOL;
  public void reset(CharSequence buffer, int start, int end, int initialState) {
    zzBuffer = buffer;
    zzCurrentPos = zzMarkedPos = zzStartRead = start;
    zzAtEOF  = false;
    zzAtBOL = true;
    zzEndRead = end;
    yybegin(initialState);
  }

  /**
   * Refills the input buffer.
   *
   * @return      {@code false}, iff there was new input.
   *
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {
    return true;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final CharSequence yytext() {
    return zzBuffer.subSequence(zzStartRead, zzMarkedPos);
  }


  /**
   * Returns the character at position {@code pos} from the
   * matched text.
   *
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch.
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer.charAt(zzStartRead+pos);
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * In a wellformed scanner (no or only correct usage of
   * yypushback(int) and a match-all fallback rule) this method
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public IElementType advance() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    CharSequence zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + ZZ_CMAP(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
        return null;
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { return BAD_CHARACTER;
            } 
            // fall through
          case 48: break;
          case 2: 
            { return WHITE_SPACE;
            } 
            // fall through
          case 49: break;
          case 3: 
            { return OP_4;
            } 
            // fall through
          case 50: break;
          case 4: 
            { return NUMBER;
            } 
            // fall through
          case 51: break;
          case 5: 
            { return CONSTANT_ID;
            } 
            // fall through
          case 52: break;
          case 6: 
            { return MEASURE_ID;
            } 
            // fall through
          case 53: break;
          case 7: 
            { return ID;
            } 
            // fall through
          case 54: break;
          case 8: 
            { return OP_1;
            } 
            // fall through
          case 55: break;
          case 9: 
            { return OP_2;
            } 
            // fall through
          case 56: break;
          case 10: 
            { return OP_3;
            } 
            // fall through
          case 57: break;
          case 11: 
            { return OP_5;
            } 
            // fall through
          case 58: break;
          case 12: 
            { return COMMENT;
            } 
            // fall through
          case 59: break;
          case 13: 
            { return EVENT_ID;
            } 
            // fall through
          case 60: break;
          case 14: 
            { return STRING;
            } 
            // fall through
          case 61: break;
          case 15: 
            { return OR;
            } 
            // fall through
          case 62: break;
          case 16: 
            { return AND;
            } 
            // fall through
          case 63: break;
          case 17: 
            { return NOT;
            } 
            // fall through
          case 64: break;
          case 18: 
            { return DAYS;
            } 
            // fall through
          case 65: break;
          case 19: 
            { return ELSE;
            } 
            // fall through
          case 66: break;
          case 20: 
            { return TRUE;
            } 
            // fall through
          case 67: break;
          case 21: 
            { return THEN;
            } 
            // fall through
          case 68: break;
          case 22: 
            { return WHEN;
            } 
            // fall through
          case 69: break;
          case 23: 
            { return EVENT;
            } 
            // fall through
          case 70: break;
          case 24: 
            { return FALSE;
            } 
            // fall through
          case 71: break;
          case 25: 
            { return SCALE;
            } 
            // fall through
          case 72: break;
          case 26: 
            { return WHILE;
            } 
            // fall through
          case 73: break;
          case 27: 
            { return HOURS;
            } 
            // fall through
          case 74: break;
          case 28: 
            { return EXISTS;
            } 
            // fall through
          case 75: break;
          case 29: 
            { return UNLESS;
            } 
            // fall through
          case 76: break;
          case 30: 
            { return WITHIN;
            } 
            // fall through
          case 77: break;
          case 31: 
            { return DEF_END;
            } 
            // fall through
          case 78: break;
          case 32: 
            { return SECONDS;
            } 
            // fall through
          case 79: break;
          case 33: 
            { return NUMERIC;
            } 
            // fall through
          case 80: break;
          case 34: 
            { return BOOLEAN;
            } 
            // fall through
          case 81: break;
          case 35: 
            { return MEASURE;
            } 
            // fall through
          case 82: break;
          case 36: 
            { return MINUTES;
            } 
            // fall through
          case 83: break;
          case 37: 
            { return RULE_END;
            } 
            // fall through
          case 84: break;
          case 38: 
            { return CONSTANT;
            } 
            // fall through
          case 85: break;
          case 39: 
            { return DEF_START;
            } 
            // fall through
          case 86: break;
          case 40: 
            { return OTHERWISE;
            } 
            // fall through
          case 87: break;
          case 41: 
            { return MEANWHILE;
            } 
            // fall through
          case 88: break;
          case 42: 
            { return EVENTUALLY;
            } 
            // fall through
          case 89: break;
          case 43: 
            { return RULE_START;
            } 
            // fall through
          case 90: break;
          case 44: 
            { return CONCERN_END;
            } 
            // fall through
          case 91: break;
          case 45: 
            { return PURPOSE_END;
            } 
            // fall through
          case 92: break;
          case 46: 
            { return CONCERN_START;
            } 
            // fall through
          case 93: break;
          case 47: 
            { return PURPOSE_START;
            } 
            // fall through
          case 94: break;
          default:
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
