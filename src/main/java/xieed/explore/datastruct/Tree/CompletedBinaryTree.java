package xieed.explore.datastruct.Tree;

public  class CompletedBinaryTree {
    int[] element;
    private static final int rootIndex = 1;
    int initLen;
    StringBuilder builder = new StringBuilder();

    public CompletedBinaryTree(int rootData, int initLen, int maxLen) {
        element = new int[maxLen];
        element[rootIndex] = rootData;
        this.initLen = initLen;
        fillArrayBinaryTreeData(rootIndex);
    }

    public int[] getElement() {
        return element;
    }

    void fillArrayBinaryTreeData(int parentIndex){
        int leftNodeIndex = 2 * parentIndex;
        if(leftNodeIndex > this.initLen - 2){
            return;
        }
        this.element[leftNodeIndex] = 2*this.element[parentIndex];
        int rightNodeIndex = leftNodeIndex + 1;
        this.element[rightNodeIndex] = 2*this.element[parentIndex]+1;

        fillArrayBinaryTreeData(leftNodeIndex);
        fillArrayBinaryTreeData(rightNodeIndex);
    }

    public void loopBinaryTreeOverPreOrder(int parentIndex){
        if(parentIndex > this.element.length -1){
            return;
        }
        this.builder.append(this.element[parentIndex]+" ");
        int leftNodeIndex = 2 * parentIndex;
        this.loopBinaryTreeOverPreOrder(leftNodeIndex);
        this.loopBinaryTreeOverPreOrder(leftNodeIndex+1);
    }

    public void loopBinaryTreeOverMiddleOrder(int parentIndex){
        if(parentIndex > this.element.length -1){
            return;
        }
        int leftNodeIndex = 2 * parentIndex;
        this.loopBinaryTreeOverMiddleOrder(leftNodeIndex);
        this.builder.append(this.element[parentIndex]+" ");
        this.loopBinaryTreeOverMiddleOrder(leftNodeIndex+1);
    }

    public void loopBinaryTreeOverPostOrder(int parentIndex){
        if(parentIndex > this.element.length -1){
            return;
        }
        int leftNodeIndex = 2 * parentIndex;
        this.loopBinaryTreeOverPostOrder(leftNodeIndex);
        this.loopBinaryTreeOverPostOrder(leftNodeIndex+1);
        this.builder.append(this.element[parentIndex]+" ");
    }
}
