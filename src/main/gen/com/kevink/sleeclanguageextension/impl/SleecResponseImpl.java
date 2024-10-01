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

public class SleecResponseImpl extends ASTWrapperPsiElement implements SleecResponse {

  public SleecResponseImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SleecVisitor visitor) {
    visitor.visitResponse(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SleecVisitor) accept((SleecVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public SleecAlternative getAlternative() {
    return findChildByClass(SleecAlternative.class);
  }

  @Override
  @NotNull
  public List<SleecDefeater> getDefeaterList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SleecDefeater.class);
  }

  @Override
  @Nullable
  public SleecNd getNd() {
    return findChildByClass(SleecNd.class);
  }

  @Override
  @NotNull
  public SleecOcc getOcc() {
    return findNotNullChildByClass(SleecOcc.class);
  }

}
