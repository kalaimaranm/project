package CustomeDSA.Queue;

public interface Queue<T> {

    public boolean push(T value);

    public String peak();

    public String poll();

    public int size();

    public int capacity();

}
