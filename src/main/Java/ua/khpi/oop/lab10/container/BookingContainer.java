package ua.khpi.oop.lab10.container;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BookingContainer<T> implements Iterable<T> {
    private T[] elements;
    private int size = 0;
    private static final int INITIAL_CAPACITY = 10;

    @SuppressWarnings("unchecked")
    public BookingContainer() {
        this.elements = (T[]) new Object[INITIAL_CAPACITY];
    }

    public void add(T element) {
        if (size == elements.length) {
            grow();
        }
        elements[size++] = element;
    }

    public int size() {
        return size;
    }

    @SuppressWarnings("unchecked")
    private void grow() {
        int newCapacity = elements.length * 2;
        T[] newElements = (T[]) new Object[newCapacity];
        System.arraycopy(elements, 0, newElements, 0, elements.length);
        elements = newElements;
    }

    @Override
    public Iterator<T> iterator() {
        return new BookingIterator();
    }

    private class BookingIterator implements Iterator<T> {
        private int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor < size;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return elements[cursor++];
        }
    }
}