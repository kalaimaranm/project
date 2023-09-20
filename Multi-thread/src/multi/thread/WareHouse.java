package multi.thread;

public class WareHouse {

    private Integer goods;

    public WareHouse(Integer goods) {

        this.goods = goods;

    }

    public WareHouse() {

    }

    public synchronized Integer getGoods() {

        while (true) {

            if (this.goods != null) {
                Integer temp = goods;
                goods = null;

                this.notifyAll();
                return temp;

            } else {
                try {
                    this.wait();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }

    }

    public synchronized void setGoods(Integer goods) {

        while (true) {

            if (this.goods == null) {
                this.goods = goods;
                this.notifyAll();// back from waiting state to runnable state
                break;

            } else {
                try {
                    this.wait();
                } catch (InterruptedException e) {

                    e.printStackTrace();
                }
            }
        }
    }

}
