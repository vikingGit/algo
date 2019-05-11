package xieed.explore.datastruct.Tree;

public class BinaryTreeFactory {

    public void createTreeNode(TreeNode parentNode){
        if(parentNode.getData() >= 8){
            return;
        }

        TreeNode leftTreeNode = new TreeNode();
        leftTreeNode.setData(parentNode.getData() + 1);

        TreeNode rightTreeNode = new TreeNode();
        rightTreeNode.setData(parentNode.getData() + 2);

        parentNode.setLeftNode(leftTreeNode);
        parentNode.setRightNode(rightTreeNode);
        createTreeNode(leftTreeNode);
        createTreeNode(rightTreeNode);
    }

    public LinkedBinaryTree createLinkedBinaryTree(int rootData){
        TreeNode rootNode = new TreeNode();
        rootNode.setData(rootData);
        createTreeNode(rootNode);

        LinkedBinaryTree linkedBinaryTree = new LinkedBinaryTree();
        linkedBinaryTree.setRootNode(rootNode);
        return linkedBinaryTree;
    }

    public CompleteArrayBinaryTree createArrayBinaryTree(int rootData, int len){
        return new CompleteArrayBinaryTree(rootData, len);
    }


}
