package com.liao.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * <p>
 * 归并排序
 * </p>
 *
 * @author LiAo
 * @since 2021/3/1
 */
@SuppressWarnings("all")
public class MergeSort {
    public static void main(String[] args) {

        int[] arr = new int[80000];

        int[] temp = new int[arr.length];

        for (int i = 0; i < 80000; i++) {
            // 生成一个0~80000的随机数
            arr[i] = (int) (Math.random() * 80000);
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // 打印开始时间
        System.out.println("排序前的时间=======>" + simpleDateFormat.format(new Date()));

        // 进行排序
        mergeSort(arr, 0, arr.length - 1, temp);

        // 打印结束时间
        System.out.println("排序后的时间=======>" + simpleDateFormat.format(new Date()));

        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            // 中间的索引
            int mid = (left + right) / 2;
            // 向左递归分解
            mergeSort(arr, left, mid, temp);

            // 向右递归分解
            mergeSort(arr, mid + 1, right, temp);

            // 执行合并
            merge(arr, left, mid, right, temp);
        }
    }


    /**
     * 合并方法
     *
     * @param arr   原始数组
     * @param left  左边有序序列初始索引
     * @param mid   中间索引
     * @param right 右边索引
     * @param temp  临时数组
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        // 左边有序序列的初始索引
        int i = left;
        // 右边有序序列的初始索引
        int j = mid + 1;
        // 用于确定临时数组下标位置
        int t = 0;
        //先把左右两边的数据按照规则填充的temp数组中
        //直到左右两边的有序序列有一边处理完毕为止

        while (i <= mid && j <= right) {
            // 如果左边的小于 就直接放入当前临时数组索引中 临时数组索引 左边索引加一 反之亦然
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t += 1;
                i += 1;
            } else {
                temp[t] = arr[j];
                t += 1;
                j += 1;
            }
        }
        // 把有剩余数据的一边的数据依次填充到temp
        // 说明左边有剩余
        while (i <= mid) {
            temp[t] = arr[i];
            t += 1;
            i += 1;
        }
        // 说明右边边有剩余
        while (j <= right) {
            temp[t] = arr[j];
            t += 1;
            j += 1;
        }

        // 将temp数组拷贝到arr
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t += 1;
            tempLeft += 1;
        }
    }
}

