package com.hl.chunzhao.wangyihulian;

import java.util.Scanner;
import java.util.StringJoiner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringJoiner sj = new StringJoiner(" ");
        for (int i = 2; i <=n; i+=2) {
            sj.add(String.valueOf(i));
        }
        for (int i = 1; i <=n; i+=2) {
            sj.add(String.valueOf(i));
        }
        System.out.println(sj);
    }
}
