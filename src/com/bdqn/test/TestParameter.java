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
		 *
		 *
		 形参出现在函数定义中，在整个函数体内都可以使用， 离开该函数则不能使用。
		 实参出现在主调函数中，进入被调函数后，实参变量也不能使用。
		 形参和实参的功能是作数据传送。发生函数调用时， 主调函数把实参的值传送给被调函数的形参从而实现主调函数向被调函数的数据传送。
		 1.形参变量只有在被调用时才分配内存单元，在调用结束时， 即刻释放所分配的内存单元。因此，形参只有在函数内部有效。 函数调用结束返回主调函数后则不能再使用该形参变量。
		 2.实参可以是常量、变量、表达式、函数等， 无论实参是何种类型的量，在进行函数调用时，它们都必须具有确定的值， 以便把这些值传送给形参。 因此应预先用赋值，输入等办法使实参获得确定值。
		 3.实参和形参在数量上，类型上，顺序上应严格一致， 否则会发生“类型不匹配”的错误。
		 4.函数调用中发生的数据传送是单向的。 即只能把实参的值传送给形参，而不能把形参的值反向地传送给实参。 因此在函数调用过程中，形参的值发生改变，而实参中的值不会变化。
		 5.当形参和实参不是指针类型时，在该函数运行时，形参和实参是不同的变量，他们在内存中位于不同的位置，形参将实参的内容复制一份，在该函数运行结束的时候形参被释放，而实参内容不会改变。
		 而如果函数的参数是指针类型变量,在调用该函数的过程中，传给函数的是实参的地址，在函数体内部使用的也是实参的地址，即使用的就是实参本身。所以在函数体内部可以改变实参的值。
		 *
		 */
		TestParameter ts = new TestParameter();
		ts.change(ts.str, ts.ch);
		System.err.println(ts.str);
		System.err.println(ts.ch);
	}

}
