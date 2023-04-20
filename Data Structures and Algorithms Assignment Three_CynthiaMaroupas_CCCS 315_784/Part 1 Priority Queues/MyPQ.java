/*Student Name: Cynthia Maroupas Student ID: 261119382*/

/*MyPQ is a way to organize a list of items where the smallest one is easy to find quickly.
It uses a binary heap to store the items.*/
public class MyPQ {
    private MyHeap heap;

    /**
     Constructs a new MyPQ instance with the specified capacity.
     @param capacity the capacity of the priority queue
     */
    public MyPQ(int capacity) {
        heap = new MyHeap(capacity);
    }
    /**
     Inserts the specified element into the priority queue.
     @param element the element to be inserted
     */
    public void insert(int element) {
        heap.insert(element);
    }
    /**
     Returns the minimum element in the priority queue.
     @throws RuntimeException if the priority queue is empty
     @return the minimum element in the priority queue
     */
    public int min() {
        return heap.min();
    }
    /**
     Removes and returns the minimum element in the priority queue.
     @throws RuntimeException if the priority queue is empty
     @return the minimum element in the priority queue
     */
    public int removeMin() {
        return heap.removeMin();
    }
    /**
     Returns the number of elements in the priority queue.
     @return the number of elements in the priority queue
     */
    public int size() {
        return heap.size();
    }
    /**
     Returns true if the priority queue is empty, false otherwise.
     @return true if the priority queue is empty, false otherwise
     */
    public boolean isEmpty() {
        return heap.isEmpty();
    }
    /**
     Returns a string representation of the priority queue.
     @return a string representation of the priority queue
     */
    public String toString() {
        return heap.toString();
    }
}