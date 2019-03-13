package com.lhh.singleton.饿汉式;

public class Singleton {
    //最简单,线程安全
    private Singleton(){}

    private static final Singleton singleton=new Singleton();

    public static Singleton getInstance(){
        return singleton;
    }
}
