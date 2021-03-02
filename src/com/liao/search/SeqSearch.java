package com.liao.search;

/**
 * <p>
 * 线性查找
 * </p>
 *
 * @author LiAo
 * @since 2021/3/2
 */
public class SeqSearch {

    public static void main(String[] args) {

        int[] arr = {1, 8, 10, 89, 1000, 1234};
        int index = orderFind(arr, 66);
        if (index == -1) {
            System.out.println("没有查找到 ~");
        } else {
            System.out.println("找到, 下标为 = " + index);
        }
    }

    public static int orderFind(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }
}