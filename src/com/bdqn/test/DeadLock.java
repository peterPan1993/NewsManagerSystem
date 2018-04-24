package com.bdqn.test;

public class DeadLock {
    public static void main(String[] args) {
        Object bobby = new Object();
        Object duck = new Object();
        Pan p = new Pan();
        Thread t1 = new Thread(new Tang(bobby,duck),"t1");
        Thread t2 = new Thread(new Dou(bobby,duck),"t2");
        t1.start();
        t2.start();
    }
    private static class Pan{

    }
}
class Tang implements Runnable{
    private Object bobby;
    private Object duck;

    public Tang(Object bobby, Object duck) {
        this.bobby = bobby;
        this.duck = duck;
    }

    @Override
    public void run() {
        synchronized (bobby){
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (duck){
                System.out.println("糖糖拿到兜兜給的鸭子！");
            }
            System.out.println("糖糖把芭比給兜兜玩！");
        }
    }
}
class Dou implements Runnable{
    private Object bobby;
    private Object duck;

    public Dou(Object bobby, Object duck) {
        this.bobby = bobby;
        this.duck = duck;
    }

    @Override
    public void run() {
        synchronized (duck){
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (bobby){
                System.out.println("兜兜拿到糖糖給的芭比！");
            }
            System.out.println("兜兜把鸭子給糖糖玩！");
        }
    }
}
