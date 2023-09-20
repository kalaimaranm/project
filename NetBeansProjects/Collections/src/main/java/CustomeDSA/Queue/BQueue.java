package CustomeDSA.Queue;

public class BQueue implements Queue {

    int[] queue;
    int start = 0;
    int end = 0;
    int element = 0;

    public BQueue() {
        this.queue = new int[6];
    }

    @Override
    public boolean push(Object value) {
        
        return true;    //++end
    }

    @Override
    public String peak() {
        return null;
    }


    @Override
    public String poll() {//++start
        return null;
    }

    @Override
    public int size() {
        return -1;
    }

    @Override
    public int capacity() {
        return -1;
    }

}
