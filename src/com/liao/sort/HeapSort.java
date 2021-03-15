package com.liao.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * <p>
 * 堆排序
 * </p>
 *
 * @author LiAo
 * @since 2021/3/11
 */
@SuppressWarnings("all")
public class HeapSort {

    public static void main(String[] args) {
        // 数组升序排列 -> 大顶堆
        // 数组降序排列 -> 小顶堆
        // int[] arr = {4, 6, 8, 5, 9};
        // 第一次调整
       /* adjustHeap(arr, 1, arr.length);
        System.out.println(Arrays.toString(arr));*/

        // 第二次调整
        /*adjustHeap(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));*/

        int[] arr = new int[8000000];

        for (int i = 0; i < 8000000; i++) {
            // 生成一个0~80000的随机数
            arr[i] = (int) (Math.random() * 8000000);
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // 打印开始时间
        System.out.println("排序前的时间=======>" + simpleDateFormat.format(new Date()));

        // 生成大顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }

        int temp;
        // 进行交换 将大元素调整到数组末尾
        for (int i = arr.length - 1; i > 0; i--) {
            temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, i);
        }

        // 打印结束时间
        System.out.println("排序后的时间=======>" + simpleDateFormat.format(new Date()));

        // System.out.println(Arrays.toString(arr));
    }

    /**
     * 将数组调整成堆
     *
     * @param arr 待调整的
     * @param i   非叶子节点在数组中的索引
     * @param len 表示对多少个元素进行调整，len 主键减少
     */
    public static void adjustHeap(int[] arr, int i, int len) {

        //取出当前元素的值
        int temp = arr[i];

        // k = i * 2 + 1 指向的是 i 节点的左子节点
        for (int k = i * 2 + 1; k < len; k = k * 2 + 1) {
            // k 此时为左子节点 k + 1 =右子节点下标(i * 2 + 2)
            if (k + 1 < len && arr[k] < arr[k + 1]) {
                // 此时就让k 指向 右子节点
                k++;
            }

            // 与顶部节点比较
            if (arr[k] > temp) {
                // 如果成立 就把较大的值给顶部节点
                arr[i] = arr[k];
                // 让 i 指向 k
                i = k;
            } else {
                break;
            }
        }

        // 当 for 循环结束后, 就已经将以 i 为父节点树的最大值，放在了最顶部(顶部)

        // 将 temp 值放到调整后的位置
        arr[i] = temp;
    }
}
