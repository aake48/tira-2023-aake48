package oy.interact.tira.student;

import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

import oy.interact.tira.util.Pair;
import oy.interact.tira.util.StackInterface;
import oy.interact.tira.util.TIRAKeyedOrderedContainer;
import oy.interact.tira.util.Visitor;

public class BinarySearchTreeContainer<K extends Comparable<K>, V> implements TIRAKeyedOrderedContainer<K, V> {

    private TreeNode<K, V> root = null;
    private int count = 0;
    private int maxDepth = 0;
    private Comparator<K> comparator;  // The comparator used to determine if new node will go to left or right subtree.

	public BinarySearchTreeContainer(Comparator<K> comparator) {
		this.comparator = comparator;
	}

    @Override
    public void add(K key, V value) throws OutOfMemoryError, IllegalArgumentException {

        if (key == null || value == null) {
            throw new IllegalArgumentException("Error: Key or value is null");
        }
        if (root == null) {
            root = new TreeNode<>(key, value, comparator);
            count++;
            maxDepth = 1;
        } else {
            TreeNode.addDepth = 1;
            if (root.insert(key, value)) {
                maxDepth = Math.max(maxDepth, TreeNode.addDepth);
                count++;
            }
        }
    }

    @Override
    public V get(K key) throws IllegalArgumentException {
        if (key == null) {
            throw new IllegalArgumentException("Error: The key is null");
        }
        if (root == null) {
            return null;
        }
        return root.find(key);
    }

    @Override
    public V remove(K key) throws IllegalArgumentException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public V find(Predicate<V> searcher) {

        if (root == null) {
            return null;
        }
        V value = null;
        TreeNode<K, V> current = root;
        TreeNode<K, V> parent = null;
        StackInterface<TreeNode<K, V>> nodeStack = new StackImplementation<>();

        while (!nodeStack.isEmpty() || current != null) {
            if (current != null) {
                nodeStack.push(current);
                parent = current;
                current = current.getLeftChild();
            } else {
                parent = nodeStack.pop();
                current = parent.getRightChild();
                if (searcher.test(parent.getValue())) {
                    value = parent.getValue();
                    return value;
                }
            }
        }
        return value;

    }

    /**
     * The number of key-value pairs in the container.
     * 
     * @return The number of pairs in container.
     */
    @Override
    public int size() {
        return count;
    }

    @Override
    public int capacity() {
        return Integer.MAX_VALUE;
    }

    @Override
    public void ensureCapacity(int capacity) throws OutOfMemoryError, IllegalArgumentException {

    }

    @Override
    public void clear() {
        root = null;
        count = 0;
        maxDepth = 0;
    }

    /**
     * Provides the elements of the container in an array. Note that
     * the array must not be any internal array used by the container, but
     * a temporary array allocated in the method. Caller can then manipulate
     * that array without manipulating the container internal data.
     * 
     * @return The key-value pairs in the container in an array.
     * @throws Exception If memory runs out or other faults happen in creating the
     *                   array.
     */
    @Override
    @SuppressWarnings("unchecked")
    public Pair<K, V>[] toArray() throws Exception {

        
        System.out.println("Max depth:" + maxDepth);
        Pair<K, V>[] array = (Pair<K, V>[]) new Pair[count];
        if (root == null) {
            return array;
        }
        AtomicInteger arrayIndex = new AtomicInteger(0);

       root.toArray(array, arrayIndex);

        return array;

    }

    /**
     * Retrieves the index of an key in the container.
     * 
     * Note that in searching, comparison should be used; either Comparable
     * interface
     * or Comparator interface. When determining if the correct key has been found,
     * finally use equals.
     * 
     * @param itemKey The key to query the index of.
     * @return The index of the key to search in the container, or -1 if not found
     *         or collection is empty.
     */
    @Override
    public int indexOf(K itemKey) throws IndexOutOfBoundsException {

        StackInterface<TreeNode<K, V>> nodeStack = new StackImplementation<>();
        TreeNode<K, V> current = root;
        TreeNode<K, V> parent = null;
        int index = 0;

        if (root == null) {
            return -1;
        }

        while (!nodeStack.isEmpty() || current != null) {
            if (current != null) {
                nodeStack.push(current);
                parent = current;
                current = current.getLeftChild();
            } else {
                parent = nodeStack.pop();
                current = parent.getRightChild();
                if (parent.getKey().equals(itemKey)) {
                    return index;
                }
                index++;
            }
        }

        return -1;
    }

    /**
     * Retrieves the key-value pair at the index.
     * 
     * @param index Index to retrieve, must be 0..<size.
     * @return The key-value pair.
     * @throws IndexOutOfBoundsException If index < 0 or index >= size.
     */
    @Override
    public Pair<K, V> getIndex(int index) throws IndexOutOfBoundsException {

        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Error: Index out of bounds");
        }
        int currentIndex = 0;
        TreeNode<K, V> current = root;
        TreeNode<K, V> parent = null;
        StackInterface<TreeNode<K, V>> nodeStack = new StackImplementation<>();

        if (root == null) {
            return null;
        }

        while (!nodeStack.isEmpty() || current != null) {
            if (current != null) {
                nodeStack.push(current);
                parent = current;
                current = current.getLeftChild();
            } else {
                parent = nodeStack.pop();
                current = parent.getRightChild();
                if (index == currentIndex) {
                    return new Pair<>(parent.getKey(), parent.getValue());
                }
                currentIndex++;
            }

        }

        return null;

    }

    /**
     * Finds an index for the value conforming to the predicate.
     * 
     * @param searcher The predicate specifying the search criteria.
     * @return The index for the value or -1 if not found.
     */
    @Override
    public int findIndex(Predicate<V> searcher) {
        StackInterface<TreeNode<K, V>> stack = new StackImplementation<>();
        TreeNode<K, V> current = root;
        TreeNode<K, V> parent = null;
        int index = 0;

        while (!stack.isEmpty() || root != null) {
            if (current != null) {
                stack.push(current);
                parent = current;
                current = current.getLeftChild();
            } else {
                parent = stack.pop();
                current = parent.getRightChild();
                if (searcher.test(parent.getValue())) {
                    return index;
                }
                index++;
            }
        }
        return -1;
    }

    @Override
    public void accept(Visitor<K, V> visitor) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'accept'");
    }
}
