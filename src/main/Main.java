package main;

import datastructures.linear.arrays.ArraysDs;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    BufferedReader input;
    ArraysDs arraysDs;

    public Main(int size) {
        input = new BufferedReader(new InputStreamReader(System.in));
        arraysDs = new ArraysDs(size);
    }


    public int getUserChoice() {
        boolean repeat = false;
        do {
            System.out.print("[+]Choice:>> ");
            try {
                return Integer.parseInt(input.readLine());
            } catch (Exception e) {
                System.out.println(e.toString());
                repeat = true;
            }
        } while (repeat);
        return -1;
    }

    public void actionsExcecutor(int choice){

    }

    public static void main(String[] args) {

        String k = "lawi";
        System.out.println(k.hashCode());
        System.exit(0);
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Main driver ;
        System.out.print("[+]Enter size of array: ");
        try {
            driver = new Main(Integer.parseInt(input.readLine()));
            while (true) {
                driver.arraysDs.displayMenu();
                driver.getUserChoice();


            }

        } catch (NumberFormatException e) {
            System.err.println("The Array size must be of type Integer");
        } catch (Exception e) {
            System.err.println(e.toString());
        }

    }
}
