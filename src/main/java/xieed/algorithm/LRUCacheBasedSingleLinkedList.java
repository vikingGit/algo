package xieed.algorithm;

import xieed.explore.datastruct.linklist.LinkedListNode;
import xieed.explore.datastruct.linklist.SingleLinkedList;

public class LRUCacheBasedSingleLinkedList {

    private final int capacity;
    private SingleLinkedList singleLinkedList;

    public SingleLinkedList getSingleLinkedList() {
        return singleLinkedList;
    }

    public LRUCacheBasedSingleLinkedList(int capacity){
        this.capacity = capacity;
        this.singleLinkedList = new SingleLinkedList();
    }

    /**
     * https://time.geekbang.org/column/article/41013
     */
    public void cacheData(int data){
        if(this.singleLinkedList == null){
            this.singleLinkedList = new SingleLinkedList();
        }

        if(singleLinkedList.isEmpty()){
            singleLinkedList.initalHeadNode(data);
        }else{
            LinkedListNode preNode = singleLinkedList.findPreNodeByValue(data);
            LinkedListNode currentNode;
            if(preNode != null){
                currentNode = preNode.getNextNode();
                preNode.setNextNode(currentNode.getNextNode());
                currentNode.setNextNode(null);
            }else{
                if(singleLinkedList.size() == this.capacity){
                    LinkedListNode theSecondTailNode = singleLinkedList.findNodeByIndex(this.capacity - 1);
                    LinkedListNode tailNode = theSecondTailNode.getNextNode();
                    theSecondTailNode.setNextNode(null);
                    tailNode = null;
                }
                currentNode = new LinkedListNode(data, null);
            }
            singleLinkedList.setHeadNode(currentNode);
        }
    }
}
