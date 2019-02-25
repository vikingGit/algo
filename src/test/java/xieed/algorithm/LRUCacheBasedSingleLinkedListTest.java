package xieed.algorithm;

import org.junit.Test;
import xieed.explore.datastruct.linklist.LinkedListNode;

import static org.junit.Assert.*;

public class LRUCacheBasedSingleLinkedListTest {

    @Test
    public void should_insert_data_to_head_when_cacheData_given_empty_single_list() {
        LRUCacheBasedSingleLinkedList lruCache = new LRUCacheBasedSingleLinkedList(4);
        lruCache.cacheData(1);

        assertEquals(1, lruCache.getSingleLinkedList().getHeadNode().getValue());
    }

    @Test
    public void should_move_new_data_to_head_when_cacheData_given_non_empty_single_list(){
        LRUCacheBasedSingleLinkedList lruCache = new LRUCacheBasedSingleLinkedList(4);
        lruCache.cacheData(1);
        lruCache.cacheData(2);
        lruCache.cacheData(3);

        LinkedListNode headNode = lruCache.getSingleLinkedList().getHeadNode();
        assertEquals(3, headNode.getValue());
        assertEquals(2, headNode.getNextNode().getValue());
        assertEquals(1, headNode.getNextNode().getNextNode().getValue());
    }

    @Test
    public void should_remove_tail_data_when_cacheData_given_single_list_is_full() {
        LRUCacheBasedSingleLinkedList lruCache = new LRUCacheBasedSingleLinkedList(4);
        lruCache.cacheData(1);
        lruCache.cacheData(2);
        lruCache.cacheData(3);
        lruCache.cacheData(4);
        lruCache.cacheData(5);

        LinkedListNode headNode = lruCache.getSingleLinkedList().getHeadNode();
        assertEquals(5, headNode.getValue());
        assertEquals(4, headNode.getNextNode().getValue());
        assertEquals(3, headNode.getNextNode().getNextNode().getValue());
        assertEquals(2, headNode.getNextNode().getNextNode().getNextNode().getValue());
    }
}