package xieed.explore.datastruct.Tree;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CompleteArrayBinaryTreeTest {

    @Test
    public void should_return_data_by_preOrder_when_loopBinaryTreeOverPreOrder_given_specific_CompleteArrayBinaryTree() {
        CompleteArrayBinaryTree binaryTree = new BinaryTreeFactory().createArrayBinaryTree(2,10);

        binaryTree.loopBinaryTreeOverPreOrder(1);

        Assert.assertEquals("2 4 8 16 17 9 5 10 11 ", binaryTree.builder.toString());
    }

    @Test
    public void should_return_data_by_preOrder_when_loopBinaryTreeOverMiddleOrder_given_specific_CompleteArrayBinaryTree() {
        CompleteArrayBinaryTree binaryTree = new BinaryTreeFactory().createArrayBinaryTree(2,10);

        binaryTree.loopBinaryTreeOverMiddleOrder(1);

        Assert.assertEquals("16 8 17 4 9 2 10 5 11 ", binaryTree.builder.toString());
    }

    @Test
    public void should_return_data_by_preOrder_when_loopBinaryTreeOverPostOrder_given_specific_CompleteArrayBinaryTree() {
        CompleteArrayBinaryTree binaryTree = new BinaryTreeFactory().createArrayBinaryTree(2,10);

        binaryTree.loopBinaryTreeOverPostOrder(1);

        Assert.assertEquals("16 17 8 9 4 10 11 5 2 ", binaryTree.builder.toString());
    }
}