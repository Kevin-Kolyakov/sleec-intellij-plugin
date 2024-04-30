// This is a generated file. Not intended for manual editing.
package com.example.sleeclanguageextension.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.example.sleeclanguageextension.SleecTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.example.sleeclanguageextension.psi.*;
import com.example.sleeclanguageextension.SleecPsiImplUtil;

public class SleecBinaryOpImpl extends ASTWrapperPsiElement implements SleecBinaryOp {

  public SleecBinaryOpImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SleecVisitor visitor) {
    visitor.visitBinaryOp(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SleecVisitor) accept((SleecVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public SleecBoolBinaryOp getBoolBinaryOp() {
    return findChildByClass(SleecBoolBinaryOp.class);
  }

  @Override
  @Nullable
  public SleecNumericalOp getNumericalOp() {
    return findChildByClass(SleecNumericalOp.class);
  }

  @Override
  @Nullable
  public SleecScalarBinaryOp getScalarBinaryOp() {
    return findChildByClass(SleecScalarBinaryOp.class);
  }

}
