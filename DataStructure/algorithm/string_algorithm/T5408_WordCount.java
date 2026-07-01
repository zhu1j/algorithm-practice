package string_algorithm;

/**
 * 5408. 字符串中的单词数
 * 简单
 * 算法
 * 字符串
 * 给定一个字符串 s，输出字符串中单词的数量。
 *
 * 输入格式
 * 一个字符串，其中单词由空格分隔。
 *
 * 输出格式
 * 字符串中单词的数量。
 *
 * 学到了：
 *  1.trim():
 *  作用：删除字符串首尾空白(空格、\t、\n、\r),中间空白不动。
 *  返回：新字符串（String 不可变，原字符串不变）
 *  补充（Java11+）：
 *  strip(): 比trim() 更安全，支持全角空格
 *  stripLeading() 只删开头，stripTrailing() 只删结尾
 *
 *  2.split(String regex):
 *  作用:
 *  按指定正则分隔符切割字符串，返回String[]数组。
 *  返回
 *  字符串数组
 *
 */
public class T5408_WordCount {
    static void main() {
        String s = "hi how are you?";
        System.out.println(countWords(s));
    }

    public static int countWords(String s){
        //用正则表达式
        String[] s1 = s.trim().split("\\s+");
        return s1.length;
    }

    /**
     * \\s+ 完整解析
     * 1. \s 含义（正则原符号）
     * \s 是正则内置元字符，不只是普通空格，匹配所有空白类字符：
     *    普通空格
     *    制表符 \t Tab
     *    换行 \n、回车 \r
     *    换页符 \f
     *    等价字符集：[ \t\n\r\f]
     * 2. Java 里为什么要写 \\s，不是 \s
     * Java 字符串中 \ 是转义符，想要表达正则里的 \，必须双写 \\：
     * 正则表达式原生：\s
     * Java 字符串书写："\\s"
     * 3. + 量词作用
     * + = 匹配前面的字符连续出现 1 次或多次
     * \\s+ = 匹配一段连续空白（1 个及以上空格 / Tab / 换行）
     */
}
