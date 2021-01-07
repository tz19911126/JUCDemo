package com.yg.edu.schedule;

import org.springframework.util.Assert;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Handler;

public class test {
    public static void main(String[] args) {
//        final String wwz311="3123322";
//        new Thread(()->{
//            System.out.println(weixinpay(wwz311));
//        }).start();
//
//        System.out.println("success");
        doScan(null);
    }
    public static void doScan(String... basePackages) {

        try {
            Assert.notEmpty(basePackages, "At least one base package must be specified");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static Map weixinpay(String wwz311) {
        System.out.println("调用微信下单");
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
        long starttime = System.currentTimeMillis();
        Map map=new HashMap();
        scheduledThreadPoolExecutor.scheduleWithFixedDelay(() -> {
            String temp=frontReg(wwz311);
//            if(temp.equals("success")){
//                scheduledThreadPoolExecutor.shutdown();
//                countDownLatch.countDown();
//            }
            long nowtime = System.currentTimeMillis();
//            System.out.println(starttime);
//            System.out.println(nowtime);
            while ((nowtime - starttime) > 7000) {
                map.put("flag",false);
                countDownLatch.countDown();
                scheduledThreadPoolExecutor.shutdown();
            }
        }, 0, 1, TimeUnit.SECONDS);
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       if(scheduledThreadPoolExecutor.isShutdown()){
           return map;
       }else{
           return null;
       }

    }

    public static String frontReg(String wwz311) {
        System.out.println("调用微信回掉wwz311++"+wwz311);
        return "success";
    }
}
