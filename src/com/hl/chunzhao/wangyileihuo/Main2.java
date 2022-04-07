package com.hl.chunzhao.wangyileihuo;

import com.hl.zhousai.Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        int[][] trea={{1, 2, 4, 3},{2, 3, 2, 2},{3, 4, 1, 4}};
        int[] res = getTreasures(6, 10, trea);
        Arrays.sort(res);
        System.out.println();
    }
    public static int[] getTreasures (int packageSize, int wakeTime, int[][] treasureInfo) {
        int n= treasureInfo.length;
        int res=0;
        List<Integer> ans = null;
        l1:for (int i = 1; i < 1<<n; i++) {
            int bao=0,time=0,jiazhi=0;
            List<Integer> tmp = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (((i>>j)&1)==1) {
                    int index = n - 1 - j;
                    tmp.add(treasureInfo[index][0]);
                    if (time == 0) {
                        time = treasureInfo[index][1] * 2 + 1;
                    } else {
                        time += 1;
                    }
                    bao += treasureInfo[index][2];
                    jiazhi += treasureInfo[index][3];
                    if (bao>packageSize||time>wakeTime) continue l1;

                }
            }
            if (jiazhi > res) {
                res=jiazhi;
                ans = new ArrayList<>(tmp);
            }
        }
        int[] aa = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            aa[i] = ans.get(i);
        }
        return aa;
    }
}
