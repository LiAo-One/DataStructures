package com.liao.leetcode;

/**
 * <p>
 * 编写程序，输入一个正整数n，求下列算式的值。要求定义和调用函数fact(k)计算k的阶乘，函数返回值的类型是double。
 * 1+1/2+ .... +1/n!
 * 输出保留5位小数。
 * 样例输入
 * 5
 * 样例输出
 * sum=1.71667
 * 税后
 * </p>
 *
 * @author LiAo
 * @since 2021/3/19
 */
public class Factorial {

    public static void main(String[] args) {

        test("aabbcacddeeaffgg", "a");

        test1("AABBccddeeADSADAsadfasdajsd");

        test2("AABBccddeeADSADAsadfasdajsd");

        test3();

        // 取出两个字符串中相同的最长小串
        String s1 = "adafafagafgagfdgsdfgsdfgsdfgsdf";
        String s2 = "fgagfdgsadaf";
        System.out.println("=====>");
        String maxSub = test4(s1, s2);
        System.out.println("比较的结果是：" + maxSub);
    }

    // 删除指定字符
    public static void test(String str, String ch) {

        // 删除所有指定字符串
        // 参数说明 把匹配到的第一个字符串替换为第二个
        String replace = str.replace(ch, "");

        System.out.println(replace);
    }

    // 根据正则表达式删除
    public static void test1(String str) {

        // 删除所有指定字符串
        String replace = str.replaceAll("([a-z])", "");

        System.out.println(replace);
    }

    // 删除出现的第一个指定字符串
    public static void test2(String str) {

        // 删除所有指定字符串
        String replace = str.replaceFirst("A", "");

        System.out.println(replace);
    }


    // 删除出现的第一个指定字符串
    public static void test3() {

        StringBuilder strOrig = new StringBuilder("Hello world ,Hello Nowcoder");
        int lastIndex = strOrig.lastIndexOf("Nowcoder");

        System.out.println("Nowcoder 字符串最后出现的位置： " + lastIndex);

        System.out.println(strOrig.delete(lastIndex, lastIndex + 8).toString());

    }

    // 两个字符串中相同的最长的字符串。
    public static String test4(String string1, String string2) {

        // 存储长度较长的
        String longStr;
        // 存储长度较短的
        String shortStr;

        // 获取长度最长的字符串
        longStr = string1.length() > string2.length() ? string1 : string2;

        // 获取另一个字符串
        shortStr = string1.equals(longStr) ? string2 : string1;

        for (int i = 0; i < shortStr.length(); i++) {
            for (int j = 0, z = shortStr.length() - i; z < shortStr.length(); j++, z++) {

                String temp = shortStr.substring(j, z);

                if (longStr.contains(temp)) {
                    return temp;
                }
            }
        }

        return null;
    }


}
