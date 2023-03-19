/* Student Name : Cynthia Maroupas Student ID: 261119382 Class: CCCS 315-784 */
/* This project is Part 1 of the second assignment for Data Structures and Algorithm class */
/* This class implements a stack ADT data structure using an Array and provides methods for pushing elements, popping elements,
checking the size of the stack, and returning a string representation of the stack elements.*/

/**

 A class that implements a stack ADT data structure using an array of Integer objects.
 */
public class Stacks {

    private Integer[] arrayValues;
    private int topIndex;

    /**

     Constructor for creating a new instance of the stack with a given size.
     @param size the size of the stack
     */
    public Stacks(int size) {
        arrayValues = new Integer[size];
        topIndex = -1;
    }
    /**

     Pushes an element onto the top of the stack.
     @param element the element to be pushed at the top
     */
    public void push(Integer element) {
        if (topIndex == arrayValues.length - 1) {
            return;
        }
        topIndex++;
        arrayValues[topIndex] = element;
    }
    /**

     Removes and returns the element at the top of the stack.
     @return the element at the top of the stack, or null if empty
     */
    public Integer pop() {
        if (topIndex == -1) {
            return null;
        }
        Integer element = arrayValues[topIndex];
        topIndex--;
        return element;
    }
    /**

     Returns the number of elements in the stack.
     @return the size of the stack
     */
    public int size() {
        return topIndex + 1;
    }
    /**

     Returns a string representation of the stack.
     @return a string containing the elements of the stack in LIFO order
     */
    @Override
    public String toString() {
        String result = "[";
        for (int i = topIndex; i >= 0; i--) {
            result += arrayValues[i];
            if (i > 0) {
                result += "-";
            }
        }
        result += "-]";
        return result;
    }
}