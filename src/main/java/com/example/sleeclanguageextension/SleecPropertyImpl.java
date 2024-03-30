// This is a generated file. Not intended for manual editing.
package com.example.sleeclanguageextension;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.example.sleeclanguageextension.SleecTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.example.sleeclanguageextension.psi.*;

public class SleecPropertyImpl extends ASTWrapperPsiElement implements SleecProperty {

  public SleecPropertyImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SleecVisitor visitor) {
    visitor.visitProperty(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SleecVisitor) accept((SleecVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  public String getKey() {
    return null;
  }

  @Override
  public String getValue() {
    return null;
  }

  @Override
  public PsiElement setName(@NotNull String newName) {
    return null;
  }

  @Override
  public PsiElement getNameIdentifier() {
    return null;
  }
}
