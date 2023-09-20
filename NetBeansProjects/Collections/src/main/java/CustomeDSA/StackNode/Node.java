package CustomeDSA.StackNode;

public class Node<T> {

    T data;
    int address;

    public Node(T data, int address) {
        this.data = data;
        this.address = address;
    }
}
