package xieed.explore.datastruct.Tree;

public class LinkedBinaryTree implements BinaryTree{
    public TreeNode getRootNode() {
        return rootNode;
    }

    public void setRootNode(TreeNode rootNode) {
        this.rootNode = rootNode;
    }
    TreeNode rootNode;

    StringBuilder treeBuilder = new StringBuilder();

    public void loopBinaryTreeOverPreOrder(TreeNode node){
        if(node == null){
            return;
        }
//        System.out.print(rootNode.getData() + " ");
        treeBuilder.append(node.getData() + " ");
        loopBinaryTreeOverPreOrder(node.getLeftNode());
        loopBinaryTreeOverPreOrder(node.getRightNode());
    }

    public void loopBinaryTreeOverMiddleOrder(TreeNode node){
        if(node == null){
            return;
        }
        loopBinaryTreeOverMiddleOrder(node.getLeftNode());
//        System.out.print(rootNode.getData() + " ");
        treeBuilder.append(node.getData() + " ");
        loopBinaryTreeOverMiddleOrder(node.getRightNode());
    }

    public void loopBinaryTreeOverPostOrder(TreeNode node){
        if(node == null){
            return;
        }
        loopBinaryTreeOverPostOrder(node.getLeftNode());
        loopBinaryTreeOverPostOrder(node.getRightNode());
        // System.out.print(rootNode.getData() + " ");
        treeBuilder.append(node.getData() + " ");
    }

    @Override
    public int height() {
        return maxHeight(this.getRootNode()) - 1;
    }

    public int maxHeight(TreeNode node){
        if(node == null){
            return 0;
        }
        int leftHeight = maxHeight(node.getLeftNode()) + 1;
        int rightHeight = maxHeight(node.getRightNode()) + 1;

        if(leftHeight > rightHeight){
            return leftHeight;
        }else{
            return rightHeight;
        }
    }
}
