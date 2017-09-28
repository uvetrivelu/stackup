package com.fff;

/**
 * Another implementation of SweetStack interface that private data structure for manipulating
 * values in stack like fashion.
 * The datastructure allows to maintain O(1) execution time on all the operations.
 */

public class SuperSweetStackImpl implements SweetStack {

    private class Node {
        Node next;
        int value;
    }

    int numberOfNodes;
    Node head;
    Node maxHead;
    Node minHead;

    private SuperSweetStackImpl() {
    }

    public SuperSweetStackImpl(int value) {
        this.head = new Node();
        this.head.value = value;
        this.head.next = null;
        this.maxHead = new Node();
        this.maxHead.value = value;
        this.maxHead.next = null;
        this.minHead = new Node();
        this.minHead.value = value;
        this.minHead.next = null;
        ++numberOfNodes;
    }

    /**
     * Adds values to top of the stack.
     * @param val element to be added to the stack
     */
    public void push(int val) {
        Node node = new Node();
        node.value = val;
        node.next = head;
        head = node;

        if (maxHead.value < val) {
            Node newMaxNode = new Node();
            newMaxNode.value = val;
            newMaxNode.next = maxHead;
            maxHead = newMaxNode;
        } else if (minHead.value > val) {
            Node newMinNode = new Node();
            newMinNode.value = val;
            newMinNode.next = minHead;
            minHead = newMinNode;
        }

        numberOfNodes++;
    }

    /**
     * Removes values from top.
     * @return value removed
     */
    public int pop() {
        if (head == null) {
            throw new java.util.NoSuchElementException();
        }
        int currentValue = head.value;
        head = head.next;
        numberOfNodes--;
        if (maxHead != null && maxHead.value == currentValue) {
            maxHead = maxHead.next;
        }
        return currentValue;
    }

    public int size() {
        return numberOfNodes;
    }


    /**
    * Returns max element if present, if not present, returns -1.
     */
    public int max() {
        return maxHead != null ? maxHead.value : -1;
    }


    /**
     * Returns min element if present, if not present, returns -1.
     * @return
     */
    public int min () {
        return minHead != null ? minHead.value : -1;
    }

}
