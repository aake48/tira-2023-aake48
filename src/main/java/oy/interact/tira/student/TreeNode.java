package oy.interact.tira.student;

public class TreeNode<K extends Comparable<K>, V> {

    private K key;
    private V value;
    private TreeNode<K, V> leftChild = null;
    private TreeNode<K, V> rightChild = null;
    public static int addDepth = 0;

    // Constructor

    public TreeNode(K key, V value) {
        if (key != null) {
            this.key = key;
        }

        if (value != null) {
            this.value = value;
        }
    }

    public boolean insert(K key, V value) {

        boolean result = false;
        if (this.value.equals(value)) {
            this.key = key;
            this.value = value;
            return result;
        }

        // Add to left side if parameter key is smaller
        if (key.compareTo(this.key) <= 0) {
            if (leftChild == null) {
                leftChild = new TreeNode<>(key, value);
                addDepth++;
                result = true;
            } else {
                addDepth++;
                result = leftChild.insert(key, value);
            }
        } else { // Add to the right side if parameter key is bigger
            if (rightChild == null) {
                rightChild = new TreeNode<>(key, value);
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
        if (this.key.compareTo(key) == 0) {
            result = value;
        } else if (key.compareTo(this.key) <= 0) {
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

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

}
