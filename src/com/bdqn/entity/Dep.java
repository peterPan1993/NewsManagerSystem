package com.bdqn.entity;

import com.bdqn.utils.Func;

/**
 * 模拟总经理叫手下办事，完后回话
 * @author Administrator
 *
 */
public class Dep implements Func{
	
	/**
	 * 分配一个员工任务
	 * @param e
	 */
	public Dep(Emp e){
		/**
		 * 需要员工做的具体事情
		 */
		e.doSomething(this,"整理公司文件");
	}

	/**
	 * 要求员工干完活回复自己
	 * 利用接口实现
	 */
	@Override
	public void phoneCall(String result) {
		// TODO Auto-generated method stub
		System.out.println("事情"+result);
	}

}
