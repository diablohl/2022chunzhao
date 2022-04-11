package com.hl.chunzhao.honor;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if (num%2!=0){
            System.out.println(0);
            return;
        }
        int i1 = (num / 2) % 2 == 0 ? (num / 2) - 1 : (num / 2);
        for (int i = i1; i >=3; i -= 2) {
            if (fun(i) && fun(num - i)) {
                System.out.println(i + " " + (num - i)); // 输出所有可能的素数对
                return;
            }
        }
    }

    private static boolean fun(int num) {
        if (num == 3) return true;
        boolean flag = true;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}

