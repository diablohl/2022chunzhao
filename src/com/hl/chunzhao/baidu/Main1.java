package com.hl.chunzhao.baidu;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                for (int l = 0; l < n; l++) {
                    for (int m = 0; m < k; m++) {
                        if (l == n - 1 && m == k - 1) {
                            System.out.print(arr[i][l]);
                        } else {
                            System.out.print(arr[i][l]+" ");
                        }
                    }
                }
                System.out.println();
            }
        }
    }
}
