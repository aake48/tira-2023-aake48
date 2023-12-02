package oy.interact.tira.student;

import java.util.function.Predicate;

import oy.interact.tira.util.Pair;
import oy.interact.tira.util.TIRAKeyedContainer;

public class HashTableContainer<K extends Comparable<K>, V> implements TIRAKeyedContainer<K, V> {

    private int addCollided = 0;
    private int collisionCounter = 0;
    private int probingCounter = 0;
    private int pairsUpdated = 0;
    private int count = 0;
    private static final int DEFAULT_TABLE_SIZE = 40;
    private static final double LOAD_FACTOR = 0.65;
    private Pair<K, V>[] array;

    @SuppressWarnings("unchecked")
    public HashTableContainer() {
        this.array = (Pair<K, V>[]) new Pair[DEFAULT_TABLE_SIZE];
    }

    @SuppressWarnings("unchecked")
    public void reallocate(int newCapacity) {

        if (!(newCapacity <= count)) {

            Pair<K, V>[] oldArray = array;
            array = (Pair<K, V>[]) new Pair[newCapacity];

            collisionCounter = 0;
            probingCounter = 0;
            count = 0;

            for (int index = 0; index < oldArray.length; index++) {
                if (oldArray[index] != null) {
                    add(oldArray[index].getKey(), oldArray[index].getValue());
                }
            }
        }
    }

    @Override
    public void add(K key, V value) throws OutOfMemoryError, IllegalArgumentException {

        if (key == null || value == null) {
            throw new IllegalArgumentException("Error: Key or value cannot be null");
        }
        if (count >= array.length * LOAD_FACTOR) {
            reallocate((int) (array.length / LOAD_FACTOR));
        }
        int hash = key.hashCode();
        int index = 0;
        boolean added = false;
        int hashModifier = 0;
        do {
            index = indexFor(hash, hashModifier);
            if (array[index] == null) {
                array[index] = new Pair<K, V>(key, value);
                added = true;
                count++;
            } else if (array[index].getKey().equals(key)) {
                array[index].setValue(value);
                addCollided++;
                added = true;
            } else {
                hashModifier++;
                collisionCounter++;
                probingCounter++;
            }
        } while (!added);
    }

    @Override
    public V get(K key) throws IllegalArgumentException {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        int hash = key.hashCode();
        int hashModifier = 0;
        int index = 0;
        boolean found = false;
        V value = null;

        do {
            index = indexFor(hash, hashModifier);
            Pair<K, V> pair = array[index];
            if (array[index] == null) {
                found = true;
            } else if (pair.getKey().equals(key)) {
                value = pair.getValue();
                found = true;
            }else{
            hashModifier++;
            collisionCounter++;
            probingCounter++;
            }
        } while (!found);

        // If nothing in index, return null
        return value;

    }

    @Override
    public V remove(K key) throws IllegalArgumentException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public V find(Predicate<V> searcher) {
        int index = 0;
        V value = null;

        while (index < array.length) {
            if (array[index] != null) {
                if (searcher.test(array[index].getValue())) {
                    value = array[index].getValue();
                    return value;
                }
            }
            index++;
        }
        // returns null if value not found
        return value;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public int capacity() {
        return array.length;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void ensureCapacity(int capacity) throws OutOfMemoryError, IllegalArgumentException {
        if (count == 0) {
            array = (Pair<K, V>[]) new Pair[capacity];
        } else if (!(capacity <= count)) {
            reallocate(capacity);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public void clear() {
        this.array = (Pair<K, V>[]) new Pair[DEFAULT_TABLE_SIZE];
        this.count = 0;
        this.collisionCounter = 0;
        this.probingCounter = 0;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Pair<K, V>[] toArray() throws Exception {
        System.out.println("Count: " + count);
        System.out.println("Collisions " + collisionCounter);
        System.out.println("Probing: " + probingCounter);
        Pair<K, V>[] array2 = (Pair<K, V>[]) new Pair[count];
        int index2 = 0;
        for (int index = 0; index < array.length; index++) {
            if (array[index] != null) {
                array2[index2++] = array[index];
            }
        }

        return array2;
    }

    private int indexFor(int hash, int hashModifier) {
        final int c1 = 4;
        final int c2 = 17;
        return ((hash + c1 * hashModifier + c2 * (hashModifier * hashModifier) & 0x7FFFFFFF)% array.length);
    }

}
