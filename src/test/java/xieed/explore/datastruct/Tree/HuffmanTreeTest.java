package xieed.explore.datastruct.Tree;

import org.junit.Test;

import static org.junit.Assert.*;

public class HuffmanTreeTest {

    /**
     *
     *
     *
     *
     *                    16         10              10
     *                7      9    5       5
     *                                  2    3
     */
    @Test
    public void should_construct_huffman_tree_when_init_given_data() {
        HuffmanTree tree = new HuffmanTree(new int[]{2,5,3,9,12,7,10});
        tree.init();

        assertEquals(48, tree.rootNode.getData());
        assertEquals(20, tree.rootNode.getLeftNode().getData());
        assertEquals(28, tree.rootNode.getRightNode().getData());
        assertEquals(5, tree.rootNode.getLeftNode().getRightNode().getLeftNode().getData());
    }
}