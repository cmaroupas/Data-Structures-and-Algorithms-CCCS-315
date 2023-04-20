/*Student Name: Cynthia Maroupas Student ID: 261119382*/

/* This implementation represents a binary heap using an array.*/
public class MyHeap {
    private int[] heap; // array to store heap elements
    private int size; // number of elements in the heap

    /**
     * Constructs an empty heap with the specified capacity.
     * @param capacity the maximum number of elements the heap can hold
     */
    public MyHeap(int capacity) {
        heap = new int[capacity];
        size = 0;
    }

    /**
     * Inserts the specified element into the heap.
     * @param element the element to insert
     * @throws RuntimeException if the heap is already full
     */
    public void insert(int element) {
        if (size == heap.length) {
            throw new RuntimeException("The maximum capacity of the heap has been reached, cannot insert more elements");
        }

        heap[size] = element;
        siftUp(size);
        size++;
    }

    /**
     * Returns the minimum element in the heap.
     * @throws RuntimeException if the heap is empty
     */
    public int min() {
        if (isEmpty()) {
            throw new RuntimeException("Cannot return minimum element: the heap is already empty.");
        }

        return heap[0];
    }

    /**
     * Removes and returns the minimum element in the heap.
     * @throws RuntimeException if the heap is empty
     */
    public int removeMin() {
        if (isEmpty()) {
            throw new RuntimeException("Cannot remove minimum element: the heap is already empty.");
        }

        int min = heap[0];
        heap[0] = heap[size - 1];
        size--;
        downSift(0);
        return min;
    }

    /**
     * Returns the number of elements in the heap.
     */
    public int size() {
        return size;
    }

    /**
     * Returns true if the heap is empty, false otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns a string representation of the heap.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(heap[i]);
            if (i != size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * Moves the element at the specified index up the heap until it satisfies the heap property.
     * @param index the index of the element to sift up
     */
    private void siftUp(int index) {
        if (index == 0) {
            return;
        }

        int parentIndex = (index - 1) / 2;
        if (heap[index] < heap[parentIndex]) {
            exchange(index, parentIndex);
            siftUp(parentIndex);
        }
    }

    private void downSift(int index) {
        int leftChildIndex = index * 2 + 1;
        int rightChildIndex = index * 2 + 2;

        int smallestChildIndex = index;
        if (leftChildIndex < size && heap[leftChildIndex] < heap[smallestChildIndex]) {
            smallestChildIndex = leftChildIndex;
        }
        if (rightChildIndex < size && heap[rightChildIndex] < heap[smallestChildIndex]) {
            smallestChildIndex = rightChildIndex;
        }

        if (smallestChildIndex != index) {
            exchange(index, smallestChildIndex);
            downSift(smallestChildIndex);
        }
    }

    private void exchange(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}