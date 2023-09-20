package multi.thread;

public class Consumer extends Thread {

    private WareHouse wareHouse;

    public Consumer(WareHouse wareHouse) {

        this.wareHouse = wareHouse;
    }

    @Override
    public void run() {

        System.out.println("..................consumer is unloading the goods............" + Thread.currentThread().getName());

        for (int i = 0; i < 10; i++) {

            System.out.println("c1 # " + wareHouse.getGoods());
            try {
                Thread.sleep(700);
            } catch (InterruptedException ex) {

                ex.printStackTrace();
            }
        }
    }

    public void setWareHouse(WareHouse wareHouse) {
        this.wareHouse = wareHouse;
    }

    public WareHouse getWareHouse() {
        return wareHouse;
    }

}
