//package com.example.sleeclanguageextension.spacing;
//
//import com.example.sleeclanguageextension.SleecLanguage;
//import com.example.sleeclanguageextension.SleecTypes;
//import com.intellij.formatting.*;
//import com.intellij.lang.ASTNode;
//import com.intellij.openapi.util.TextRange;
//import com.intellij.psi.PsiElement;
//import com.intellij.psi.codeStyle.CodeStyleSettings;
//import com.intellij.psi.formatter.common.AbstractBlock;
//import com.intellij.psi.tree.IElementType;
//import org.jetbrains.annotations.NotNull;
//import org.jetbrains.annotations.Nullable;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class SleecFormattingModelBuilder implements FormattingModelBuilder {
//
//    @Override
//    public @NotNull FormattingModel createModel(@NotNull FormattingContext formattingContext) {
//        PsiElement element = formattingContext.getPsiElement();
//        CodeStyleSettings settings = formattingContext.getCodeStyleSettings();
//        return FormattingModelProvider.createFormattingModelForPsiFile(
//                element.getContainingFile(),
//                new SleecBlock(element.getNode(), Wrap.createWrap(WrapType.NONE, false),
//                        Alignment.createAlignment(), createSpaceBuilder(settings)),
//                settings
//        );
//    }
//
//    private static SpacingBuilder createSpaceBuilder(CodeStyleSettings settings) {
//        return new SpacingBuilder(settings, SleecLanguage.INSTANCE)
//                .before(SleecTypes.COLON).spaces(1)
//                .after(SleecTypes.COLON).spaces(1)
//                .around(SleecTypes.OP_1).spaces(1)
//                .around(SleecTypes.OP_2).spaces(1)
//                .around(SleecTypes.OP_3).spaces(1)
//                .around(SleecTypes.OP_4).spaces(1)
//                .around(SleecTypes.OP_5).spaces(1);
//    }
//
//    private static class SleecBlock extends AbstractBlock {
//        private final SpacingBuilder spacingBuilder;
//
//        protected SleecBlock(@NotNull ASTNode node, @Nullable Wrap wrap, @Nullable Alignment alignment, SpacingBuilder spacingBuilder) {
//            super(node, wrap, alignment);
//            this.spacingBuilder = spacingBuilder;
//        }
//
//        @Override
//        protected List<Block> buildChildren() {
//            List<Block> blocks = new ArrayList<>();
//            ASTNode child = myNode.getFirstChildNode();
//            while (child != null) {
//                if (child.getTextRange().getLength() > 0) {
//                    blocks.add(new SleecBlock(child, Wrap.createWrap(WrapType.NONE, false), Alignment.createAlignment(), spacingBuilder));
//                }
//                child = child.getTreeNext();
//            }
//            return blocks;
//        }
//
//        @Override
//        public @Nullable Spacing getSpacing(@Nullable Block child1, @NotNull Block child2) {
//            return spacingBuilder.getSpacing(this, child1, child2);
//        }
//
//        @Override
//        public @Nullable Indent getIndent() {
//            // Apply normal indentation if the node is inside start/end blocks
//            if (isInsideBlock(myNode)) {
//                return Indent.getNormalIndent();
//            }
//            return Indent.getNoneIndent();
//        }
//
//        @Override
//        public @Nullable Indent getChildIndent() {
//            if (isBlockStartOrEnd(myNode)) {
//                return Indent.getNoneIndent();
//            }
//            return Indent.getNormalIndent();
//        }
//
//        private boolean isInsideBlock(ASTNode node) {
//            ASTNode parent = node.getTreeParent();
//            while (parent != null) {
//                if (isBlockStartOrEnd(parent)) {
//                    return true;
//                }
//                parent = parent.getTreeParent();
//            }
//            return false;
//        }
//
//        private boolean isBlockStartOrEnd(ASTNode node) {
//            IElementType type = node.getElementType();
//            return type == SleecTypes.DEF_START || type == SleecTypes.DEF_END ||
//                    type == SleecTypes.RULE_START || type == SleecTypes.RULE_END ||
//                    type == SleecTypes.CONCERN_START || type == SleecTypes.CONCERN_END ||
//                    type == SleecTypes.PURPOSE_START || type == SleecTypes.PURPOSE_END;
//        }
//
//        @Override
//        public boolean isLeaf() {
//            return myNode.getFirstChildNode() == null;
//        }
//    }
//}
