package com.liao.queue;

import java.util.Scanner;

/**
 * <p>
 * 数组实现环形队列
 * </p>
 *
 * @author LiAo
 * @since 2021/1/15
 */
public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        CircleArrayQueue circleArrayQueue = new CircleArrayQueue(3);

        Scanner scanner = new Scanner(System.in);

        char key = ' ';
        boolean loop = true;

        while (loop) {
            System.out.println("s(Show)：显示队列");
            System.out.println("e(Exit)：退出程序");
            System.out.println("a(Add)：添加数据到队列");
            System.out.println("g(Get)：从队列中取出数据");
            System.out.println("h(Head)：从头部取出数据");
            System.out.println("d(Data)：显示有效数据个数");
            key = scanner.next().charAt(0);

            switch (key) {
                case 's':
                    circleArrayQueue.showQueue();
                    break;
                case 'e':
                    loop = false;
                    break;
                case 'a':
                    System.out.println("请输入一个数字");
                    int i = scanner.nextInt();
                    circleArrayQueue.addQueue(i);
                    break;
                case 'g':
                    System.out.println(circleArrayQueue.getQueue());
                    break;
                case 'h':
                    System.out.println(circleArrayQueue.headQueue());
                    break;
                case 'd':
                    System.out.println(circleArrayQueue.size());
                    break;
            }
        }

        System.out.println("程序退出！");
    }
}

class CircleArrayQueue {
    // 表示数组最大容量
    private int maxSize;
    // 表示队头
    private int front;
    // 表示队列尾
    private int rear;
    // 存放数据 模拟队列
    private int[] arr;

    public CircleArrayQueue(int maxSize) {
        maxSize++;
        this.maxSize = maxSize;
        // 队列长度为最大有效数据加一 空留一个位置为约定
        this.arr = new int[maxSize];
    }

    // 判断队列是否已经满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
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
        // 存入数组
        arr[rear] = n;
        // 尾部加一 考虑取模
        rear = (rear + 1) % maxSize;
    }

    // 出队列
    public int getQueue() {
        // 判断队列是否为空
        if (isEmpyt()) {
            System.out.println("队列为空");
        }

        // 获取数据
        int i = arr[front];

        // 头部加一
        front = (front + 1) % maxSize;
        return i;

    }

    // 打印队列
    public void showQueue() {
        if (isEmpyt()) {
            System.out.println("队列为空");
        }

        // 从头部下标位置开始遍历 遍历次数为有效数据个数 加 头部下标
        for (int i = front; i < size() + front; i++) {
            // 取模
            System.out.println(arr[i % maxSize]);
        }
    }

    // 显示头部数据
    public int headQueue() {
        // 判断队列是否为空
        if (isEmpyt()) {
            System.out.println("队列为空");
        }
        return arr[front];
    }

    // 打印有效数据
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }
}
