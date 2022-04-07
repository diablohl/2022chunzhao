package com.hl.chunzhao.baidu;

import java.util.Scanner;

public class Main3 {
    public static int MaxValue = 200000000;
    public static int[][] path;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int dan=sc.nextInt();
        int shuang=sc.nextInt();
        int zhan=sc.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < dan; i++) {
            int from=sc.nextInt();
            int to=sc.nextInt();
            int w = sc.nextInt();
            matrix[from - 1][to - 1] = w;
        }
        for (int i = 0; i < shuang; i++) {
            int from=sc.nextInt();
            int to=sc.nextInt();
            int w = sc.nextInt();
            matrix[from - 1][to - 1] = w;
            matrix[to - 1][from - 1] = w;
        }
        int dangmian=sc.nextInt();
        int cungui=sc.nextInt();
        int q=sc.nextInt();
        int[] kuaidi = new int[q];
        for (int i = 0; i < q; i++) {
            kuaidi[i] = sc.nextInt();
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i!=j&&matrix[i][j]==0) matrix[i][j] = MaxValue;
            }
        }
        path = new int[n][n];
        floyd(matrix);
        for (int i = 0; i < q; i++) {
            int destination = kuaidi[i];

        }
    }

    public static void floyd(int[][] matrx) {
        for (int i = 0; i < matrx.length; i++) {
            for (int i1 = 0; i1 < matrx.length; i1++) {
                path[i][i1] = -1;
            }
        }
        for (int i = 0; i < matrx.length; i++) {
            for (int j = 0; j < matrx.length; j++) {
                for (int k = 0; k < matrx.length; k++) {
                    if (matrx[j][i] + matrx[i][k] < matrx[j][k]) {
                        matrx[j][k]=matrx[j][i] + matrx[i][k];
                        path[j][k] = i;
                    }
                }
            }
        }
        for (int i = 0; i < matrx.length; i++) {
            for (int j = 0; j < matrx.length; j++) {
                if (i != j) {
//                    if (matrx[i][j]==MaxValue)
                }
            }
        }
    }
}
