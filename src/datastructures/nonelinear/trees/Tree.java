package datastructures.nonelinear.trees;

public class Tree {
    private Node root;

    public Tree() {
        root = null;
    }

    private class Node {
        public int value;
        public Node leftChild;
        public Node rightChild;

        private Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", leftChild=" + leftChild +
                    ", rightChild=" + rightChild +
                    '}';
        }
    }

    public void insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return;
        }
        Node current = root;
        while (true) {
            if (current.value < value){
                if (current.rightChild == null){
                    current.rightChild = newNode;
                    break;
                }
                current = current.rightChild;
            }
            else if (current.value > value) {
                if (current.leftChild == null){
                    current.leftChild = newNode;
                    break;
                }
                current = current.leftChild;
            }

        }
    }

    public boolean find(int value) {
        Node current = root;
        while (current != null) {
            if (current.value < value) current = current.rightChild;
            else if (current.value > value) current = current.leftChild;
            else return true;
        }
        return false;
    }

    private void preorderTraversal(Node root){
        if (root != null) {
            System.out.println(root.value);
            preorderTraversal(root.leftChild);
            preorderTraversal(root.rightChild);
        }
    }

    private void postorderTraversal(Node root){
        if (root != null) {
            postorderTraversal(root.leftChild);
            postorderTraversal(root.rightChild);
            System.out.println(root.value);
        }
    }

    private void inorderTraversal(Node root){
        if (root != null) {
            inorderTraversal(root.leftChild);
            System.out.println(root.value);
            inorderTraversal(root.rightChild);
        }
    }

    private boolean isLeaf(Node node){
        return node.leftChild == null && node.rightChild == null;
    }

    private int height(Node root){
        /**
         * The maximum number of links from leaf node to the target node
         */
        if (root == null)
            return -1;
        if (isLeaf(root))
            return 0;
        return 1 + Math.max(
          height(root.leftChild), height(root.rightChild)
        );

    }

    public int min(){
        return min(root);
    }

    public boolean equals(Tree other){
        if (other == null)
            return false;
        return equals(root, other.root);
    }

    private boolean equals(Node first, Node second){
        if (first == null && second == null)
            return true;
        if (first != null && second != null)
            return first.value == second.value
                    && equals(first.leftChild, second.leftChild)
                    && equals(first.rightChild, second.rightChild);
        return false;
    }

    private int min(Node root){
        /**
         * For any tree, bt for bst is easier since its sorted so simply go to the left most
         */
        if (isLeaf(root))
            return root.value;
        var left = min(root.leftChild);
        var right = min(root.rightChild);

        return Math.min(
          Math.min(left, right),root.value
        );
    }

    public int height(){
        return height(root);
    }


    public void preorderTraversal(){
        preorderTraversal(root);
    }

    public void postorderTraversal(){
        postorderTraversal(root);
    }

    public void inorderTraversal(){
        inorderTraversal(root);
    }

}
