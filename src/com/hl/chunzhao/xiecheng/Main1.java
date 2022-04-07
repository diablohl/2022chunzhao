package com.hl.chunzhao.xiecheng;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int weishu = count((long) n);
        int start = (int) Math.pow(10, weishu);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < weishu+1; i++) {
            sb.append("9");
        }
        Long end = Long.valueOf(sb.toString());
        for (long i = start; i <=end ; i++) {
            if (check(i)&&check1(i,n)) {
                System.out.println(i);
                return;
            }
        }

    }

    private static int count(Long integer) {
        int n1=0;
        while (integer > 0) {
            integer/=10;
            n1++;
        }
        return n1;
    }

    public static boolean check(Long integer) {
        if (count(integer)<=3){
            Long yu=integer%10;
            integer/=10;
            Long tmp=integer-yu*2;
            return tmp%7==0;
        }else {
            Long yu=integer%1000;
            integer/=1000;
            Long tmp = Math.abs(yu - integer);
            return tmp%7==0;
        }
    }
    public static boolean check1(Long a,int b) {
        int[] arr = new int[10];
        while (a > 0) {
            arr[Math.toIntExact(a % 10)]++;
            a/=10;
        }
        while (b > 0) {
            arr[b % 10]--;
            b /=10;
        }
        int res=0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==0) {
                continue;
            }else if (arr[i]==1){
                res++;
            }else {
                return false;
            }
        }
        return res==1;
    }
}
