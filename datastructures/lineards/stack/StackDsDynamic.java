package invisiTecLab.datastructures.lineards.stack;

import invisiTecLab.datastructures.lineards.linkedlist.SinglyLinkedListDs;

/**
 * @Author Omondi Laurent Ouma
 * *********************************
 * It implements Adapter Pattern
 * ********************************
 * The adapter design pattern applies to any context where we effectively want to
 * modify an existing class so that its methods match those of a related, but different,
 * class or interface. One general way to apply the adapter pattern is to define a new
 * class in such a way that it contains an instance of the existing class as a hidden
 * field, and then to implement each method of the new class using methods of this
 * hidden instance variable. By applying the adapter pattern in this way, we have
 * created a new class that performs some of the same functions as an existing class,
 * but repackaged in a more convenient way.
 * In the context of the stack ADT, we can adapt our SinglyLinkedList class
 *
 * @param <AnyType> a stack of any type
 *
 */

public class StackDsDynamic<AnyType> implements StackDsAPI <AnyType> {

    private SinglyLinkedListDs <AnyType> linkedListDs;

    public StackDsDynamic(){
        this.linkedListDs = new SinglyLinkedListDs <>();
    }

    @Override
    public int size() {
        return linkedListDs.size();
    }

    @Override
    public boolean isEmpty() {
        return linkedListDs.isEmpty();
    }

    @Override
    public void push(AnyType element) {
        linkedListDs.addAtBeginning(element);
    }

    @Override
    public AnyType top() {
        return linkedListDs.head();
    }

    @Override
    public AnyType pop() {
        return linkedListDs.deleteAtBeginning();
    }

    public static void main(String[] args) {
        StackDsDynamic<String> stackDsDynamic = new StackDsDynamic<>();
        stackDsDynamic.push("ous");
        stackDsDynamic.push("lawi");
        stackDsDynamic.push("jeff");
        stackDsDynamic.push("oscar");
//        System.out.println(stackDsDynamic.pop());
        System.out.println(stackDsDynamic);
        System.out.println(stackDsDynamic.size());
    }
}
