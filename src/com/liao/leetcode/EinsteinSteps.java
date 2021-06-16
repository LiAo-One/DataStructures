package com.liao.leetcode;

/**
 * <p>
 * 爱因斯坦台阶
 * </p>
 *
 * @author LiAo
 * @since 2021/3/24
 */
public class EinsteinSteps {


    public static void main(String[] args) {
        int i = 0;

        while (true) {
            i++;
            if (i % 2 == 1 && i % 3 == 2 && i % 4 == 3 && i % 5 == 4 && i % 6 == 5 && i % 7 == 0){
                System.out.println(i);
                break;
            }
        }
    }
}
