package CustomeDSA.Stack;

public class Main {

    public static void main(String[] args) {
        Stack stack = new BStack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(60);
        stack.push(70);
        System.out.println(stack.peek());
        System.out.println(stack.poll());
        System.out.println(stack);
        System.out.println(stack.capacity());
        System.out.println(stack.size());
    }

}
