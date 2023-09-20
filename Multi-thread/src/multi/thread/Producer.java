package multi.thread;

import java.util.Random;

public class Producer extends Thread {

    private WareHouse wareHouse;

    public Producer(WareHouse wareHouse) {

        this.wareHouse = wareHouse;
    }

    @Override
    public void run() {

        String name = Thread.currentThread().getName();
        System.out.println(name);
        Random r = new Random();
        
        r.ints(10, 10, 100).forEach(ic
                -> {
            try {

                wareHouse.setGoods(ic);
                System.out.println(name + " - " + ic);
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        });
    }

    public void setWareHouse(WareHouse wareHouse) {
        this.wareHouse = wareHouse;
    }

    public WareHouse getWareHouse() {
        return wareHouse;
    }

}
