package com.example.sleeclanguageextension;

import com.intellij.codeInsight.editorActions.TypedHandlerDelegate;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;

public class SleecTypedHandler extends TypedHandlerDelegate {

    @Override
    public Result charTyped(char c, @NotNull Project project, @NotNull Editor editor, @NotNull PsiFile file) {
        if (c == '(' || c == '{' || c == '[') {
            insertPairedBracket(editor, c);
        }
        return super.charTyped(c, project, editor, file);
    }

    private void insertPairedBracket(@NotNull Editor editor, char c) {
//        String pairedBracket = getPairedBracket(c);
//        if (pairedBracket != null) {
//            int offset = editor.getCaretModel().getOffset();
//            editor.getDocument().insertString(offset, pairedBracket);
//            editor.getCaretModel().moveToOffset(offset);
//        }
    }

    private String getPairedBracket(char c) {
        switch (c) {
            case '(':
                return ")";
            case '{':
                return "}";
            case '[':
                return "]";
            default:
                return null;
        }
    }
}
