package com.yg.edu.jmm.kuangshen;

public class ThreadTield {
    public static void main(String[] args) {
        MyYield myYield=new MyYield();
        Thread t1=new Thread(myYield,"A");
        Thread t2=new Thread(myYield,"B");
        t1.start();
        t2.start();

    }
}
class MyYield implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"开始执行");
        Thread.yield();
        System.out.println(Thread.currentThread().getName()+"停止执行");
    }
}
