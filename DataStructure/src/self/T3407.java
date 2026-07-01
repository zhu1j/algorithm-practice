package self;

import java.util.Scanner;

public class T3407 {

    static void main() {
        day2();

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] map = new int[n+1];
        for (int i=1;i<=n;i++){
            int ai = scanner.nextInt();
            map[ai] = i;
        }
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        if (Math.abs(map[x]-map[y]) == 1) {
            System.out.println("YES");
            return;// 不返回任何值，只是**结束方法**
        } //if 条件成立 → 执行 return，提前退出，不执行后面的 No

        System.out.println("NO");

    }

    static void day2() {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n+1];
        for (int i=1;i<=n;i++){
            int ai = scanner.nextInt();
            nums[ai] = i;
        }

        int x = scanner.nextInt();
        int y = scanner.nextInt();

        if (Math.abs(nums[x]-nums[y]) == 1) {
            System.out.println("YES");
            return;
        }else {
            System.out.println("NO");
        }
    }
}
