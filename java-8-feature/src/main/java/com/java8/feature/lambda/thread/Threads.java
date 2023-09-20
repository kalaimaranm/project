package com.java8.feature.lambda.thread;

public class Threads {

    public static void main(String[] args) {

        Thread thread = new Thread(() -> System.out.println("inside thread demo-main"));
        thread.start();
        
        
    }

}

class ThreadDemo implements Runnable {

    @Override
    public void run() {
        System.out.println("thread demo running...");
    }

}
