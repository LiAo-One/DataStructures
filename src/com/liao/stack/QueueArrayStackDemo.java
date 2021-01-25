package com.liao.stack;

import java.util.Stack;

/**
 * <p>
 * 单链表实现栈
 * </p>
 *
 * @author LiAo
 * @since 2021/1/19
 */
public class QueueArrayStackDemo {

    public static void main(String[] args) {

        SingleLinkedList linkedList = new SingleLinkedList(3);

        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode heroNode3 = new HeroNode(3, "吴用", "智多星");
        HeroNode heroNode4 = new HeroNode(4, "公孙胜", "入云龙");

        System.out.println("入栈");
        linkedList.push(heroNode1);
        linkedList.push(heroNode2);
        linkedList.push(heroNode3);
        linkedList.push(heroNode4);
        System.out.println("遍历");
        linkedList.list();
        System.out.println("出栈");
        linkedList.pop();
        linkedList.pop();
        linkedList.pop();
        linkedList.pop();
        System.out.println("遍历");
        linkedList.list();


    }
}


class SingleLinkedList {
    // 头结点
    private final HeroNode head = new HeroNode(0, "", "");

    public SingleLinkedList(int maxSize) {
        this.top = 0;
        this.maxSize = maxSize;
    }

    // 顶部位置
    private int top;
    // 最大
    private int maxSize;

    // 返回头结点
    public HeroNode getHead() {
        return head;
    }

    // 栈满
    public boolean isFull() {
        return top == maxSize;
    }

    // 栈空
    public boolean isEmpty() {
        return top < 0;
    }

    // 添加
    public void push(HeroNode heroNode) {

        if (isFull()) {
            System.out.println("栈满");
            return;
        }

        HeroNode temp = getHead();

        boolean flag = false;

        while (temp.next != null) {
            if (temp.next.no > heroNode.no) {
                break;
            } else if (temp.next.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            System.out.println("数据已存在");
        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;
            top++;
        }
    }

    public void list() {
        if (isEmpty()) {
            System.out.println("栈空");
            return;
        }


        HeroNode temp = getHead().next;

        Stack<HeroNode> stack = new Stack<>();

        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }

        while (stack.size() != 0) {
            System.out.println(stack.pop());
        }
    }

    // 出栈
    public HeroNode pop() {
        if (isEmpty()) {

            System.out.println("栈空");

            return null;
        }

        HeroNode temp = getHead().next;

        while (temp.next != null) {

            temp = temp.next;
        }

        top--;
        return temp.next;
    }
}

/**
 * <p>
 * 模拟单链表
 * </p>
 *
 * @author LiAo
 * @since 2021/1/15
 */
class HeroNode {

    // 好汉编号
    public int no;
    // 姓名
    public String name;
    // 昵称
    public String nickName;
    // 下一个节点
    public HeroNode next;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("HeroNode{");
        sb.append("no=").append(no);
        sb.append(", name='").append(name).append('\'');
        sb.append(", nickName='").append(nickName).append('\'');
        /*sb.append(", next=").append(next);*/
        sb.append('}');
        return sb.toString();
    }
}
