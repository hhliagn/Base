package com.lhh.singleton.懒汉式;

public class Singleton {

    private Singleton(){}

    //volatile:在创建singleton实例时保证多个线程可见
    private volatile static Singleton singleton;

    //双重检查加锁:只同步一次
    public static Singleton getInstance(){

        if (singleton==null){
            //只会进行一次加锁,就是第一次
            synchronized (Singleton.class){
                //double-check
                if (singleton==null){
                    singleton=new Singleton();
                }
            }
        }

        return singleton;
    }

    //简单版本:缺点:每次调用getInstance都要加锁,浪费性能,而且多线程同时调用可能会发生阻塞
    public synchronized static Singleton getInstance1(){

        if (singleton==null){
            singleton=new Singleton();
        }

        return singleton;
    }
}
