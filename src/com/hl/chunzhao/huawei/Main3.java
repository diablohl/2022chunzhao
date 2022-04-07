package com.hl.chunzhao.huawei;

import	java.util.*;

//[1,2,3,1,null,2,null,null,null,null,null,1,null,null,null]
public class Main3 {
    static int[] ints = new int[1000000];
    static int anInt;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String split[] = s.split(",");
        int cnt = 0;
        Arrays.fill(ints,-1);
        for (String s1 : split) {
            int dd = -1, len = s1.length();
            for (int i = 0; i < len; i++) {
                if (Character.isDigit(s1.charAt(i))) {
                    dd = dd==-1?0:dd;
                    dd = dd * 10 + s1.charAt(i) - '0';
                }
            }
            ints[++cnt] = dd;
        }
        int tr = -1, res = 0;
        for (int i = 1; i <= cnt; i++) { //遍历i为根结点的树
            for (int j = 1; j < i; j++) { //遍历j为根节点的树
                anInt = 0; //全局变量 寻找在此轮对比中的树的最大深度
                if (cc(i, j, 1) == 1) { //如果对比两个数相同
                    if (anInt >Math.max(1,res)) { //因为最后要求子数深度必须大于1 所以这里取1和res最大值，即anInt必须有效
                        res = anInt;  //最大值大于res 赋值给res
                        tr = i; //子数节点赋值给tr
                    }
                }
            }
        }
        if (tr == -1){ //tr还是初始值，说明没找到
            System.out.println(-1);
        } else {
            int[] wq = new int[1000000];
            int mm = 0, oo = -1;
            wq[++oo] = tr;
            int ct = 0;
            while (mm <= oo) {
                int v = wq[mm++];
                ct++;
                if (v > cnt) continue;
                if (ct == 1) {
                    System.out.print("[");
                } else{
                    System.out.print(",");
                }
                if (ints[v] == -1){
                    System.out.print("null");
                } else {
                    System.out.print(ints[v]);
                    oo += 1;
                    wq[oo] = v * 2;
                    oo += 1;
                    wq[oo] = v * 2 + 1;
                }
            }
            System.out.println("]");
        }
    }
    static int cc(int j, int i, int i1) {
        if (ints[j] != ints[i]){ //两节点值不想等，返回0等于返回false
            return 0;
        }else if (ints[i] == -1){
             return 1; //说明已经找到空节点了 返回true；
        }else{
            anInt = Math.max(anInt, i1); //i代表当前深度
            //遍历i，j两个节点的左节点与右节点
            return 1 & cc(j * 2, i * 2, i1 + 1) & cc(j * 2 + 1, i * 2 + 1, i1 + 1);
        }
    }
}
