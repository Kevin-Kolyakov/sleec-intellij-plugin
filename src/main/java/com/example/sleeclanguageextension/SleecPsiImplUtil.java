package com.example.sleeclanguageextension;

import com.intellij.lang.ASTNode;
import com.example.sleeclanguageextension.SleecProperty;
import com.example.sleeclanguageextension.SleecTypes;

public class SleecPsiImplUtil {

    public static String getKey(SleecProperty element) {
        ASTNode keyNode = element.getNode().findChildByType(SleecTypes.KEY);
        if (keyNode != null) {
            // IMPORTANT: Convert embedded escaped spaces to simple spaces
            return keyNode.getText().replaceAll("\\\\ ", " ");
        } else {
            return null;
        }
    }

    public static String getValue(SleecProperty element) {
        ASTNode valueNode = element.getNode().findChildByType(SleecTypes.VALUE);
        if (valueNode != null) {
            return valueNode.getText();
        } else {
            return null;
        }
    }

}