package com.hl.chunzhao.huawei;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main2 {
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    static TreeMap<Integer, Integer> path = new TreeMap<>();
    static int s1,s2,e1, e2;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean[][] stone = new boolean[n][m];
        s1 = sc.nextInt();
        s2 = sc.nextInt();
        e1 = sc.nextInt();
        e2 = sc.nextInt();
        int k = sc.nextInt();
        for (int i = 0; i < k; i++) {
            int j = sc.nextInt();
            int t = sc.nextInt();
            stone[j][t] =true;
        }
        stone[s1][s2]=true;
        dfs(stone,s1,s2,0);
        Map.Entry<Integer, Integer> entry = path.firstEntry();
        System.out.println(entry.getValue() + " " + entry.getKey());
    }

    private static void dfs(boolean[][] can, int s1,int s2,int length) {
        if (s1==e1&&s2==e2) path.put(length, path.getOrDefault(length, 0) + 1);
        for (int[] dir : dirs) {
            int newx=s1+dir[0];
            int newy=s2+dir[1];
            if (newx < 0 || newx >= can.length || newy < 0 || newy >= can[0].length || can[newx][newy]) {

            } else {
                can[newx][newy] = true;
                dfs(can, newx, newy, length + 1);
                can[newx][newy] = false;
            }
        }
    }
}
