package xieed.explore.datastruct.Tree;

public class TreeNode {
    private int data;
    private TreeNode leftNode;
    private TreeNode rightNode;

    public TreeNode(){

    }

    public TreeNode(int targetData, TreeNode leftNode, TreeNode rightNode) {
        this.data = targetData;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public TreeNode(int targetData) {
        this.data = targetData;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public TreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }
}
