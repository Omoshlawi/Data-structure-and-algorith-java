package invisiTecLab.datastructures.lineards.linkedlist;

import com.sun.jdi.ArrayReference;
import invisiTecLab.datastructures.lineards.linear_ds_api.LinearDsAPI;

import java.util.Arrays;

/**
 * @param <AnyType> singly linked list of any type
 * @Author Omondi Laurent Ouma
 */

public class SinglyLinkedListDs<AnyType> implements LinearDsAPI<AnyType> {
    private Node<AnyType> head = null;
    private Node<AnyType> tail = null;
    public int size = 0;

    public static class Node<AnyType> {
        private AnyType element;
        private Node<AnyType> next;

        public Node(AnyType element, Node<AnyType> next) {
            this.element = element;
            this.next = next;
        }

        public AnyType getElement() {
            return this.element;
        }

        public Node<AnyType> getNext() {
            return this.next;
        }

        public void setNext(Node<AnyType> next) {
            this.next = next;
        }

        public String toString() {
            AnyType last;
            try {
                last = next.getElement();
            } catch (Exception e) {
                last = null;
            }
            return "(Element: " + element + ", " + "Next:=> " + last + ")";
        }
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return ((head == null) && (size == 0));//either of the 2 is correct,you can eliminate one
    }

    @Override
    public void traverse() {
        if (!isEmpty()) {
            Node<AnyType> tmp = head;
            while (tmp != null) {//you could also use the size propert
                System.out.println(tmp.getElement());
                tmp = tmp.getNext();
            }
        } else {
            System.out.println("The list is Empty");
        }
    }

    @Override
    public void printElements() {
        if (!isEmpty()) {
            Node<AnyType>[] elements = new Node[size];
            Node<AnyType> tmp = head;
            int i = 0;
            while (tmp != null) {//you could also use the size property
                elements[i] = tmp;
                tmp = tmp.getNext();
                i++;
            }
            System.out.println(Arrays.toString(elements));
        } else {
            System.out.println("The list is Empty");
        }
    }

    @Override
    public void addAtBeginning(AnyType element) {
        head = new Node<>(element, head);
        if (size == 0) {
            tail = head;
        }
        size++;
    }

    @Override
    public void addAtTheEnd(AnyType element) {
        Node<AnyType> tmp = new Node<>(element, null);
        if (isEmpty()) {
            head = tmp;
        } else {
            tail.setNext(tmp);
        }
        tail = tmp;
        size++;
    }

    @Override
    public void addAtPosition(AnyType element, int index) {
        if (index > size) {
            System.err.print("Index Error");
            return;
        }
        Node<AnyType> new_node = new Node<>(element, null);
        if (isEmpty()) {
            head = new_node;
        } else if (index == 0) {
            new_node.setNext(head);
            head = new_node;
        } else {
            int i = 0;
            Node<AnyType> tmp = head;
            for (; i < index - 1; i++) {
                tmp = tmp.getNext();
            }
            new_node.setNext(tmp.getNext());
            tmp.setNext(new_node);
        }
        tail = new_node;
        size++;
    }

    @Override
    public AnyType deleteAtBeginning() {
        AnyType tmp = null;
        if (isEmpty()) {
            System.out.print("The list is empty!");
        } else {
            tmp = head.getElement();
            head = head.getNext();
            size--;
            if (size == 0) {
                tail = null;
            }
        }
        return tmp;
    }

    @Override
    public AnyType deleteAtTheEnd() {
        AnyType tmp = null;
        if (isEmpty()) {
            System.out.print("The list is Empty");
        } else {
            tmp = tail.getElement();
            Node<AnyType> tmpnode = head;
            while (tmpnode.getNext() != tail) {
                tmpnode = tmpnode.getNext();
            }
            tmpnode.setNext(null);
            tail = tmpnode;
            size -= 1;
            if (size == 0) {
                tail = null;
                head = null;
            }
        }
        return tmp;
    }

    @Override
    public AnyType deleteAtPosition(int index) {
        AnyType tmp = null;
        if (isEmpty() || index >= size) {
            System.err.print("Index Error");
        } else if (index == 0) {
            tmp = deleteAtBeginning();
        } else if (index == size - 1) {
            tmp = deleteAtTheEnd();
        } else {
            int i = 0;
            Node<AnyType> tmp_node = head;
            for (; i < index - 1; i++) {
                tmp_node = tmp_node.getNext();
            }
            tmp = tmp_node.getElement();
            Node<AnyType> to_delete_node = tmp_node.getNext();
            tmp_node.setNext(to_delete_node.getNext());
            size--;
        }
        return tmp;
    }

    @Override
    public int search() {
        return 0;
    }

    @Override
    public void insertionSort() {

    }

    @Override
    public AnyType head() {
        if (isEmpty()) return null;
        return head.getElement();
    }

    @Override
    public AnyType tail() {
        if (isEmpty()) return null;
        return tail.getElement();
    }

    public static void main(String[] args) {
        SinglyLinkedListDs<String> listDs = new SinglyLinkedListDs<>();
        listDs.addAtBeginning("Lawi");
        listDs.addAtBeginning("ous");
        listDs.addAtTheEnd("jeff");
//        listDs.addAtBeginning("obonyo");
//        listDs.addAtTheEnd("obae");
//        listDs.traverse();
        listDs.addAtPosition("onyonyi", 1);
        listDs.addAtTheEnd("obae");
        listDs.addAtBeginning("ous");
        listDs.addAtPosition("lasty", listDs.size());
//        System.out.println(listDs.size());
//        listDs.traverse();
        listDs.printElements();
        System.out.println("Deleted element at the beginning: " + listDs.deleteAtBeginning());
        listDs.printElements();
//        System.out.println(listDs.size());
        System.out.println("Deleted element at the end: " + listDs.deleteAtTheEnd());
//        System.out.println(listDs.size());
        listDs.printElements();
        System.out.println("Deleted element at index 2: " + listDs.deleteAtPosition(2));
        listDs.printElements();
        System.out.println(listDs.tail.getElement());
        System.out.println(listDs.head());
//        listDs.traverse();
    }
}
