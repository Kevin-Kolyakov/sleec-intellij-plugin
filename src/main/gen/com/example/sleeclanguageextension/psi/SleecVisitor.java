// This is a generated file. Not intended for manual editing.
package com.example.sleeclanguageextension.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class SleecVisitor extends PsiElementVisitor {

  public void visitEnder(@NotNull SleecEnder o) {
    visitPsiElement(o);
  }

  public void visitExpr(@NotNull SleecExpr o) {
    visitPsiElement(o);
  }

  public void visitFactorialExpr(@NotNull SleecFactorialExpr o) {
    visitExpr(o);
  }

  public void visitLiteralExpr(@NotNull SleecLiteralExpr o) {
    visitExpr(o);
  }

  public void visitMulExpr(@NotNull SleecMulExpr o) {
    visitExpr(o);
  }

  public void visitParenExpr(@NotNull SleecParenExpr o) {
    visitExpr(o);
  }

  public void visitPlusExpr(@NotNull SleecPlusExpr o) {
    visitExpr(o);
  }

  public void visitPropert(@NotNull SleecPropert o) {
    visitPsiElement(o);
  }

  public void visitProperties(@NotNull SleecProperties o) {
    visitPsiElement(o);
  }

  public void visitProperty(@NotNull SleecProperty o) {
    visitPsiElement(o);
  }

  public void visitRefExpr(@NotNull SleecRefExpr o) {
    visitExpr(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
