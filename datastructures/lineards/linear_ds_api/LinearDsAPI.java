package invisiTecLab.datastructures.lineards.linear_ds_api;


/**
 * @Author Omondi Laurent Ouma
 * The structure can be of any type
 * @param <AnyType>
 */
public interface LinearDsAPI <AnyType>{
    /**
     * Test if the linear ds id full
     * @return false if not full else true
     */
    boolean isFull();

    /**
     * Returns the number of elements in the structure
     * @return an integer
     */
    int size();
    /**
     * Test if the linear ds id empty
     * @return false if not full otherwise true
     */
    boolean isEmpty();

    /**
     * Travers the entire structure displaying its values
     */
    void traverse();

    /**
     * Print all the elements in the structure excluding while traversing through all of them
     */
    void printElements();

    /**
     * Insert an element at the first position if structure isn't full
     * @param element to be inserted at the first position
     */
    void addAtBeginning(AnyType element);

    /**
     * Insert an lement to the last position of the structure if it is not empty
     * @param element to be inserted at the last position
     */
    void addAtTheEnd(AnyType element);

    /**
     * Inserts an element at a given index position
     * @param element to be added at index specified
     * @param index where to add the element
     */

    void addAtPosition(AnyType element, int index);

    /**
     * Delete element at the first position/head
     * @return return the deleted element
     */
    AnyType deleteAtBeginning();

    /**
     * Delete element at th last position
     * @return the deleted element
     */
    AnyType deleteAtTheEnd();

    /**
     * Deletes element at a given position
     * @param index the position to delete an element from
     * @return the deleted element
     */
    AnyType deleteAtPosition(int index);

    /**
     * Searches for an element and returns its index
     * @return its index or position
     */
    int search();

    /**
     * Sorts the elements in the structure using insertion sort
     */
    void insertionSort();

    /**
     * @return the first element in the data structure without deleting it
     */
    AnyType head();

    /**
     * Returns the last Element in the list and null when the list is empty
     * @return AnyData taype defined by user
     */
    AnyType tail();
}
