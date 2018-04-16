package com.bdqn.entity;

public class MyThread extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		//super.run();
		for (int i = 0; i < 10; i++) {
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
