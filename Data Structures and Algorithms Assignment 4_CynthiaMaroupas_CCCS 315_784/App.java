/*Student Name: Cynthia Maroupas Student ID: 261119382*/
/*This code creates an array of 100 random numbers between 5 and 1000, then sorts it using three different methods:
Bubble Sort, Merge Sort, and Quick Sort. The time taken for each method to sort the array is measured and printed in milliseconds.*/

import java.util.Random; // this creates random for our program

public class App {

    /**
     * Sorts the given integer array in ascending order using the Bubble Sort algorithm.
     *
     * @param array the integer array to be sorted
     * @return 0 when sorting is completed
     */
    public static int bubbleSort(int[] array) {
        int length = array.length;
        int temp = 0;

    // loop through the array and compare adjacent elements to sort them
        for (int i = 0; i < length; i++) {
            for (int j = 1; j < (length - i); j++) {
                if (array[j - 1] > array[j]) {
                    // swap the adjacent elements if they are in the wrong order
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return 0; // sorting is completed, return 0
    }

    /**
     * Sorts an integer array in ascending order using the Merge Sort algorithm.
     *
     * @param array the array to be sorted
     * @param left  the index of the first element in the subarray
     * @param right the index of the last element in the subarray
     * @return 0 upon completion of sorting
     */
    public static int mergeSort(int[] array, int left, int right) {
        // check if the array has more than one element to sort
        if (left < right) {
            // find the middle index of the array
            int middle = (left + right) / 2;
            // recursively sort the left half of the array
            mergeSort(array, left, middle);
            // recursively sort the right half of the array
            mergeSort(array, middle + 1, right);
            // merge the two sorted halves of the array
            merge(array, left, middle, right);
        }

        return 0;
    }

    /**
     * Sorts a subarray of the given array using the merge sort algorithm.
     *
     * @param arr    The array containing the subarray to be sorted.
     * @param left   The index of the leftmost element of the subarray to be sorted.
     * @param middle The index of the middle element of the subarray to be sorted.
     * @param right  The index of the rightmost element of the subarray to be sorted.
     * @return 0 after sorting the subarray.
     */
    public static int merge(int[] arr, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        for (int i = 0; i < n1; ++i)
            leftArr[i] = arr[left + i];
        for (int j = 0; j < n2; ++j)
            rightArr[j] = arr[middle + 1 + j];

        int i = 0, j = 0;
        int k = left;

        // Merge the two subarrays into a sorted array
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }
        // Copy any remaining elements of the left subarray
        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }
        // Copy any remaining elements of the right subarray
        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
        // Return 0 to indicate that the sorting is complete
        return 0;
    }

    /**
     * Sorts the given subarray in ascending order using the Quick Sort algorithm.
     *
     * @param array      the subarray to be sorted
     * @param startIndex the index of the first element in the subarray to be sorted
     * @param endIndex   the index of the last element in the subarray to be sorted
     * @return 0
     */
    public static int quickSort(int[] array, int startIndex, int endIndex) {
        // Check if there are at least two elements in the subarray
        if (startIndex < endIndex) {
            // Partition the subarray using a pivot element
            int pivotIndex = partition(array, startIndex, endIndex);
            // Recursively sort the two subarrays on either side of the pivot
            quickSort(array, startIndex, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, endIndex);
        }
        // Return 0 to indicate that the sorting is completed
        return 0;
    }

    /**
     * Partitions the given integer array around a pivot element, in place.
     * This implementation uses the last element of the subarray as the pivot.
     *
     * @param array      the integer array to partition
     * @param startIndex the index of the first element of the subarray to partition
     * @param endIndex   the index of the last element of the subarray to partition
     * @return the index of the pivot element after partitioning
     */

    public static int partition(int[] array, int startIndex, int endIndex) {
        int pivotValue = array[endIndex]; // Choose the pivot value as the last element in the array
        int partitionIndex = startIndex; // Initialize the partition index as the start index

        // Iterate through the array from the start index to the end index
        for (int i = startIndex; i < endIndex; i++) {
            // If the current element is less than the pivot value, swap it with the element at the partition index
            if (array[i] < pivotValue) {
                int temp = array[i];
                array[i] = array[partitionIndex];
                array[partitionIndex] = temp;
                partitionIndex++;
            }
        }
        // Swap the pivot value with the element at the partition index
        int temp = array[partitionIndex];
        array[partitionIndex] = array[endIndex];
        array[endIndex] = temp;

        // Return the partition index
        return partitionIndex;
    }

    /**
     * This method generates an array of 100 random integers with a range of values between 5 and 1000.
     * It then sorts the array using Bubble Sort, Merge Sort, and Quick Sort algorithms and prints the time taken
     * for each algorithm to sort the array in milliseconds. This method serves as a test of the efficiency of each sorting algorithm
     *
     * @param args the command line arguments
     * @throws Exception if an exception occurs during the sorting process
     */

    public static void main(String[] args) throws Exception {
        int numItem = 100; // This decides how big the array is
        int[] myArr = new int[numItem];
        Random myRand = new Random(); // creating Random object
        // Range for random to select from
        int min = 5;
        int max = 1000;

        for (int i = 0; i < myArr.length; i++) {
            myArr[i] = myRand.nextInt(max - min + 1) + min; // storing random integers in an array
        }

        // Sort using Bubble Sort
        double startTime = System.nanoTime();
        bubbleSort(myArr);
        double endTime = System.nanoTime();
        double duration = (endTime - startTime) / 1000000.0; // divide by 1000000 to get milliseconds
        System.out.println("Time taken for Bubble Sort: " + duration + " milliseconds");

        // Sort using Merge Sort
        startTime = System.nanoTime();
        mergeSort(myArr, 0, myArr.length - 1);
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 1000000.0; // divide by 1000000 to get milliseconds
        System.out.println("Time taken for Merge Sort: " + duration + " milliseconds");

        // Sort using Quick Sort
        startTime = System.nanoTime();
        quickSort(myArr, 0, myArr.length - 1);
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 1000000.0; // divide by 1000000 to get milliseconds
        System.out.println("Time taken for Quick Sort: " + duration + " milliseconds");
    }
}