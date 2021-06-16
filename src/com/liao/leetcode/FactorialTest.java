package com.liao.leetcode;

/**
 * <p>
 * 求1！+2！+3！+4！+........+n!的和
 * </p>
 *
 * @author LiAo
 * @since 2021/3/24
 */
public class FactorialTest {
    public static void main(String[] args) {

        /*int sum = 0;
        for (int i = 1; i <= 20; i++) {
            int fac = 1;
            for (int j = 1; j <= i; j++) {
                fac *= j;
            }
            sum += fac;
        }
        // 268040729
        System.out.println(sum);*/

        System.out.println(sum(20));
    }

    // 递归求阶乘
    public static int fac(int n) {
        if (n == 1) {
            return 1;
        }

        // 每次减一相乘
        return n * fac(n - 1);
    }

    // 递归求阶乘和
    public static int sum(int n) {
        if (n == 1) {
            return 1;
        }

        // 每次减一得到递归相加
        return fac(n) + sum(n - 1);
    }
}
