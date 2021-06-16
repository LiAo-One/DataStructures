package com.liao.jvm;

import java.util.Arrays;

public class HeapTest {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 5, 4};

        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));
    }

    public static int add(String str) {
        return 1;
    }

    public static String add(int str) {
        return "123";
    }
    //局部final变量a,b
   /* public void test(final int b) {
        final int a = 10;
        //匿名内部类
        new Thread(){
            public void run() {
                System.out.println(a);
                System.out.println(b);
            };
        }.start();
    }*/


}

/*class OutClass {
    private int age = 12;

    public void outPrint(final int x) {
        class InClass {
            public void InPrint() {
                System.out.println(x);
                System.out.println(age);
            }
        }
        new InClass().InPrint();
    }
}*/

class test {
    public String str;
}


/**
 * 设要x小时
 * 顺流速度是320÷8=40
 * 所以(40-15-15)x=320
 * 10x=320
 * x=32
 * 所以这只船逆水行这段路程需用32小时
 */