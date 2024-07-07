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

public class SleecMeasureRuleImpl extends ASTWrapperPsiElement implements SleecMeasureRule {

  public SleecMeasureRuleImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SleecVisitor visitor) {
    visitor.visitMeasureRule(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SleecVisitor) accept((SleecVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public SleecBoolMeasure getBoolMeasure() {
    return findChildByClass(SleecBoolMeasure.class);
  }

  @Override
  @Nullable
  public SleecNumMeasure getNumMeasure() {
    return findChildByClass(SleecNumMeasure.class);
  }

  @Override
  @Nullable
  public SleecScalarMeasure getScalarMeasure() {
    return findChildByClass(SleecScalarMeasure.class);
  }

}
