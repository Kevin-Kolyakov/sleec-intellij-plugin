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

public class SleecScalarMeasureImpl extends ASTWrapperPsiElement implements SleecScalarMeasure {

  public SleecScalarMeasureImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SleecVisitor visitor) {
    visitor.visitScalarMeasure(this);
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
  public SleecScalarName getScalarName() {
    return findNotNullChildByClass(SleecScalarName.class);
  }

  @Override
  @NotNull
  public SleecScaleRule getScaleRule() {
    return findNotNullChildByClass(SleecScaleRule.class);
  }

}
