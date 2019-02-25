package xieed.explore.datastruct.linklist;

import org.junit.Assert;
import org.junit.Test;

public class SingleLinkedListTest {

  @Test
  public void should_success_when_add_head_node_given_empty_single_linked_list() throws Exception {
    SingleLinkedList slist = new SingleLinkedList();
    slist.add(1, 1);
    Assert.assertEquals(1, slist.size());
  }

  @Test
  public void should_success_when_add_head_given_not_empty_single_linked_list() throws Exception {
    SingleLinkedList slist = new SingleLinkedList();

    slist.add(1, 1);
    slist.add(2, 1);

    Assert.assertEquals(2, slist.size());
    Assert.assertEquals(2, slist.getHeadNode().getValue());
    Assert.assertEquals(1, slist.getHeadNode().getNextNode().value);
  }

  @Test
  public void should_success_when_add_middle_given_not_empty_single_linked_list() throws Exception {
    SingleLinkedList slist = createSingleLinkedList();

    Assert.assertEquals(3, slist.size());
    Assert.assertEquals(2, slist.getHeadNode().getNextNode().value);
    Assert.assertEquals(3, slist.getHeadNode().getNextNode().getNextNode().getValue());
  }

  @Test
  public void should_return_correct_node_when_findByIndex_given_multiple_node_linked_list() throws Exception {
    SingleLinkedList slist = createSingleLinkedList();

    Assert.assertEquals(2, slist.findNodeByIndex(2).getValue());
  }

  private SingleLinkedList createSingleLinkedList() {
    SingleLinkedList slist = new SingleLinkedList();
    slist.add(1, 1);
    slist.add(2, 2);
    slist.add(3, 3);
    return slist;
  }

  @Test
  public void should_return_array_when_convert_to_array_given_single_linked_list() throws Exception {
    SingleLinkedList slist = createSingleLinkedList();

    int[] ints = slist.convertToArray();

    Assert.assertEquals(1, ints[0]);
    Assert.assertEquals(2, ints[1]);
    Assert.assertEquals(3, ints[2]);
  }

  @Test
  public void should_success_when_reverse_given_single_linked_list() throws Exception {
    SingleLinkedList slist = createSingleLinkedList();

    SingleLinkedList reverseSlist = slist.reverse();

    Assert.assertEquals(3, reverseSlist.getHeadNode().value);
    Assert.assertEquals(2, reverseSlist.getHeadNode().getNextNode().value);
    Assert.assertEquals(1, reverseSlist.getHeadNode().getNextNode().getNextNode().getValue());
  }


}