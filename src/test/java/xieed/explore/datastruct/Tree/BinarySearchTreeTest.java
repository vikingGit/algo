package xieed.explore.datastruct.Tree;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {

    @Test
    public void should_return_correct_treeNode_when_find_given_BinarySearchTree() {
        BinarySearchTree binarySearchTree = createBinarySearchTree();
        assertSame(binarySearchTree.find(17), binarySearchTree.rootNode.getLeftNode().getLeftNode().getRightNode());
        assertSame(binarySearchTree.find(44), binarySearchTree.rootNode.getRightNode().getLeftNode());
    }

    @Test
    public void should_insert_into_correct_place_when_insert_given_BinarySearchTree() {
        BinarySearchTree binarySearchTree = createBinarySearchTree();
        TreeNode newNode = new TreeNode(25, null, null);
        TreeNode newNode1 = new TreeNode(19, null, null);

        binarySearchTree.insert(newNode);
        assertSame(binarySearchTree.rootNode.getLeftNode().getRightNode().getRightNode(), newNode);

        binarySearchTree.insert(newNode1);
        assertSame(binarySearchTree.rootNode.getLeftNode().getLeftNode().getRightNode().getRightNode(), newNode1);
    }


    /**
     *                                 40
     *                    20L                     48R
     *              15L           21R        44L         50R
     *         12L       17R
     * @return
     */
    private BinarySearchTree createBinarySearchTree() {
        TreeNode rootNode = new TreeNode(40);

        TreeNode leftNode1 = new TreeNode(15);
        leftNode1.setLeftNode(new TreeNode(12));
        leftNode1.setRightNode(new TreeNode(17));
        rootNode.setLeftNode(new TreeNode(20, leftNode1, new TreeNode(21)));
        rootNode.setRightNode(new TreeNode(48, new TreeNode(44),new TreeNode(50)));

        return new BinarySearchTree(rootNode);
    }
}