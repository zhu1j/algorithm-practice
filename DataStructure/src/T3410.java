// 导入需要的工具类
import java.util.HashSet;
import java.util.Arrays;
import java.util.Scanner;

public class T3410 {
    public static void main(String[] args) {
        // 1. 创建扫描器，接收控制台输入
        Scanner scanner = new Scanner(System.in);

        // 2. 读取一整行输入内容
        String input = scanner.nextLine();

        // 3. 按逗号分割输入，分成两部分：[字符串s, 数字k]
        String[] values = input.split(",");

        // 4. 取出第一个部分，去掉首尾的引号（比如输入"abc" → 变成 abc）
        String s = values[0].substring(1, values[0].length() - 1);

        // 5. 把第二个部分转成整数 k
        int k = Integer.parseInt(values[1]);

        // 6. 创建Set，用来存放字符串里【出现过的所有不同字符】（自动去重）
        HashSet<Character> chAppearSet = new HashSet<>();

        // 7. 遍历字符串的每一个字符，存入Set（去重）
        for (char ch : s.toCharArray()) {
            chAppearSet.add(ch);
        }

        // 8. 创建数组，存放去重后的所有字符
        char[] chDelArray = new char[chAppearSet.size()];
        int i = 0;

        // 9. 把Set里的字符转存到数组中（方便后续排序）
        for (char ch : chAppearSet) {
            chDelArray[i++] = ch;
        }

        // 10. 对字符数组排序（从小到大：a < b < c...）
        Arrays.sort(chDelArray);

        // 11. 用来拼接最终结果
        StringBuilder ans = new StringBuilder();

        // 12. 再次遍历原字符串的每个字符
        for (char ch : s.toCharArray()) {
            // 标记当前字符是否是【要删除的前k个最小字符】
            boolean isInChDelArray = false;

            // 13. 判断当前字符 是否等于 排序后【前k个最小字符】里的任意一个
            for (int j = 0; j < k; j++) {
                if (chDelArray[j] == ch) {
                    isInChDelArray = true; // 如果是，标记为要删除
                    break;
                }
            }

            // 14. 如果不是要删除的字符，就保留到结果里
            if (!isInChDelArray) {
                ans.append(ch);
            }
        }

        // 15. 输出最终结果，并用引号包裹
        System.out.println("\"" + ans.toString() + "\"");
    }
}