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

public class SleecDefinitionImpl extends ASTWrapperPsiElement implements SleecDefinition {

  public SleecDefinitionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SleecVisitor visitor) {
    visitor.visitDefinition(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SleecVisitor) accept((SleecVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public SleecConstantRule getConstantRule() {
    return findChildByClass(SleecConstantRule.class);
  }

  @Override
  @Nullable
  public SleecEventRule getEventRule() {
    return findChildByClass(SleecEventRule.class);
  }

  @Override
  @Nullable
  public SleecMeasureRule getMeasureRule() {
    return findChildByClass(SleecMeasureRule.class);
  }

}
