package com.yg.edu.map;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ：图灵-杨过
 * @date：2019/7/17
 * @version: V1.0
 * @slogan: 天下风云出我辈，一入代码岁月催
 * @description :HashMap存在数据丢失示例
 */
public class HashMapDataLost {
    public static final Map<String, String> map = new HashMap<String, String>();
    public static final Map<String, String>  cmap= new ConcurrentHashMap<>();
    public static Object obj=new Object();
    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 2000; i++) {
            final String temp=i+"";
            new Thread() {
                public void run() {


                        map.put(temp, temp);

                }
            }.start();
        }


//        new Thread() {
//            public void run() {
//
//                for (int i = 0; i < 1000; i++) {
//                    //线程一
//                    //synchronized (obj){
//                        map.put(String.valueOf(i), String.valueOf(i));
//                    //}
//
//                }
//            }
//        }.start();
//        //线程二
//        new Thread(){
//            public void run() {
//                for(int j=1000;j<2000;j++){
//                    //synchronized (obj) {
//                        map.put(String.valueOf(j), String.valueOf(j));
//                    //}
//                }
//            }
//        }.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("map.size"+map.size());
        //输出
        for(int i=0;i<2000;i++){
            System.out.println("第："+i+"元素，值："+map.get(String.valueOf(i)));
        }

    }
}
