
package LibraryManagementSystem;

import java.lang.reflect.Array;
import java.util.Stack;

public class LibraryADT<T extends Comparable<T>> {
    private T[] array;
    private int size;
    private static final int INITIAL_CAPACITY = 10;
    private Stack<T> undoStack = new Stack<>();

    // Updated constructor to use reflection for creating a generic array
    @SuppressWarnings("unchecked")
    public LibraryADT(Class<T> clazz) {
        array = (T[]) Array.newInstance(clazz, INITIAL_CAPACITY); // Correct array initialization
        size = 0;
    }

    public void add(T element) {
        if (size == array.length) {
            resize();
        }
        array[size++] = element;
        undoStack.push(element); // Keep track of the added book for undo
    }

    public void insert(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (size == array.length) {
            resize();
        }
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = element;
        size++;
        undoStack.push(element); // Keep track of the inserted book for undo
    }

    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        T removedElement = array[index];
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        size--;
        undoStack.push(removedElement); // Keep track of the removed book for undo
        return removedElement;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return array[index];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void sort() {
        heapSort();
    }

    public void undoLastAction() {
        if (!undoStack.isEmpty()) {
            T lastAction = undoStack.pop();
            System.out.println("Undid last action: " + lastAction);
        } else {
            System.out.println("Nothing to undo.");
        }
    }

    private void heapSort() {
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(size, i);
        }
        for (int i = size - 1; i > 0; i--) {
            T temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapify(i, 0);
        }
    }

    private void heapify(int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && array[left].compareTo(array[largest]) > 0)
            largest = left;
        if (right < n && array[right].compareTo(array[largest]) > 0)
            largest = right;

        if (largest != i) {
            T swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;
            heapify(n, largest);
        }
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        T[] newArray = (T[]) Array.newInstance(array.getClass().getComponentType(), array.length * 2);
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }
}
