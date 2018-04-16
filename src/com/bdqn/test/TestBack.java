package com.bdqn.test;

import com.bdqn.entity.Dep;
import com.bdqn.entity.Emp;

/**
 * 利用Emp和Dep类，测试回调函数
 * @author Administrator
 *
 */
public class TestBack {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//給老板安排员工，触发事件
		new Dep(new Emp());
	}

}
