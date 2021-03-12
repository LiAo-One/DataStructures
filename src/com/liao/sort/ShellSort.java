package com.liao.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * <p>
 * 希尔排序（改良版插入排序）
 * </p>
 *
 * @author LiAo
 * @since 2021/2/26
 */
@SuppressWarnings("all")
public class ShellSort {

    public static void main(String[] args) {
        int[] arr = new int[80000];

        for (int i = 0; i < 80000; i++) {
            // 生成一个0~80000的随机数
            arr[i] = (int) (Math.random() * 80000);
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // 打印开始时间
        System.out.println("排序前的时间=======>" + simpleDateFormat.format(new Date()));

        // 进行排序
        shellSort2(arr);

        // 打印结束时间
        System.out.println("排序后的时间=======>" + simpleDateFormat.format(new Date()));
    }

    /**
     * 交换法 希尔排序
     *
     * @param arr 数组
     */
    public static void shellSort(int[] arr) {
        // 用于数据交换
        int temp;
        // 希尔排序第一轮排序
        // 第一轮排序 把数组分成了五份
        for (int k = arr.length / 2; k > 0; k /= 2) {
            for (int i = k; i < arr.length; i++) {
                for (int j = i - k; j >= 0; j -= k) {
                    if (arr[j] > arr[j + k]) {
                        temp = arr[j];
                        arr[j] = arr[j + k];
                        arr[j + k] = temp;
                    }
                }
            }
        }
        // System.out.println(Arrays.toString(arr));
    }

    /**
     * 位移法 希尔排序
     *
     * @param arr 数组
     */
    public static void shellSort2(int[] arr) {

        // 设置i值 作为增量
        for (int i = arr.length / 2; i > 0; i /= 2) {
            for (int j = i; j < arr.length; j++) {
                int index = j;
                int temp = arr[index];
                if (arr[index] < arr[index - i]) {
                    while (index - i >= 0 && temp < arr[index - i]) {
                        // 移动
                        arr[index] = arr[index - i];
                        index -= i;
                    }
                    //完成交换
                    arr[index] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
