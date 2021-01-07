package com.yg.edu.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
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
public class Juc02_Thread_ReentrantLock_3 {

    //默认非公平锁

    public   volatile int sum;



    public static void main(String[] args) {
        Juc02_Thread_ReentrantLock_3 j=new Juc02_Thread_ReentrantLock_3();
        new Thread(()->{
            j.sum=1;
        }).start();
        new Thread(()->{
            System.out.println(j.sum);
        }).start();
    }

}
