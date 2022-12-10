package datastructures.lineards.linkedlist;

import datastructures.lineards.linear_ds_api.LinearDsAPI;

import java.util.List;

/**
 * @param <AnyType>
 * @Author :Omondi Laurent Ouma
 * you can use adapter method to implement circular ds using simple linked list
 * It's recommended to make code more efficient bt only keeping track of tail and not head
 * To get head simply use tail.getNext method
 */
public class CircularLinkedListDs<AnyType> implements LinearDsAPI<AnyType> {
    private int size;
    private Node<AnyType> tail = null;

    public static class Node<AnyType> {
        private AnyType element;
        Node<AnyType> next;

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
        return size == 0 || tail == null;//either can work
    }

    @Override
    public void traverse() {
        //infinite loop since its a circle hence repeat to end of the world
        try {
            if (!isEmpty()) {
                Node<AnyType> tmp = tail;
                while (tmp != null) {
                    Thread.sleep(1000);
                    System.out.println(tmp);
                    tmp = tmp.getNext();
                }
            } else {
                System.out.println("List is Empty");
            }
        }catch (Exception e){
            //pass
        }
    }

    @Override
    public void printElements() {
//        so big
    }

    @Override
    public void addAtBeginning(AnyType element) {
        if (isEmpty()) {
            tail = new Node<>(element, null);
            tail.setNext(tail); // link to itself circularly
        } else {
            Node<AnyType> newest = new Node<>(element, tail.getNext());
            tail.setNext(newest);
        }
        size++;
    }

    @Override
    public void addAtTheEnd(AnyType element) {
        addAtBeginning(element);
        tail = tail.getNext();//rotate
    }

    @Override
    public void addAtPosition(AnyType element, int index) {

    }

    @Override
    public AnyType deleteAtBeginning() {
        if (isEmpty())
            return null; // nothing to remove
        Node<AnyType> head = tail.getNext();
        if (head == tail)
            tail = null; // must be the only node left
        else
            tail.setNext(head.getNext()); // removes ”head” from the list
        size--;
        return head.getElement();
    }

    @Override
    public AnyType deleteAtTheEnd() {
        return null;
    }

    public void rotate() { // rotate the first element to the back of the list
        if (tail != null) // if empty, do nothing
            tail = tail.getNext(); // the old head becomes the new tail
    }

    @Override
    public AnyType deleteAtPosition(int index) {
        return null;
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
        AnyType tmp = null;
        if (!isEmpty()) {
            tmp = tail.getNext().getElement();
        }
        return tmp;
    }

    @Override
    public AnyType tail() {
        AnyType tmp = null;
        if (!isEmpty()) {
            tmp = tail.getElement();
        }
        return tmp;
    }

    public static void main(String[] args) {
        CircularLinkedListDs<String> listDs = new CircularLinkedListDs<>();
        listDs.addAtBeginning("Lawi");
        listDs.addAtBeginning("ous");
        listDs.addAtTheEnd("jeff");
        listDs.addAtBeginning("obonyo");
        listDs.addAtTheEnd("obae");
        listDs.traverse();
    }
}
