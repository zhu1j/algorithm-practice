package string_algorithm;

/**
 * 5409. 反转单词顺序
 * 简单 算法 字符串
 * 给定一个字符串 s，反转字符串中的单词顺序后输出。
 *
 * 输入格式
 * 一个字符串，其中单词由空格分隔。
 *
 * 输出格式
 * 单词顺序反转后的字符串。
 *
 * 学到了：
 * 1.StringBuilder 内部是一块可变字符缓冲区，它本身只是容器，不是字符串。
 *      调用 .toString() 会：
 *      1）读取缓冲区里所有字符；
 *      2）新建一个不可变 String 对象把字符存进去；
 *      3）返回这个 String。
 * 2.append()
 *    1)所属类：StringBuilder / StringBuffer 专属方法，String 没有 append
 *    2)作用：拼接任意类型数据（字符串、数字、布尔、字符等）到缓冲区末尾，不会生成新字符串，性能远优于 + 拼接。
 *    3)返回值：返回自身对象this,支持链式调用。
 *    4)小区别：StringBuilder.append：线程不安全，单线程推荐 ；StringBuffer.append：加了同步锁，多线程安全，速度慢一点
 *3.补充区分
 *    1)append() / reverse()：操作原 StringBuilder 对象，不产生字符串；
 *    2)toString()：唯一一步，把缓冲区内容转为标准 String。
 */
public class T5409_WordReverse {

    static void main() {
        String s = "hi how are you zhu";
        System.out.println(reverseWords(s));
    }
    public static String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder reverseWords = new StringBuilder();
        for (int i = words.length - 1;i>=0;i--) {
            reverseWords.append(words[i]);
            if (i !=0){
                reverseWords.append(" ");
            }
        }
        return reverseWords.toString();
    }
}
