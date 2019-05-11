package xieed.explore.datastruct.Tree;

public  class CompleteArrayBinaryTree {
    int[] element;
    private static final int rootIndex = 1;
    StringBuilder builder = new StringBuilder();

    public CompleteArrayBinaryTree(int rootData, int len) {
        element = new int[len];
        element[rootIndex] = rootData;
        fillArrayBinaryTreeData(rootIndex);
    }

    public int[] getElement() {
        return element;
    }

    public StringBuilder getBuilder() {
        return builder;
    }

    void fillArrayBinaryTreeData(int parentIndex){
        int leftNodeIndex = 2 * parentIndex;
        if(leftNodeIndex > this.element.length - 2){
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
