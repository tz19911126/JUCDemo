package com.yg.edu.PAC;

public class Consumer {
    public Producer producer;

    public Consumer(Producer producer) {
        this.producer = producer;
    }

    public void consume() {
        while (true) {
            Object obj = this.producer.producerQuene.poll();

            if (obj == null) {
                break;
            }
            System.out.println("开始消费：" + obj);

        }
    }
}
