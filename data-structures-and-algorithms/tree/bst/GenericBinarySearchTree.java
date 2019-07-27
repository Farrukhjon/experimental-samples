/**
 * Complete me!
 **/
public class BinarySearchTree<K extends Comparable<T>> {
    
    private Node root;

    class Node {
        K key;
        V value
        Node left;
        Node right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        } 

    }

    public void put(K key, V value) {
        if(root == null) {
            root = new Node(key, value);
        }
        else {
           int comp = key.compareTo(root.key);
           if(comp < 0) {

           }
           else {
           } 
        }

        Node newNode = new Node(data);
        data.compareTo()
    }



} 
