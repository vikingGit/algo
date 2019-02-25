package xieed.explore.datastruct.stack;

import org.junit.Assert;
import org.junit.Test;

public class ArrayStackTest {

  @Test
  public void should_success_when_push_one_element_given_empty_stack() throws Exception {
    ArrayStack arrayStack = new ArrayStack(4);

    arrayStack.push(1);
    arrayStack.push(2);

    Assert.assertSame(2, arrayStack.size());
  }

  @Test
  public void should_override_value_from_tail_when_push_one_element_given_full_stack() throws Exception {
    ArrayStack arrayStack = new ArrayStack(2);
    arrayStack.push(1);
    arrayStack.push(2);

    Assert.assertEquals(true, arrayStack.push(3));
    Assert.assertSame(3, arrayStack.pop());
    Assert.assertSame(2, arrayStack.pop());
  }

  @Test
  public void should_success_when_pop_elements_given_non_empty_stack() throws Exception {
    ArrayStack arrayStack = new ArrayStack(4);
    arrayStack.push(1);
    arrayStack.push(2);

    Assert.assertSame(2, arrayStack.pop());
    Assert.assertSame(1, arrayStack.pop());
    Assert.assertSame(0, arrayStack.pop());
  }
}