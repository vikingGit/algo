package xieed.algorithm.sort;

import org.junit.Test;

import static org.junit.Assert.*;

public class CountSortTest {

    @Test
    public void should_return_ordered_numbers__when_countSort_given_unordered_numbers() throws Exception {
        int[] numbers = new int[]{2,2,1,7,6,6,0,10};
        new CountSort().countSort(numbers);

        StringBuilder builder = new StringBuilder();
        for (int number : numbers) {
            builder.append(number);
        }
        builder.toString().equals("012266710");
    }
}