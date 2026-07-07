package string_algorithm;

/**
 * 5407. 反转字符串
 * 简单 算法 字符串
 * 给定一个字符串 s，将字符串进行反转后输出。
 *
 * 输入格式
 * 一个字符串。
 *
 * 输出格式
 * 反转后的字符串。
 *
 * 学到了：
 * 1.reverse()返回的是原StringBuilder类的对象
 * 2.toString()只做类型转换，打印需要println
 * 3.reverse()源码中，实际实现逻辑的是StringBuilder的父类AbstractStringBuilder类里面的reverse()
 */

public class T5407_ReverseString {

    public static void main(String[] args) {

        String s = "反转字符串";
        System.out.println(ReverseString(s));
    }

    public static String ReverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}
