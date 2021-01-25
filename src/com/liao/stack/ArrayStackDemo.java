package com.liao.stack;

/**
 * <p>
 * 数组模拟栈
 * </p>
 *
 * @author LiAo
 * @since 2021/1/19
 */
public class ArrayStackDemo {

    public static void main(String[] args) {
        // 创建长度为3的栈
        ArrayStack arrayStack = new ArrayStack(3);

        System.out.println("入栈===>");
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        arrayStack.push(4);

        System.out.println("遍历===>");
        arrayStack.list();
        System.out.println("出栈===>");

        arrayStack.pop();
        arrayStack.pop();
        arrayStack.pop();
        arrayStack.pop();
    }
}

class ArrayStack {
    // 栈的大小
    private int maxSize;

    // 栈顶
    public int top;

    // 用数组模拟栈
    private int[] stack;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.top = -1;
        this.stack = new int[maxSize];
    }

    // 判断栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    // 判断栈空
    public boolean isEmpty() {
        return top < 0;
    }

    // 入栈
    public void push(int value) {

        if (isFull()) {
            System.out.println("栈满了");
            return;
        }
        // 栈顶加一
        top++;
        // 添加
        stack[top] = value;
    }

    // 出栈
    public int pop() {
        // 判断是否为空
        if (isEmpty()) {
            System.out.println("栈空了");
            return -1;
        }

        // 取值
        int i = stack[top];

        // 顶部减一
        top--;
        return i;
    }

    // 遍历
    public void list() {
        if (isEmpty()) {
            System.out.println("栈空了");
            return;
        }

        // 从栈顶开始遍历 先入后出的原理
        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }
}
