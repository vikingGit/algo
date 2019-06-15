package xieed.explore.datastruct.Tree;

import java.util.ArrayList;

public class HuffmanTree {
    int[] initData;
    ArrayList<TreeNode> nodes;
    TreeNode rootNode;

    public HuffmanTree(int[] initData) {
        this.initData = initData;
        nodes = new ArrayList(this.initData.length * 2 );
        for (int data : initData) {
            nodes.add(new TreeNode(data));
        }
    }

    void init() {
        TreeNode parent = null;
        while (nodes.size() > 1) {
            nodes.sort((o1, o2) -> o1.getData() > o2.getData() ? 1 : o1.getData() == o2.getData() ? 0 : -1);//似乎是穩定排序
            TreeNode leftChild = nodes.get(0);
            TreeNode rightChild = nodes.get(1);
            parent = new TreeNode(leftChild.getData() + rightChild.getData(), leftChild, rightChild);

         nodes.remove(0);
         nodes.remove(0);
         nodes.add(parent);
        }

        this.rootNode = parent;
    }

}
