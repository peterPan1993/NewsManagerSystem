package com.bdqn.test;

import org.junit.Test;

public class TestThread {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	    //验证线程生死
		// TODO Auto-generated method stub
        //传入一个接口，直接实例化接口，并实现其方法
		Thread t1 = new Thread(new Runnable(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
                System.out.println(Thread.currentThread().getName()+"+线程正在运行！！！");
				try {
                    System.out.println(Thread.currentThread().getName()+"+线程要睡眠4s！！！");
					Thread.sleep(4000);
					for (int i = 0; i < 1; i++) {
						System.out.println(Thread.currentThread().getName()+"+"+i);
					}
                    System.out.println(Thread.currentThread().getName()+"+线程要睡眠4s！！！");
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
                    System.out.println(Thread.currentThread().getName()+"+线程被中断！！！");
				} finally {
                    System.out.println(Thread.currentThread().getName()+"+Ending ！！！");
                    System.err.println(Thread.currentThread().getName()+"线程是否活着："+Thread.currentThread().isAlive());
				}
			}
		},"线程t1");
		t1.start();
		System.err.println(t1.getName()+"线程是否活着："+t1.isAlive());
		try {
            System.out.println(Thread.currentThread().getName()+"+线程正在睡眠！！！");
			Thread.sleep(14000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(Thread.currentThread().getName()+"+线程被中断！！！");
		}
        System.err.println(t1.getName()+"线程是否活着："+t1.isAlive());
	}

	//线程强制执行与礼让
	@Test
	public void test1(){
		Thread t1 = new MyThread();
		Thread t2 = new MyThread();
		t1.start();
		t2.start();
		for (int i = 0; i < 10; i++) {
			if(i==4){
				try {
					t1.join();//线程强制执行
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (i==8){
				//线程回到就绪状态
			    t1.yield();//线程礼让
            }
			try {
				//线程进入阻塞状态
				Thread.sleep(800);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"+"+i);
		}
	}
}
class MyThread extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		System.out.println(Thread.currentThread().getName()+"+线程正在运行！！！");
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(800);
				System.out.println(Thread.currentThread().getName()+"+线程正在休眠，处于阻塞状态！！！");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println(Thread.currentThread().getName()+"+线程被中断！！！");
			}
			System.out.println(Thread.currentThread().getName()+"+"+i);
		}
	}

	public static void main(String[] args) {
		Thread myThread = new MyThread();
		//Thread t = new Thread("t");传String参数，做该线程名
		System.out.println(Thread.currentThread().getName()+"+线程处于新建状态！！！");
		myThread.start();
		System.out.println(Thread.currentThread().getName()+"+线程处于就绪状态！！！");
	}

}
