package prefixsum_algorithm;

/**
 * 5404. 子数组最大平均数
 * 中等 算法 前缀和
 * 给定一个包含 n 个整数的数组 nums，找到长度为 k 的子数组，使得该子数组的平均值最大，并输出这个最大平均值。
 * 第一行包含两个整数 n 和 k，分别表示数组的长度（1 ≤ n ≤ 10^5）和子数组的长度（1 ≤ k ≤ n）。
 * 第二行包含 n 个整数，表示数组 nums 的元素。nums[i] 代表数组的第 i 个元素，所有元素的取值范围为 -10^4 ≤ nums[i] ≤ 10^4。
 *
 * 输出格式
 * 输出一个浮点数，表示子数组的最大平均值，保留 5 位小数。
 */
public class T5404_Solution {
    public double findMaxAverage(int[] nums, int k) {
        int windowSum = 0;

        // 计算第一个窗口的和
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }

        int maxSum = windowSum;

        // 滑动窗口
        for (int i = k; i < nums.length; i++) {
            windowSum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum / (double) k;
    }

    public static void main(String[] args) {
        T5404_Solution sol = new T5404_Solution();

        // 示例输入
        int[] nums = {1, 12, -5, -6, 50};
        int n = 5;
        int k = 2;

        // 调用函数并输出结果
        double result = sol.findMaxAverage(nums, k);
        System.out.printf("%.5f", result);
    }
}

