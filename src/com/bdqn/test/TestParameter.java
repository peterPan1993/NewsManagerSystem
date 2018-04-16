package com.bdqn.test;

/**
 * 值传递和引用传递的本质区别在于是否在传递的时候进行对象的内存拷贝。
 * 基本类型是由于在JVM中存储区域不同于普通对象所以传递前会拷贝，传递的是拷贝后的值，但是对象在传递的时候不拷贝，
 * 直接传“引用值”，指向同一片对象堆内存区域，当然要注意String这种特殊情况。
 * 
 * @author Administrator
 * 
 */
public class TestParameter {

	private String str = "str";
	private char[] ch = { 'a', 'b', 'c' };

	private static class MyClass {
		int i = 1;
	}

	private static void change(MyClass myClass) {
		//myClass = new MyClass();
		myClass.i = 2;
	}

	public void change(String str, char[] ch) {
		//ch = new char[]{'a','b','c'};
		str = "change";
		ch[0] = 'c';
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * 值传递是指方法调用时，实际参数把它的值传递给对应方法的形参，如change()方法中i和j，也在内存空间中分配了存储单元，
		 * 这样形参在change()方法中的改变不会影响实际参数的值。
		 */
		MyClass myClass = new MyClass();
		change(myClass);
		System.out.println(myClass.i);
		/**
		 * 引用传递 当我们把str作为参数传入方法后，会新建另一个变量，已经不是原来的变量了，但是他们指向的数据区域都一样，
		 * 所以如果你在方法中改变了str指向的数据区域，即执行str =
		 * "change"，那也只是改变新建的另一个变量所指向的数据区域，即指向一个新对象
		 * "change"，str仍然指向原来的数据区域。所以会输出abc。
		 * 但是对于char数组的例子呢，即对象类型，也就是Object的子类（除了String
		 * ），是把ch的引用传递进来，即引用传递。这样里面和外面的ch都指向了相同的数据区域，执行ch[0] =
		 * 'c'，就会把这个数据区域里的第一个字符改成c
		 * ，并没有改变内部ch的数据地址，所以这个修改也会反映到外部的ch。所以会输出cbc。如果你改变了内部ch所指向的数据区域
		 * ，即把上面代码中注释的那一行打开，即执行ch = new
		 * char[]{'a','b','c'}，这样ch已经指向一个新的数据区域。输出的结果肯定也就是abc了。
		 */
		TestParameter ts = new TestParameter();
		ts.change(ts.str, ts.ch);
		System.err.println(ts.str);
		System.err.println(ts.ch);
	}

}
