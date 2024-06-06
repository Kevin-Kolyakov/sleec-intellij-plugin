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

public class SleecPurposeImpl extends ASTWrapperPsiElement implements SleecPurpose {

  public SleecPurposeImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SleecVisitor visitor) {
    visitor.visitPurpose(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SleecVisitor) accept((SleecVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public SleecExtendedResponse getExtendedResponse() {
    return findChildByClass(SleecExtendedResponse.class);
  }

  @Override
  @Nullable
  public SleecHeadlessConcern getHeadlessConcern() {
    return findChildByClass(SleecHeadlessConcern.class);
  }

  @Override
  @Nullable
  public SleecMBoolExpr getMBoolExpr() {
    return findChildByClass(SleecMBoolExpr.class);
  }

  @Override
  @NotNull
  public SleecPurposeName getPurposeName() {
    return findNotNullChildByClass(SleecPurposeName.class);
  }

  @Override
  @NotNull
  public SleecTrigger getTrigger() {
    return findNotNullChildByClass(SleecTrigger.class);
  }

}
