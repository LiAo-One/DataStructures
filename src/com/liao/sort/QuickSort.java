package com.liao.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>
 * 快速排序
 * </p>
 *
 * @author LiAo
 * @since 2021/3/1
 */
@SuppressWarnings("all")
public class QuickSort {
    public static void main(String[] args) {
        int[] ints = new int[8000000];

        for (int i = 0; i < 8000000; i++) {
            ints[i] = (int) (Math.random() * 8000000);
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd : HH:mm:ss");

        // 打印开始时间
        System.out.println("排序前的时间=======>" + simpleDateFormat.format(new Date()));

        quickSort(ints, 0, ints.length - 1);

        // 打印开始时间
        System.out.println("排序后的时间=======>" + simpleDateFormat.format(new Date()));

        // System.out.println(Arrays.toString(ints));
    }

    /**
     * 排序
     * @param arr 数组
     * @param left 左边索引
     * @param right 右边索引
     */
    public static void quickSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        // 选择中间值
        int piovt = arr[(left + right) / 2];
        // 用于交换的中甲变量
        int temp;
        while (l < r) {
            //如果左边的数据值小于 中间值
            while (arr[l] < piovt) {
                // 左下标右移进行下一次判断
                l += 1;
            }
            //如果右边的数据值大于 中间值
            while (arr[r] > piovt) {
                // 左下标左移 进行下一次判断
                r -= 1;
            }

            // 左边下标位置大于等于右边下标位置说明越界
            if (l >= r) {
                break;
            }

            // 此时说明 左边数据大于中间值 右边数据小于中间值
            // 需要进行交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            // 交换后的左边下标的值等于中间值 右下标左移 越过重复值
            if (arr[l] == piovt) {
                r -= 1;
            }

            // 交换后的左边下标的值等于中间值 左下标右移 越过重复值
            if (arr[r] == piovt) {
                l += 1;
            }
        }

        // 循环结束 l==r 就各自后移一位 作为递归的条件
        if (l == r) {
            l += 1;
            r -= 1;
        }

        // 向左递归 从左边开始 到当前右边位置
        if (left < r) {
            quickSort(arr, left, r);
        }

        // 向右递归 从右边开始 到当前右边位置
        if (right > l) {
            quickSort(arr, l, right);
        }
    }
}
