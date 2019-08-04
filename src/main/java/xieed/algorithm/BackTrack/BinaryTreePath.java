package xieed.algorithm.BackTrack;

import xieed.explore.datastruct.Tree.TreeNode;

public class BinaryTreePath {
    //https://time.geekbang.org/column/article/74788
    public TreeNode constructTranguliation(){
        TreeNode thirdLayerNode1 = new TreeNode(2);
        TreeNode thirdLayerNode2 = new TreeNode(4);
        TreeNode thirdLayerNode3 = new TreeNode(3);
        TreeNode thirdLayerNode4 = new TreeNode(5);

        TreeNode secondLayerNode1 = new TreeNode(3, thirdLayerNode1,thirdLayerNode2);
        TreeNode secondLayerNode2 = new TreeNode(1, thirdLayerNode3, thirdLayerNode4);

        TreeNode rootNode = new TreeNode(0, secondLayerNode1, secondLayerNode2);
        return rootNode;
    }

    public int miniumDistance = Integer.MAX_VALUE;
    public void calPathDistance(TreeNode node, int distanceSum){
        if(node.getLeftNode() == null || node.getRightNode() == null){
            if(distanceSum < miniumDistance){
                miniumDistance = distanceSum;
            }
            return;
        }

        calPathDistance(node.getLeftNode(),distanceSum + node.getLeftNode().getData());
        calPathDistance(node.getRightNode(),distanceSum + node.getRightNode().getData());
    }

    public int getMiniumDistance() {
        return miniumDistance;
    }
}
