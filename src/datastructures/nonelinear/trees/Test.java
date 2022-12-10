package datastructures.nonelinear.trees;

public class Test {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(40);
        tree.insert(30);
        tree.insert(50);
        tree.insert(780);
        tree.insert(45);
        tree.insert(54);
        System.out.println(tree.height());
//        tree.preorderTraversal();
//        tree.inorderTraversal();
//        tree.postorderTraversal();
    }
}
