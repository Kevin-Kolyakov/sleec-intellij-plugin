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
   * Chosen bits are [11, 6, 4]
   * Total runtime size is 14208 bytes
   */
  public static int ZZ_CMAP(int ch) {
    return ZZ_CMAP_A[(ZZ_CMAP_Y[(ZZ_CMAP_Z[ch>>10]<<6)|((ch>>4)&0x3f)]<<4)|(ch&0xf)];
  }

  /* The ZZ_CMAP_Z table has 1088 entries */
  static final char ZZ_CMAP_Z[] = zzUnpackCMap(
    "\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\2\11\1\12\1\13\6\14\1\15\23\14\1\16"+
    "\1\14\1\17\1\20\12\14\1\21\10\11\1\22\1\23\1\24\1\25\1\26\1\27\1\30\1\31\1"+
    "\32\1\33\1\34\1\35\2\11\1\14\1\36\3\11\1\37\10\11\1\40\1\41\5\14\1\42\1\43"+
    "\11\11\1\44\2\11\1\45\5\11\1\46\4\11\1\47\1\50\4\11\51\14\1\51\3\14\1\52\1"+
    "\53\4\14\1\54\12\11\1\55\u0381\11");

  /* The ZZ_CMAP_Y table has 2944 entries */
  static final char ZZ_CMAP_Y[] = zzUnpackCMap(
    "\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\1\1\11\1\12\1\13\1\14\1\13\1\14\34"+
    "\13\1\15\1\16\1\17\10\1\1\20\1\21\1\13\1\22\4\13\1\23\10\13\1\24\12\13\1\25"+
    "\1\13\1\26\1\25\1\13\1\27\4\1\1\13\1\30\1\31\2\1\2\13\1\30\1\1\1\32\1\25\5"+
    "\13\1\33\1\34\1\35\1\1\1\36\1\13\1\1\1\37\5\13\1\40\1\41\1\42\1\13\1\30\1"+
    "\43\1\13\1\44\1\45\1\1\1\13\1\46\4\1\1\13\1\47\4\1\1\50\2\13\1\51\1\1\1\52"+
    "\1\16\1\25\1\53\1\54\1\55\1\56\1\57\1\60\2\16\1\61\1\54\1\55\1\62\1\1\1\63"+
    "\1\1\1\64\1\65\1\22\1\55\1\66\1\1\1\67\1\16\1\70\1\71\1\54\1\55\1\66\1\1\1"+
    "\60\1\16\1\41\1\72\1\73\1\74\1\75\1\1\1\67\2\1\1\76\1\36\1\55\1\51\1\1\1\77"+
    "\1\16\1\1\1\100\1\36\1\55\1\101\1\1\1\57\1\16\1\102\1\76\1\36\1\13\1\103\1"+
    "\57\1\104\1\16\1\42\1\105\1\106\1\13\1\107\1\110\3\1\1\25\2\13\1\111\1\110"+
    "\3\1\1\112\1\113\1\114\1\115\1\116\1\117\2\1\1\67\3\1\1\120\1\13\1\121\1\1"+
    "\1\122\7\1\2\13\1\30\1\123\1\1\1\124\1\125\1\126\1\127\1\1\2\13\1\130\2\13"+
    "\1\131\24\13\1\132\1\133\2\13\1\132\2\13\1\134\1\135\1\14\3\13\1\135\3\13"+
    "\1\30\2\1\1\13\1\1\5\13\1\136\1\25\45\13\1\137\1\13\1\140\1\30\4\13\1\30\1"+
    "\141\1\142\1\16\1\13\1\16\1\13\1\16\1\142\1\67\3\13\1\143\1\1\1\144\4\1\5"+
    "\13\1\27\1\145\1\13\1\146\4\13\1\40\1\13\1\147\3\1\1\13\1\150\1\151\2\13\1"+
    "\152\1\13\1\75\3\1\1\13\1\110\3\13\1\151\4\1\1\153\5\1\1\105\2\13\1\143\1"+
    "\154\3\1\1\155\1\13\1\156\1\42\2\13\1\40\1\1\2\13\1\143\1\1\1\37\1\42\1\13"+
    "\1\150\1\46\5\1\1\157\1\160\14\13\4\1\21\13\1\136\2\13\1\136\1\161\1\13\1"+
    "\150\3\13\1\162\1\163\1\164\1\121\1\163\1\165\1\1\1\166\2\1\1\167\1\1\1\170"+
    "\1\1\1\121\6\1\1\171\1\172\1\173\1\174\1\175\3\1\1\176\147\1\2\13\1\147\2"+
    "\13\1\147\10\13\1\177\1\200\2\13\1\130\3\13\1\201\1\1\1\13\1\110\4\202\4\1"+
    "\1\123\35\1\1\203\2\1\1\204\1\25\4\13\1\205\1\25\4\13\1\131\1\105\1\13\1\150"+
    "\1\25\4\13\1\147\1\1\1\13\1\30\3\1\1\13\40\1\133\13\1\40\4\1\135\13\1\40\2"+
    "\1\10\13\1\121\4\1\2\13\1\150\20\13\1\121\1\13\1\206\1\1\2\13\1\147\1\123"+
    "\1\13\1\150\4\13\1\40\2\1\1\207\1\210\5\13\1\211\1\13\1\147\1\27\3\1\1\207"+
    "\1\212\1\13\1\31\1\1\3\13\1\143\1\210\2\13\1\143\3\1\1\213\1\42\1\13\1\40"+
    "\1\13\1\110\1\1\1\13\1\121\1\50\2\13\1\31\1\123\1\1\1\214\1\215\2\13\1\46"+
    "\1\1\1\216\1\1\1\13\1\217\3\13\1\220\1\221\1\222\1\30\1\64\1\223\1\224\1\202"+
    "\2\13\1\131\1\40\7\13\1\31\1\1\72\13\1\143\1\13\1\225\2\13\1\152\20\1\26\13"+
    "\1\150\6\13\1\75\2\1\1\110\1\226\1\55\1\227\1\230\6\13\1\16\1\1\1\155\25\13"+
    "\1\150\1\1\4\13\1\210\2\13\1\27\2\1\1\152\7\1\1\214\7\13\1\121\2\1\1\25\1"+
    "\30\1\25\1\30\1\231\4\13\1\147\1\232\1\233\2\1\1\234\1\13\1\14\1\235\2\150"+
    "\2\1\7\13\1\30\30\1\1\13\1\121\3\13\1\67\2\1\2\13\1\1\1\13\1\236\2\13\1\40"+
    "\1\13\1\150\2\13\1\237\3\1\11\13\1\150\1\1\2\13\1\237\1\13\1\152\2\13\1\27"+
    "\3\13\1\143\11\1\23\13\1\110\1\13\1\40\1\27\11\1\1\240\2\13\1\241\1\13\1\40"+
    "\1\13\1\110\1\13\1\147\4\1\1\13\1\242\1\13\1\40\1\13\1\75\4\1\3\13\1\243\4"+
    "\1\1\67\1\244\1\13\1\143\2\1\1\13\1\121\1\13\1\121\2\1\1\120\1\13\1\151\1"+
    "\1\3\13\1\40\1\13\1\40\1\13\1\31\1\13\1\16\6\1\4\13\1\46\3\1\3\13\1\31\3\13"+
    "\1\31\60\1\1\155\2\13\1\27\4\1\1\155\2\13\2\1\1\13\1\46\1\1\1\155\1\13\1\110"+
    "\2\1\2\13\1\245\1\155\2\13\1\31\1\246\1\247\2\1\1\13\1\22\1\152\5\1\1\250"+
    "\1\251\1\46\2\13\1\147\2\1\1\71\1\54\1\55\1\66\1\1\1\252\1\16\11\1\3\13\1"+
    "\151\1\253\3\1\3\13\1\1\1\254\13\1\2\13\1\147\2\1\1\255\2\1\3\13\1\1\1\256"+
    "\3\1\2\13\1\30\5\1\1\13\1\75\30\1\4\13\1\1\1\123\34\1\3\13\1\46\20\1\1\55"+
    "\1\13\1\147\1\1\1\67\2\1\1\210\1\13\67\1\71\13\1\75\16\1\14\13\1\143\53\1"+
    "\2\13\1\147\75\1\44\13\1\110\33\1\43\13\1\46\1\13\1\147\7\1\1\13\1\150\1\1"+
    "\3\13\1\1\1\143\1\1\1\155\1\257\1\13\67\1\4\13\1\151\1\67\3\1\1\155\4\1\1"+
    "\67\1\1\76\13\1\121\1\1\57\13\1\31\20\1\1\16\77\1\6\13\1\30\1\121\1\46\1\75"+
    "\66\1\5\13\1\214\3\13\1\142\1\260\1\261\1\262\3\13\1\263\1\264\1\13\1\265"+
    "\1\266\1\36\24\13\1\267\1\13\1\36\1\131\1\13\1\131\1\13\1\214\1\13\1\214\1"+
    "\147\1\13\1\147\1\13\1\55\1\13\1\55\1\13\1\216\3\1\14\13\1\151\3\1\4\13\1"+
    "\143\113\1\1\262\1\13\1\270\1\271\1\272\1\273\1\274\1\275\1\276\1\152\1\277"+
    "\1\152\24\1\55\13\1\110\2\1\103\13\1\151\15\13\1\150\150\13\1\16\25\1\41\13"+
    "\1\150\36\1");

  /* The ZZ_CMAP_A table has 3072 entries */
  static final char ZZ_CMAP_A[] = zzUnpackCMap(
    "\11\0\1\2\4\1\22\0\1\2\1\44\1\13\4\0\1\11\2\0\1\43\1\41\1\0\1\42\1\5\1\3\12"+
    "\4\7\0\32\10\1\0\1\12\2\0\1\7\1\0\1\21\1\31\1\26\1\14\1\15\1\16\1\10\1\36"+
    "\1\33\2\10\1\25\1\32\1\23\1\27\1\30\1\10\1\22\1\17\1\20\1\24\1\34\1\35\1\40"+
    "\1\37\1\10\12\0\1\1\12\0\1\2\11\0\1\6\12\0\1\6\4\0\1\6\5\0\27\6\1\0\12\6\4"+
    "\0\14\6\16\0\5\6\7\0\1\6\1\0\1\6\1\0\5\6\1\0\2\6\2\0\4\6\1\0\1\6\6\0\1\6\1"+
    "\0\3\6\1\0\1\6\1\0\4\6\1\0\23\6\1\0\13\6\10\0\6\6\1\0\26\6\2\0\1\6\6\0\10"+
    "\6\10\0\13\6\5\0\3\6\33\0\6\6\1\0\1\6\17\0\2\6\7\0\2\6\12\0\3\6\2\0\2\6\1"+
    "\0\16\6\15\0\11\6\13\0\1\6\30\0\6\6\4\0\2\6\4\0\1\6\5\0\6\6\4\0\1\6\11\0\1"+
    "\6\3\0\1\6\7\0\11\6\7\0\5\6\1\0\10\6\6\0\26\6\3\0\1\6\2\0\1\6\7\0\11\6\4\0"+
    "\10\6\2\0\2\6\2\0\26\6\1\0\7\6\1\0\1\6\3\0\4\6\3\0\1\6\20\0\1\6\15\0\2\6\1"+
    "\0\1\6\5\0\6\6\4\0\2\6\1\0\2\6\1\0\2\6\1\0\2\6\17\0\4\6\1\0\1\6\3\0\3\6\20"+
    "\0\11\6\1\0\2\6\1\0\2\6\1\0\5\6\3\0\1\6\2\0\1\6\30\0\1\6\13\0\10\6\2\0\1\6"+
    "\3\0\1\6\1\0\6\6\3\0\3\6\1\0\4\6\3\0\2\6\1\0\1\6\1\0\2\6\3\0\2\6\3\0\3\6\3"+
    "\0\14\6\13\0\10\6\1\0\2\6\10\0\3\6\5\0\1\6\4\0\10\6\1\0\6\6\1\0\5\6\3\0\1"+
    "\6\3\0\2\6\15\0\13\6\2\0\1\6\6\0\3\6\10\0\1\6\5\0\22\6\3\0\10\6\1\0\11\6\1"+
    "\0\1\6\2\0\7\6\11\0\1\6\1\0\2\6\15\0\2\6\1\0\1\6\2\0\2\6\1\0\1\6\2\0\1\6\6"+
    "\0\4\6\1\0\7\6\1\0\3\6\1\0\1\6\1\0\1\6\2\0\2\6\1\0\4\6\1\0\2\6\11\0\1\6\2"+
    "\0\5\6\1\0\1\6\25\0\14\6\1\0\24\6\13\0\5\6\22\0\7\6\4\0\4\6\3\0\1\6\3\0\2"+
    "\6\7\0\3\6\4\0\15\6\14\0\1\6\1\0\6\6\1\0\1\6\5\0\1\6\2\0\13\6\1\0\15\6\1\0"+
    "\4\6\2\0\7\6\1\0\1\6\1\0\4\6\2\0\1\6\1\0\4\6\2\0\7\6\1\0\1\6\1\0\4\6\2\0\16"+
    "\6\2\0\6\6\2\0\15\6\2\0\1\6\1\2\17\6\1\0\10\6\7\0\15\6\1\0\6\6\23\0\1\6\4"+
    "\0\1\6\3\0\5\6\2\0\22\6\1\0\1\6\5\0\17\6\1\0\16\6\2\0\5\6\13\0\14\6\13\0\1"+
    "\6\15\0\7\6\7\0\16\6\15\0\2\6\11\0\4\6\1\0\4\6\3\0\2\6\11\0\10\6\1\0\1\6\1"+
    "\0\1\6\1\0\1\6\1\0\6\6\1\0\7\6\1\0\1\6\3\0\3\6\1\0\7\6\3\0\4\6\2\0\6\6\4\0"+
    "\13\2\15\0\2\1\5\0\1\2\17\0\1\2\1\0\1\6\15\0\1\6\2\0\1\6\4\0\1\6\2\0\12\6"+
    "\1\0\1\6\3\0\5\6\6\0\1\6\1\0\1\6\1\0\1\6\1\0\4\6\1\0\13\6\2\0\4\6\5\0\5\6"+
    "\4\0\1\6\4\0\2\6\13\0\5\6\6\0\4\6\3\0\2\6\14\0\10\6\7\0\10\6\1\0\7\6\1\0\1"+
    "\2\4\0\2\6\12\0\5\6\5\0\2\6\3\0\7\6\6\0\3\6\12\0\2\6\13\0\11\6\2\0\27\6\2"+
    "\0\7\6\1\0\3\6\1\0\4\6\1\0\4\6\2\0\6\6\3\0\1\6\1\0\1\6\2\0\5\6\1\0\12\6\12"+
    "\0\5\6\1\0\3\6\1\0\10\6\4\0\7\6\3\0\1\6\3\0\2\6\1\0\1\6\3\0\2\6\2\0\5\6\2"+
    "\0\1\6\1\0\1\6\30\0\3\6\3\0\6\6\2\0\6\6\2\0\6\6\11\0\7\6\4\0\5\6\3\0\5\6\5"+
    "\0\1\6\1\0\10\6\1\0\5\6\1\0\1\6\1\0\2\6\1\0\2\6\1\0\12\6\6\0\12\6\2\0\6\6"+
    "\2\0\6\6\2\0\6\6\2\0\3\6\3\0\14\6\1\0\16\6\1\0\2\6\1\0\2\6\1\0\10\6\6\0\4"+
    "\6\4\0\16\6\2\0\1\6\1\0\14\6\1\0\2\6\3\0\1\6\2\0\4\6\1\0\2\6\12\0\10\6\6\0"+
    "\6\6\1\0\3\6\1\0\12\6\3\0\1\6\12\0\4\6\25\0\1\6\1\0\1\6\3\0\7\6\1\0\1\6\1"+
    "\0\4\6\1\0\17\6\1\0\2\6\14\0\3\6\7\0\4\6\11\0\2\6\1\0\1\6\20\0\4\6\10\0\1"+
    "\6\13\0\10\6\5\0\3\6\2\0\1\6\2\0\2\6\2\0\4\6\1\0\14\6\1\0\1\6\1\0\7\6\1\0"+
    "\21\6\1\0\4\6\2\0\10\6\1\0\7\6\1\0\14\6\1\0\4\6\1\0\5\6\1\0\1\6\3\0\14\6\2"+
    "\0\10\6\1\0\2\6\1\0\1\6\2\0\1\6\1\0\12\6\1\0\4\6\1\0\1\6\1\0\1\6\6\0\1\6\4"+
    "\0\1\6\1\0\1\6\1\0\1\6\1\0\3\6\1\0\2\6\1\0\1\6\2\0\1\6\1\0\1\6\1\0\1\6\1\0"+
    "\1\6\1\0\1\6\1\0\2\6\1\0\1\6\2\0\4\6\1\0\7\6\1\0\4\6\1\0\4\6\1\0\1\6\1\0\12"+
    "\6\1\0\5\6\1\0\3\6\1\0\5\6\1\0\5\6");

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\1\4\1\5\2\1\20\5"+
    "\1\6\1\7\1\10\1\11\1\12\1\4\1\0\1\13"+
    "\3\0\21\5\1\14\21\5\1\15\2\5\1\16\14\5"+
    "\1\17\1\20\5\5\1\21\1\22\14\5\1\23\4\5"+
    "\1\24\1\5\1\25\1\5\1\26\14\5\1\27\1\30"+
    "\3\5\1\31\4\5\1\32\10\5\1\33\1\34\2\5"+
    "\1\35\2\5\1\36\4\5\1\37\1\40\1\5\1\41"+
    "\2\5\1\42\1\5\1\43\4\5\1\44\4\5\1\45"+
    "\2\5\1\46\1\47\1\50\4\5\1\51\1\5\1\52"+
    "\3\5\1\53\1\54";

  private static int [] zzUnpackAction() {
    int [] result = new int[196];
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
    "\0\0\0\45\0\112\0\157\0\224\0\271\0\336\0\u0103"+
    "\0\u0128\0\u014d\0\u0172\0\u0197\0\u01bc\0\u01e1\0\u0206\0\u022b"+
    "\0\u0250\0\u0275\0\u029a\0\u02bf\0\u02e4\0\u0309\0\u032e\0\u0353"+
    "\0\45\0\45\0\45\0\45\0\u0378\0\u039d\0\336\0\45"+
    "\0\u03c2\0\u0103\0\u03e7\0\u040c\0\u0431\0\u0456\0\u047b\0\u04a0"+
    "\0\u04c5\0\u04ea\0\u050f\0\u0534\0\u0559\0\u057e\0\u05a3\0\u05c8"+
    "\0\u05ed\0\u0612\0\u0637\0\u065c\0\271\0\u0681\0\u06a6\0\u06cb"+
    "\0\u06f0\0\u0715\0\u073a\0\u075f\0\u0784\0\u07a9\0\u07ce\0\u07f3"+
    "\0\u0818\0\u083d\0\u0862\0\u0887\0\u08ac\0\u08d1\0\271\0\u08f6"+
    "\0\u091b\0\271\0\u0940\0\u0965\0\u098a\0\u09af\0\u09d4\0\u09f9"+
    "\0\u0a1e\0\u0a43\0\u0a68\0\u0a8d\0\u0ab2\0\u0ad7\0\271\0\271"+
    "\0\u0afc\0\u0b21\0\u0b46\0\u0b6b\0\u0b90\0\271\0\271\0\u0bb5"+
    "\0\u0bda\0\u0bff\0\u0c24\0\u0c49\0\u0c6e\0\u0c93\0\u0cb8\0\u0cdd"+
    "\0\u0d02\0\u0d27\0\u0d4c\0\271\0\u0d71\0\u0d96\0\u0dbb\0\u0de0"+
    "\0\u0e05\0\u0e2a\0\271\0\u0e4f\0\271\0\u0e74\0\u0e99\0\u0ebe"+
    "\0\u0ee3\0\u0f08\0\u0f2d\0\u0f52\0\u0f77\0\u0f9c\0\u0fc1\0\u0fe6"+
    "\0\u100b\0\271\0\271\0\u1030\0\u1055\0\u107a\0\271\0\u109f"+
    "\0\u10c4\0\u10e9\0\u110e\0\271\0\u1133\0\u1158\0\u117d\0\u11a2"+
    "\0\u11c7\0\u11ec\0\u1211\0\u1236\0\271\0\271\0\u125b\0\u1280"+
    "\0\271\0\u12a5\0\u12ca\0\271\0\u12ef\0\u1314\0\u1339\0\u135e"+
    "\0\271\0\271\0\u1383\0\271\0\u13a8\0\u13cd\0\271\0\u13f2"+
    "\0\271\0\u1417\0\u143c\0\u1461\0\u1486\0\271\0\u14ab\0\u14d0"+
    "\0\u14f5\0\u151a\0\271\0\u153f\0\u1564\0\271\0\271\0\271"+
    "\0\u1589\0\u15ae\0\u15d3\0\u15f8\0\271\0\u161d\0\271\0\u1642"+
    "\0\u1667\0\u168c\0\271\0\271";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[196];
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
    "\1\2\2\3\1\4\1\5\1\2\1\6\1\2\1\6"+
    "\1\7\1\2\1\10\1\11\1\12\1\13\1\14\1\15"+
    "\1\16\1\17\1\20\1\21\1\6\1\22\1\23\1\24"+
    "\1\25\1\26\2\6\1\27\1\30\2\6\1\31\1\32"+
    "\1\33\1\34\46\0\2\3\45\0\1\35\45\0\1\5"+
    "\1\36\43\0\1\6\2\0\2\6\3\0\25\6\4\0"+
    "\11\37\1\40\1\41\32\37\12\42\1\43\1\40\31\42"+
    "\4\0\1\6\2\0\2\6\3\0\1\6\1\44\3\6"+
    "\1\45\17\6\10\0\1\6\2\0\2\6\3\0\11\6"+
    "\1\46\6\6\1\47\3\6\1\50\10\0\1\6\2\0"+
    "\2\6\3\0\5\6\1\51\17\6\10\0\1\6\2\0"+
    "\2\6\3\0\1\6\1\52\10\6\1\53\12\6\10\0"+
    "\1\6\2\0\2\6\3\0\6\6\1\54\13\6\1\55"+
    "\2\6\10\0\1\6\2\0\2\6\3\0\7\6\1\56"+
    "\15\6\10\0\1\6\2\0\2\6\3\0\10\6\1\57"+
    "\14\6\10\0\1\6\2\0\2\6\3\0\10\6\1\60"+
    "\2\6\1\61\11\6\10\0\1\6\2\0\2\6\3\0"+
    "\7\6\1\62\15\6\10\0\1\6\2\0\2\6\3\0"+
    "\13\6\1\63\11\6\10\0\1\6\2\0\2\6\3\0"+
    "\4\6\1\64\1\6\1\65\16\6\10\0\1\6\2\0"+
    "\2\6\3\0\10\6\1\66\14\6\10\0\1\6\2\0"+
    "\2\6\3\0\13\6\1\67\11\6\10\0\1\6\2\0"+
    "\2\6\3\0\1\6\1\70\15\6\1\71\5\6\10\0"+
    "\1\6\2\0\2\6\3\0\17\6\1\72\2\6\1\73"+
    "\2\6\10\0\1\6\2\0\2\6\3\0\13\6\1\74"+
    "\11\6\4\0\1\35\1\0\43\35\4\0\1\36\40\0"+
    "\1\37\1\0\43\37\1\42\1\0\43\42\4\0\1\6"+
    "\2\0\2\6\3\0\2\6\1\75\22\6\10\0\1\6"+
    "\2\0\2\6\3\0\23\6\1\76\1\6\10\0\1\6"+
    "\2\0\2\6\3\0\3\6\1\77\21\6\10\0\1\6"+
    "\2\0\2\6\3\0\1\6\1\100\23\6\10\0\1\6"+
    "\2\0\2\6\3\0\17\6\1\101\5\6\10\0\1\6"+
    "\2\0\2\6\3\0\11\6\1\102\13\6\10\0\1\6"+
    "\2\0\2\6\3\0\12\6\1\103\12\6\10\0\1\6"+
    "\2\0\2\6\3\0\5\6\1\104\17\6\10\0\1\6"+
    "\2\0\2\6\3\0\10\6\1\105\14\6\10\0\1\6"+
    "\2\0\2\6\3\0\1\6\1\106\23\6\10\0\1\6"+
    "\2\0\2\6\3\0\1\107\24\6\10\0\1\6\2\0"+
    "\2\6\3\0\11\6\1\110\13\6\10\0\1\6\2\0"+
    "\2\6\3\0\16\6\1\111\6\6\10\0\1\6\2\0"+
    "\2\6\3\0\4\6\1\112\20\6\10\0\1\6\2\0"+
    "\2\6\3\0\11\6\1\113\13\6\10\0\1\6\2\0"+
    "\2\6\3\0\7\6\1\114\15\6\10\0\1\6\2\0"+
    "\2\6\3\0\22\6\1\115\2\6\10\0\1\6\2\0"+
    "\2\6\3\0\6\6\1\116\16\6\10\0\1\6\2\0"+
    "\2\6\3\0\13\6\1\117\11\6\10\0\1\6\2\0"+
    "\2\6\3\0\5\6\1\120\17\6\10\0\1\6\2\0"+
    "\2\6\3\0\7\6\1\121\15\6\10\0\1\6\2\0"+
    "\2\6\3\0\4\6\1\122\20\6\10\0\1\6\2\0"+
    "\2\6\3\0\1\6\1\123\15\6\1\124\5\6\10\0"+
    "\1\6\2\0\2\6\3\0\10\6\1\125\14\6\10\0"+
    "\1\6\2\0\1\126\1\6\3\0\25\6\10\0\1\6"+
    "\2\0\2\6\3\0\3\6\1\127\21\6\10\0\1\6"+
    "\2\0\2\6\3\0\1\6\1\130\23\6\10\0\1\6"+
    "\2\0\2\6\3\0\7\6\1\131\15\6\10\0\1\6"+
    "\2\0\2\6\3\0\3\6\1\132\21\6\10\0\1\6"+
    "\2\0\2\6\3\0\3\6\1\133\21\6\10\0\1\6"+
    "\2\0\2\6\3\0\13\6\1\134\11\6\10\0\1\6"+
    "\2\0\2\6\3\0\11\6\1\135\13\6\10\0\1\6"+
    "\2\0\2\6\3\0\1\6\1\136\23\6\10\0\1\6"+
    "\2\0\2\6\3\0\7\6\1\137\15\6\10\0\1\6"+
    "\2\0\2\6\3\0\1\6\1\140\23\6\10\0\1\6"+
    "\2\0\2\6\3\0\1\6\1\141\23\6\10\0\1\6"+
    "\2\0\2\6\3\0\1\6\1\142\23\6\10\0\1\6"+
    "\2\0\2\6\3\0\3\6\1\143\6\6\1\144\12\6"+
    "\10\0\1\6\2\0\2\6\3\0\1\6\1\145\23\6"+
    "\10\0\1\6\2\0\2\6\3\0\14\6\1\146\10\6"+
    "\10\0\1\6\2\0\2\6\3\0\11\6\1\147\13\6"+
    "\10\0\1\6\2\0\2\6\3\0\3\6\1\150\3\6"+
    "\1\151\15\6\10\0\1\6\2\0\2\6\3\0\10\6"+
    "\1\152\14\6\10\0\1\6\2\0\2\6\3\0\22\6"+
    "\1\153\2\6\10\0\1\6\2\0\2\6\3\0\7\6"+
    "\1\154\15\6\10\0\1\6\2\0\2\6\3\0\11\6"+
    "\1\155\13\6\10\0\1\6\2\0\2\6\3\0\6\6"+
    "\1\156\16\6\10\0\1\6\2\0\2\6\3\0\1\6"+
    "\1\157\1\6\1\160\21\6\10\0\1\6\2\0\2\6"+
    "\3\0\4\6\1\161\20\6\10\0\1\6\2\0\2\6"+
    "\3\0\4\6\1\162\20\6\10\0\1\6\2\0\2\6"+
    "\3\0\1\6\1\163\23\6\10\0\1\6\2\0\2\6"+
    "\3\0\7\6\1\164\15\6\10\0\1\6\2\0\2\6"+
    "\3\0\1\6\1\165\23\6\10\0\1\6\2\0\1\166"+
    "\1\6\3\0\25\6\10\0\1\6\2\0\2\6\3\0"+
    "\6\6\1\167\16\6\10\0\1\6\2\0\2\6\3\0"+
    "\3\6\1\170\21\6\10\0\1\6\2\0\2\6\3\0"+
    "\4\6\1\171\20\6\10\0\1\6\2\0\2\6\3\0"+
    "\1\6\1\172\23\6\10\0\1\6\2\0\2\6\3\0"+
    "\6\6\1\173\16\6\10\0\1\6\2\0\2\6\3\0"+
    "\13\6\1\174\11\6\10\0\1\6\2\0\2\6\3\0"+
    "\1\6\1\175\23\6\10\0\1\6\2\0\2\6\3\0"+
    "\10\6\1\176\14\6\10\0\1\6\2\0\2\6\3\0"+
    "\21\6\1\177\3\6\10\0\1\6\2\0\2\6\3\0"+
    "\4\6\1\200\20\6\10\0\1\6\2\0\2\6\3\0"+
    "\17\6\1\201\5\6\10\0\1\6\2\0\2\6\3\0"+
    "\1\6\1\202\23\6\10\0\1\6\2\0\2\6\3\0"+
    "\3\6\1\203\21\6\10\0\1\6\2\0\2\6\3\0"+
    "\7\6\1\204\15\6\10\0\1\6\2\0\2\6\3\0"+
    "\4\6\1\205\20\6\10\0\1\6\2\0\2\6\3\0"+
    "\10\6\1\206\14\6\10\0\1\6\2\0\2\6\3\0"+
    "\3\6\1\207\21\6\10\0\1\6\2\0\2\6\3\0"+
    "\1\210\24\6\10\0\1\6\2\0\2\6\3\0\1\6"+
    "\1\211\1\6\1\212\21\6\10\0\1\6\2\0\2\6"+
    "\3\0\17\6\1\213\5\6\10\0\1\6\2\0\2\6"+
    "\3\0\3\6\1\214\21\6\10\0\1\6\2\0\2\6"+
    "\3\0\5\6\1\215\17\6\10\0\1\6\2\0\2\6"+
    "\3\0\6\6\1\216\16\6\10\0\1\6\2\0\2\6"+
    "\3\0\21\6\1\217\3\6\10\0\1\6\2\0\2\6"+
    "\3\0\3\6\1\220\21\6\10\0\1\6\2\0\2\6"+
    "\3\0\5\6\1\221\17\6\10\0\1\6\2\0\2\6"+
    "\3\0\6\6\1\222\16\6\10\0\1\6\2\0\2\6"+
    "\3\0\22\6\1\223\2\6\10\0\1\6\2\0\2\6"+
    "\3\0\1\6\1\224\23\6\10\0\1\6\2\0\2\6"+
    "\3\0\7\6\1\225\15\6\10\0\1\6\2\0\2\6"+
    "\3\0\1\226\24\6\10\0\1\6\2\0\2\6\3\0"+
    "\5\6\1\227\17\6\10\0\1\6\2\0\2\6\3\0"+
    "\5\6\1\230\17\6\10\0\1\6\2\0\2\6\3\0"+
    "\3\6\1\231\21\6\10\0\1\6\2\0\2\6\3\0"+
    "\7\6\1\232\15\6\10\0\1\6\2\0\2\6\3\0"+
    "\4\6\1\233\20\6\10\0\1\6\2\0\2\6\3\0"+
    "\12\6\1\234\12\6\10\0\1\6\2\0\2\6\3\0"+
    "\7\6\1\235\15\6\10\0\1\6\2\0\2\6\3\0"+
    "\7\6\1\236\15\6\10\0\1\6\2\0\2\6\3\0"+
    "\17\6\1\237\5\6\10\0\1\6\2\0\2\6\3\0"+
    "\1\6\1\240\23\6\10\0\1\6\2\0\2\6\3\0"+
    "\7\6\1\241\15\6\10\0\1\6\2\0\2\6\3\0"+
    "\1\6\1\242\23\6\10\0\1\6\2\0\2\6\3\0"+
    "\17\6\1\243\5\6\10\0\1\6\2\0\2\6\3\0"+
    "\3\6\1\244\21\6\10\0\1\6\2\0\2\6\3\0"+
    "\6\6\1\245\16\6\10\0\1\6\2\0\2\6\3\0"+
    "\11\6\1\246\13\6\10\0\1\6\2\0\2\6\3\0"+
    "\1\247\24\6\10\0\1\6\2\0\2\6\3\0\5\6"+
    "\1\250\17\6\10\0\1\6\2\0\2\6\3\0\4\6"+
    "\1\251\20\6\10\0\1\6\2\0\1\252\1\6\3\0"+
    "\25\6\10\0\1\6\2\0\2\6\3\0\3\6\1\253"+
    "\21\6\10\0\1\6\2\0\1\254\1\6\3\0\25\6"+
    "\10\0\1\6\2\0\2\6\3\0\11\6\1\255\13\6"+
    "\10\0\1\6\2\0\2\6\3\0\4\6\1\256\20\6"+
    "\10\0\1\6\2\0\2\6\3\0\11\6\1\257\13\6"+
    "\10\0\1\6\2\0\2\6\3\0\6\6\1\260\16\6"+
    "\10\0\1\6\2\0\2\6\3\0\1\6\1\261\1\6"+
    "\1\262\21\6\10\0\1\6\2\0\2\6\3\0\1\6"+
    "\1\263\23\6\10\0\1\6\2\0\2\6\3\0\1\6"+
    "\1\264\1\6\1\265\21\6\10\0\1\6\2\0\2\6"+
    "\3\0\1\6\1\266\23\6\10\0\1\6\2\0\2\6"+
    "\3\0\23\6\1\267\1\6\10\0\1\6\2\0\2\6"+
    "\3\0\4\6\1\270\20\6\10\0\1\6\2\0\2\6"+
    "\3\0\7\6\1\271\15\6\10\0\1\6\2\0\2\6"+
    "\3\0\4\6\1\272\20\6\10\0\1\6\2\0\2\6"+
    "\3\0\7\6\1\273\15\6\10\0\1\6\2\0\2\6"+
    "\3\0\4\6\1\274\20\6\10\0\1\6\2\0\2\6"+
    "\3\0\1\275\24\6\10\0\1\6\2\0\2\6\3\0"+
    "\5\6\1\276\17\6\10\0\1\6\2\0\2\6\3\0"+
    "\1\277\24\6\10\0\1\6\2\0\2\6\3\0\5\6"+
    "\1\300\17\6\10\0\1\6\2\0\2\6\3\0\6\6"+
    "\1\301\16\6\10\0\1\6\2\0\2\6\3\0\6\6"+
    "\1\302\16\6\10\0\1\6\2\0\2\6\3\0\4\6"+
    "\1\303\20\6\10\0\1\6\2\0\2\6\3\0\4\6"+
    "\1\304\20\6\4\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[5809];
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
    "\1\0\1\11\26\1\4\11\2\1\1\0\1\11\3\0"+
    "\241\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[196];
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
          case 45: break;
          case 2: 
            { return WHITE_SPACE;
            } 
            // fall through
          case 46: break;
          case 3: 
            { return OP_4;
            } 
            // fall through
          case 47: break;
          case 4: 
            { return NUMBER;
            } 
            // fall through
          case 48: break;
          case 5: 
            { return ID;
            } 
            // fall through
          case 49: break;
          case 6: 
            { return OP_1;
            } 
            // fall through
          case 50: break;
          case 7: 
            { return OP_2;
            } 
            // fall through
          case 51: break;
          case 8: 
            { return OP_3;
            } 
            // fall through
          case 52: break;
          case 9: 
            { return OP_5;
            } 
            // fall through
          case 53: break;
          case 10: 
            { return COMMENT;
            } 
            // fall through
          case 54: break;
          case 11: 
            { return STRING;
            } 
            // fall through
          case 55: break;
          case 12: 
            { return OR;
            } 
            // fall through
          case 56: break;
          case 13: 
            { return AND;
            } 
            // fall through
          case 57: break;
          case 14: 
            { return NOT;
            } 
            // fall through
          case 58: break;
          case 15: 
            { return DAYS;
            } 
            // fall through
          case 59: break;
          case 16: 
            { return ELSE;
            } 
            // fall through
          case 60: break;
          case 17: 
            { return TRUE;
            } 
            // fall through
          case 61: break;
          case 18: 
            { return THEN;
            } 
            // fall through
          case 62: break;
          case 19: 
            { return WHEN;
            } 
            // fall through
          case 63: break;
          case 20: 
            { return EVENT;
            } 
            // fall through
          case 64: break;
          case 21: 
            { return FALSE;
            } 
            // fall through
          case 65: break;
          case 22: 
            { return SCALE;
            } 
            // fall through
          case 66: break;
          case 23: 
            { return WHILE;
            } 
            // fall through
          case 67: break;
          case 24: 
            { return HOURS;
            } 
            // fall through
          case 68: break;
          case 25: 
            { return EXISTS;
            } 
            // fall through
          case 69: break;
          case 26: 
            { return UNLESS;
            } 
            // fall through
          case 70: break;
          case 27: 
            { return WITHIN;
            } 
            // fall through
          case 71: break;
          case 28: 
            { return DEF_END;
            } 
            // fall through
          case 72: break;
          case 29: 
            { return SECONDS;
            } 
            // fall through
          case 73: break;
          case 30: 
            { return NUMERIC;
            } 
            // fall through
          case 74: break;
          case 31: 
            { return BOOLEAN;
            } 
            // fall through
          case 75: break;
          case 32: 
            { return MEASURE;
            } 
            // fall through
          case 76: break;
          case 33: 
            { return MINUTES;
            } 
            // fall through
          case 77: break;
          case 34: 
            { return RULE_END;
            } 
            // fall through
          case 78: break;
          case 35: 
            { return CONSTANT;
            } 
            // fall through
          case 79: break;
          case 36: 
            { return DEF_START;
            } 
            // fall through
          case 80: break;
          case 37: 
            { return OTHERWISE;
            } 
            // fall through
          case 81: break;
          case 38: 
            { return MEANWHILE;
            } 
            // fall through
          case 82: break;
          case 39: 
            { return EVENTUALLY;
            } 
            // fall through
          case 83: break;
          case 40: 
            { return RULE_START;
            } 
            // fall through
          case 84: break;
          case 41: 
            { return CONCERN_END;
            } 
            // fall through
          case 85: break;
          case 42: 
            { return PURPOSE_END;
            } 
            // fall through
          case 86: break;
          case 43: 
            { return CONCERN_START;
            } 
            // fall through
          case 87: break;
          case 44: 
            { return PURPOSE_START;
            } 
            // fall through
          case 88: break;
          default:
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
