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

public class SleecPropertImpl extends ASTWrapperPsiElement implements SleecPropert {

  public SleecPropertImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SleecVisitor visitor) {
    visitor.visitPropert(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SleecVisitor) accept((SleecVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public SleecConcernBlock getConcernBlock() {
    return findChildByClass(SleecConcernBlock.class);
  }

  @Override
  @NotNull
  public SleecDefblock getDefblock() {
    return findNotNullChildByClass(SleecDefblock.class);
  }

  @Override
  @Nullable
  public SleecPurposeBlock getPurposeBlock() {
    return findChildByClass(SleecPurposeBlock.class);
  }

  @Override
  @NotNull
  public SleecRuleBlock getRuleBlock() {
    return findNotNullChildByClass(SleecRuleBlock.class);
  }

}
