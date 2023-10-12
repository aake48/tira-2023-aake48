package oy.interact.tira.student;

import oy.interact.tira.util.QueueInterface;

public class QueueImplementation<E> implements QueueInterface<E> {

    private int head;
    private int tail;
    private int count = 0;
    private static final int DEFAULT_QUEUE_SIZE = 10;
    private Object[] itemArray = null;
    private int capacity = DEFAULT_QUEUE_SIZE;

    public QueueImplementation() {
        this(DEFAULT_QUEUE_SIZE);
    }

    public QueueImplementation(int newCapacity) {
        if (newCapacity < 0) {
            throw new IndexOutOfBoundsException("Error: Can't set capacity under 0");
        }
        this.capacity = newCapacity;
        itemArray = new Object[capacity];
        head = 0;
        tail = 0;
        
    }

    // Own method, used for reallocating the array if needed
    private void reallocate(int newCapacity){

        int counter = count;
        int oldIndex = head;
        head = 0;
        tail = 0;
        Object [] newArray = new Object[newCapacity];
        
        while (counter > 0){
            if (oldIndex >= itemArray.length){
                oldIndex = 0;
            }
            newArray[tail++] = itemArray[oldIndex++];
            counter--;
        }
        itemArray = newArray;
        count = tail;
        capacity = newCapacity;


    }

    /**
     * For querying the current capacity of the queue.
     * 
     * @return The number of elements the queue can currently hold.
     */
    @Override
    public int capacity() {
        return capacity;
    }

    /**
     * Add an element to the queue.
     * 
     * @param element The element to add, must not be null.
     * @throws QueueAllocationException If the reallocation for the queue failed in
     *                                  case queue needs reallocation.
     * @throws NullPointerException     If the element is null.
     */
    @Override
    public void enqueue(Object element) throws OutOfMemoryError, NullPointerException {

        if (element == null) {
            throw new NullPointerException("The element is null");
        }

        if (count == itemArray.length) {
            try {
                reallocate(capacity * 2);
            } catch (Exception e) {
                throw new OutOfMemoryError("Queue allocation failed, out of memory");
            }
        }

        if (tail >= itemArray.length && head > 0) {
            tail = 0;
        }
        itemArray[tail] = element;
        tail++;
        count++;

    }

    /**
     * Removes an element from the queue.
     * 
     * @return The element from the head of the queue.
     * @throws QueueIsEmptyException If the queue is empty.
     */
    @SuppressWarnings("unchecked")
    @Override
    public E dequeue() throws IllegalStateException {

        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        E element = (E) itemArray[head];
        itemArray[head] = null;
        head++;
        count--;

        if (head == itemArray.length){
            head = 0;
        }

        return element;
    }

    /**
     * Returns the element at the head of the queue, not removing it from the queue.
     * 
     * @return The element in the head of the queue.
     * @throws QueueIsEmptyException If the queue is empty.
     */
    @SuppressWarnings ("unchecked")
    @Override
    public E element() throws IllegalStateException {

        if (isEmpty()){
            throw new IllegalStateException("Error queue is empty");
        }
        return (E)itemArray[head];
    }

    /**
     * Returns the count of elements currently in the queue.
     * 
     * @return Count of elements in the queue.
     */

    @Override
    public int size() {
        return count;
    }

    /**
     * Can be used to check if the queue is empty.
     * 
     * @return True if the queue is empty, false otherwise.
     */

    @Override
    public boolean isEmpty() {
        if (count == 0) {
            return true;
        }
        return false;
    }

    /**
     * Resets the queue to empty state, removing the objects.
     */

    @Override
    public void clear() {
        capacity = DEFAULT_QUEUE_SIZE;
        Object [] newArray = new Object[capacity];
        itemArray = newArray;
        head = 0;
        tail = 0;
        count = 0;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        int counter = count;
        int index = head;

        builder.append("[");
        while (counter > 0){
            builder.append(itemArray[index]);
            if (counter > 1){
                builder.append(", ");
            }
            index++;
            counter--;
            if (index >= itemArray.length){
                index = 0;
            }
        }

        builder.append("]");
        return builder.toString();
    }

}
