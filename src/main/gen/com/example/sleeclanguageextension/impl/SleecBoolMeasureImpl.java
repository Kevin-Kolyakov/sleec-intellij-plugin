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

public class SleecBoolMeasureImpl extends ASTWrapperPsiElement implements SleecBoolMeasure {

  public SleecBoolMeasureImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SleecVisitor visitor) {
    visitor.visitBoolMeasure(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SleecVisitor) accept((SleecVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public SleecBoolName getBoolName() {
    return findNotNullChildByClass(SleecBoolName.class);
  }

  @Override
  @Nullable
  public SleecBooleanRule getBooleanRule() {
    return findChildByClass(SleecBooleanRule.class);
  }

  @Override
  @Nullable
  public SleecColon getColon() {
    return findChildByClass(SleecColon.class);
  }

}
