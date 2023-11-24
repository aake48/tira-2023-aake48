package oy.interact.tira.student;

import oy.interact.tira.util.StackInterface;

public class StackImplementation<E> implements StackInterface<E> {

    private Object[] itemArray = null;
    private static final int DEFAULT_STACK_SIZE = 10;
    private int currentIndex = -1;

    // Constructors

    public StackImplementation() {
        this(DEFAULT_STACK_SIZE);
    }

    public StackImplementation(int capacity) {
        if (capacity < 0) {
            throw new IndexOutOfBoundsException("Error: Can't set capacity under 0");
        }
        itemArray = new Object[capacity];
    }

    private void reallocate(int newCapacity) {

        Object[] newArray = new Object[newCapacity];
        for (int index = 0; index <= currentIndex; index++) {
            newArray[index] = itemArray[index];
        }
        itemArray = newArray;
    }

    @Override
    public int capacity() {
        return itemArray.length;
    }

    @Override
    public void push(E element) throws OutOfMemoryError, NullPointerException {
        if (element == null) {
            throw new NullPointerException("Error: Element is null");
        }
        if (size() == capacity()) {
            reallocate(itemArray.length * 2);
        }
        currentIndex++;
        itemArray[currentIndex] = element;

    }

    @SuppressWarnings("unchecked")
    @Override
    public E pop() throws IllegalStateException {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        E removedElement = (E) itemArray[currentIndex];
        itemArray[currentIndex] = null;
        currentIndex--;
        return removedElement;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E peek() throws IllegalStateException {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return (E) itemArray[currentIndex];
    }

    @Override
    public int size() {
        return currentIndex + 1;
    }

    @Override
    public boolean isEmpty() {
        if (currentIndex < 0) {
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        itemArray = new Object[DEFAULT_STACK_SIZE];
        currentIndex = -1;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("[");
        for (int index = 0; index <= currentIndex; index++) {
            builder.append(itemArray[index].toString());
            if (index < currentIndex) {
                builder.append(", ");
            }

        }
        builder.append("]");
        return builder.toString();
    }

}
