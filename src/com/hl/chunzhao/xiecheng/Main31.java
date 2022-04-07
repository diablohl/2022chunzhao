package com.hl.chunzhao.xiecheng;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main31 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            Integer[] arr = new Integer[5];
            for (int j = 0; j < 5; j++) {
                arr[j] = sc.nextInt();
            }
            Arrays.sort(arr, (o1, o2) -> o2-o1);
            long res=0l;
            while (arr[3] > 0) {
                res += arr[3];
                for (int j = 0; j < 4; j++) {
                    arr[j] -= arr[3];
                }
                Arrays.sort(arr, (o1, o2) -> o2-o1);
            }
            System.out.println(res);
        }
    }
}
