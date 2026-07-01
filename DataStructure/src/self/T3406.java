package self;

import java.util.HashSet;
import java.util.Scanner;

public class T3406 {

    static void main() {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] nums = new int[n];
        for (int i =0;i<=n-1;i++){
            nums[i] = scanner.nextInt();
        }

        HashSet hashSet = new HashSet<>();
        int count = 0;

        for(int num : nums){
            if (!hashSet.contains(num)){
                hashSet.add(num);
                count++;
            }else {
                break;
            }
        }
        System.out.println(count);

    }

    static void day2() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] nums = new int[n];
        for (int i=0;i<n;i++){
            nums[i] = scanner.nextInt();
        }

        HashSet hashSet = new HashSet();
        int ans = 0;
        for (int num:nums){
            if (!hashSet.contains(num)){
                hashSet.add(num);
                ans++;
            }else {
                break;
            }
        }
        System.out.println(ans);
    }
}
