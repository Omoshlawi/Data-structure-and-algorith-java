package datastructures.linear.stack;

/**
 * Author: Omondi Laurent Ouma
 */

public interface StackDsAPI<GType> {

    /**
     * counts number of element in the stack
     * @return integer size of the stack
     */
    int size();

    /**
     * Test id the stack is empty
     * @return false if not empty else true
     */
    boolean isEmpty();

    /**
     * Insert element at the top of the stack
     * @param element element to be inserted
     */
    void push(GType element);

    /**
     * Returns, but does not remove, the element at the top of the stack.
     * @return @return top element in the stack (or null if empty)
     */
    GType top();

    /**
     * Removes and returns the top element from the stack.
     * @return element removed (or null if empty)
     */
    GType pop();
}
