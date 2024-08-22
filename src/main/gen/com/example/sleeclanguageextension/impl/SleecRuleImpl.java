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

public class SleecRuleImpl extends ASTWrapperPsiElement implements SleecRule {

  public SleecRuleImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SleecVisitor visitor) {
    visitor.visitRule(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SleecVisitor) accept((SleecVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public SleecMBoolExpr getMBoolExpr() {
    return findChildByClass(SleecMBoolExpr.class);
  }

  @Override
  @NotNull
  public SleecResponse getResponse() {
    return findNotNullChildByClass(SleecResponse.class);
  }

  @Override
  @NotNull
  public SleecTrigger getTrigger() {
    return findNotNullChildByClass(SleecTrigger.class);
  }

  @Override
  @Nullable
  public PsiElement getConstantId() {
    return findChildByType(CONSTANT_ID);
  }

  @Override
  @Nullable
  public PsiElement getEventId() {
    return findChildByType(EVENT_ID);
  }

  @Override
  @Nullable
  public PsiElement getId() {
    return findChildByType(ID);
  }

  @Override
  @Nullable
  public PsiElement getMeasureId() {
    return findChildByType(MEASURE_ID);
  }

}
