package org.farrukh.examples.data.structures.tree;

/**
 * Binary Tree data structure.
 */
public abstract class AbstractBinaryTree<E> implements BinaryTree {

    private int size;

    private Node root;

    public AbstractBinaryTree(int size) {
        this.size = size;
    }

    class Node<E> {
        private Node<E> left;
        private Node<E> right;
        private E value;

        public Node(E value) {
            this.value = value;
        }
    }

    public void addNode(E value) {
        Node<E> newNode = new Node<>(value);
    }

    public int getSize() {
        return size;
    }
}
