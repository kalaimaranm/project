package multi.thread;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;

//s8 archi, ar arch
public class ThreadDemo {

    //        Demon thread are lower priority threads
    public static void main3(String[] args) {
        try {
            Files.readAllLines(
                    Path.of(URI.create("/home/bas200193/Desktop/textFiles/Download/sample-2mb-text-file.txt")))
                    .stream()
                    .forEach(s -> {
                        try {
                            for (int i = 0; i < s.length(); i++) {
                                Thread.sleep(250);
                                System.out.println(s.charAt(i));
                            }

                        } catch (InterruptedException e) {

                            e.printStackTrace();
                        }
                    });
        } catch (IOException ex) {

        }

    }

    public static void main2(String[] args) {

        System.out.println(Thread.currentThread().getName());
        Thread t = new SampleThread();
        t.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("main " + i);
        }
    }

    public static void main1(String[] args) {

        Thread thread = Thread.currentThread();

        System.out.println(thread.getName());
        System.out.println(thread.getPriority());
        System.out.println(thread.getState());

    }

    private static class SampleThread extends Thread {

        @Override
        public void run() {
            Thread thread = Thread.currentThread();

            System.out.println(thread.getName());

            for (int i = 0; i < 10; i++) {
                System.out.println("thread " + i);
            }
        }

    }

}
