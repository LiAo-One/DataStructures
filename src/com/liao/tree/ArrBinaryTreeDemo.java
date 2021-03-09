package com.liao.tree;

/**
 * <p>
 * 数组二叉树顺序存储
 * </p>
 *
 * @author LiAo
 * @since 2021/3/9
 */
public class ArrBinaryTreeDemo {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};

        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);

        // 执行遍历
        arrBinaryTree.perOrder();
    }

}

//
class ArrBinaryTree {

    // 顺序存储二叉树遍历
    private int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }


    // 重写方法
    public void perOrder() {
        this.perOrder(0);
    }

    // 前序遍历
    public void perOrder(int index) {

        if (arr == null || arr.length <= 0) {
            return;
        }

        // 输出当前递归到的数据
        System.out.println(arr[index]);

        // 向左递归 (index * 2 + 1) 左子节点下标位置
        if ((index * 2 + 1) < arr.length) {
            perOrder((index * 2 + 1));
        }

        // 向右递归 (index * 2 + 2) 右子节点下标位置
        if ((index * 2 + 2) < arr.length) {
            perOrder((index * 2 + 2));
        }


    }
}
