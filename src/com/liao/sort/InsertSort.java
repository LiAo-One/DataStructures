package com.liao.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>
 * 插入排序
 * </p>
 *
 * @author LiAo
 * @since 2021/2/25
 */
public class InsertSort {

    public static void main(String[] args) {

        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 80000);
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // 打印开始时间
        System.out.println("排序前的时间=======>" + simpleDateFormat.format(new Date()));

        // 进行排序
        insertSort(arr);

        // 打印结束时间
        System.out.println("排序后的时间=======>" + simpleDateFormat.format(new Date()));
    }

    /**
     * 插入排序
     *
     * @param arr 需要被排序的值
     */
    public static void insertSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            // 被比较的当前值
            int insertVal = arr[i];
            // 前一个值下标 用于和当前值比较
            int insertIndex = i - 1;

            // 被比较的前一个下标值不小于零 说明下标没有越界 选择排序是从当前值往前比较值
            // 前一个值大于当前值 需要被替换
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                // 把当前值设为前一个值
                arr[insertIndex + 1] = arr[insertIndex];
                // 下标减一 为下一次比较做准备
                insertIndex--;
            }

            // 如果当前下标加一不等于i 就说明进行了替换
            if (insertIndex + 1 != i) {
                // 把前一个值设为 之前保存的当前值 完成替换
                arr[insertIndex + 1] = insertVal;
            }
        }
    }
}
