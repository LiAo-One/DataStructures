package com.liao.recursion;

/**
 * <p>
 * 递归调用机制测试
 * </p>
 *
 * @author LiAo
 * @since 2021/1/27
 */
public class RecursionTest {
    public static void main(String[] args) {
        // 只打印一次 n=>2
        test(4);

        // 输出6
        System.out.println(factorial(3));
    }

    // 打印问题
    public static void test(int n) {
        if (n > 2) {
            test(n - 1);
        } else {
            System.out.println("n=>" + n);
        }
    }

    // 阶乘
    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return factorial(n - 1) * n;
            /**
             * 最后一次递归 返回 1
             * 倒数第二次 返回  1 * 2
             * 倒数第三次返回   2 * 3
             *
             */
        }
    }
}