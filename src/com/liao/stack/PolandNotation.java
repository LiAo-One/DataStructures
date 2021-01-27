package com.liao.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * <p>
 * 逆波兰表达式
 * </p>
 *
 * @author LiAo
 * @since 2021/1/27
 */
public class PolandNotation {

    public static void main(String[] args) {
        // 逆波兰表达式
        String suffixExpression = "30 4 + 5 * 6 - ";

        // 获取逆波兰表达式的集合
        List<String> listString = getListString(suffixExpression);

        // 执行计算
        System.out.println(calculate(listString));
    }

    // 将逆波兰表达式转换为List
    public static List<String> getListString(String suffixExpression) {
        // 分割表达式
        String[] s = suffixExpression.split(" ");
        // 数组转换为集合
        return new ArrayList<>(Arrays.asList(s));
    }

    // 对逆波兰表达式进行计算
    public static int calculate(List<String> list) {
        // 创建一个栈
        Stack<String> stack = new Stack<>();
        // 遍历逆波兰表达式集合
        for (String s : list) {
            // 判断是否为多位数
            if (s.matches("\\d+")) {
                // 直接入栈
                stack.push(s);
            } else {
                // 取出顶部数
                String num1 = stack.pop();
                // 取出次顶部数
                String num2 = stack.pop();
                // 执行计算并入栈
                stack.push(col(num1, num2, s) + "");
            }
        }

        // 取出顶部数
        String pop = stack.pop();
        // 返回
        return Integer.parseInt(pop);
    }

    /**
     * 执行计算
     *
     * @param num1 顶部数
     * @param num2 次顶部数
     * @param pop  运算符
     * @return 结果
     */
    public static int col(String num1, String num2, String pop) {
        // 用于存储计算结果
        int res = 0;

        // 判断运算符
        switch (pop) {
            case "+":
                res = Integer.parseInt(num1) + Integer.parseInt(num2);
                break;
            case "-":
                res = Integer.parseInt(num2) - Integer.parseInt(num1);
                break;
            case "*":
                res = Integer.parseInt(num1) * Integer.parseInt(num2);
                break;
            case "/":
                res = Integer.parseInt(num2) * Integer.parseInt(num1);
                break;
            default:
                break;
        }
        return res;
    }
}
