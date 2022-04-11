package com.hl.chunzhao.WeiZhongBank;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
 小明有一个长度为n的仅由0到9组成的字符串。小美想知道这个串里有多少个子串代表的十进制数能被k整除。

      字符串a的子串即是那些可被描述为“由a中第i至第j个字符组成的字符串”的串。如字符串‘121’有‘1’，‘2’，‘1’，‘12’，‘21’，‘121’六个子串。
 */

/*
5 3
11012
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String s1 = s.nextLine();
        String[] s3 = s1.split(" ");
        int n = Integer.valueOf(s3[0]);
        int k = Integer.valueOf(s3[1]);
        BigInteger bigk = new BigInteger(String.valueOf(k));
        String s2 = s.nextLine();
        int res=0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j <= n; j++) {
                BigInteger bigInteger = new BigInteger(s2.substring(i,j));
                BigInteger remainder = bigInteger.remainder(bigk);
                if(remainder.toString().equals("0")) {
                    res++;
                }
            }
        }
        System.out.println(res);

    }
}
