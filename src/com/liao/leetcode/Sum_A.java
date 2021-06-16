package com.liao.leetcode;

/**
 * <p>
 * 求 a+aa+aaa+aaaa+a....a 的值
 * </p>
 *
 * @author LiAo
 * @since 2021/3/24
 */
public class Sum_A {

    public static void main(String[] args) {
        getSum(2, 6);
    }

    public static void getSum(int a, int count) {
        int sum = 0;
        int temp = 0;
        for (int i = 0; i < count; i++) {
            temp = temp * 10 + a;
            sum += temp;
        }

        System.out.println(sum);
    }
}
