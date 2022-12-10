package datastructures.nonelinear.trees;


import vsexceptions.InvalidOperationException;

import java.util.Iterator;

public class TreesDs<AnyType> implements Iterable<AnyType> {
    private Node<AnyType> root;
    private int size;

    public TreesDs() {
        size = 0;
        root = null;
    }

    @Override
    public Iterator<AnyType> iterator() {
        return null;
    }

    public void insert(AnyType element) throws IllegalArgumentException {
        Node<AnyType> newNode = new Node<>(element, null, null, null);
        Node<AnyType>  parent = null;
        if (isEmpty()) {
            root = newNode;
            size++;
        } else {
            if (getNode(element) != null){
                throw new IllegalArgumentException("Node with the element already exist");
            }
            Node<AnyType> tmp = root;
            Node<AnyType> left = null;
            Node<AnyType> right = null;
            while (tmp != null){
                parent = tmp;
                if ((Integer) tmp.getElement() > (Integer) element){
                    System.out.println("Go to the left");
                    tmp = tmp.getLeft();
                    parent.setLeft(tmp);
                }else if ((Integer) tmp.getElement() < (Integer) element){
                    System.out.println("go to the right");
                    tmp = tmp.getRight();
                    parent.setRight(tmp);
                }
            }
            System.out.println(tmp);
            System.out.println(parent);
            tmp = newNode;
            System.out.println(parent);
            tmp.setParent(parent);
            size ++;
            System.out.println(tmp);
        }

    }

    public static class Node<AnyType> {
        Node<AnyType> left, right, parent;
        AnyType element;

        public Node(AnyType element, Node<AnyType> parent, Node<AnyType> left, Node<AnyType> right) {
            this.left = left;
            this.right = right;
            this.element = element;
            this.parent = parent;
        }

        public String toString() {
            return "(element: " + element + ", parent: " + parent + ", left: " + left + ", right: " + right + ")";
        }

        public Node<AnyType> getParent() {
            return parent;
        }

        public void setParent(Node<AnyType> parent) {
            this.parent = parent;
        }

        public Node<AnyType> getLeft() {
            return left;
        }

        public Node<AnyType> getRight() {
            return right;
        }

        public AnyType getElement() {
            return element;
        }

        public void setLeft(Node<AnyType> left) {
            this.left = left;
        }

        public void setRight(Node<AnyType> right) {
            this.right = right;
        }

        public void setElement(AnyType element) {
            this.element = element;
        }
    }

    public int size() {
        return size;
    }

    public int depth(AnyType element) throws InvalidOperationException {
        if (isEmpty()) {
            throw new InvalidOperationException("Cant perform depth operation in empty tree");
        }
        if (isRoot(element))
            return 0;
        else
            return 1 + depth(parent(element).getElement());

    }

    public Node<AnyType> root() {
        if (isEmpty()) {
            System.out.println("The Tree is Empty");
            return null;
        }
        return root;
    }

    public boolean isRoot(AnyType element) throws InvalidOperationException {
        if (isEmpty()) {
            throw new InvalidOperationException("Operation Not supported in an Empty Tree");
        }
        return root.getElement() == element;
    }

    public boolean isInternal(AnyType element) throws InvalidOperationException {
        return !isExternal(element);
    }

    public boolean isExternal(AnyType element) throws InvalidOperationException {
        if (isEmpty()) {
            throw new InvalidOperationException("Operation Not supported in an Empty Tree");
        }else {
            Node <AnyType> node = getNode(element);
            if (node != null){
                return node.getLeft() == null && node.getRight() == null;
            }
        }
        throw new InvalidOperationException("No such element in the tree");
    }

    public boolean isEmpty() {
        return root == null && size == 0;
    }

    public Node<AnyType> getNode(AnyType element) {
        Node<AnyType> node = null;
        if (!isEmpty()) {
            Node<AnyType> tmp = root;
            while (tmp != null) {
                if ((Integer) tmp.getElement() < (Integer) element) {
                    tmp = tmp.getRight();
                } else if ((Integer) tmp.getElement() > (Integer) element) {
                    tmp = tmp.getRight();
                } else {
                    node = tmp;
                    break;
                }
            }
        }
        return node;
    }

    public Node<AnyType> parent(AnyType element) {
        Node<AnyType> parent = null;
        if (isEmpty()) {
            return null;
        } else if (root.getElement() == element) {
            return null;
        } else {
            Node<AnyType> node = getNode(element);
            if (node != null) {
                parent = node.getParent();
            }
        }
        return parent;
    }

    public static void main(String[] args) throws InvalidOperationException {
        TreesDs<Integer> tree = new TreesDs<>();
        tree.insert(23);
        tree.insert(24);
        System.out.println(tree.isEmpty());
        System.out.println(tree.root());
        System.out.println(tree.isInternal(23));
        System.out.println(tree.getNode(23));
        System.out.println(tree.size());

    }
}
