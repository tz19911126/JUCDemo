package com.yg.edu.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.ReentrantLock;

/**
 *                  ,;,,;
 *                ,;;'(    社
 *      __      ,;;' ' \   会
 *   /'  '\'~~'~' \ /'\.)  主
 * ,;(      )    /  |.     义
 *,;' \    /-.,,(   ) \    码
 *     ) /       ) / )|    农
 *     ||        ||  \)     
 *     (_\       (_\
 * @author ：杨过
 * @date ：Created in 2020/4/28 17:09
 * @version: V1.0
 * @slogan: 天下风云出我辈，一入代码岁月催
 * @description: 
 **/
@Slf4j
public class Juc02_Thread_ReentrantLock_2 {

    //默认非公平锁
    private static ReentrantLock lock = new ReentrantLock(true);
    private static volatile int sum;
    private static CountDownLatch countDownLatch=new CountDownLatch(1);
    public static void reentrantLock() throws InterruptedException {
        String threadName = Thread.currentThread().getName();
        //默认创建的是独占锁，排它锁；同一时刻读或者写只允许一个线程获取锁
        lock.lock();
        log.info("Thread:{},加锁",threadName);
          System.out.println("执行业务逻辑");
        sum++;
        log.info("Thread:{},解锁",threadName);
        lock.unlock();
    }
    public  static void synchronizedLock() throws InterruptedException {
            synchronized (Juc02_Thread_ReentrantLock_2.class) {
                String threadName = Thread.currentThread().getName();
                //默认创建的是独占锁，排它锁；同一时刻读或者写只允许一个线程获取锁
                System.out.println("加锁" + ":线程" + threadName);
                sum++;
                System.out.println("解锁" + ":线程" + threadName);
            }
    }
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            final int temp=i;

            new Thread(()->{
                try {
                    reentrantLock();
                    if(temp==9){
                        countDownLatch.countDown();
                    }
                    /*synchronizedLock();
                    System.out.println(sum);
                    if(sum==10){
                        countDownLatch.countDown();
                    }*/

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },temp+"").start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("Thread:{},当前线程+++"+Thread.currentThread().getName()+"    "+sum);
    }

}
