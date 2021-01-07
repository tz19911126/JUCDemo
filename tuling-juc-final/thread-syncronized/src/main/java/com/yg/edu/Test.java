package com.yg.edu;

public class Test {
    public static void main(String[] args) {
            TestResource tr=new TestResource();


    }

}
class TestResource implements Runnable{
    public  void  run(){
        System.out.println("获取资源");
    }
}
