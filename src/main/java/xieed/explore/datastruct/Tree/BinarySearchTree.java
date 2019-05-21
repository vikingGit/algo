package xieed.explore.datastruct.Tree;

public class BinarySearchTree {
    TreeNode rootNode;
    public static final String CURRENT_NODE ="CurrentNode";
    public static final String LEFT_NODE ="LeftNode";
    public static final String RIGHT_NODE ="RightNode";

    public BinarySearchTree(TreeNode rootNode) {
        this.rootNode = rootNode;
    }

    public TreeNode find(int targetData){
        TreeNode parentNode = rootNode;
        while(parentNode != null) {
            if (parentNode.getData() > targetData) {
                parentNode = parentNode.getLeftNode();

            } else if (parentNode.getData() < targetData) {
                parentNode = parentNode.getRightNode();
            } else {
                return parentNode;
            }
        }
        return  null;
    }

    public void insert(TreeNode newNode){
        TreeNode parentNode = rootNode;
        int targetData = newNode.getData();
        while(parentNode != null) {
            if (targetData < parentNode.getData()) {
                TreeNode leftNode = parentNode.getLeftNode();
                if (leftNode == null) {
                    parentNode.setLeftNode(newNode);
                    return;
                }
                //必须遍历到叶子节点，中途插入会有问题；大于当前左节点，不代表大于当前左节点下的所有子节点（请参考二叉搜索树的定义）
//                } else if (targetData > leftNode.getData()) {
//                    newNode.setLeftNode(newNode);
//                    parentNode.setLeftNode(newNode);
//                    return;
//                }
                parentNode = leftNode;
            }

            if (targetData > parentNode.getData()) {
                TreeNode rightNode = parentNode.getRightNode();
                if (rightNode == null) {
                    parentNode.setRightNode(newNode);
                    return;
                }
                //必须遍历到叶子节点，中途插入会有问题；小于当前右节点，不代小于于当前右节点下的所有子节点（请参考二叉搜索树的定义）
//                else if (targetData < rightNode.getData()) {
//                    newNode.setRightNode(rightNode);
//                    parentNode.setRightNode(newNode);
//                    return;
//                }
                parentNode = rightNode;
            }

            //for equal case,inert to right node
        }
    }

    //删除节点，可以参考王争实现：BinarySearchTree.java delete
    public void delete(int data){
        DeleteBinaryTreeNodeProcessor proc = this.findParentNode(data);
        proc.delete();

    }

    public DeleteBinaryTreeNodeProcessor findParentNode(int targetData){
        if(rootNode.getData() == targetData){
            return new DeleteBinaryTreeNodeProcessor(null, rootNode, CURRENT_NODE);
        }
        TreeNode parentNode = rootNode;
        while(parentNode != null) {
            if (parentNode.getLeftNode().getData() > targetData) {
                parentNode = parentNode.getLeftNode();
            } else if (parentNode.getLeftNode().getData()  < targetData) {
                parentNode = parentNode.getRightNode();
            } else if(parentNode.getLeftNode().getData() == targetData){
                return new DeleteBinaryTreeNodeProcessor(parentNode, parentNode.getLeftNode(), LEFT_NODE);
            }else{
                return new DeleteBinaryTreeNodeProcessor(parentNode, parentNode.getRightNode(), RIGHT_NODE);
            }
        }
        return  null;
    }
}
