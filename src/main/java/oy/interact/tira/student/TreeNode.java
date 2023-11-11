package oy.interact.tira.student;



import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;

import oy.interact.tira.util.Pair;

public class TreeNode<K extends Comparable<K>, V>{

    private K key;
    private V value;
    private TreeNode<K, V> leftChild = null;
    private TreeNode<K, V> rightChild = null;
    public static int addDepth = 0;
    private Comparator<K> comparator;

    // Constructor

    public TreeNode(K key, V value, Comparator<K> comparator) {
        if (key != null) {
            this.key = key;
        }

        if (value != null) {
            this.value = value;
        }

        if (comparator != null){
            this.comparator = comparator;
        }
    }


    public boolean insert(K key, V value) {

        boolean result = false;
        if (this.value.equals(value)) {
            this.key = key;
            this.value = value;
            return result;
        }

        // Add to left side if parameter key is smaller or equal to this.key
        if (comparator.compare(key, this.key) <= 0) {
            if (leftChild == null) {
                leftChild = new TreeNode<>(key, value, comparator);
                addDepth++;
                result = true;
            } else {
                addDepth++;
                result = leftChild.insert(key, value);
            }
        } else { // Add to the right side if parameter key is bigger
            if (rightChild == null) {
                rightChild = new TreeNode<>(key, value, comparator);
                addDepth++;
                result = true;
            } else {
                result = rightChild.insert(key, value);
                addDepth++;
            }
        }
        return result;
    }

    public V find(K key) {

        V result = null;
        if (comparator.compare(this.key, key) == 0){
            result = value;
        } else if (comparator.compare(key, this.key) <= 0){
            if (leftChild != null) {
                result = leftChild.find(key);
            }
        } else {
            if (rightChild != null) {
                result = rightChild.find(key);
            }
        }

        return result;
    }

    //int currentindex

    public void toArray (Pair<K, V> [] array, AtomicInteger currentIndex){
        if (leftChild != null){
            leftChild.toArray(array, currentIndex);
        }
        array[currentIndex.getAndIncrement()] = new Pair<K, V>(key, value);
        if (rightChild != null){
            rightChild.toArray(array, currentIndex);
        }
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public TreeNode<K, V> getLeftChild() {
        return leftChild;
    }

    public TreeNode<K, V> getRightChild() {
        return rightChild;
    }

}
