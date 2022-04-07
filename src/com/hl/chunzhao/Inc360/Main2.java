package com.hl.chunzhao.Inc360;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    static int[] fa;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] bians = new int[m][3];
        fa = new int[n + 1];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < m; j++) {
                bians[j][i] = scanner.nextInt();
            }
        }
        for (int i = 1; i < 1 + n; i++) {
            fa[i] = i;
        }
        Arrays.sort(bians, (o1, o2) -> o1[2] - o2[2]);
        int index = 1;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            if (index == n) {
                System.out.println(ans);
                return;
            }
            int p = find(bians[i][0]);
            int q = find(bians[i][1]);
            if (p == q) {
                continue;
            } else {
                union(p, q);
                index++;
                ans += bians[i][2];
            }
        }
    }

    public static void union(int i, int j) {
        fa[find(i)] = find(j);
    }

    public static int find(int i) {
        return fa[i] == i ? i : (fa[i] = find(fa[i]));
    }
}


