package com.liao.stack;

/**
 * <p>
 * 使用数组模拟栈 并实现综合计算器
 * </p>
 *
 * @author LiAo
 * @since 2021/1/19
 */
public class Calculator {
    public static void main(String[] args) {
        // 需要运算的表达式
        String expression = "3+2*6-2";
        // 创建数栈
        ArrayStack2 numStack = new ArrayStack2(10);
        // 符号栈
        ArrayStack2 operStack = new ArrayStack2(10);
        // 定义需要的相关变量
        int index = 0;
        // 第一个
        int num1 = 0;
        // 第二个
        int num2 = 0;
        // 运算符
        int oper = 0;
        // 保存结果
        int res = 0;
        // 将每次扫描得到的Char保存到ch中
        char ch = ' ';
        // 使用while 循环扫描expression
        while (true) {
            // 依次得到expression的每一个字符 charAt(0) 获取第一个
            // ch = expression.substring(index, index + 1).charAt(0);
            ch = expression.charAt(index);
            // 判断 ch 是否为运算符
            if (operStack.isOper(ch)) {
                // 符号栈是否不为空 不为空就说明数栈已经至少有两个数字
                if (!operStack.isEmpty()) {
                    // 判断当前运算符与栈顶预算符优先级
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                        // 条件满足 从数栈取出计算
                        // 第一个参数
                        num1 = numStack.pop();
                        // 第二个参数
                        num2 = numStack.pop();
                        // 运算符
                        oper = operStack.pop();
                        // 计算结果计算
                        res = operStack.cal(num1, num2, oper);
                        // 结果入数栈
                        numStack.push(res);
                        // 当前操作符入符号栈
                        operStack.push(ch);
                    } else {
                        // 如果当前的操作符大于栈的中的操作符，就直接入符号栈
                        operStack.push(ch);
                    }
                } else {
                    // 符号栈为空 直接入符号栈
                    operStack.push(ch);
                }
            } else {
                // 为数字 char 底层是ascii 0 的ascii为48 所以要减48
                numStack.push(ch - 48);
            }

            index++;
            // 判断长度
            if (index >= expression.length()) break;
        }

        // 表达式扫描完毕就按顺序从数栈和符号栈pop相应的符号 执行运算

        // 如果符号栈为空，则计算结束
        while (!operStack.isEmpty()) {
            // 第一个参数
            num1 = numStack.pop();
            // 第二个参数
            num2 = numStack.pop();
            // 预算符
            oper = operStack.pop();
            // 计算结果计算
            res = operStack.cal(num1, num2, oper);
            // 结果入数栈
            numStack.push(res);
        }
        // 打印结果
        System.out.println(numStack.peek());
    }
}

// 创建一个栈
class ArrayStack2 {
    // 栈的大小
    private final int maxSize;

    // 栈顶
    public int top;

    // 用数组模拟栈
    private final int[] stack;

    public ArrayStack2(int maxSize) {
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

    // 增加一个方法,可以返回栈顶的值,但不是真正的pop
    public int peek() {
        return stack[top];
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

    // 判断优先级 数字越大 优先级越高
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    // 判断是不是一个运算符
    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    /**
     * 计算方法
     *
     * @param num1 第一个参数
     * @param num2 第二个参数
     * @param oper 运算符
     * @return 运算结果
     */
    public int cal(int num1, int num2, int oper) {
        int res = 0;
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                // 要把后弹出的做减数
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                // 要把后弹出的做除数
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }
}
