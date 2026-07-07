package string_algorithm;

/**
 * 5410. 判断回文串
 * 简单 算法 字符串
 * 给定一个字符串 s，判断字符串是否是回文串。
 *
 * 回文串是指正读和反读都一样的字符串。
 *
 * 输入格式
 * 一个字符串。
 *
 * 输出格式
 * 输出 True；否则输出 False。
 *
 * 学到了： equals()
 *  主要分三种：
 *  1.Object原生equals():不重写 equals 时，a.equals(b) 等价 a == b，只判断是不是同一个对象。
 *   == 规则：
 *      1)基本数据类型（int/char 等）：比较值
 *      2)引用类型（String / 自定义对象）：比较内存地址
 *  2.String 重写了 equals(最常用)：String 重写后不再比地址，而是逐个对比字符内容
 *  3.包装类（Integer/Long等)：全部重写 equals，比较数值，不比较地址。
 *
 *  四.自定义实体类(如 User)默认坑:需要手动重写 equals，按业务字段判断相等(id 相同则视为同一用户)。配合 IDE 一键生成 equals + hashCode。
 *  五.equals 与 hashCode 配套规则（必记）
 *      1)重写 equals，必须重写 hashCode
 *      2)equals 相等的两个对象，hashCode 必须相等
 *      3)hashCode 相等，equals 不一定相等
 *  六、日常开发规范
 *      1)常量放前面，避免空指针："test".equals(str) 而非 str.equals("test")
 *      2)JDK8 + 推荐 Objects.equals (a,b)，内置判 null
 *        例：Objects.equals(null, "abc"); // false，不会NPE
 */
public class T5410_PalindromeChecker {
    static void main() {
        String s = "mainiam";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s){
        String reversed = new StringBuilder(s).reverse().toString();
        return s.equals(reversed);
    }
}
