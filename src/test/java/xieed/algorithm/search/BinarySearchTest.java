package xieed.algorithm.search;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTest {

    @Test
    public void binarySearch() {
        int[] numbers = new int[]{1,3,6,9,17,25};
        BinarySearch binarySearch = new BinarySearch();
        assertEquals(4, binarySearch.binarySearch(numbers, 17));
        assertEquals(-1, binarySearch.binarySearch(numbers, 19));

        assertEquals(4, binarySearch.binarySearchViaRecursion(numbers, 17, 0, numbers.length - 1));
        assertEquals(-1, binarySearch.binarySearchViaRecursion(numbers, 19, 0, numbers.length - 1));
    }
}