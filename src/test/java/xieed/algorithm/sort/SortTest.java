package xieed.algorithm.sort;

import org.junit.Test;

public class SortTest {

  @Test
  public void should_return_ordered_numbers__when_bubbleSort_given_unordered_numbers() throws Exception {
    int[] numbers = new int[]{3,2,1,7,6,9,0,10};
    new Sort().bubbleSort(numbers);

    StringBuilder builder = new StringBuilder();
    for (int number : numbers) {
      builder.append(number);
    }
    builder.toString().equals("012367910");
  }

  @Test
  public void should_return_ordered_numbers__when_insertSort_given_unordered_numbers() throws Exception {
    int[] numbers = new int[]{3,2,1,7,6,9,0,10};
    new Sort().insertSort(numbers);

    StringBuilder builder = new StringBuilder();
    for (int number : numbers) {
      builder.append(number);
    }
    builder.toString().equals("012367910");
  }


  @Test
  public void should_return_ordered_numbers__when_insertSort1_given_unordered_numbers() throws Exception {
    int[] numbers = new int[]{3,2,1,7,6,9,0,10};
    new Sort().insertSort1(numbers);

    StringBuilder builder = new StringBuilder();
    for (int number : numbers) {
      builder.append(number);
    }
    builder.toString().equals("012367910");
  }

  @Test
  public void should_return_ordered_numbers__when_selectSort_given_unordered_numbers() throws Exception {
    int[] numbers = new int[]{3,2,1,7,6,9,0,10};
    new Sort().selectSort(numbers);

    StringBuilder builder = new StringBuilder();
    for (int number : numbers) {
      builder.append(number);
    }
    builder.toString().equals("012367910");
  }
}