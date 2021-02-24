package com.liao.recursion;

/**
 * <p>
 * 使用递归解决迷宫问题
 * </p>
 *
 * @author LiAo
 * @since 2021/1/30
 */
public class Maze {

    public static void main(String[] args) {
        // 使用二维数组模拟地图
        int[][] map = new int[8][7];

        // 使用1 表示墙 设置围墙
        // 上下设置为1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }

        // 左右设置为1
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }

        // 设置挡板
        map[3][1] = 1;
        map[3][2] = 1;
        map[2][2] = 1;

        // 打印地图
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        // 执行小球找路
        // setWay(map, 1, 1);
        setWay2(map, 1, 1);

        System.out.println("执行找路之后输出新的地图");

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    // 约定
    /*
     * map 表示地图
     * i,j 表示出发的位置
     * map[6][5] 表示终点
     * 当map[i][j]为0表示该点没有走过 当为1时表示墙 2表示可以走 3表示路已经走过但走不通
     * 走迷宫的策略（方法）下->右->上->左，如果该点走不通 再回溯
     */

    /**
     * 策略一 下->右->上->左
     *
     * @param map 地图
     * @param i,j 起始位置
     * @return true：找到了 false：没有找到
     */
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            // 表示已经到终点
            return true;
        } else {
            // 如果当前这个点还没走过
            if (map[i][j] == 0) {
                // 将当前点设为可以走通
                map[i][j] = 2;
                // 按照策略 下->右->上->左
                if (setWay(map, i + 1, j)) { // 向下走
                    return true;
                } else if (setWay(map, i, j + 1)) { // 向右走
                    return true;
                } else if (setWay(map, i - 1, j)) { // 向上走
                    return true;
                } else if (setWay(map, i, j - 1)) { // 向左走
                    return true;
                } else { // 说明该点走不通
                    // 设置该点走不通
                    map[i][j] = 3;
                    return false;
                }
            } else { //如果map[i][j] != 0 ,可能是 1 2 3
                return false;
            }
        }
    }

    /**
     * 策略二 上->右->下->左
     *
     * @param map 地图
     * @param i,j 起始位置
     * @return true：找到了 false：没有找到
     */
    public static boolean setWay2(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            // 表示已经到终点
            return true;
        } else {
            // 如果当前这个点还没走过
            if (map[i][j] == 0) {
                // 将当前点设为可以走通
                map[i][j] = 2;
                // 改成策略 上->右->下->左
                if (setWay2(map, i - 1, j)) { // 向上走
                    return true;
                } else if (setWay2(map, i, j + 1)) { // 向右走
                    return true;
                } else if (setWay2(map, i + 1, j)) { // 向下走
                    return true;
                } else if (setWay2(map, i, j - 1)) { // 向左走
                    return true;
                } else { // 说明该点走不通
                    // 设置该点走不通
                    map[i][j] = 3;
                    return false;
                }
            } else { //如果map[i][j] != 0 ,可能是 1 2 3
                return false;
            }
        }
    }
}
