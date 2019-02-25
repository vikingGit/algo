package xieed.explore.datastruct.linklist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkedListNode {
  int value;
  LinkedListNode nextNode;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }

    LinkedListNode that = (LinkedListNode) o;

    if (value != that.value) {
      return false;
    }
    return nextNode != null ? nextNode.equals(that.nextNode) : that.nextNode == null;
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + value;
    result = 31 * result + (nextNode != null ? nextNode.hashCode() : 0);
    return result;
  }
}
