package com.liao.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>
 * 基数排序
 * </p>
 *
 * @author LiAo
 * @since 2021/3/1
 */
public class RadixSort {

    public static void main(String[] args) {
        int[] ints = new int[8000000];

        for (int i = 0; i < 8000000; i++) {
            ints[i] = (int) (Math.random() * 8000000);
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd : HH:mm:ss");

        // 打印开始时间
        System.out.println("排序前的时间=======>" + simpleDateFormat.format(new Date()));

        radixSort(ints);

        // 打印开始时间
        System.out.println("排序后的时间=======>" + simpleDateFormat.format(new Date()));

        // System.out.println(Arrays.toString(ints));
    }


    public static void radixSort(int[] arr) {

        // 定义一个二维数组 表示10个桶
        int[][] bucket = new int[10][arr.length];

        // 记录每个桶中有效数据个数
        int[] bucketEl = new int[bucket.length];

        // 得到数组最大数字
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // 得到最大值位数
        int maxLen = (max + "").length();

        for (int j = 0, n = 1; j < maxLen; j++, n *= 10) {
            // // 对每个元素的位数进行处理 个位 十位 百位...
            for (int i = 0; i < arr.length; i++) {
                int digit = arr[i] / n % 10;
                // 第digit行 第bucketEl[digit]列
                // bucketEl[digit] 初始为0 每次进行++
                // bucket[digit][?] 初始为0列 每次进行++
                bucket[digit][bucketEl[digit]] = arr[i];
                // 下标位置个数加一
                bucketEl[digit]++;
            }

            // 按照桶的顺序把元素取出放入数组

            int index = 0;
            // 遍历桶计数数组 k 即为桶的下标
            for (int k = 0; k < bucketEl.length; k++) {
                // 如果当前桶不为空 进遍历
                if (bucketEl[k] != 0) {
                    // bucketEl[k] 即为当前桶的有效个数 l即为当前桶列的下标
                    for (int l = 0; l < bucketEl[k]; l++) {
                        // 取出元素放入arr
                        arr[index++] = bucket[k][l];
                    }
                }
                // 置空计数数组 为下次做准备
                bucketEl[k] = 0;
            }
        }
    }
}
