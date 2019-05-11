package xieed.explore.datastruct.Tree;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedBinaryTreeTest {

    @Test
    public void should_return_data_by_preOrder_when_loopBinaryTreeOverPreOrder_given_specific_linkedBinaryTree() {
        BinaryTreeFactory binaryTreeFactory = new BinaryTreeFactory();
        LinkedBinaryTree linkedBinaryTree = binaryTreeFactory.createLinkedBinaryTree(5);
        linkedBinaryTree.loopBinaryTreeOverPreOrder(linkedBinaryTree.getRootNode());

        Assert.assertEquals("5 6 7 8 9 8 7 8 9 ", linkedBinaryTree.treeBuilder.toString());
    }

    @Test
    public void should_return_data_by_preOrder_when_loopBinaryTreeOverMiddleOrder_given_specific_linkedBinaryTree() {
        BinaryTreeFactory binaryTreeFactory = new BinaryTreeFactory();
        LinkedBinaryTree linkedBinaryTree = binaryTreeFactory.createLinkedBinaryTree(5);
        linkedBinaryTree.loopBinaryTreeOverMiddleOrder(linkedBinaryTree.getRootNode());

        Assert.assertEquals("8 7 9 6 8 5 8 7 9 ", linkedBinaryTree.treeBuilder.toString());
    }

    @Test
    public void should_return_data_by_preOrder_when_loopBinaryTreeOverPostOrder_given_specific_linkedBinaryTree() {
        BinaryTreeFactory binaryTreeFactory = new BinaryTreeFactory();
        LinkedBinaryTree linkedBinaryTree = binaryTreeFactory.createLinkedBinaryTree(5);
        linkedBinaryTree.loopBinaryTreeOverPostOrder(linkedBinaryTree.getRootNode());

        Assert.assertEquals("8 9 7 8 6 8 9 7 5 ", linkedBinaryTree.treeBuilder.toString());
    }
}