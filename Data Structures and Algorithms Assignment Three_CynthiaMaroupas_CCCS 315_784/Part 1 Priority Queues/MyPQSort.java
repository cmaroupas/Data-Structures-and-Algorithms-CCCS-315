/*Student Name: Cynthia Maroupas Student ID: 261119382*/

/*Using a priority queue, MyPQSort uses a static method for sorting an array of numbers.
Heap sort maintains a collection of elements where the smallest element is always available in constant time.
The input array is sorted using an ascending order.*/
public class MyPQSort {

    /**
     Sorts an array of integers in ascending order using a priority queue.
     @param elements the array of integers to be sorted
     */
    public static void heapSort(int[] elements) {
        MyPQ pqueue = new MyPQ(elements.length);
        for (int i = 0; i < elements.length; i++) {
            pqueue.insert(elements[i]);
        }
        for (int i = 0; i < elements.length; i++) {
            elements[i] = pqueue.removeMin();
        }
    }
}