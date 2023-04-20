/*Student Name: Cynthia Maroupas Student ID: 261119382
Code Reference:https://github.com/farhadrclass/CCCS315/blob/main/2023-Winter/Assingment/Assignment%203/src/App.java*/

import java.util.Random; // this creates random for our program

public class App {

    /**
     * Sorts an array of numbers in ascending order using the heap sort algorithm
     *
     * @param elements the array of numbers to be sorted
     */
    public static void heapSort(int[] elements) {
        // Build a max heap from the input array
        for (int index = elements.length / 2 - 1; index >= 0; index--) {
            downHeap(elements, elements.length, index);
        }

        // Extract elements from the max heap one by one and put them at the end of the array
        for (int index = elements.length - 1; index >= 0; index--) {
            int temp = elements[0];
            elements[0] = elements[index];
            elements[index] = temp;

            // Restore the max heap property after removing the maximum element
            downHeap(elements, index, 0);
        }
    }

    /**
     * Reorganizes the elements of an array in a certain way to keep them in a specific order.
     * This method is a helper method for the {@link #heapSort(int[])} method.
     *
     * @param elements the array of numbers to be reorganized
     * @param sizeOfArray the number of elements in the array
     * @param startingNode the starting point of the reorganization
     */
    private static void downHeap(int[] elements, int sizeOfArray, int startingNode) {
        int largestNode = startingNode;
        int leftChild = 2 * startingNode + 1;
        int rightChild = 2 * startingNode + 2;

        // Find the largest node among the starting node and its two children
        if (leftChild < sizeOfArray && elements[leftChild] > elements[largestNode]) {
            largestNode = leftChild;
        }
        if (rightChild < sizeOfArray && elements[rightChild] > elements[largestNode]) {
            largestNode = rightChild;
        }

        // Swap the starting node with the largest node if they are different, and continue reorganizing
        if (largestNode != startingNode) {
            int temp = elements[startingNode];
            elements[startingNode] = elements[largestNode];
            elements[largestNode] = temp;
            downHeap(elements, sizeOfArray, largestNode);
        }
    }

    /**
     * Sorts an array of numbers in ascending order using the insertion sort algorithm.
     *
     * @param elements the array of numbers to be sorted
     */
    public static void insertionSort(int[] elements) {
        for (int index = 1; index < elements.length; index++) {
            int currentElement = elements[index];
            int previousIndex = index - 1;

            // Move all elements greater than the current element one position to the right
            // until the correct position for the current element is found
            while (previousIndex >= 0 && elements[previousIndex] > currentElement) {
                elements[previousIndex + 1] = elements[previousIndex];
                previousIndex--;
            }

            // Insert the current element into its correct position in the sorted array
            elements[previousIndex + 1] = currentElement;
        }
    }

    /**
     * Sorts an array of numbers in ascending order using the selection sort algorithm.
     *
     * @param elements the array of numbers to be sorted
     */
    public static void selectionSort(int[] elements) {
        for (int index = 0; index < elements.length - 1; index++) {
            int minIndex = index;
            // Find the index of the smallest element in the unsorted portion of the array
            for (int subIndex = index + 1; subIndex < elements.length; subIndex++) {
                if (elements[subIndex] < elements[minIndex]) {
                    minIndex = subIndex;
                }
            }

            // Swap the smallest element with the first unsorted element
            int temp = elements[minIndex];
            elements[minIndex] = elements[index];
            elements[index] = temp;
        }
    }

    /**
     * Generates an array of random integers and sorts it using three different sorting algorithms: heap sort,
     * insertion sort, and selection sort. Prints the time taken by each algorithm to sort the array.
     *
     * @throws Exception if there is an error generating or sorting the array
     */
    public static void main(String[] args) throws Exception {
        int numItem = 100; // This decides how big your array is
        int[] myArr = new int[numItem];
        Random myRand = new Random(); // creating Random object
        // Range for random to select from
        int min = 5;
        int max = 1000;

        int indexMin = 0;

        for (int i = 0; i < myArr.length; i++) {
            myArr[i] = myRand.nextInt(max - min + 1) + min; // storing random integers in an array
        }

        // Now sort the array using three different sorting algorithms and time each one
        double startTime = System.nanoTime();

        // Sort the array using heap sort and time it.
        double heapStartTime = System.nanoTime();
        heapSort(myArr);
        double heapEndTime = System.nanoTime();
        double heapDuration = (heapEndTime - heapStartTime) / 1000000;
        System.out.println("The Heap Sort Algorithm took " + heapDuration + " milliseconds.");

        // Sort the array using insertion sort and time it.
        double insertionStartTime = System.nanoTime();
        insertionSort(myArr);
        double insertionEndTime = System.nanoTime();
        double insertionDuration = (insertionEndTime - insertionStartTime) / 1000000;
        System.out.println("The Insertion Sort Algorithm took " + insertionDuration + " milliseconds.");

        // Sort the array using selection sort and time it.
        double selectionStartTime = System.nanoTime();
        selectionSort(myArr);
        double selectionEndTime = System.nanoTime();
        double selectionDuration = (selectionEndTime - selectionStartTime) / 1000000;
        System.out.println("The Selection Sort Algorithm took " + selectionDuration + " milliseconds.");

        double endTime = System.nanoTime();
        double duration = (endTime - startTime); // divide by 1000000 to get milliseconds.
        System.out.println("The time it took to sort the array using all three algorithms is " + duration + " milliseconds.");
    }
}