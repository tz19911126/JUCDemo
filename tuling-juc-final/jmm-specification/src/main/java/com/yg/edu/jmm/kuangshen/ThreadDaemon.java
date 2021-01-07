package com.yg.edu.jmm.kuangshen;

public class ThreadDaemon {
    public static void main(String[] args) {
        God god =new God();
        Thread t1=new Thread(god);
        t1.setDaemon(true);
        t1.start();
        new Thread(new you()).start();
    }

}
class God implements Runnable{
    @Override
    public void run() {
        while (true){
            System.out.println("上帝守护者你");
        }
    }
}
class you implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 35000; i++) {
            System.out.println("你快乐的活着");
        }
        System.out.println("------去天堂了，byebye");
    }
}
