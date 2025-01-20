// This is a generated file. Not intended for manual editing.
package com.kevink.sleeclanguageextension.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.kevink.sleeclanguageextension.SleecTypes.*;
import com.kevink.sleeclanguageextension.psi.*;
import com.kevink.sleeclanguageextension.SleecPsiImplUtil;

public class SleecRefExprImpl extends SleecExprImpl implements SleecRefExpr {

  public SleecRefExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull SleecVisitor visitor) {
//    visitor.visitRefExpr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SleecVisitor) accept((SleecVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public PsiElement getId() {
    return findNotNullChildByType(ID);
  }

}