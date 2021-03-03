package com.liao.search;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 二分查找算法
 * </p>
 *
 * @author LiAo
 * @since 2021/3/2
 */
public class BinarySearch {

    public static void main(String[] args) {

        // 要保证是一个有序数组
        int[] arr = {1, 8, 10, 89, 1000, 1000, 1000, 1000, 1234};

        System.out.println(binarySearch2(arr, 0, arr.length - 1, 1000));
    }

    /**
     * 二分查找 一个有效数
     *
     * @param arr     数组
     * @param left    左边下标
     * @param right   右边下标
     * @param findVal 需要查找的值
     * @return 返回找到的值的下标 没有找到就返回-1
     */
    public static int binarySearch(int[] arr, int left, int right, int findVal) {
        // 判断是否遍历结束 没有找到要找的数字
        if (left > right) {
            return -1;
        }

        // 获取中间下标
        int mid = (left + right) / 2;
        // 获取下标值
        int midVal = arr[mid];

        // 如果大于 就向右递归
        if (findVal > midVal) {
            return binarySearch(arr, left + 1, right, findVal);
        } else if (findVal < midVal) {// 小于 就向左递归
            return binarySearch(arr, left, right - 1, findVal);
        } else {// 等于就直接返回
            return mid;
        }
    }

    /**
     * 二分查找 一个有效数
     *
     * @param arr     数组
     * @param left    左边下标
     * @param right   右边下标
     * @param findVal 需要查找的值
     * @return 返回找到的值的下标 没有找到就返回-1
     */
    public static List<Integer> binarySearch2(int[] arr, int left, int right, int findVal) {
        // 判断是否遍历结束 没有找到要找的数字
        if (left > right) {
            return null;
        }

        // 获取中间下标
        int mid = (left + right) / 2;
        // 获取下标值
        int midVal = arr[mid];

        // 如果大于 就向右递归
        if (findVal > midVal) {
            return binarySearch2(arr, left + 1, right, findVal);
        } else if (findVal < midVal) {// 小于 就向左递归
            return binarySearch2(arr, left, right - 1, findVal);
        } else {
            /**
             * 思路分析
             * 找到mid索引值，不要马上返回
             * 向mid 索引的左边扫描，将所有满足条件的下标 加入集合
             * 向mid 索引的右边扫描，将所有满足条件的下标 加入集合
             * 将list返回
             *
             */
            // 存储有效数据下标
            List<Integer> resIndexList = new ArrayList<>();

            // 开始向左扫描
            int temp = mid - 1;
            while (true) {
                // 索引没有到头 当前值不符合条件
                if (temp < 0 || arr[temp] != findVal) {
                    break;
                }

                // 说明当前下标符合条件
                resIndexList.add(temp);
                // 下标左移
                temp -= 1;
            }

            // 开始向右扫描
            temp = mid + 1;
            while (true) {
                // 索引没有到头 当前值不符合条件
                if (temp > arr.length - 1 || arr[temp] != findVal) {
                    break;
                }
                resIndexList.add(temp);
                // 下标左移
                temp += 1;
            }

            // 说明当前下标符合条件
            resIndexList.add(mid);

            return resIndexList;
        }
    }
}
