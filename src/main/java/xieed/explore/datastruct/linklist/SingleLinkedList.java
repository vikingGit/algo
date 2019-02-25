package xieed.explore.datastruct.linklist;

import java.security.InvalidParameterException;

public class SingleLinkedList {


  private LinkedListNode headNode;

  public void initalHeadNode(int value){
    if(this.headNode == null){
      this.headNode = new LinkedListNode(value, null);
      return;
    }

    this.headNode = new LinkedListNode(value, this.headNode);
  }

  public void setHeadNode(LinkedListNode node){
    if(this.headNode == null){
      this.headNode = node;
      return;
    }

    node.nextNode = this.headNode;
    this.headNode = node;
  }

  public LinkedListNode getHeadNode() {
    return headNode;
  }

  public int size() {
    return countNodeSize(this.headNode);
  }

  private int countNodeSize(LinkedListNode node) {
    if(node == null){
      return 0;
    }else{
      return countNodeSize(node.nextNode) + 1;
    }
  }

  private LinkedListNode findNodeByIndex(LinkedListNode node, int iniCount, int index) {
    if(index < 0){
      throw new InvalidParameterException("error index");
    }
    if(node == null){
      throw new IndexOutOfBoundsException("index out of bound");
    }else{
      if(index == iniCount){
        return node;
      }else{
        return findNodeByIndex(node.nextNode, iniCount + 1, index);
      }
    }
  }

  public LinkedListNode findNodeByIndex(int index){
    return findNodeByIndex(this.headNode, 1, index);
  }

  public LinkedListNode findPreNodeByValue(int value){
    if(this.isEmpty()){
      return null;
    }
    LinkedListNode currentNode = this.getHeadNode();
    while(currentNode.nextNode != null){
      if(currentNode.nextNode.value == value){
        return currentNode;
      }

      currentNode = currentNode.nextNode;
    }

    return null;
  }

  public void add(int value, int index) {
    if(index < 1){
      throw new InvalidParameterException("error index");
    }

    if(index == 1){
      this.initalHeadNode(value);
    }else{
      LinkedListNode preNode = findNodeByIndex(index - 1);
      LinkedListNode node = new LinkedListNode(value, preNode.nextNode);
      preNode.nextNode = node;
    }
  }

  public SingleLinkedList reverse() {
    if(this.headNode == null){
      return null;
    }
    int nodes[] = convertToArray();
    int index = 1;
    SingleLinkedList reversedLinkedList = new SingleLinkedList();
    for(int i = nodes.length - 1; i >= 0; i--){
      reversedLinkedList.add(nodes[i], index++);
    }
    return reversedLinkedList;
  }

  public int[] convertToArray() {
    int nodes[] = new int[this.countNodeSize(this.headNode)];
    LinkedListNode currNode = this.headNode;
    for(int i = 0; i < nodes.length; i++){
      nodes[i] = currNode.value;
      currNode = currNode.nextNode;
    }
    return nodes;
  }

  public boolean isEmpty() {
    return this.headNode == null;
  }

//  @Override
//  public String toString() {
//    if(this.headNode == null){
//      return "";
//    }
//
//  }
}
