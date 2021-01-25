package com.liao.linkedelist;

/**
 * <p>
 * 约瑟夫问题
 * </p>
 *
 * @author LiAo
 * @since 2021/1/18
 */
public class Josepfu {

    public static void main(String[] args) {

        CircleSingleLinkedList linkedList = new CircleSingleLinkedList();

        // 创建若干个个节点
        linkedList.add(125);

        // 遍历
        linkedList.showBoy();

        // 执行出圈
        System.out.println("执行出圈");

        linkedList.countBoy(1, 7, 42);
    }
}


/**
 * <p>
 * 创建一个单向环形链表
 * rederic/knudsen的Down the Rabbit Hole
 * </p>
 *
 * @author LiAo
 * @since 2021/1/18
 */
class CircleSingleLinkedList {

    // 头部节点
    private Boy first = null;

    // 添加方法
    public void add(int nums) {
        // 辅助节点
        Boy curBy = null;

        // 遍历添加环形单向链表
        for (int i = 1; i <= nums; i++) {
            // 创建节点
            Boy boy = new Boy(i);

            if (i == 1) {
                // 第一个节点 赋值给头部
                first = boy;
                // 指向自己构成环状
                first.setNext(boy);
                // 辅助节点指向新添加的节点
                curBy = first;
            } else {
                // 将尾部指向新节点
                curBy.setNext(boy);
                // 新节点指向头部
                boy.setNext(first);
                // 辅助节点指向新添加的节点
                curBy = boy;
            }
        }
    }

    // 遍历节点
    public void showBoy() {
        // 判断链表是否为空
        if (first == null) {
            System.out.println("链表为空");
            return;
        }

        // 辅助节点
        Boy curBoy = first;

        // 循环遍历
        while (true) {
            // 输出当前节点
            System.out.println("=======>" + curBoy.getNo());

            // 当 当前节点的子节点指向头部节点时 结束循环
            if (curBoy.getNext() == first) {
                return;
            }

            // 节点后移
            curBoy = curBoy.getNext();
        }

    }

    /**
     * 根据用户输入 计算小孩出圈
     *
     * @param startNo  从第几个小孩开始
     * @param countNum 数几下
     * @param nums     圈中有多少个小孩
     */
    public void countBoy(int startNo, int countNum, int nums) {
        // 参数校验
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数有误，请重新输入");
            return;
        }
        // 创建辅助指针
        Boy helper = first;

        // 将辅助指针指向最后一个节点
        while (helper.getNext() != first) {
            // 节点后移
            helper = helper.getNext();
        }

        // 将指针遍历到要报数的小孩位置
        // 当前指针位于第一个 如果从第二个开始数,指针只需移动一次
        // 所以是小孩位置减一
        for (int i = 0; i < startNo - 1; i++) {

            // first 指向子节点
            first = first.getNext();
            // helper 一直在 first 之后一个节点 是个闭环
            // 所以 helper 指向自身子节点 就是之前的first 所以对象存在引用 不会被会回收
            helper = helper.getNext();
        }

        // 小孩报数 当两个指针都指向一个对象的时候 说明只剩一个小孩

        while (helper != first) {
            // 将指针循环到要出圈的小孩位置
            // 报数前 first 和 helper 前移一个 跳过第一个小孩
            // 因为第一个小孩要数一下 指针不动 第二个小孩数的时候实际上指针才会后移
            // 如果数两下 实际上就是移动一次 所以遍历次数 减一
            for (int i = 0; i < countNum - 1; i++) {
                // 每次遍历进行一次移动
                first = first.getNext();
                helper = helper.getNext();
            }

            // 此时first 即为要出圈的小孩 执行打印
            System.out.println("=====>" + first.getNo());
            // 将first 指向子节点
            first = first.getNext();
            // helper子节点指向first
            helper.setNext(first);
        }

        System.out.println("最后的小孩为" + helper.getNo());
    }
}

/**
 * <p>
 * 小朋友类
 * </p>
 *
 * @author LiAo
 * @since 2021/1/18
 */
class Boy {
    // 编号
    public int no;

    // 指向下一个
    public Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
