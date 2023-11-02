package oy.interact.tira.student;

import java.util.function.Predicate;

import oy.interact.tira.util.Pair;
import oy.interact.tira.util.TIRAKeyedOrderedContainer;
import oy.interact.tira.util.Visitor;

public class BinarySearchTreeContainer<K extends Comparable <K>, V> implements TIRAKeyedOrderedContainer<K, V> {

    private TreeNode<K, V> root = null;
    private int count = 0;
    private int maxDepth = 0;


    
    @Override
    public void add(K key, V value) throws OutOfMemoryError, IllegalArgumentException {
        if (root == null){
            root = new TreeNode<>(key, value);
            count++;
            maxDepth = 1;
        }else {
            TreeNode.addDepth = 1;
            if (root.insert(key, value)){
                maxDepth = Math.max(maxDepth, TreeNode.addDepth);
                count++;
            }
        }



    }

    @Override
    public V get(K key) throws IllegalArgumentException {
        if (root == null){
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'find'");
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'size'");
    }

    @Override
    public int capacity() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'capacity'");
    }

    @Override
    public void ensureCapacity(int capacity) throws OutOfMemoryError, IllegalArgumentException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ensureCapacity'");
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'clear'");
    }

    @Override
    public Pair<K, V>[] toArray() throws Exception {
        if (root == null){
            return (Pair<K, V> []) new Pair[0];
        }

        return (Pair<K, V> []) new Pair[0];
    }
	/**
	 * Retrieves the index of an key in the container.
	 * 
	 * Note that in searching, comparison should be used; either Comparable interface
	 * or Comparator interface. When determining if the correct key has been found, 
	 * finally use equals.
	 * 
	 * @param itemKey The key to query the index of.
	 * @return The index of the key to search in the container, or -1 if not found or collection is empty.
	 */
    @Override
    public int indexOf(K itemKey) throws IndexOutOfBoundsException {



        return -1;
    }

    @Override
    public Pair<K, V> getIndex(int index) throws IndexOutOfBoundsException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getIndex'");
    }

    @Override
    public int findIndex(Predicate<V> searcher) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findIndex'");
    }

    @Override
    public void accept(Visitor<K, V> visitor) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'accept'");
    }
    
}
