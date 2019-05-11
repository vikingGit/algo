package xieed.algorithm.search;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTest {

    @Test
    public void should_return_equal_element_when_binarySearch_given_ordered_array() {
        int[] numbers = new int[]{1,3,6,9,17,25};
        BinarySearch binarySearch = new BinarySearch();
        assertEquals(4, binarySearch.binarySearch(numbers, 17));
        assertEquals(-1, binarySearch.binarySearch(numbers, 19));

        assertEquals(4, binarySearch.binarySearchViaRecursion(numbers, 17, 0, numbers.length - 1));
        assertEquals(-1, binarySearch.binarySearchViaRecursion(numbers, 19, 0, numbers.length - 1));
    }

    @Test
    public void should_return_the_first_equal_element_when_binarySearchFirstEqual_given_ordered_array_include_duplicate_element() {
        int[] numbers = new int[]{1,2,2,2,3,7,9,10,20};
        assertEquals(1, new BinarySearch().binarySearchFirstEqual(numbers, 2));
    }

    @Test
    public void should_return_the_last_equal_element_when_binarySearchLastEqual_given_ordered_array_include_duplicate_element() {
        int[] numbers = new int[]{1,2,2,2,3,7,9,9,9,20};
        assertEquals(8, new BinarySearch().binarySearchLastEqual(numbers, 9));
    }

    @Test
    public void should_return_the_first_greater_or_equal_element_when_binarySearchFirstGreaterEqual_given_ordered_array_include_duplicate_element() {
        int[] numbers = new int[]{1,3,3,4,6,7,9,9,9,20};
        assertEquals(1, new BinarySearch().binarySearchFirstGreaterEqual(numbers, 2));
    }

    @Test
    public void should_return_the_last_less_or_equal_element_when_binarySearchLastLessEqual_given_ordered_array_include_duplicate_element() {
        int[] numbers = new int[]{1,3,3,4,6,7,9,9,9,20};
        assertEquals(5, new BinarySearch().binarySearchLastLessOrEqual(numbers, 8));
    }
}