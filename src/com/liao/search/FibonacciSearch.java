package com.liao.search;

import java.util.Arrays;

/**
 * <p>
 * 裴波那契查找法
 * </p>
 *
 * @author LiAo
 * @since 2021/3/4
 */
public class FibonacciSearch {

    public static int maxSize = 20;

    public static void main(String[] args) {

        int[] arr = {1, 8, 10, 89, 1000, 1234};

        System.out.println(fibonacciSearch(arr, 1234));
    }

    /**
     * 获取裴波那契数列
     * 因为 mid = low + F (k - 1) - 1 所以要先获取一个裴波那契数列
     *
     * @return 裴波那契数列
     */
    public static int[] fib() {
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;

        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }

        return f;
    }

    public static int fibonacciSearch(int[] arr, int key) {
        // 开始下标
        int low = 0;
        // 结束下标
        int high = arr.length - 1;
        // 裴波那契分割数值下标
        int k = 0;
        int mid = 0;
        // 获取裴波那契数列
        int[] f = fib();
        // 获取分割数值的下标
        while (high > f[k] - 1) {
            k++;
        }

        // 此时 f[k] - 1 的值大于被查找的数组的长度
        // k 为 大于数组长度的裴波那契数组的值的下标
        // 因为f[k] 的值可能大于 arr 的长度，一次需要构造一个新的的数组并指向arr
        // 不足的部分使用0填充

        // 此时 数组可能为 temp = {1, 8, 10, 89, 1000, 1234, 0, 0, 0};
        int[] temp = Arrays.copyOf(arr, f[k]);
        // 实际使用arr最后的数填充temp
        // 变为 temp = {1, 8, 10, 89, 1000, 1234, 1234, 1234, 1234};
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = arr[high];
        }

        while (low <= high) {
            mid = low + f[k - 1] - 1;
            if (key < temp[mid]) {
                // 此时应该往mid左边查找
                high = mid - 1;
                // 为甚是k--
                // 说明
                // 1.全部元素=前面的元素+后边元素
                // 2.f[k]=f[k-1]+f[k-2]
                // 因为前面有f[k-1]个元素，所以可以继续拆分f[k-1]=f[k-2]+f[k-3]
                // 即在f[k-1]的前面继续查找k--∥即下次循环mid=f[k-1-1]-1
                k--;
            } else if (key > temp[mid]) {
                // 我们应该向数组的右边查找
                low = mid + 1;
                k -= 2;
            } else {
                return Math.min(mid, high);
            }
        }
        return -1;
    }
}
