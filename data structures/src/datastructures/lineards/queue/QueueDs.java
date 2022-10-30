package datastructures.lineards.queue;

import datastructures.lineards.linkedlist.SinglyLinkedListDs;

public class QueueDs<AnyType> {
    private SinglyLinkedListDs<AnyType> listDs = new SinglyLinkedListDs<>();

    public int size(){
        return listDs.size();
    }
    public boolean isEmpty(){
        return listDs.isEmpty();
    }
    public boolean isFull(){
        return listDs.isFull();
    }
    public void enqueue(AnyType element){
        listDs.addAtTheEnd(element);
    }
    public AnyType dequeue(){
        return listDs.deleteAtBeginning();
    }

    public static void main(String[] args) {
        QueueDs<String> queueDs = new QueueDs<>();
        queueDs.enqueue("Jeff");
        queueDs.enqueue("Ous");
        queueDs.enqueue("Frank");
        System.out.println(queueDs.dequeue());
        System.out.println(queueDs.dequeue());
    }

}
