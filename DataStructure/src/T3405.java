import java.util.HashSet;
import java.util.Scanner;

public class T3405 {
    /**
     * 禁着点的方案数
     * 中等
     * 哈希集合
     * 小红拿到了一个数组， 她将这个数组的元素定义为“禁着点”。小红希望你找到一对正整数x和y，满足x+y=s且x和y都不是“禁着点”。你能告诉小红有多少种方案吗?
     * */
    public static void main(String[] args) {
        // 创建Scanner对象，用于接收控制台输入
        Scanner scanner = new Scanner(System.in);

        // 读取第一个整数n，表示接下来要输入n个禁止使用的数字
        int n = scanner.nextInt();

        // 创建HashSet集合，用来存储【禁止使用的数字】，方便快速查找
        HashSet<Integer> hashSet = new HashSet<>();

        // 循环n次，把n个禁止数字存入集合
        for (int i = 0; i < n; i++) {
            hashSet.add(scanner.nextInt());
        }

        // 读取目标和s，我们要找两个数相加等于s
        int s = scanner.nextInt();

        // 记录符合条件的【数对(x,y)数量】，初始为0
        int ans = 0;

        // 遍历x从1到s-1，寻找满足 x + y = s 的数对
        for (int x = 1; x < s; x++) {
            // 由x + y = s，推出 y = s - x
            int y = s - x;

            // 判断条件：x 和 y 都【不在禁止集合】中
            if (!hashSet.contains(x) && !hashSet.contains(y)) {
                // 符合条件，答案+1
                ans++;
            }
        }

        // 输出最终符合条件的数对总数
        System.out.println(ans);
    }
}






/**
 * 我发现一个挺神奇的，就是hashset这个方法for循环添加的时候，如果添加的是输入的的话，可以一次一次输入，也可以一次输入多个用空格作为分隔符，程序会自动识别
 * */