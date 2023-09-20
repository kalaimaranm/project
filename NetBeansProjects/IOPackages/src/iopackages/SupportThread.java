package iopackages;

import java.util.List;

public class SupportThread extends Thread {

    @Override
    public void run() {

        String name = Thread.currentThread().getName();

        List.of(10, 20, 30, 40, 50)
                .stream()
                .forEach(e -> {
                    try {

                        Thread.sleep(2000);
                        System.out.println(name + "$" + e);
                    } catch (InterruptedException ee) {

                        ee.printStackTrace();
                    }
                });
    }
}
