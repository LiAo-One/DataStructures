package com.liao.sparsearray;

/**
 * <p>
 * 稀疏数组
 * </p>
 *
 * @author LiAo
 * @since 2021/1/14
 */
public class Sparsearray {

    public static void main(String[] args) {
        // 创建一个二维数组棋盘
        // 1 为黑子 2白子 0为没有子
        int[][] chessArr = new int[11][11];
        // 初始化赋值
        chessArr[1][1] = 1;
        chessArr[2][3] = 2;
        chessArr[6][7] = 1;
        chessArr[5][1] = 2;

        System.out.println("原始二维数组：");

        // 输出原始二维数组
        for (int[] ints : chessArr) {
            for (int anInt : ints) {
                System.out.printf("%d\t", anInt);
            }
            System.out.println();
        }

        // 存储有效数据
        int sum = 0;

        // 计算有效数据长度
        for (int[] ints : chessArr) {
            for (int j = 0; j < chessArr.length; j++) {
                if (ints[j] != 0) {
                    sum++;
                }
            }
        }

        // 创建稀疏数组
        int[][] chessArr2 = new int[sum + 1][3];

        // 第一行值
        chessArr2[0][0] = chessArr.length;
        chessArr2[0][1] = chessArr.length;
        chessArr2[0][2] = sum;

        // 计数器
        int count = 0;

        // 二维数组转化为稀疏数组
        for (int k = 0; k < chessArr.length; k++) {
            for (int i = 0; i < chessArr.length; i++) {
                if (chessArr[k][i] != 0) {
                    count++;
                    chessArr2[count][0] = k;
                    chessArr2[count][1] = i;
                    chessArr2[count][2] = chessArr[k][i];
                }
            }
        }

        // 换行
        System.out.println();

        System.out.println("得到稀疏数组：");

        // 输出稀疏数组
        for (int[] ints : chessArr2) {
            System.out.printf("%d\t%d\t%d\t\n", ints[0], ints[1], ints[2]);
        }

        // 换行
        System.out.println();

        System.out.println("稀疏数组转二维数组：");

        // 创建二维数组
        int[][] chessArr3 = new int[chessArr2[0][0]][chessArr2[0][1]];

        // 稀疏数组转二维数组
        for (int i = 0; i < chessArr2[0][2]; i++) {
            chessArr3[chessArr2[i + 1][0]][chessArr2[i + 1][1]] = chessArr2[i + 1][2];
        }

        System.out.println("转化后的二维数组：");

        // 输出二维数组
        for (int[] ints : chessArr3) {
            for (int anInt : ints) {
                System.out.printf("%d\t", anInt);
            }
            System.out.println();
        }
    }
}
