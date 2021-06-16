package com.liao.inherit;

/**
 * <p>
 * 父类测试
 * </p>
 * 
 * @author LiAo
 * @since 2021/4/9
 */
public class Wine {

    public void fun1(){
        System.out.println("Wine 的Fun.....");
        fun2();
    }

    public void fun2(){
        System.out.println("Wine 的Fun2...");
    }
}
