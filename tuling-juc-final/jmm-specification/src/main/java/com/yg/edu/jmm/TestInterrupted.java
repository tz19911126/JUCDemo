package com.yg.edu.jmm;

public class TestInterrupted {
    public volatile static boolean flag=false;
    public static void main(String[] args) {
        Thread t1=new Thread(()->{
            System.out.println("t1线程");
            System.out.println(Thread.currentThread().isInterrupted());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        Thread.interrupted();

        System.out.println(t1.isInterrupted());
    }
}
