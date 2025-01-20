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

public class SleecPurposeNameImpl extends ASTWrapperPsiElement implements SleecPurposeName {

  public SleecPurposeNameImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SleecVisitor visitor) {
    visitor.visitPurposeName(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SleecVisitor) accept((SleecVisitor)visitor);
    else super.accept(visitor);
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