package iopackages;

import java.util.List;

public class JoinDemo extends Thread {

    public static void main(String[] args) {

        String name = Thread.currentThread().getName();
        Thread t = new SupportThread();
        t.start();

        List.of(8, 12, 13, 16, 17, 18)
                .stream()
                .forEach(c -> {
                    try {
                        if (c % 2 == 1 && t.isAlive()) {

                            t.join();
                        }
                        Thread.sleep(2000);
                        System.out.println(name + "$" + c);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });

    }

}
