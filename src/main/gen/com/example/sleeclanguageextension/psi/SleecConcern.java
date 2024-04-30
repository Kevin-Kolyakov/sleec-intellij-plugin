// This is a generated file. Not intended for manual editing.
package com.example.sleeclanguageextension.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SleecConcern extends PsiElement {

  @Nullable
  SleecBoolExpValue getBoolExpValue();

  @NotNull
  SleecConcernName getConcernName();

  @Nullable
  SleecExtendedResponse getExtendedResponse();

  @Nullable
  SleecHeadlessConcern getHeadlessConcern();

  @NotNull
  SleecTrigger getTrigger();

}
