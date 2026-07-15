package zhuge_algorithm;

/**
 * 求素数
 *
 * 思想：
 * 1.埃氏筛：批量筛区间所有数字，标记倍数；
 * 2.暴力试除法：单独判断某一个数字，挨个试除。
 */
public class Sushu {
    public static void main(String[] args) {
        System.out.println(bf(100));
    }

    public static int bf(int n) {
        int count = 0;
        for (int i = 2;i < n;i++) {
            count += isPrime(i) ? 1 : 0;
        }
        return count;
    }
    //方法1 : 暴力思想 （原理：大于 1 的整数，若存在 2 到(自身 - 1)之间能整除它的数，就是合数，否则为质数。）
    private static boolean isPrime(int x) {
        for (int i = 2;i*i <= x;i++) {   //大于 1 的整数，若 2 到根号 n 之间有能整除它的数，就是合数，否则是质数。(i<x 优化为遍历一半：i<=根号x (根号x为整数的话，漏掉‘=’会误判为质数))
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    //方法2：埃氏筛 （原理：在 2到n 中，凡是质数的整数倍都属于合数，全部剔除，剩余未剔除数字就是区间内所有质数。）
    public static int eratosthenes(int n) {
        boolean[] isPrime = new boolean[]; //
        int count = 0;
    }
}
