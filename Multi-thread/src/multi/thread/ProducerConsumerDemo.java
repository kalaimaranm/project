package multi.thread;

import java.util.Random;

//orphan object
public class ProducerConsumerDemo {

    public static void main(String[] args) {

        WareHouse wareHouse = new WareHouse();

        Producer producer = new Producer(wareHouse);

        Consumer consumer = new Consumer(wareHouse);

//        Producer producer2 = new Producer(wareHouse);
//
//        Consumer consumer2 = new Consumer(wareHouse);
        producer.setName("p1");
        consumer.setName("c1");
//        producer2.setName("p2");
//        consumer2.setName("c2");
        producer.start();
        consumer.start();
//        producer2.start();
//        consumer2.start();

//        Integer rand = 1;
//        for (int i = 0; i < 10; i++) {
//
//            WareHouse wareHouse2 = new WareHouse(rand++);
//            Producer producer2 = new Producer(wareHouse2);
//            Consumer consumer1 = new Consumer(wareHouse2);
//
//            try {
//
//                Thread.sleep(1000);
////                System.out.println("thread sleep");
//            } catch (InterruptedException e) {
//
//                e.printStackTrace();
//            }
//        }
    }

}
