package com.liao.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * <p>
 * 选择排序
 * </p>
 *
 * @author LiAo
 * @since 2021/2/25
 */
@SuppressWarnings("all")
public class SelectSort {

    public static void main(String[] args) {
        int[] ints = new int[80000];

        for (int i = 0; i < 80000; i++) {
            ints[i] = (int) (Math.random() * 80000);
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd : HH:mm:ss");

        // 打印开始时间
        System.out.println("排序前的时间=======>" + simpleDateFormat.format(new Date()));

        selectSort(ints);

        // 打印开始时间
        System.out.println("排序后的时间=======>" + simpleDateFormat.format(new Date()));
    }

    /**
     * 选择排序封装
     *
     * @param ints 要排序的数组
     */
    public static void selectSort(int[] ints) {

        // 最小值下标
        int index;
        // 最小值
        int value;
        // 执行循环
        for (int j = 0; j < ints.length - 1; j++) {
            // 假定最小值下标为当下标
            index = j;
            // 假定最小值为当前值
            value = ints[j];
            for (int i = j + 1; i < ints.length; i++) {
                // 如果当前最小值大于任意一个数 就进行重置
                if (value > ints[i]) {
                    // 重置最小值下标
                    index = i;
                    // 重置最小值
                    value = ints[i];
                }
            }
            // 判断是否需要交换 index如果还等于j 就说明没有没重置
            if (index != j) {
                // 将当前值放到最小值的位置
                ints[index] = ints[j];
                // 将最小值放到当前值的位置
                ints[j] = value;
            }
        }
        System.out.println(Arrays.toString(ints));
    }
}
