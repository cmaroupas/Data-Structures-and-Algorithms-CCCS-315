/*Student Name: Cynthia Maroupas Student ID: 261119382*/

import java.util.Collections;
import java.util.LinkedList;

public class Search {

    /**
     * Main method to demonstrate finding a value in a LinkedList using linear and binary search methods.
     */
    public static void main(String[] args) {
        int n = 100;
        int minValue = 0;
        int maxValue = 10;
        int myValue = 5;

        // Generate a linked list of size n with random int values between minValue and maxValue
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int randValue = (int) (Math.random() * (maxValue - minValue + 1) + minValue);
            list.add(randValue);
        }

        // Sort the list
        Collections.sort(list);

        // Method 1: Linear search
        int index1 = findUsingLinearSearch(list, myValue);
        if (index1 == -1) {
            System.out.println("Linear search: The value " + myValue + " was not found in the linked list.");
        } else {
            System.out.println("Linear search: The value " + myValue + " was found at index " + index1 + " in the linked list.");
        }

        // Method 2: Binary search
        int index2 = findUsingBinarySearch(list, 0, n - 1, myValue);
        if (index2 == -1) {
            System.out.println("Binary search: The value " + myValue + " was not found in the linked list.");
        } else {
            System.out.println("Binary search: The value " + myValue + " was found at index " + index2 + " in the linked list.");
        }
    }

    /**
     * Finds the index of a value in the list using linear search.
     *
     * @param list the LinkedList to search
     * @param targetValue the value to search for
     * @return the index of the value if found, return -1 otherwise
     */
    public static int findUsingLinearSearch(LinkedList<Integer> list, int targetValue) {
        int index = 0;
        for (int num : list) {
            if (num == targetValue) {
                return index;
            }
            index++;
        }
        return -1;
    }

    /**
     * Finds the index of a value in the sorted list using binary search and recursion.
     *
     * @param list the sorted LinkedList to search
     * @param left the left index of the search interval
     * @param right the right index of the search interval
     * @param targetValue the value to search for
     * @return the index of the value if found, return -1 otherwise
     */
    public static int findUsingBinarySearch(LinkedList<Integer> list, int left, int right, int targetValue) {
        if (right >= left) {
            int mid = left + (right - left) / 2;

            if (list.get(mid) == targetValue) {
                return mid;
            }

            if (list.get(mid) > targetValue) {
                return findUsingBinarySearch(list, left, mid - 1, targetValue);
            }

            return findUsingBinarySearch(list, mid + 1, right, targetValue);
        }

        return -1;
    }
}