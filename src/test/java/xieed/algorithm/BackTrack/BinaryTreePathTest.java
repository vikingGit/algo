package xieed.algorithm.BackTrack;

import org.junit.Test;
import xieed.explore.datastruct.Tree.TreeNode;

public class BinaryTreePathTest {

    @Test
    public void calPathDistance() {
        BinaryTreePath binaryTreePath = new BinaryTreePath();
        TreeNode rootNode = binaryTreePath.constructTranguliation();
        binaryTreePath.calPathDistance(rootNode, rootNode.getData());

        System.out.println("The shortest distance:" + binaryTreePath.getMiniumDistance());
    }


}