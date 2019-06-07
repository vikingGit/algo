package xieed.algorithm.search;

import org.junit.Test;

import static org.junit.Assert.*;

public class TrieTreeTest {

    @Test
    public void should_construct_correct_trie_tree_when_insert_given_hello() {
        TrieTree trieTree = new TrieTree();
        trieTree.insert("hello");

        TrieTree.TrieTreeNode parentNode = trieTree.rootNode;
        assertEquals('h', parentNode.childNode['h' - 'a'].node);

        parentNode = parentNode.childNode['h' - 'a'];
        assertEquals('e', parentNode.childNode['e' - 'a'].node);

        parentNode = parentNode.childNode['e' - 'a'];
        assertEquals('l', parentNode.childNode['l'-'a'].node);

        parentNode = parentNode.childNode['l'-'a'];
        assertEquals('l', parentNode.childNode['l' - 'a'].node);

        parentNode = parentNode.childNode['l'-'a'];
        assertEquals('o', parentNode.childNode['o' - 'a'].node);
    }

    @Test
    public void should_return_true_when_find_given_ending_str_hello() {
        TrieTree trieTree = new TrieTree();
        trieTree.insert("hello");

        assertEquals(true, trieTree.find("hello"));
    }

    @Test
    public void should_return_false_when_find_given_prefix_str_hell() {
        TrieTree trieTree = new TrieTree();
        trieTree.insert("hello");

        assertEquals(false, trieTree.find("hell"));
    }
}