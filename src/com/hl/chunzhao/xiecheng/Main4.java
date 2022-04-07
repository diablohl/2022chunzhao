package com.hl.chunzhao.xiecheng;

import javax.xml.stream.events.Characters;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int q=sc.nextInt();
        char[][] trix = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < m; j++) {
                trix[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < q; i++) {
            int uu = sc.nextInt() - 1;
            int vv = sc.nextInt() - 1;
            int ss = sc.nextInt() - 1;
            int zz = sc.nextInt() - 1;
            for (int k = uu; k <=ss ; k++) {
                for (int l = vv; l <=zz ; l++) {
                    if (Character.isUpperCase(trix[k][l])) {
                        char lowCase = (char) (trix[k][l] + 32);
                        trix[k][l] = lowCase;
                    } else if (Character.isLowerCase(trix[k][l])) {
                        char upCase = (char) (trix[k][l] - 32);
                        trix[k][l] = upCase;
                    }
                }


            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(trix[i][j]);
            }
            System.out.println();

        }

    }
}
