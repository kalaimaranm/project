package iopackages;

import java.util.List;

public class JoinDemoThread extends Thread {

    @Override
    
    public void run() {

        String threadName = Thread.currentThread().getName();

        List.of(10, 20, 30, 40)
                .stream()
                .forEach(e -> {
                    try {
                        Thread.sleep(2000);
                        System.out.println(threadName + "$" + e);

                    } catch (InterruptedException ee) {

                        ee.printStackTrace();
                    }
                });

    }
}
