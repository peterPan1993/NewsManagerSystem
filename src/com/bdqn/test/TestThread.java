package com.bdqn.test;

import org.junit.Test;

import com.bdqn.entity.MyThread;

public class TestThread {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println();
		// TODO Auto-generated method stub
		/*Thread t = new Thread("admin");
		Thread tt = new Thread();
		t.start();
		System.out.println("============================");
		System.out.println(t.getName());
		System.out.println(tt.getName());*/
		//System.out.println(Thread.currentThread().getName());
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("线程a正在运行！");
				try {
					System.out.println("线程a要睡眠5s");
					Thread.sleep(5000);
					
					for (int i = 0; i < 1; i++) {
						System.out.println(Thread.currentThread().getName()+"+"+i);
					}
					System.out.println("线程a又要睡眠5s");
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("线程a被中断！");
				} finally {
					System.out.println("Ending!!!");
				}
			}
			
		});
		t1.start();
		Boolean b = t1.isAlive();
		System.out.println("t1是否活着"+b);
		try {
			Thread.sleep(14000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread t2 = new MyThread();
		t2.start();
		Boolean bb = t1.isAlive();
		System.err.println("t1是否活着"+bb);
		
		
	}
	
	@Test
	public void test1(){
		Thread t1 = new MyThread();
		Thread t2 = new MyThread();
		t1.start();
		t2.start();
		for (int i = 0; i < 10; i++) {
			if(i==5){
				try {
					t1.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				Thread.sleep(800);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"+"+i);
		}
		
	}
	

}
