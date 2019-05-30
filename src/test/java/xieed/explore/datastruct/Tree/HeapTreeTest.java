package xieed.explore.datastruct.Tree;

import org.junit.Test;

import static org.junit.Assert.*;

public class HeapTreeTest {
    /**                          50
     *                  47                   48
     *              35      40         39
     *
     */
    @Test
    public void should_insert_into_index_2_when_insert_48_given_TopBigHeap() {
        HeapTree heapTree = new HeapTree(12);
        heapTree.insert(35);
        heapTree.insert(39);
        heapTree.insert(47);
        heapTree.insert(40);
        heapTree.insert(50);
        heapTree.insert(48);
        heapTree.insert(49);
        assertEquals(49, heapTree.get(3));
        System.out.println(heapTree.toString());
    }

    /**
     *
     */
    @Test
    public void should_del_success_when_deleteRootNode_given_TopBigHeap() {
        HeapTree heapTree = new HeapTree(12);
        heapTree.insert(35);
        heapTree.insert(39);
        heapTree.insert(47);
        heapTree.insert(40);
        heapTree.insert(50);
        heapTree.insert(48);
        heapTree.insert(49);
        System.out.println(heapTree.toString());

        heapTree.deleteRootNode();
        assertEquals(" 49 47 48 35 40 39", heapTree.toString());

        heapTree.deleteRootNode();
        assertEquals(" 48 47 39 35 40", heapTree.toString());
    }

    @Test
    public void should_return_top_big_heap_when_buildHeapTreeByUpDownHeapify_given_int_array() {
        int[] a = new int[]{69,70,23,45,56,22,32,14,23};
        HeapTree heapTree = new HeapTree();
        heapTree.buildHeapTreeByUpDownHeapify(a);
        assertArrayEquals(a, new int[]{ 70,69,32,45,56,22,23,14,23});
    }

    @Test
    public void shout_sort_by_ascending_when_heapSort_given_int_array() {
        int[] a = new int[]{69,70,23,45,56,22,32,14,23};
        HeapTree heapTree = new HeapTree();
        heapTree.heapSort(a);
        assertArrayEquals(a, new int[]{14,22,23,23,32,45,56,69,70});}
}