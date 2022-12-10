package datastructures.linear.arrays;

import datastructures.utils.exceptions.ArrayFullError;

public class Test {
    public static void main(String[] args) {
        Array numbers = new Array(4);
        numbers.insert(3);
        numbers.insert(2);
        numbers.insert(7);
        numbers.insert(9);
        numbers.insert(9);
        numbers.insert(9);
        numbers.print();
    }
}
