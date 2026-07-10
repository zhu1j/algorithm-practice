package prefixsum_algorithm;

import java.util.Scanner;

/**
 * 5403. 区间和
 * 简单 算法 前缀和
 * 给定一个整数数组 nums，需要多次计算指定区间的元素之和。
 *
 * 输入格式
 * - 第一行包含两个整数 n 和 q，分别表示数组的长度（1 ≤ n ≤ 10^5）和查询的数量（1 ≤ q ≤ 10^5）。
 * - 第二行包含 n 个整数，表示数组 nums 的元素。nums[i] 代表数组的第 i 个元素，所有元素的取值范围为 -10^4 ≤ nums[i] ≤ 10^4。
 * - 接下来 q 行，每行包含两个整数 l 和 r，表示查询的区间 [l, r]，其中 1 ≤ l ≤ r ≤ n。
 * 输出格式
 * - 对于每个查询，输出一个整数，表示区间 [l, r] 中元素的和。
 *
 */

public class T5403_IntervalSum  {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();

        int[] nums = new int[n + 1];
        int[] prefixSum = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            nums[i] = scanner.nextInt();
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        for (int i = 0; i < q; i++) {  //包前包后
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            System.out.println(prefixSum[r] - prefixSum[l - 1]);
        }

        scanner.close();
    }
}
