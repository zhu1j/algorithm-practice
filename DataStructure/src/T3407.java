import java.util.Scanner;

public class T3407 {

    static void main() {
        /**
         * 小美的排列询问
         * 中等
         * 哈希表
         * 题目描述
         * 小美拿到了一个排列。她想知道在这个排列中，x和y是否是相邻的。你能帮帮她吗？
         *
         * 排列是指一个长度为n的数组，其中 1 到 n 每个元素恰好出现一次，任意顺序。
         * 代码中定义的排列，因为java数组天生从索引0开始，所以0索引的那个位置直接忽略，这样就符合排列的定义了。
         * 属于是 浪费空间，图方便，不然还因为硬要符合排列定义，来做代码逻辑处理
         * */

        // 创建Scanner对象，用于读取输入数据
        Scanner scanner = new Scanner(System.in);

        // 读取输入的第一个整数：表示数组的长度n
        int n = scanner.nextInt();

        // 定义一个数组map，作用：记录【每个数字 对应的 下标位置】
        // map[数字] = 该数字在数组中的下标i
        int[] map = new int[n+1];

        // 循环读取n个数字，并存入map数组
        for (int i = 1; i <= n; i++) {
            // 读取当前输入的数字ai
            int ai = scanner.nextInt();
            // 把数字ai对应的下标i存到map中
            // 即：数字 ai 出现在数组的第 i 个位置
            map[ai] = i;
        }

        // 读取需要判断的两个数字 x 和 y
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        // 判断：x 和 y 在数组中的下标是否相邻（差的绝对值为1）
        if(Math.abs(map[x]-map[y])==1){
            // 如果相邻，输出 Yes
            System.out.println("Yes");
            return; // 不返回任何值，只是**结束方法**
        }

        // 如果不相邻，输出 No
        System.out.println("No");
    }
}

/**
 * 我的天这也太不符合写代码的直觉了吧，因为看上去我输入的到了代码里面变成了数组的索引，然后for循环里面的i是从1开始一直到n的，没想到是for循环是从一开始排序号，然后我输入的是数字，其实就相当于for循环是一个发号牌的老师，它手上有0-n号牌，因为java数组是从0开始的，所以0号牌忽略，不发出去，然后我给五个数字，按照顺序循环依次发号码牌，，然后我输入，查找的两个数字，它会循环对比号码牌是不是在一块
 *
 * */