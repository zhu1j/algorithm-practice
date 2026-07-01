package self;

import java.util.HashMap;
import java.util.Scanner;

public class T3408 {

    static void main() {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        HashMap<Integer,Integer> hashMap = new HashMap<>();

        for (int i=0;i<n;i++){
            int num = scanner.nextInt();
            hashMap.put(num,hashMap.getOrDefault(num,0)+1);
        }

        int ans = 0;

        for (int a:hashMap.keySet()) {
            if (hashMap.containsKey(a+1)) {
                int cntA = hashMap.get(a);
                int cntAPlus1 = hashMap.get(a+1);
                //第一种情况 a+1、a+1、a
                if (hashMap.get(a+1)>=2&&hashMap.get(a)>=1){
                   ans  += cntA*cntAPlus1*(cntAPlus1-1)/2;

                }
                //第二种情况 a+1、a、a
                if (hashMap.get(a+1)>=1&&hashMap.get(a)>=1){
                     ans += cntAPlus1*cntA*(cntA-1)/2;
                }
            }

        }
        System.out.println(ans);
    }
}
