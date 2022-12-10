package datastructures.lineards.stack;

/**
 * @Author Omondi Laurent Ouma
 * @param <AnyType> Any type so long as its reference type.For Primitive use wrapper classes
 *                 to Autobox them
 */

public class StackDsStatic<AnyType> implements StackDsAPI <AnyType> {
    int top = -1;
    AnyType[] ousStack;

    public StackDsStatic(int size) {
        ousStack = (AnyType[]) new Object[size];
    }

    @Override
    public int size() {
        if (isEmpty()) {
            return 0;
        }
        return top + 1;
    }

    @Override
    public boolean isEmpty() {
        return (top == -1);
    }

    public void push(AnyType element) {
        if (top >= ousStack.length - 1)
            System.err.println("The Stack is Full");
        else {
            ousStack[++top] = element;
        }
    }

    @Override
    public AnyType top() {
        if (!isEmpty()) {
            return ousStack[top];
        } else {
            System.err.println("The Stack is empty");
            return null;
        }
    }

    @Override
    public AnyType pop() {
        if (!isEmpty()) {
            AnyType tmp = ousStack[top];
            ousStack[top--] = null;
            return tmp;
        }
        System.err.println("The Stack is empty");
        return null;
    }

    public static void main(String[] args) {
        StackDsStatic<Performance<String, Integer>> stackDs = new StackDsStatic<>(5);

        stackDs.push(new Performance<>("LawiOmosh", 20));
        stackDs.push(new Performance<>("LawiOus", 30));
        stackDs.push(new Performance<>("JeffOdhis", 40));
        stackDs.push(new Performance<>("Hilikia Mayianda", 400));
        stackDs.push(new Performance<>("Hilikia Mayianda", 400));
        stackDs.push(new Performance<>("Hilikia Mayianda", 400));
        stackDs.push(new Performance<>("Hilikia Mayianda", 400));
//        System.out.println(stackDs.size());
        System.out.println(stackDs.pop());
        System.out.println(stackDs.pop());
        System.out.println(stackDs.top());
        System.out.println(stackDs.pop());
        System.out.println(stackDs.pop());
        System.out.println(stackDs.pop());
        System.out.println(stackDs.pop());


    }
}

class Performance<Left, Right> {
    Left left;
    Right right;

    public Performance(Left left, Right right) {
        this.left = left;
        this.right = right;
    }

    public Left getLeft() {
        return this.left;
    }

    public Right getRight() {
        return this.right;
    }

    public String toString() {
        return ("(" + left + ", " + right + ")");
    }
}
