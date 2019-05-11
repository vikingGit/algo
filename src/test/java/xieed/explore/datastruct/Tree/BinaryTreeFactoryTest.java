package xieed.explore.datastruct.Tree;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class BinaryTreeFactoryTest {

    @Test
    public void should_return_correct_tree_when_createLinkedBinaryTree_given_root_data() {
        LinkedBinaryTree linkedBinaryTree = new BinaryTreeFactory().createLinkedBinaryTree(1);

        Assert.assertEquals(1, linkedBinaryTree.getRootNode().getData());
        Assert.assertEquals(2, linkedBinaryTree.getRootNode().getLeftNode().getData());
        Assert.assertEquals(3, linkedBinaryTree.getRootNode().getRightNode().getData());
        Assert.assertEquals(3, linkedBinaryTree.getRootNode().getLeftNode().getLeftNode().getData());
        Assert.assertEquals(4, linkedBinaryTree.getRootNode().getLeftNode().getRightNode().getData());
        Assert.assertEquals(4, linkedBinaryTree.getRootNode().getRightNode().getLeftNode().getData());
        Assert.assertEquals(5, linkedBinaryTree.getRootNode().getRightNode().getRightNode().getData());
    }

    @Test
    public void should_return_correct_tree_when_createCompleteBinaryTree_given_root_data() {
        CompleteArrayBinaryTree binaryTree = new BinaryTreeFactory().createArrayBinaryTree(1,10);
        StringBuilder builder = new StringBuilder();
        Arrays.stream(binaryTree.getElement()).forEach(i -> builder.append(i));
        System.out.println(builder.toString());

    }
}