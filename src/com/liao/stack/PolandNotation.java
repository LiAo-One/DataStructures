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
        String suffixExpression = "30 4 + 5 * 6 -";

        // 获取逆波兰表达式的集合
        List<String> listString = getListString(suffixExpression);

        // 执行计算
        System.out.println(calculate(listString));

        // 中缀表达式转List
        List<String> list = toInfixExpressionListy("1+((2+3)*4)-5");
        System.out.println("中缀表达式=====>" + list);
        List<String> list1 = parseSuffixExpreesionList(list);
        System.out.println("逆波兰表达式=====>" + list1);
        // 执行计算
        System.out.println("1+((2+3)*4)-5 = " + calculate(list1));

    }

    // 中缀表达式转List 便于后期操作
    public static List<String> toInfixExpressionListy(String str) {
        List<String> list = new ArrayList<>();
        // 辅助指针 遍历
        int index = 0;
        // 多位数拼接
        StringBuilder s;
        // 每遍历一个数就加入到c
        char c;
        while (index < str.length()) {
            // 判断值是否不为数字
            // ASCII 码底层为数字 大于等于48 小于等于57 数字48~57之间
            if ((c = str.charAt(index)) < 48 || (c = str.charAt(index)) > 57) {
                // 不为数字 添加进集合
                list.add(c + "");
                // 下标加一
                index++;
            } else {
                // 初始化 置空
                s = new StringBuilder();
                // 辅助指针不为最后一个 而且是数字 在48~57之间
                while (index < str.length() && (c = str.charAt(index)) >= 48 && (c = str.charAt(index)) <= 57) {
                    // 拼接加入
                    s.append(c);
                    // 下标加一
                    index++;
                }
                // 放入数组
                list.add(s.toString());
            }
        }
        return list;
    }

    // 中缀表达式List转逆波兰表达式List
    public static List<String> parseSuffixExpreesionList(List<String> strings) {
        // 运算符栈 s1
        Stack<String> s1 = new Stack<>();
        // 中间结果栈
        List<String> s2 = new ArrayList<>();

        // 遍历 中缀表达式集合
        for (String string : strings) {
            // 如果为数字就直接加入集合
            if (string.matches("\\d+")) {
                s2.add(string);
                // 如果为 "(" 压入 s1 栈中
            } else if (string.equals("(")) {
                s1.push(string);
                // 为 ")" 就遍历
            } else if (string.equals(")")) {
                // 如果栈顶不是 "("
                while (!s1.peek().equals("(")) {
                    // 就弹出 加入集合
                    s2.add(s1.pop());
                }
                // 遍历结束 说明此时栈顶为"(" pop弹出 "(" 消除一对括号
                s1.pop();

                // string 为运算符号
            } else {
                // s1不为空 且栈顶优先级大于或等于当前符号
                while (s1.size() != 0 && priority(s1.peek()) >= priority(string)) {
                    // 将栈顶弹出 加入集合
                    s2.add(s1.pop());
                }
                // 循环结束 说明此时 栈为空 或 栈顶符号为数字或"("
                s1.push(string);
            }
        }

        // s1 剩余的元素加入 集合
        while (s1.size() != 0) {
            s2.add(s1.pop());
        }

        return s2;
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

    // 判断优先级
    public static int priority(String oper) {
        if (oper.equals("*") || oper.equals("/")) {
            return 2;
        } else if (oper.equals("+") || oper.equals("-")) {
            return 1;
        } else {
            System.out.println("字符不存在");
            return -2;
        }

    }
}
