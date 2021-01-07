package com.yg.edu;

import java.util.ArrayList;
import java.util.List;

public class failfastdemo {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        for (int i = 0; i < list.size(); i++) {
            if(i==2){
                list.remove(i);
            }
        }
    }
}
