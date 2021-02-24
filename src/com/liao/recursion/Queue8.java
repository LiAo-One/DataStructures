package com.liao.recursion;

/**
 * <p>
 * 八皇后问题
 * </p>
 *
 * @author LiAo
 * @since 2021/2/23
 */
public class Queue8 {

    // 定义一个max表示放置多少个皇后
    int max = 8;
    // 定义数组arr，保存皇后位置放置结果，比如arr={0,4,7,5,2,6,1,3}
    int[] arr = new int[max];
    static int count = 0;
    static int judgeCont = 0;

    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.printf("一共有%d", count);
        System.out.printf("一共回溯%d", judgeCont);
    }

    /**
     * 放置第n个皇后
     *
     * @param n
     */
    public void check(int n) {
        // 验证是否为最后一个
        if (n == max) {
            print();
            // 返回 开始回溯
            return;
        }

        for (int i = 0; i < max; i++) {
            // 设置第n个值
            arr[n] = i;
            // 校验刚刚设置的值是否冲突
            if (judge(n)) {
                // 不存在冲突 就进行下一次
                check(n + 1);
            }
        }
    }

    // 打印皇后摆放的位置
    public void print() {
        count++;
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    /**
     * 校验皇后位置是否合适
     *
     * @param n 第n个皇后
     * @return true：合适 false：不合适
     */
    private boolean judge(int n) {
        judgeCont++;
        for (int i = 0; i < n; i++) {
            // arr[i] == arr[n] 判断是否在同一列
            // Math.abs(n - i) == Math.abs(arr[n] - arr[i]) 判断是否在同一斜线
            if (arr[i] == arr[n] || Math.abs(n - i) == Math.abs(arr[n] - arr[i])) {
                return false;
            }
        }
        return true;
    }
}
