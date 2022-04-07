package com.hl.chunzhao.xiecheng;

import java.util.*;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String s1 = sc.nextLine();
        int k = s.charAt(2) - '0';
        Set<Character> set = new HashSet<>();
        Deque<Character> deque = new ArrayDeque<>();
        Map<Character, Integer> map = new HashMap<>();
        int begin=0,max=0,tmp=0;
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            if (set.size() < k || (set.size() == k && set.contains(c))) {
                if (set.contains(c)) {
                    map.put(c, i);
                } else {
                    set.add(c);
                    deque.addLast(c);
//                    deque.addLast(c);
                    map.put(c, i);
                }
            } else {

            }
            tmp=i-begin+1;
            max=Math.max(max,tmp);
        }
        System.out.println(max);
    }
}
