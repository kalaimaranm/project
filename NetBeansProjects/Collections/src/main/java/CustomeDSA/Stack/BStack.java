package CustomeDSA.Stack;

import java.util.Arrays;

public class BStack implements Stack {

    int[] stack;
    int element = 0;

    public BStack() {
        this.stack = new int[6];
    }

    @Override
    public int push(int add) {
        if (stack.length > element) {
            stack[element++] = add;
            return add;
        } else {
            stack = Arrays.copyOf(stack, stack.length * 2);
            if (stack.length > element) {
                stack[element++] = add;
                return add;
            }
            return -1;
        }

    }

    @Override
    public String peek() {
        if (!(element == 0)) {
            return stack[element - 1] + "";
        }
        return "[]";
    }

    @Override
    public String poll() {
        if (!(element == 0)) {
            return stack[--element] + "";
        }
        return "[]";
    }

    @Override
    public int capacity() {
        return stack.length;
    }

    @Override
    public int size() {
        return element;
    }

    @Override
    public String toString() {
        String out = "[";
        for (int i = 0; i < element; i++) {
            if (i == element - 1) {
                out += stack[i];
            } else {
                out += stack[i] + ",";
            }
        }
        return out + "]";
    }

}
