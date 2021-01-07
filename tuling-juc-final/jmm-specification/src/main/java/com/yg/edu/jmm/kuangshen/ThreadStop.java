package com.yg.edu.jmm.kuangshen;


/**
 * 1.建议正常停止
 * 2.利用标志位
 */
public class ThreadStop implements Runnable{

    //设置标志位
    private boolean flag=true;
    @Override
    public void run() {
        int i=0;
        while (flag){
            System.out.println("Thread run"+i);
        }
    }

    public void stop(){
        this.flag=false;
    }

    public static void main(String[] args) {
        ThreadStop threadStop=new ThreadStop();
        new Thread(threadStop).start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("main"+i);
           if(i==900){
               threadStop.stop();
           }
        }
    }
}
