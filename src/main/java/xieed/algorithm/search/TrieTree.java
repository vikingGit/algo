package xieed.algorithm.search;

public class TrieTree {
    TrieTreeNode rootNode = new TrieTreeNode('\0', null);

    void insert(String str){
        char[] chars = str.toCharArray();
        TrieTreeNode  parentNode = rootNode;
        for (char aChar : chars) {
            int index = aChar - 'a';
            if(parentNode.childNode == null){
                parentNode.childNode = new TrieTreeNode[26];
            }
            if (parentNode.childNode[index] == null ) {
                parentNode.childNode[index] = new TrieTreeNode(aChar, null);
            }
            parentNode = parentNode.childNode[index];
        }
        parentNode.isEndingChar = true;
    }

    boolean find(String str){
        char[] chars = str.toCharArray();
        TrieTreeNode parentNode = rootNode;
        for (char aChar : chars) {
            int index = aChar - 'a';
            if(parentNode.childNode[index].node != aChar){
                return false;
            }
            parentNode = parentNode.childNode[index];
        }
        if(parentNode.isEndingChar){
            return  true;
        }else {
            return false;
        }
    }



    class TrieTreeNode{
        char node;
        boolean isEndingChar = false;
        TrieTreeNode[] childNode ;

        public TrieTreeNode(char node, TrieTreeNode[] childNode) {
            this.node = node;
            this.childNode = childNode;
        }
    }
}
