package com.hl.chunzhao.baidu;

import java.util.Scanner;
import java.util.StringJoiner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int index=0;
        for (int length = s.length()-1; length >= 0; length--) {
            if (s.charAt(length) == s.charAt(0)) {
                index=length;
                break;
            }
        }
        StringJoiner sj = new StringJoiner(" ");
        sj.add("1");
        sj.add(String.valueOf(index));
        sj.add("2");
        sj.add(String.valueOf(index+1));
        System.out.println(sj);
    }
}
