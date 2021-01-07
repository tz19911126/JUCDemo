package com.yg.edu.pool;

import java.util.Date;
import java.util.concurrent.*;

/**
 * @author ：杨过
 * @date ：Created in 2020/5/30
 * @version: V1.0
 * @slogan: 天下风云出我辈，一入代码岁月催
 * @description:
 **/
public class ThreadPool {

    public static void main(String[] args) {

        /*for (int i=0;i<300;i++){
            new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while(true){
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
            }).start();
        }*/
        //Executors.newCachedThreadPool();

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 5000, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(5), new ThreadPoolExecutor.DiscardOldestPolicy(){
        });

        for (int i=1;i<=10;i++){
            threadPoolExecutor.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("i m task ："+Thread.currentThread().getName()+"，线程数："+threadPoolExecutor.getPoolSize()+"，阻塞队列数量："+threadPoolExecutor.getQueue().size()
                                         +"完成任务的线程数量："+threadPoolExecutor.getCompletedTaskCount());

                }
            },i);
        }
        threadPoolExecutor.shutdown();  //running->shutdown
        try {
            System.out.println("开始时间"+new Date());
            boolean a = threadPoolExecutor.awaitTermination(2000, TimeUnit.MILLISECONDS);
            System.out.println("结束时间"+new Date());
            System.out.println("是否结束："+a);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
