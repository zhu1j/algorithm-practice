package prefixsum_algorithm;

import java.util.Scanner;

/**
 * 5405. 二维区域和检索
 * 中等 算法 前缀和
 * 给定一个二维矩阵 matrix，然后给出一个子矩阵的左上角和右下角，请输出给出子矩阵的元素之和。
 *
 * 输入格式
 * 第一行包含两个整数 m 和 n，分别表示矩阵的行数和列数（1 ≤ m, n ≤ 200）。
 * 接下来 m 行，每行包含 n 个整数，表示矩阵 matrix 的元素。matrix[i][j] 代表矩阵中第 i 行第 j 列的元素，所有元素的取值范围为 -10^4 ≤ matrix[i][j] ≤ 10^4。
 * 接下来包含一个整数 q，表示查询的数量（1 ≤ q ≤ 10^4）。
 * 接下来 q 行，每行包含四个整数 r1, c1, r2, c2，表示查询的子矩阵的左上角 （r1, c1） 和右下角 （r2, c2），其中 1 ≤ r1 ≤ r2 ≤ m，1 ≤ c1 ≤ c2 ≤ n。
 * 输出格式
 * 对于每个查询，输出一个整数，表示子矩阵 （r1, c1） 到 （r2, c2） 中元素的和。
 */
public class T5045_matrix {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] matrix = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        int[][] prefixSum = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                prefixSum[i + 1][j + 1] = matrix[i][j] + prefixSum[i][j + 1] + prefixSum[i + 1][j] - prefixSum[i][j];
            }
        }

        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int r1 = sc.nextInt() - 1;
            int c1 = sc.nextInt() - 1;
            int r2 = sc.nextInt() - 1;
            int c2 = sc.nextInt() - 1;
            int result = prefixSum[r2 + 1][c2 + 1] - prefixSum[r1][c2 + 1] - prefixSum[r2 + 1][c1] + prefixSum[r1][c1];
            System.out.println(result);
        }

        sc.close();
    }
}
