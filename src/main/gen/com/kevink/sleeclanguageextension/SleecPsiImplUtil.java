package com.kevink.sleeclanguageextension;
import com.intellij.lang.ASTNode;
import com.kevink.sleeclanguageextension.psi.SleecProperty;
import com.kevink.sleeclanguageextension.SleecTypes;

public class SleecPsiImplUtil {

    public static String getKey(SleecProperty element) {
        ASTNode keyNode = element.getNode().findChildByType(SleecTypes.COMMENT);
        if (keyNode != null) {
            // IMPORTANT: Convert embedded escaped spaces to simple spaces
            return keyNode.getText().replaceAll("\\\\ ", " ");
        } else {
            return null;
        }
    }

    public static String getValue(SleecProperty element) {
        ASTNode valueNode = element.getNode().findChildByType(SleecTypes.NUM_NAME);
        if (valueNode != null) {
            return valueNode.getText();
        } else {
            return null;
        }
    }

}
