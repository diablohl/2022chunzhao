package com.hl.chunzhao.wangyihulian;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[] dp = new int[s.length()+1];
        for (int i = 2; i <=s.length(); i++) {
            if (Math.abs(s.charAt(i - 1) - s.charAt(i - 2)) <= 1) {
                dp[i] = Math.max(dp[i-1], dp[i - 2] + s.charAt(i - 1) - 'a' + 1 +
                        s.charAt(i - 2) - 'a' + 1);
            } else {
                dp[i] =Math.max(dp[i - 1],dp[i-2]);
            }
        }
        System.out.println(dp[s.length()]);
    }
}
