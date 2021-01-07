package com.yg.edu.jmm.kuangshen;

public class ThreadJoin implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("线程VIP来了"+i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadJoin threadJoin=new ThreadJoin();
        Thread thread=new Thread(threadJoin);
        thread.start();

        //主线程
        for (int i = 0; i < 500; i++) {
            if(i==200){
                thread.join();
            }
            System.out.println("main"+i);
        }
    }
}
