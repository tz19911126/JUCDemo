package com.yg.edu.queue;

import java.util.concurrent.PriorityBlockingQueue;

public class Person {
    final  int id;

    public Person() {
      this.id=1;
    }

    public static void main(String[] args) {
        Person person=new Person();
        System.out.println(person.id);

    }
    
}
