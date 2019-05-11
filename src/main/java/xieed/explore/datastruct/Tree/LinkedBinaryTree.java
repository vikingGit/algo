package xieed.explore.datastruct.Tree;

public class LinkedBinaryTree {
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
//        System.out.print(node.getData() + " ");
        treeBuilder.append(node.getData() + " ");
        loopBinaryTreeOverPreOrder(node.getLeftNode());
        loopBinaryTreeOverPreOrder(node.getRightNode());
    }

    public void loopBinaryTreeOverMiddleOrder(TreeNode node){
        if(node == null){
            return;
        }
        loopBinaryTreeOverMiddleOrder(node.getLeftNode());
//        System.out.print(node.getData() + " ");
        treeBuilder.append(node.getData() + " ");
        loopBinaryTreeOverMiddleOrder(node.getRightNode());
    }

    public void loopBinaryTreeOverPostOrder(TreeNode node){
        if(node == null){
            return;
        }
        loopBinaryTreeOverPostOrder(node.getLeftNode());
        loopBinaryTreeOverPostOrder(node.getRightNode());
        // System.out.print(node.getData() + " ");
        treeBuilder.append(node.getData() + " ");
    }
}
