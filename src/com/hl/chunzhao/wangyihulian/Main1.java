package com.hl.chunzhao.wangyihulian;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        if (x <= y) {
            int n = (int) Math.ceil(Math.max(a, b) * 1.0 / y);
            System.out.println(n);
        } else {
            int res=0;
            while (a > 0 || b > 0) {
                if (a==0||b==0){
                    res += (a == 0 ? (int) Math.ceil(b * 1.0 / x) : (int) Math.ceil(a * 1.0 / x));
                    System.out.println(res);
                    return;
                }
                if (a <= y || b <= y) {
                    res++;
                    a =Math.max(0,a-y);
                    b =Math.max(0,b-y);
                } else {
                    if (a >= b) {
                        a = Math.max(0, a - x);
                        res++;
                    } else {
                        b = Math.max(0, b - x);
                        res++;
                    }
                }
            }
        }
    }
}
