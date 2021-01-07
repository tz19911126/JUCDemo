package com.yg.edu.PAC;

import java.util.concurrent.ArrayBlockingQueue;

public class Producer {
    public  ArrayBlockingQueue producerQuene;
    public int size;
    public Producer(int size) {
        this.size=size;
        this.producerQuene = new ArrayBlockingQueue(size);
    }

    public void produce(int data){
        try {
            producerQuene.put(data);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Producer p=new Producer(10);
        for (int i = 0; i < 10; i++) {
            try {
                p.producerQuene.put(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("生产完毕");
        System.out.println("消费者准备启动");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Consumer consumer=new Consumer(p);
        consumer.consume();
    }
}
