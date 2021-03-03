package com.liao.search;

/**
 * <p>
 * 差值查找算法
 * </p>
 *
 * @author LiAo
 * @since 2021/3/3
 */
public class InsertValueSearch {

    public static void main(String[] args) {
        int[] arr = new int[100];

        for (int i = 0; i < 100; i++) {
            arr[i] = i + 1;
        }

        System.out.println(insertValueSearch(arr, 0, arr.length - 1, 55));
    }

    public static int insertValueSearch(int[] arr, int left, int right, int findVal) {

        // 左右下标交叉 查找值大于最大值，小于最大值就返回-1
        if (left > right || findVal < arr[0] || findVal > arr[arr.length - 1]) {
            return -1;
        }

        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);

        int midVal = arr[mid];

        if (findVal > midVal) {
            return insertValueSearch(arr, left, right - 1, findVal);
        } else if (findVal < midVal) {
            return insertValueSearch(arr, left + 1, right, findVal);
        } else {
            return mid;
        }
    }
}
