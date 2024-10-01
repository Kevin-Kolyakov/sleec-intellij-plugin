// This is a generated file. Not intended for manual editing.
package com.kevink.sleeclanguageextension.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SleecResponse extends PsiElement {

  @Nullable
  SleecAlternative getAlternative();

  @NotNull
  List<SleecDefeater> getDefeaterList();

  @Nullable
  SleecNd getNd();

  @NotNull
  SleecOcc getOcc();

}
