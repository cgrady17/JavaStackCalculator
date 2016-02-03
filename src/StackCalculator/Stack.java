package StackCalculator;

/**
 * Created by Connor on 2/3/2016.
 */
public class Stack {
    public Stack() {
        head = null;
    }

    private String head;

    private Stack tail;

    public boolean isNull() {
        return head == null;
    }

    public Stack tail() {
        return tail;
    }

    public String head() {
        return head;
    }

    public String peek() {
        return head;
    }

    public String pop() {
        String currentToken = this.peek();
        if (tail != null) {
            head = this.tail.pop();
        } else {
            head = null;
        }
        return currentToken;
    }

    public Stack push(String s) {
        return init(s, this);
    }

    public Stack init(String s, Stack rest) {
        head = s;
        tail = rest;
        return this;
    }
}
