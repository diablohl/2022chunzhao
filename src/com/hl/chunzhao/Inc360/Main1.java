package com.hl.chunzhao.Inc360;

import javafx.scene.transform.Scale;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main1 {
    static Set<Character> set = new HashSet<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        set.add('A');
        set.add('H');
        set.add('I');
        set.add('M');
        set.add('O');
        set.add('T');
        set.add('U');
        set.add('V');
        set.add('W');
        set.add('X');
        set.add('Y');
        while (sc.hasNext()) {
            String s = sc.nextLine();
            if (!check1(s)){
                System.out.println("NO");
                continue;
            }
            if (check2(s)){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }

    private static boolean check2(String s) {
        int i=0,j=s.length()-1;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }

    private static boolean check1(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
