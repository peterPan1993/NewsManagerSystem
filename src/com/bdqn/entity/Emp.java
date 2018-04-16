package com.bdqn.entity;

/**
 * 模拟员工完成上头分配任务
 * @author Administrator
 *
 */
public class Emp {

	public void doSomething(Dep d,String task){
		/**
		 * 接收任务安排
		 */
		System.out.println("上头分派任务是"+task);
		System.out.println("正在开始工作....");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("任务完成！");
		String result="做完啦！";
		/**
		 * 按上头方法告诉老大结果
		 */
		d.phoneCall(result);
	}
	
}
