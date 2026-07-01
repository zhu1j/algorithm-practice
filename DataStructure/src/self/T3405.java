package self;

import java.util.HashSet;
import java.util.Scanner;

public class T3405 {

    static void main() {
        day2();

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        HashSet hashSet = new HashSet<>();
        for (int i =0;i<=n-1;i++) {
            hashSet.add(scanner.nextInt());
        }

        int s = scanner.nextInt();
        int ans = 0;
        for (int x=1;x<s;x++) {
            int y = s - x;
            if (!hashSet.contains(x) && !hashSet.contains(y)) {
                ans++;
            }
        }
        System.out.println(ans);
    }

    static void day2() {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        HashSet hashSet = new HashSet<>();
        for (int i=0;i<=n-1;i++) {
            hashSet.add(scanner.nextInt());
        }

        int s = scanner.nextInt();
        int ans = 0;

        for (int x = 1;x < s;x++){
            int y = s-x;
            if (!hashSet.contains(x)&&!hashSet.contains(y)){
                ans++;
            }
        }
        System.out.println(ans);
    }



}
