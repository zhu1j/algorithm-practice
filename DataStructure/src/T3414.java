import java.util.*;

/**
 * 找出升序数组中和为给定值的两个数字
 * 简单
 * 双指针
 * 题目描述
 * 输入一个已经按升序排序过的数组和一个数字，在数组中查找两个数，使得它们的和正好是输入的那个数字。
 *
 * 如果有多对数字的和等于输入的数字，输出找到的第一对即可。
 * */
public class T3414 {
    public static void main(String[] args) {
        // 创建键盘录入对象
        Scanner scanner = new Scanner(System.in);
        // 读取整行输入字符串
        String input = scanner.nextLine();
        // 截取字符串：去掉第一个字符和最后一个字符（去除首尾括号）
        input = input.substring(1, input.length() - 1); //保留方法，两个参数分别为保留段的首尾字符对应的索引
        // 以空格分割字符串，得到字符串数组
        String[] inputArr = input.split(" ");
        // 定义整型数组，长度和分割后的数组一致
        int[] nums = new int[inputArr.length];
        // 遍历字符串数组，转为整数存入int数组
        for (int i = 0; i < inputArr.length; i++) {
            nums[i] = Integer.parseInt(inputArr[i]);
        }
        // 录入目标求和值
        int target = scanner.nextInt();

        // 左指针初始在最左端
        int left = 0;
        // 右指针初始在最右端
        int right = nums.length - 1;
        // 标记是否找到符合条件的两个数
        boolean findFlag = false;

        // 双指针相向遍历
        while (left < right) {
            // 计算左右指针元素之和
            int sum = nums[left] + nums[right];
            // 和等于目标值，找到结果
            if (sum == target) {
                findFlag = true;
                break;
            } else if (sum > target) {
                // 和偏大，右指针左移减小和
                right--;
            } else {
                // 和偏小，左指针右移增大和
                left++;
            }
        }

        // 找到输出1加两个数，没找到输出0 0 0
        if (findFlag) {
            System.out.println("1 " + nums[left] + " " + nums[right]);
        } else {
            System.out.println("0 0 0");
        }
    }
}