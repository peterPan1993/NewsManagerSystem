package com.bdqn.test;

import org.junit.Test;

public class SellTicket {

    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        Thread t1 = new Thread(ticket,"t1");
        Thread t2 = new Thread(ticket,"t2");
        Thread t3 = new Thread(ticket,"t3");
        t1.start();
        t2.start();
        t3.start();
    }

    /**
     * 多个线程抢票，共同操作一个对象
     */
    @Test
    public void sellTicket(){
        Ticket ticket = new Ticket();
        Thread t1 = new Thread(ticket,"t1");
        Thread t2 = new Thread(ticket,"t2");
        Thread t3 = new Thread(ticket,"t3");
        t1.start();
        t2.start();
        t3.start();
        System.out.println("======   没有显示结果！！  ======");
    }

}
class Ticket implements Runnable {
    private int count = 10;//记录剩余票数
    private int num = 0;//记录当前抢到第几张票
    private boolean flag = false;//记录票是否售完

    @Override
    public void run() {
        //循环 当count=0结束
        while (!flag) {
            sale();
        }
    }
    //同步售票操作方法，包括数据操作与数据返回（输出）
    private synchronized void sale(){
        if (count <= 0) {
            flag = true;
            return;
        }
        //1.修改数据
        count--;
        num++;
        try {
            Thread.sleep(400);//模拟网络延迟
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //2.显示信息
        System.out.println(Thread.currentThread().getName() + "抢到第"+num+"张票，剩余"+count+"张票！");
    }

}
