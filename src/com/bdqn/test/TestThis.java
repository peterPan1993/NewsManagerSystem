package com.bdqn.test;

/**
 *  this 的三种用法
 *  @author peter
 */
public class TestThis {

    private int i=0;

    //第一个构造器，有一个Int形参
    public TestThis(){}
    public TestThis(int i){
        this.i=i+1;//此时，this表示引用成员变量i
        System.out.println("Int constructor i-this.i:"+i+"-"+this.i);
        System.out.println("i-1:"+(i-1)+"\tthis.i+1:"+(this.i+1));
        //从两个输出结果充分证明i this.i是不一样的
    }
    //第二个构造器，有一个String形参
    public TestThis(String s){
        System.out.println("String constructor : "+s);
    }
    //第三个构造器，有一个Int和一个String的形参
    public TestThis(int i,String s){
        this(s);//this调用第二个构造器
        //this(i);
        /**
         * 此处不能用，因为其他任何方法都不能调用构造器，只有构造方法能调用。
         * 但必须注意：就算是构造方法调用构造器，也必须位于其第一行，所以构造方法只能调用一个且仅一次构造器！
         */
        this.i=i++;//this引用该类的成员变量
        System.out.println("Int constructor : "+i+"\nString constructor : "+s);
    }

    public TestThis increment(){
        this.i++;
        return this;//返回的是当前对象，该对象属于（TestThis）这个类
    }

    public static void main(String[] args) {
        TestThis tt1 = new TestThis(10);
        TestThis tt2 = new TestThis("OK");
        TestThis tt3 = new TestThis(20,"ok again!");
        System.out.println(tt1.increment().increment().increment().i);
    }
    /**
     * 总结this的三种用法：
     * 1、表示对当前对象的引用；
     * 2、表示用类的成员变量，而非函数参数，注意在函数参数和成员变量同名是进行区分！其实这是第一种用法的特例，比较常用，所以那出来强调一下。
     * 3、用于在构造方法中引用满足指定参数类型的构造器（其实也就是构造方法）。但是这里必须非常注意：只能引用一个构造方法且必须位于开始！
     */
}
