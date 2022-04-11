    package com.hl.chunzhao.WeiZhongBank;

    import java.util.Scanner;

    public class Main1 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int nextInt = sc.nextInt();
            int res=0;
            while (nextInt > 16) {
                int i = nextInt % 16;
                if (i>9) res++;
                nextInt /= 16;
            }
            res += (nextInt > 9 ? 1 : 0);
            System.out.println(res);
        }
    }
