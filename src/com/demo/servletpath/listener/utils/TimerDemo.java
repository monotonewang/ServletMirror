package com.demo.servletpath.listener.utils;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by WangTest on 2016/12/20.
 */
public class TimerDemo {
    /**
     * 任务调度器
     * @param args
     */
    public static void main (String[] args){
        Timer timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("hello timer");
            }
        },1000,200);
    }
}
