package xieed.explore.datastruct.Tree;

public class HeapTree {

    int[] completedBinaryTree;
    int cnt;
    int capactiy;
    public HeapTree(){

    }

    public HeapTree(int capactity){
        this.completedBinaryTree = new int[capactity + 1];//completedBinaryTree started at index 1
        this.capactiy= capactity;
    }

    public void insert(int data){
        if(cnt > capactiy) return;
        int index = ++cnt;
        this.completedBinaryTree[index] = data;
        int parentIndex = index/2;
        //heapify from down to up
        while(parentIndex> 0 && this.completedBinaryTree[parentIndex] < data){
            int temp = this.completedBinaryTree[parentIndex];
            this.completedBinaryTree[parentIndex]=data;
            this.completedBinaryTree[index] = temp;
            index = parentIndex;
            parentIndex = index/2;
        }
    }

    int get(int index){
        return this.completedBinaryTree[index];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int node : this.completedBinaryTree) {
            if(node != 0){
                sb.append(" "+node);
            }
        }
        return sb.toString();
    }

    public void deleteRootNode(){
        //remove last leaf node to root ,then heapify from up to down, it can make sure the tree can be completed binary tree
        if(cnt < 1) {
            return;
        }
        //heapify from up to down
        this.completedBinaryTree[1] = this.completedBinaryTree[cnt];
        this.completedBinaryTree[cnt--] = 0;
        UpDownHeapify(this.completedBinaryTree, cnt, 1);
    }

    //origin data start index = 0,then leftNode index = 2*parentIndex + 1, rightNodeindex = 2*parentIndex + 2
    public void heapSort(int[] data) {
        //step1:Heapify for non-leaf node
        buildHeapTreeByUpDownHeapify(data);
        int index = data.length - 1;
        while (index > 0) {
            //swap root and last
            swap(data, index, 0);
            UpDownHeapify(data, index - 1, 0);
            index--;
        }

    }

    private void UpDownHeapify(int[] data, int lastIndex, int rootIndex) {
        int parentIndex = rootIndex;
        while(true){
            if(parentIndex == -1) {
                break;
            }
            int leftNodeIndex = 2 * parentIndex + 1 - rootIndex;
            int rightNodeIndex = 2 * parentIndex + 2 - rootIndex;
            parentIndex = swapParentAndChild(data, lastIndex, parentIndex, leftNodeIndex, rightNodeIndex);
        }
    }

    public void buildHeapTreeByUpDownHeapify(int[] data) {
        int lastIndex = data.length - 1;
        int lastNonLeafIndex = (lastIndex - 1)/2;
        while (lastNonLeafIndex >= 0){
            //has bug，need call UpDownHeapify , only compare directly child is not enough, sample: 2 5 6 7-->2 7 6 5-->7 2 6 5(2 is parent of 5, bug small than 5)
            int leftNodeIndex = 2*lastNonLeafIndex + 1;
            int rightNodeIndex = 2*lastNonLeafIndex + 2;
            swapParentAndChild(data, lastIndex, lastNonLeafIndex, leftNodeIndex, rightNodeIndex);
            lastNonLeafIndex--;
        }
    }

    private int swapParentAndChild(int[] data, int lastIndex, int parentNodeIndex, int leftNodeIndex, int rightNodeIndex) {
        int targetIndex = parentNodeIndex;
        if(leftNodeIndex <= lastIndex){
            if(data[leftNodeIndex] > data[parentNodeIndex]){
                targetIndex = leftNodeIndex;
            }
            if(rightNodeIndex <= lastIndex ){
               if(data[rightNodeIndex] > data[targetIndex]) {
                   targetIndex = rightNodeIndex;
               }
            }
        }

        if(targetIndex != parentNodeIndex){
            swap(data, parentNodeIndex, targetIndex);
            return targetIndex;
        }

        return -1;
    }

    private void swap(int[] data, int srcIndex, int targetIndex) {
        int temp = data[srcIndex];
        data[srcIndex] = data[targetIndex];
        data[targetIndex] = temp;
    }
}
