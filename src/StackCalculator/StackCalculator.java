package StackCalculator;

import java.util.Objects;
import java.util.Scanner;
//import grady.util.Stack;

/**
 * Supported Commands
 *
 */
public class StackCalculator {
    private Stack stack;

    public void runProgram() {
        String input = "";
        while (!input.equals("x")) {
            System.out.print("> ");
            Scanner s = new Scanner(System.in);
            input = s.nextLine();
            interpretInput(input);
        }
    }

    private void interpretInput(String input) {
        if (input == null) throw new IllegalArgumentException();

        if (input.equals("s") || input.equals("+") || isInteger(input, 10)) {
            stack = new Stack().init(input.trim(), stack);
        } else if (input.equals("d")) {
            displayStack();
        } else if (input.equals("e")) {
            evaluateStack();
        }
    }

    private void evaluateStack() {
        if (stack.isNull()) throw new IllegalArgumentException("stack");

        Stack thisStack = stack;
        int total = 0;

        while(thisStack != null) {
            String val = thisStack.pop();

            if (val.equals("+")) {
                String int1 = thisStack.pop();
                String int2 = thisStack.pop();

                total = Integer.parseInt(int1) + Integer.parseInt(int2);

                thisStack.push(Integer.toString(total));
            } else if (val.equals("s")) {
                String int1 = thisStack.pop();
                String int2 = thisStack.pop();

                thisStack.push(int1);
                thisStack.push(int2);
            }
        }
    }

    private void displayStack() {
        if (stack.isNull()) throw new IllegalArgumentException();

        Stack thisStack = stack;

        while(thisStack != null) {
            System.out.println(thisStack.peek());
            thisStack = thisStack.tail();
        }
    }

    private static boolean isInteger(String s, int radix) {
        Scanner sc = new Scanner(s.trim());
        if (!sc.hasNextInt(radix)) return false;

        sc.nextInt(radix);
        return !sc.hasNext();
    }
}
