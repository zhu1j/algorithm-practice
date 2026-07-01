import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class T3406 {

    /**
     * 切糖果
     * 中等
     * 哈希集合
     * 题目描述
     * 小美想要买糖果店的一根长长的糖果，糖果店顾客可以从中选取一个位置然后老板会在那切断，
     * 糖果前端到那个切断位置的糖果就会出售给这位顾客。这个糖果其实不同段有着不同的口味，
     * 小美希望她选出来的糖果中各个段有着不同的口味，在这基础上希望能选出尽可能长的糖果。小美想知道她能买到最长多长的糖果，请你帮帮她。
     * */
    static void main() {
        // 创建 Scanner 对象，用于接收控制台输入
        Scanner scanner = new Scanner(System.in);

        // 读取第一个整数，表示数组的长度 n
        int n = scanner.nextInt();

        // 创建一个长度为 n 的 int 类型数组，用来存储后续输入的数字
        int[] nums = new int[n];

        // 循环 n 次，依次读取 n 个数字存入数组 nums
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        // 创建一个 HashSet 集合，用于存储已经出现过的数字（自动去重）
        Set<Integer> hashSet = new HashSet<>();

        // 定义计数器，记录**连续不重复**的数字个数
        int count = 0;

        // 增强 for 循环，遍历数组中的每一个数字
        for (int num : nums) {
            // 判断当前数字是否不在集合中（即第一次出现）
            if (!hashSet.contains(num)) {
                // 把当前数字加入集合
                hashSet.add(num);
                // 不重复数字个数 +1
                count++;
            } else {
                // 如果当前数字已经在集合里（重复了），直接结束循环
                break;
            }
        }

        // 输出最终统计的连续不重复数字的个数
        System.out.println(count);
    }
}
