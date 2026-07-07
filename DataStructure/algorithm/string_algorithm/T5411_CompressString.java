package string_algorithm;

/**
 * 5411. 压缩字符串
 * 简单 算法 字符串
 * 问题描述
 * 给定一个由字符 chars，使用原地算法将其压缩。压缩规则为：相同字符连续出现时，保留该字符并在后面加上出现的次数。输出压缩后字符串的长度。
 *
 * 例如，chars = aabbccc 被压缩为 a2b2c3。
 *
 * 输入格式
 * 一个字符串 chars，表示待压缩的字符数组。
 * 输出格式
 * 一个整数，表示压缩后的字符数组的新长度。
 *
 */
public class T5411_CompressString {
    static void main() {

    }
    public static int compress(char[] chars){
        int anchor = 0,write = 0;
        for (int read = 0; read < chars.length; read++) {
            if (read + 1 == chars.length || chars[read + 1] != chars[read]) {
                chars[write++] = chars[anchor];
                if (read > anchor) {
                    for (char c : ("" + (read - anchor + 1)).toCharArray()) {
                        chars[write++] = c;
                    }
                }
                anchor = read + 1;
            }
        }
        return write;
    }

    public static void main(String[] args){
        char[] chars = {'a','a','b','b','c','c','c'};
        int newLength = compress(chars);
        System.out.println("New length: " + newLength);
        System.out.println("Compressed array: " + new String(chars, 0, newLength));
    }
}
