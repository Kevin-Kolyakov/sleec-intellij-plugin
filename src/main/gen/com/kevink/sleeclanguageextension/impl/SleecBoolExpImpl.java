// This is a generated file. Not intended for manual editing.
package com.kevink.sleeclanguageextension.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.kevink.sleeclanguageextension.SleecTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.kevink.sleeclanguageextension.psi.*;
import com.kevink.sleeclanguageextension.SleecPsiImplUtil;

public class SleecBoolExpImpl extends ASTWrapperPsiElement implements SleecBoolExp {

  public SleecBoolExpImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SleecVisitor visitor) {
    visitor.visitBoolExp(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SleecVisitor) accept((SleecVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public SleecBinaryOp getBinaryOp() {
    return findChildByClass(SleecBinaryOp.class);
  }

  @Override
  @Nullable
  public SleecBoolTerminal getBoolTerminal() {
    return findChildByClass(SleecBoolTerminal.class);
  }

  @Override
  @Nullable
  public SleecNegation getNegation() {
    return findChildByClass(SleecNegation.class);
  }

}
