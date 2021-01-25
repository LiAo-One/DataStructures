package com.liao.queue;

import java.util.Scanner;

/**
 * <p>
 * 数组模拟队列
 * </p>
 *
 * @author LiAo
 * @since 2021/1/14
 */
public class ArrayQueueDemo {

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);

        Scanner scanner = new Scanner(System.in);

        char key = ' ';
        boolean loop = true;

        while (loop) {
            System.out.println("s(Show)：显示队列");
            System.out.println("e(Exit)：退出程序");
            System.out.println("a(Add)：添加数据到队列");
            System.out.println("g(Get)：从队列中取出数据");
            System.out.println("h(Head)：从头部取出数据");
            key = scanner.next().charAt(0);

            switch (key) {
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'e':
                    loop = false;
                    break;
                case 'a':
                    System.out.println("请输入一个数字");
                    int i = scanner.nextInt();
                    arrayQueue.addQueue(i);
                    break;
                case 'g':
                    System.out.println(arrayQueue.getQueue());
                    break;
                case 'h':
                    System.out.println(arrayQueue.headQueue());
                    break;
            }
        }

        System.out.println("程序退出！");
    }
}

// 使用数组模拟队列 ArrayQueue
class ArrayQueue {
    // 表示数组最大容量
    private final int maxSize;
    // 表示队头
    private int front;
    // 表示队列尾
    private int rear;
    // 存放数据 模拟队列
    private final int[] arr;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.front = -1;
        this.rear = -1;
        this.arr = new int[maxSize];
    }

    // 判断队列是否已经满
    public boolean isFull() {
        return rear + 1 == maxSize;
    }

    // 判断队列是否为空
    public boolean isEmpyt() {
        return rear == front;
    }

    // 添加数据到队列
    public void addQueue(int n) {
        // 判断队列数据是否已经满
        if (isFull()) {
            System.out.println("队列数据已满");
            return;
        }
        // 尾部加一
        rear++;
        // 存入数组
        arr[rear] = n;
    }

    // 出队列
    public int getQueue() {
        // 判断队列是否为空
        if (isEmpyt()) {
            System.out.println("队列为空");
        }
        // 头部加一
        front++;
        return arr[front];
    }

    // 打印队列
    public void showQueue() {
        if (isEmpyt()) {
            System.out.println("队列为空");
        }
        for (int i : arr) {
            System.out.println(i);
        }
    }

    // 显示头部数据
    public int headQueue() {
        // 判断队列是否为空
        if (isEmpyt()) {
            System.out.println("队列为空");
        }
        return arr[front + 1];
    }

}