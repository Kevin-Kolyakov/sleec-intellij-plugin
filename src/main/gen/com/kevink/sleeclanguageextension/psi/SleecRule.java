// This is a generated file. Not intended for manual editing.
package com.kevink.sleeclanguageextension.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SleecRule extends PsiElement {

  @Nullable
  SleecMBoolExpr getMBoolExpr();

  @NotNull
  SleecResponse getResponse();

  @NotNull
  SleecTrigger getTrigger();

  @Nullable
  PsiElement getConstantId();

  @Nullable
  PsiElement getEventId();

  @Nullable
  PsiElement getId();

  @Nullable
  PsiElement getMeasureId();

}
