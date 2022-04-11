package com.hl.chunzhao.honor;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n==1){
            System.out.println(1);
            return;
        }
        int[] dp = new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for (int j = 3; j <=n ; j++) {
            dp[j] = dp[j - 1] + dp[j - 2];
        }
        int res=dp[n];
        for (int i = 1; i < n; i++) {
            res += dp[i] * dp[n + 1 - i];
        }
        System.out.println(res);
    }
}
