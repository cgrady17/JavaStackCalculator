package grady.util;

import java.util.NoSuchElementException;

/**
 * Represents a last-in, first-out (LIFO) unbounded data structure.
 * @author Connor P Grady
 */
public class Stack<T> {
    private int length;

    private class Node {
        private T data;
        private Node next;
    }

    private Node top;

    /**
     * Adds an element to the top of the Stack.
     * @param item The element to be added to the Stack.
     * @return The updated Stack with the new element at the top.
     */
    public Stack<T> push(T item) {
        Node current = top;
        top = new Node();
        top.data = item;
        top.next = current;
        length++;
        return this;
    }

    /**
     * Removes and returns the top-most element in the Stack.
     * @return Top element in the Stack.
     */
    public T pop() {
        if (top == null) throw new NoSuchElementException();

        T item = top.data;
        top = top.next;
        length--;
        return item;
    }

    /**
     * Returns the top-most element in the Stack.
     * @return Top element in the Stack.
     */
    public T peek() {
        if (top == null) throw new NoSuchElementException();

        return top.data;
    }

    /**
     * Outputs all elements in the Stack as a comma-delimited String.
     * @return Comma-delimited String.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node tmp = top;

        while (tmp != null) {
            sb.append(tmp.data).append(", ");
            tmp = tmp.next;
        }

        return sb.toString();
    }
}
