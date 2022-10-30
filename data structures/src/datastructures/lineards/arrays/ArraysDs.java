package datastructures.lineards.arrays;

import invisiTecLab.datastructures.lineards.stack.StackDsDynamic;

import java.util.Arrays;

public class ArraysDs {
    private int rear;
    Performance[] ousArray;
    public ArraysDs(int size) {
        ousArray = new Performance[size];
        rear = -1;
    }
    public boolean isFull() {
        return rear == ousArray.length - 1;
    }
    public boolean isEmpty() {
        return rear == -1;
    }
    public void traverse() {
        System.out.println(Arrays.toString(ousArray));
    }
    public void printElements() {
        for (int i = 0; i <= rear; i++) {
            System.out.println(ousArray[i]);
        }
    }
    public void addAtBeginning(Performance element) {
        if (!isFull()) {
            if (isEmpty()) {
                rear++;
                ousArray[rear] = element;
            } else {
                int front = rear; //where to insert new element
                rear++;
                int curr = rear;
                while (front > -1) {
                    ousArray[curr] = ousArray[front];
                    curr--;
                    front--;
                }
                front++;
                ousArray[front] = element;
            }
        } else {
            System.out.println("Cant Begin insert...the array is full");
        }
    }
    public void addAtTheEnd(Performance element) {
        if (!isFull()) {
            rear++;
            ousArray[rear] = element;
        } else {
            System.err.println("Cant End insert...the array is full");
        }
    }
    public void addAtPosition(Performance element, int index) {
        if (index >= ousArray.length) {
            System.err.println("ARRAY INDEX OUT OF BOUNCE");
        } else {
            if (!isFull()) {
                int front = rear; //where to insert new element
                rear++;
                int curr = rear;
                while (front > index - 1) {
                    ousArray[curr] = ousArray[front];
                    curr--;
                    front--;
                }
                front++;
                ousArray[front] = element;
            } else {
                System.err.println("Cant insert at index " + index + ".The Array Is Full");
            }
        }
    }
    public Performance deleteAtBeginning() {
        if (isEmpty()) {
            System.err.println("Array List Empty");
        } else {
            int front = 0;
            Performance deleted = ousArray[front];
            while (front < rear) {
                ousArray[front] = ousArray[front + 1];
                front++;
            }
            ousArray[rear] = null;
            rear--;
            return deleted;
        }
        return null;
    }
    public Performance deleteAtTheEnd() {
        if (isEmpty()) {
            System.err.println("Array is empty...Couldn't delete at the end");
        } else {
            Performance deleted = ousArray[rear];
            ousArray[rear] = null;
            rear--;
            return deleted;
        }
        return null;
    }
    public Performance deleteAtPosition(int index) {
        if (isEmpty()) {
            System.err.println("Array is empty...Couldn't delete at index " + index);
        } else if (index >= ousArray.length) {
            System.err.println("Array Index Out of bounce");
        } else if (index > rear) {
            System.err.println("Couldn't Delete at index " + index + " it has no value");
        } else {
            Performance deleted = ousArray[index];
            int front = index;
            while (front < rear) {
                ousArray[front] = ousArray[front + 1];
                front++;
            }
            ousArray[rear] = null;
            rear--;
            return deleted;
        }
        return null;
    }
    private int countIntMatches(int value) {
        int count = 0;
        if (isEmpty()) {
            return count;
        } else {
            for (int i = 0; i <= rear; i++) {
                if (ousArray[i].getMarks() == value) {
                    count++;
                }
            }
        }
        return count;
    }
    private int countStringMatches(String value) {
        int count = 0;
        if (isEmpty()) {
            return count;
        } else {
            for (int i = 0; i <= rear; i++) {
                if (ousArray[i].getSubject().equals(value)) {
                    count++;
                }
            }
        }
        return count;
    }
    public Performance[] searchWithIntValue(int value) {
        if (isEmpty()) {
            System.err.println("The array is Empty");
        } else {
            Performance[] matches = new Performance[countIntMatches(value)];
            int j = 0;
            for (int i = 0; i <= rear; i++) {
                if (ousArray[i].getMarks() == value) {
                    matches[j] = ousArray[i];
                    j++;
                }
            }
            return matches;
        }
        return null;
    }
    public int linearSearchByValue(int value) {
        int index = -1;
        if (!isEmpty()) {
            for (int i = 0; i <= rear; i++) {
                if (ousArray[i].getMarks() == value) {
                    index = i;
                    break;
                }
            }
        }
        return index;
    }
    public int getIndexWithStringValue(String value) {
        int index = -1;
        if (isEmpty()) {
            System.err.println("The array is Empty");
        } else {
            for (int i = 0; i <= rear; i++) {
                if (ousArray[i].getSubject().equals(value)) {
                    index = i;
                    break;
                }
            }
        }
        return index;
    }
    public Performance[] searchWithStringValue(String value) {
        if (isEmpty()) {
            System.err.println("The array is Empty");
        } else {
            Performance[] matches = new Performance[countStringMatches(value)];
            int j = 0;
            for (int i = 0; i <= rear; i++) {
                if (ousArray[i].getSubject().equals(value)) {
                    matches[j] = ousArray[i];
                    j++;
                }
            }
            return matches;
        }
        return null;
    }
    public void displayMenu() {
        System.out.println("""
                =============================| Array Linear Datastructures Options|=========================
                    1.  Insert At the beginning
                    2.  Insert at the end
                    3.  Insert at Position
                    4.  Is empty
                    5.  is Full
                    6.  Delete At beginning
                    7.  Delete at End
                    8.  Delete at Position
                    9.  Search with String
                    10. Search with Integer
                    11. Get ist index with String
                    12. Get ist index by integer
                    13. Insertion Sort by value
                ______________________________________[END OF OPTIONS]_____________________________________
                """);
    }
    public void reverseWithStack() {
        StackDsDynamic<Performance> stack = new StackDsDynamic<>();
        //fill stack
        for (Performance p: ousArray){
            stack.push(p);
        }
        //  empty stack reversing array
        for (int i = 0; i <= rear; i++){
            ousArray[i] = stack.pop();
        }
    }
    public void insertionSortWithValue() {
        /**
         * It tests each element at a time (current arr)with its predecessors  by looping from it
         * backwards looking for as value smaller than it (a value it's greater than) and stops there
         * and insert it there else its taken to the 1st position indicating it's the smallest mean while
         * while searching for the right position to insert it is swaps the elements one step to the
         * right and when it finds the position it then simply insert(It uses concept of inserting an element
         * to an array than involve shifting all values to the right creating room for the new value
         */
        for (int k = 1; k <= rear; k++) {
            Performance currentArr = ousArray[k];
            int currIndex = k;
            while (currIndex > 0 && ousArray[currIndex - 1].getMarks() > currentArr.getMarks()) {
                ousArray[currIndex] = ousArray[currIndex - 1];
                currIndex--;
            }
            ousArray[currIndex] = currentArr;
        }
    }
    public void merge(Performance[] arr, Performance subArr1[], Performance[] subArr2, int beginning,int mid, int end){
        int n1 = mid - beginning; //size of sub array 1
        int n2 = end - mid ; //size of sub array2
        int i = 0;//initial index for 1st sub array
        int j = 0; //initial index for 2nd sub arr
        int k = beginning; //initial index for merged array
        while (i < n1 && j < n2){
            if (subArr1[i].getMarks() <= subArr2[j].getMarks()){
                arr[k] = subArr1[i];
                i++;
            }else {
                arr[k] = subArr2[j];
                j++;
            }
            k++;
        }
        while (i < n1){
            arr[k++] = subArr1[i++];
        }
        while (j < n2){
            arr[k++] = subArr2[j++];
        }
    }
    public void mergeSort(Performance[] subArray) {
        int low = 0, high = subArray.length;
        if (high > 1) {
            int mid = (int) Math.ceil((high + low) / 2.0);
            //  divide
            Performance[] s1, s2;
            s1 = Arrays.copyOfRange(subArray, low, mid); //left array
            s2 = Arrays.copyOfRange(subArray, mid, high); //right array
//            System.out.println(Arrays.toString(s1) + Arrays.toString(s2));
            //conquer
            mergeSort(s1);
            mergeSort(s2);
            //merge
            merge(subArray, s1, s2, low, mid, high);
        }
    }
    public void bubbleSortWithValue() {
        /**
         * The BubbleSort compares each successive pair of elements in an unordered
         * list and inverts the elements if they are not in order ie  it swaps it with
         * predecessor and this process ends up the largest element in its right position ie sorted.
         * consecutive loops don't go to end since its sorted already as show in inner
         * loop condition j <= i
         * ANFP:PG-149;unsortedArc
         */
        Performance tmp;
        for (int i = rear; i >= 0; i--) {
            for (int j = 1; j <= i; j++) {
                if (ousArray[j - 1].getMarks() > ousArray[j].getMarks()) {
//                    /* Swapping */
                    tmp = ousArray[j];
                    ousArray[j] = ousArray[j - 1];
                    ousArray[j - 1] = tmp;
                }
            }
            //traverse();
        }
    }
    public int binarySearchByValue(int value, int low, int high) {
        /**
         * calculates the mid-position to be used in comparison and divide the array into two sub arrays
         * and going to the right or left depending on where the value is located i.e the greater side
         * the lesser side to the right or left respectively
         * returns -1 if no match found
         */
        int mid = (int) Math.ceil((low + high) / 2.0);
        if (mid - low > -1 && high - mid > -1) {//exit recursion due to exhaustion of all elements
            if (ousArray[mid].getMarks() == value) {//exit recursion when found the value being searched for
                //System.out.println("Found: " + ousArray[mid].getMarks() + " at: " + mid);
                return mid;
            } else if (ousArray[mid].getMarks() > value) {
                //System.out.println("Go to the left for smaller values: " + ousArray[mid].getMarks());
                return binarySearchByValue(value, low, mid - 1);
            } else {
//                System.out.println("Go to the right for bigger values: " + ousArray[mid].getMarks());
                return binarySearchByValue(value, mid + 1, high);
            }
        }
        return -1;
    }
    public Performance getTopPerfomance(){
        Performance top = ousArray[0];
        for (int i = 1;i<=rear;i++){
            if (ousArray[i].getMarks() > top.getMarks()){
                top = ousArray[i];
            }
        }
        return top;
    }
    public void selectionSortWithValue(){
        /**
         * in this sort, array has 2 section left > sorted and right unsorted.Att the begining it has not
         * sorted section.The array is passed up to the last element by outer loop and each with index i
         * is assumed to be the smallest and compared to all other succeeding elements looking for smaller
         * value and when found the are swapped leaving the left array section sorted.
         * (name selection sort since the smallest element is  selected from the unsorted
         * section and place at the last index of the sorted array section when swapping the two)
         */
        for (int i = 0; i <= rear; i++){
            int small = i;//for readerbility otherwise you can use i instead
            for (int j = i + 1; j <= rear; j++){
                // ousarr[i]/ous[small] => Is assumed to be the smallest in the right unsorted
                // section of the array
                if (ousArray[small].getMarks() > ousArray[j].getMarks()){
                    //swap them
                    Performance tmp = ousArray[small];
                    ousArray[i] = ousArray[j];
                    ousArray[j] = tmp;
                }
            }
        }
    }
    public void linearVsBinarySearchAlgo(int value) {
        long l_start = System.nanoTime();
        int l_index = linearSearchByValue(value);
        long l_time = System.nanoTime() - l_start;
        long b_start = System.nanoTime();
        int b_index = binarySearchByValue(value, 0, rear);
        long b_time = System.nanoTime() - b_start;
        System.out.println("Binary Search took: " + b_time + " miliseconds and found " + b_index);
        System.out.println("Linear Search took: " + l_time + " miliseconds and found " + l_index);

    }
    public void bucketSortByValue(){
        /**
         * Separate elements into multiple groups know as buckets which is uniformly distributed in range
         * elements in each ousBucket are then sorted by other stable algorithm and then gathered in a sorted
         * manner.adv:Reduces number of comaprisons, asymptotically first due to uniform distr of elements
         *
         */
        int MAX = getTopPerfomance().getMarks() + 1;
        Performance[] ousBucket = new Performance[MAX];
        for (int i = 0; i <= rear; i++){
            ousBucket[ousArray[i].getMarks()] = ousArray[i];
        }
        for (int i = 0, j = 0; i < ousBucket.length; i++){
            if (ousBucket[i] != null){
                ousArray[j++] = ousBucket[i];
                ousBucket[i] = null;
            }
        }

    }
    public void quickSortByValue(int low, int high){
        /**
         * Am Not fully implemented, Research and come back to me
         */
        int pivot = low;
        for (int i = high; i >= 0; i--){
            if (ousArray[pivot].getMarks() > ousArray[i].getMarks()){
                Performance tmp = ousArray[pivot];
                ousArray[pivot] = ousArray[i];
                ousArray[i] = tmp;

            }
        }
    }
    public static void main(String[] args) {
        ArraysDs arraysDs = new ArraysDs(10);
        arraysDs.addAtPosition(new Performance("eng", 70), 0);
        arraysDs.addAtPosition(new Performance("kis", 60), 1);
        arraysDs.addAtPosition(new Performance("eng", 40), 2);
        arraysDs.addAtTheEnd(new Performance("mao", 58));
        arraysDs.addAtTheEnd(new Performance("mao", 100));
        arraysDs.addAtBeginning(new Performance("cherry", 88));
        arraysDs.addAtBeginning(new Performance("Frank", 45));
        arraysDs.addAtTheEnd(new Performance("rose", 95));
        arraysDs.addAtTheEnd(new Performance("night", 74));
        arraysDs.addAtPosition(new Performance("Oscar", 90), 2);
//        for (int i = 10; i < 10000000; i++) {
//            arraysDs.addAtTheEnd(new Performance("lolo", i));
//        }
        arraysDs.traverse();
//        arraysDs.mergeSort(Arrays.copyOfRange(arraysDs.ousArray, 0, arraysDs.rear +1));
//        arraysDs.insertionSortWithValue();
//        arraysDs.bubbleSortWithValue();
//        arraysDs.traverse();
//        arraysDs.insertionSortWithValue();
//        arraysDs.traverse();
//        System.out.println("Index: " + arraysDs.binarySearchByValue(100, 0, arraysDs.rear));
//        arraysDs.linearVsBinarySearchAlgo(9999999);
//        arraysDs.traverse();
        arraysDs.selectionSortWithValue();
        arraysDs.traverse();
//        arraysDs.bucketSortByValue();
//        arraysDs.traverse();
        arraysDs.reverseWithStack();
        arraysDs.traverse();
        arraysDs.mergeSort(arraysDs.ousArray);
        arraysDs.traverse();

    }

}

class Performance {
    /**
     * @Author Ous
     * An array to encapsulate data using objects
     */
    private int marks;
    private String subject;

    public Performance(String key, int value) {
        this.subject = key;
        this.marks = value;
    }

    public String getSubject() {
        return this.subject;
    }

    public int getMarks() {
        return this.marks;
    }

    public String toString() {
        return ("(" + subject + "," + marks + ")");
    }
}