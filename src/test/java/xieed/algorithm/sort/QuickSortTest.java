package xieed.algorithm.sort;

import org.junit.Test;

import static org.junit.Assert.*;

public class QuickSortTest {

    @Test
    public void should_return_ordered_numbers__when_quickSort_given_unordered_numbers() throws Exception {
        int[] numbers = new int[]{3,2,1,7,6,9,0,10};
        new QuickSort().quickSort(numbers, 0, numbers.length-1);

        StringBuilder builder = new StringBuilder();
        for (int number : numbers) {
            builder.append(number);
        }
        builder.toString().equals("012367910");
    }
}