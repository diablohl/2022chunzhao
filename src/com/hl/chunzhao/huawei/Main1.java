package com.hl.chunzhao.huawei;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    static int[][] dp;
    static boolean[] can;
    static int x,y;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = Integer.parseInt(sc.nextLine());
        int n = Integer.parseInt(sc.nextLine());

        String s = sc.nextLine();
        dp = new int[m][4];
        can = new boolean[m];
        for (int i = 0; i < s.length(); i+=2) {
            if (s.charAt(i) == 'A') {
                dealA();
            } else {
                if(!dealB()){
                    System.out.println("0");
                    System.out.println("0");
                    return;
                }
            }
            if (i==s.length()-1) {
                if (s.charAt(i) == 'A') {
                    System.out.println(x + 1);
                    System.out.println(y + 1);
                } else {
                    System.out.println(x+1);
                    System.out.println(y);
                }

            }
        }
    }

    private static boolean dealB() {
        for (int i = 0; i < dp.length; i++) {
            if (!can[i]) {
                Arrays.fill(dp[i], 1);
                x=i;
                y=1;
                can[i]=true;
                return true;
            }
        }
        return false;
    }

    private static void dealA() {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < 4; j++) {
                if (dp[i][j] == 0) {
                    dp[i][j]=1;
                    can[i] = true;
                    x=i;
                    y = j;
                    return;
                }
            }
        }
    }
}
