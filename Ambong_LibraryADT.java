package li;

public class LibraryADT<T> {
    private T[] array;
    private int size;
    private static final int INITIAL_CAPACITY = 10;

    @SuppressWarnings("unchecked")
    public LibraryADT() {
        array = (T[]) new Object[INITIAL_CAPACITY];
        size = 0;
    }

    public void add(T element) {
        if (size == array.length) {
            resize();
        }
        array[size++] = element;
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
    }

