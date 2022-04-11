package com.hl.chunzhao.honor;

import java.util.*;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }
//            int max=0,tmp=0;
//            for (int j = 1; j < n; j++) {
//
//                for (int k = 0; k < j; k++) {
//                    if (arr[k]>arr[j]){
//                        tmp--;
//                    }else if (arr[k]<arr[j]){
//                        tmp++;
//                    }
//                }
//                max = Math.max(max, tmp);
////                if (j==n-1) p = tmp;
//            }
            Map<Integer, Integer> maplarger = new HashMap<>();
            Map<Integer, Integer> mapsmall = new HashMap<>();
            int[] larger = new int[n];
            int[] small = new int[n];
            Stack<Integer> slarger = new Stack<>();
            Stack<Integer> ssmall = new Stack<>();
            slarger.add(arr[0]);
            ssmall.add(arr[0]);
            for (int j = 1; j < n; j++) {
                int cout=0;
                while (!slarger.isEmpty()&&slarger.peek()>arr[j]){
                    Integer pop = slarger.pop();
                    cout=cout+1+maplarger.getOrDefault(pop,0);
                }
                slarger.add(arr[j]);
                cout += maplarger.getOrDefault(arr[j],0);
                larger[j]=cout;
                maplarger.put(arr[j], cout);
            }
            for (int j = 1; j < n; j++) {
                int cout=0;
                while (!ssmall.isEmpty()&&ssmall.peek()<arr[j]){
                    Integer pop = ssmall.pop();
                    cout=cout+1+mapsmall.getOrDefault(pop,0);
                }
                ssmall.add(arr[j]);
                cout += mapsmall.getOrDefault(arr[j],0);
                small[j]=cout;
                mapsmall.put(arr[j], cout);
            }
            int res=0,max=0;

            for (int j = 1; j < n; j++) {

                res += small[j];
                res -= larger[j];
                max = Math.max(max, res);
            }
            System.out.println(max+" "+res);
            System.out.println();
        }
    }
}

