package string_algorithm;

/**
 *5412. 大数加法
 * 中等 算法 字符串
 * 对两个大整数进行加法操作。大数以字符串形式给出。
 *
 * 输入格式
 * 两个大数的字符串。
 *
 * 输出格式
 * 两个大数的和。
 * 学到了：
 *  字符串.charAt(索引)
 *  1.作用：返回字符串中第 i 个位置的单个字符。(弥补了num[i] 索引越界报错的问题)
 */
public class T5412_BigNumberAddition {
    public static String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        while (i >= 0 || j >= 0 || carry != 0) {
            int x = (i >= 0) ? num1.charAt(i) - '0' : 0;
            int y = (j >= 0) ? num2.charAt(j) - '0' : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            result.append(sum % 10);
            i--;
            j--;
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        String num1 = "98765";
        String num2 = "43210";
        System.out.println(addStrings(num1, num2));   //结果：141975
    }
}
