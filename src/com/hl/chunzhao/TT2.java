package com.hl.chunzhao;

import java.util.*;

public class TT2 {
    public static void main(String[] args) {
        //1.遍历
//        删除了变成长度98的数组了？？？还是怎么说

        //2。优化 遍历 二分
    }
    public List<Integer> find(int[] arr){
        List<Integer> list = new ArrayList<>();
        int[] tmp = new int[101];
        for (int i = 0; i < arr.length; i++) {
            tmp[arr[i]]=1;
        }
        for (int i = 1; i <=100 ; i++) {
            if (tmp[i]==0) list.add(i);
        }
        return list;

    }
}
