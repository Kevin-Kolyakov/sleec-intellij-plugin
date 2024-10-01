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

public class SleecNumMeasureImpl extends ASTWrapperPsiElement implements SleecNumMeasure {

  public SleecNumMeasureImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SleecVisitor visitor) {
    visitor.visitNumMeasure(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SleecVisitor) accept((SleecVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public SleecColon getColon() {
    return findNotNullChildByClass(SleecColon.class);
  }

  @Override
  @NotNull
  public SleecNumName getNumName() {
    return findNotNullChildByClass(SleecNumName.class);
  }

  @Override
  @NotNull
  public SleecNumericRule getNumericRule() {
    return findNotNullChildByClass(SleecNumericRule.class);
  }

}
