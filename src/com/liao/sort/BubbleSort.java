package com.liao.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>
 * 冒泡排序
 * </p>
 *
 * @author LiAo
 * @since 2021/2/24
 */
public class BubbleSort {
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
        bubbleSort(arr);

        // 打印结束时间
        System.out.println("排序后的时间=======>" + simpleDateFormat.format(new Date()));
    }

    /**
     * 封装冒泡排序
     *
     * @param arr 需要被排序的数组
     */
    public static void bubbleSort(int[] arr) {
        // 变量位置互换 中间变量
        int item;
        // 标识是否进行过冒泡
        boolean flag = false;
        // 需要冒泡数组长度减一次
        for (int i = 0; i < arr.length - 1; i++) {
            // 因为使用 arr[i + 1] 所以最后一个下标的数字不用遍历
            for (int j = 0; j < arr.length - 1 - i; j++) {
                // 如果当前下标的值大于下一个下标的值 就进行位置互换
                if (arr[j] > arr[j + 1]) {
                    // 更改状态
                    flag = true;
                    item = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = item;
                }
            }

            if (flag) {
                // 重置flag 进行下一次判断
                flag = false;
            } else { // 说明一次排序都没有发生直接跳出循环 结束排序
                break;
            }
        }
    }
}
