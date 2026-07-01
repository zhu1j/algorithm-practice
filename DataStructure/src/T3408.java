import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class T3408 {

    static void main() {
        /**
         * 合法的三元组
         * 中等
         * 哈希表
         * 题目描述
         * 给定一个数组，请你计算有多少个三元组<i,j,k>满足0≤i<j<k<n且
         * max(ai,aj,ak) − min(ai,aj,ak) = 1
         * */
        Scanner scanner = new Scanner(System.in);

        // 读取第一个整数 n：表示数组的元素个数
        int n = scanner.nextInt();

        // 创建哈希表 cnt：key 是数组中的数字，value 是该数字出现的次数
        Map<Integer, Integer> cnt = new HashMap<>();

        // 循环读取 n 个数字，并统计每个数字出现的次数
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            // 如果数字 num 已存在，次数+1；不存在则默认 0，再加 1
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        }

        // 最终答案：符合条件的三元组总数
        int ans = 0;

        // 遍历哈希表中所有不同的数字 a
        for (int a : cnt.keySet()) {
            // 只有当 a+1 也在数组中时，才可能组成符合要求的三元组
            if (cnt.containsKey(a + 1)) {
                // 获取数字 a 出现的次数
                int cntA = cnt.get(a);
                // 获取数字 a+1 出现的次数
                int cntAPlus1 = cnt.get(a + 1);

                // 情况 1：选 2 个 a+1 和 1 个 a → 组合成 (a, a+1, a+1)
                // 要求：a 至少 1 个，a+1 至少 2 个
                if (cntA >= 1 && cntAPlus1 >= 2) {
                    // 计算这种组合的数量：C(a+1,2) * a的个数
                    ans += cntA * cntAPlus1 * (cntAPlus1 - 1) / 2;
                }

                // 情况 2：选 1 个 a+1 和 2 个 a → 组合成 (a, a, a+1)
                // 要求：a 至少 2 个，a+1 至少 1 个
                if (cntA >= 2 && cntAPlus1 >= 1) {
                    // 计算这种组合的数量：C(a,2) * a+1的个数
                    ans += cntAPlus1 * cntA * (cntA - 1) / 2;
                }
            }
        }

        // 输出所有符合条件的三元组总数
        System.out.println(ans);
    }

    /** cnt 用来数数，ans 存最终答案
     * cnt：统计每个数字出现次数
     * ans：最后算出来符合条件的总组数（最终答案）
     * */
}
