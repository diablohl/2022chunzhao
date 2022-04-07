package com.hl.chunzhao;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class TT2 {
    static int[] fa;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        fa = new int[n];
        int m = sc.nextInt();
        int[][] shitu = new int[m][2];
        for (int i = 0; i < m; i++) {
            shitu[i][0] = sc.nextInt()-1;
            shitu[i][1] = sc.nextInt()-1;
        }
        for (int i = 0; i < n; i++) {
            fa[i]=i;
        }
        for (int i = 0; i <m ; i++) {
            if (check(shitu[i][0], shitu[i][1])) {
                union(shitu[i][0],shitu[i][1]);
            }
        }
        int count=0;
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        for (int i = 0; i < n; i++) {
            if (i == find(i)) {
                count++;
            }
            map.put(find(i), map.getOrDefault(find(i), 0) + 1);
        }
        System.out.println(count);
        int k = map.entrySet().size();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            k++;
//            if (k<map.entrySet())
            System.out.print(579 * entry.getValue() / n+" ");
        }

    }

    private static boolean check(int i, int i1) {
        if (fa[i] == fa[i1] || fa[i] == i1 || fa[i1] == i) {
            return false;
        } else {
            return true;
        }
    }

    private static void union(int i, int j) {
        fa[find(i)] = find(j);
    }

    private static int find(int i) {
        return fa[i]==i?i:(fa[i]=find(fa[i]));
    }
}
