package com.hl.chunzhao.WeiZhongBank;

import java.util.*;
/*
小亮来到了一个特殊的国度，这个国家的人有一个奇特的地方：如果一个人身边的人都比自己强，那么这个人会开始努力提升自己。
       现在有n个人排成一排，因为视线是有限的，所以每个人只能看见左边的x个人和右边的y个人。
       每个人都有一个能力值a_i,如果他视线能看到的人能力值都比他高，则他会开始努力提升自己。
       如果左边人数不足x个人，则左边的视线能看见左边所有人，如果右边并没有y个人，那么右边的视线仅仅覆盖右边的所有人。
       已知这n个人的编号从左到右为1~n，请问努力的人中最左边的人编号是多少。
       保证这n个人的能力值都不重复，且都在10^6以内。
 */
/*
input:
10 2 3
10 8 7 1 9 2 6 4 3 5

output:4
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int[] arr = new int[n+x+y];
        Arrays.fill(arr,2000000);
        for (int i = x; i < arr.length-y; i++) {
            arr[i] = sc.nextInt();
        }
        Stack<Integer> sbig = new Stack<>();
        Stack<Integer> ssmall = new Stack<>();
        ssmall.add(n+x);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = arr.length-y-1; i >=x; i--) {
            while (!ssmall.isEmpty()&&arr[i] < arr[ssmall.peek()]) {
                ssmall.pop();
            }
            int tmp = ssmall.isEmpty() ? y : ssmall.peek() - i - 1;
            map.put(i, tmp);
            ssmall.push(i);
        }
        sbig.add(x-1);
        for (int i = x; i < arr.length-y; i++) {
            while (!sbig.isEmpty()&&arr[i] < arr[sbig.peek()]) {
                sbig.pop();
            }
            int tmp = sbig.isEmpty() ? x : i-sbig.peek() - 1;
            if (tmp>=x&&map.get(i)>=y){
                System.out.println(i-1);
                return;
            }
        }
    }
}
