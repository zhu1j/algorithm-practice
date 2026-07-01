package self;

import java.util.Scanner;

public class T3414 {

    static void main() {
        day2();

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String str1 = input.substring(1, input.length() - 1); //该方法包前不包后
        String[] arry1 = str1.split(" ");

        int[] arry2 = new int[arry1.length];

        for (int i=0;i<=arry1.length-1;i++){
            arry2[i] = Integer.parseInt(arry1[i]);
        }

        int target = scanner.nextInt();

        int flag1 = 0;
        boolean flag2 = false;
        int left = 0;
        int right = arry2.length-1;

        while (left < right) {
            int sum = arry2[left] + arry2[right];
            if (sum == target) {
                flag1 = 1;

                break;
            }else if (sum<target){
                left++;
            }else if(sum>target){
                right--;
            }
        }

        if (flag1==1){
            System.out.println(flag1 +" " +left+" "+right);
        }else {
            System.out.println("0 0 0");
        }

    }


    static void day2() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String str1 = input.substring(1,input.length()-1);
        String[] arry1 = str1.split(" ");
        int[] arry2 = new int[arry1.length];

        for (int i=0;i<=arry1.length-1;i++) {
            arry2[i] = Integer.parseInt(arry1[i]);
        }

        int target = scanner.nextInt();

        int flag1 = 0;
        boolean flag2 = false;

        int left = 0;
        int right = arry2.length-1;

        while (left<right){
            int sum = arry2[left] + arry2[right];

            if (sum == target) {
                flag1 = 1;
                break;
            } else if (sum>target) {
                right--;
            } else if (sum<target) {
                left++;
            }
        }

        if (flag1==1){
            System.out.println(flag1+" "+arry2[left]+" "+arry2[right]);
    }else{
            System.out.println(0+" "+0+ " "+0);
        }

    }




}
