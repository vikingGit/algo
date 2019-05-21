package xieed.explore.datastruct.Tree;

import static xieed.explore.datastruct.Tree.BinarySearchTree.LEFT_NODE;
import static xieed.explore.datastruct.Tree.BinarySearchTree.RIGHT_NODE;

public class DeleteBinaryTreeNodeProcessor {
    TreeNode parentNode;
    TreeNode delNode;
    String delNodeDirection;

    public DeleteBinaryTreeNodeProcessor(TreeNode parentNode, TreeNode delNode, String direction) {
        this.parentNode = parentNode;
        this.delNode = delNode;
        this.delNodeDirection = direction;
    }

    public TreeNode getParentNode() {
        return parentNode;
    }

    public void setParentNode(TreeNode parentNode) {
        this.parentNode = parentNode;
    }

    public String getDelNodeDirection() {
        return delNodeDirection;
    }

    public void setDelNodeDirection(String delNodeDirection) {
        this.delNodeDirection = delNodeDirection;
    }

    public TreeNode getTargetNode(){
        if(parentNode == null){
            return null;
        }
        if(LEFT_NODE.equals(delNodeDirection)){
            return parentNode.getLeftNode();
        }
        if (RIGHT_NODE.equals(delNodeDirection)){
            return parentNode.getRightNode();
        }
        return parentNode;
    }

    public void delete() {
        if(this.parentNode == null || this.delNode == null){
            return;
        }

        if(this.delNode.getLeftNode() == null && this.delNode.getRightNode() == null){
            if(LEFT_NODE.equals(delNodeDirection)){
                this.parentNode.setLeftNode(null);
            }else{
                this.parentNode.setRightNode(null);
            }
        }

        //删除节点下有1个子节点
        if(this.delNode.getLeftNode() != null || this.delNode.getRightNode() != null){
            if(LEFT_NODE.equals(delNodeDirection)){
                if(this.delNode.getLeftNode() != null){
                    this.parentNode.setLeftNode(this.delNode.getLeftNode());
                    this.delNode.setLeftNode(null);
                }else if(this.delNode.getRightNode() != null){
                    this.parentNode.setLeftNode(this.delNode.getRightNode());
                    this.delNode.setRightNode(null);
                }
            }
            if(RIGHT_NODE.equals(delNodeDirection)){
                if(this.delNode.getLeftNode() != null){
                    this.parentNode.setRightNode(this.delNode.getLeftNode());
                    this.delNode.setLeftNode(null);
                }else if(this.delNode.getRightNode() != null){
                    this.parentNode.setRightNode(this.delNode.getRightNode());
                    this.delNode.setRightNode(null);
                }
            }

            //删除节点下有两个子节点
            if(this.delNode.getLeftNode() != null && this.delNode.getRightNode() != null){
                TreeNode rightNode = this.delNode.getRightNode();
                if(rightNode.getLeftNode() == null){
                    if(LEFT_NODE.equals(delNodeDirection)){
                        this.parentNode.setLeftNode(rightNode);
                    }else{
                        this.parentNode.setRightNode(rightNode);
                    }
                  return;
                }

                TreeNode parentOfMinimumNode = findParentOfMinmumNode(rightNode);
                TreeNode minimumNode = parentOfMinimumNode.getLeftNode();
                if(LEFT_NODE.equals(delNodeDirection)){
                    this.parentNode.setLeftNode(minimumNode);
                }else{
                    this.parentNode.setRightNode(minimumNode);
                }
                parentOfMinimumNode.setLeftNode(null);
                minimumNode.setLeftNode(delNode.getLeftNode());
                minimumNode.setRightNode(delNode.getRightNode());
                delNode.setLeftNode(null);
                delNode.setRightNode(null);
            }

        }

    }

    private TreeNode findParentOfMinmumNode(TreeNode node) {
        TreeNode pNode = node;
        while(pNode.getLeftNode() != null){
            if(pNode.getLeftNode().getLeftNode() == null){
                return pNode;
            }else{
                pNode = pNode.getLeftNode();
            }
        }

        return null;
    }
}
