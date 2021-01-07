package com.yg.edu.ThreadDemo;

import java.util.concurrent.TimeUnit;

public class Profiler {
    // 第一次get()方法调用时会进行初始化（如果set方法没有调用），每个线程会调用一次
    private static final ThreadLocal<Long> TIME_THREADLOCAL = new ThreadLocal<Long>() {
        protected Long initialValue() {
            return 1L;
        }
    };
    public static final void begin() {
        TIME_THREADLOCAL.set(10L);
    }
    public static final long end() {
        return TIME_THREADLOCAL.get();
    }
    public static void main(String[] args) throws Exception {
        Profiler.begin();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("get取到的值：" + Profiler.end() );
    }
}
