package day01;

import java.util.Scanner;

public class hammingWeight {
    public static void main(String[] args) {
        int n=new Scanner(System.in).nextInt();
        System.out.println(hammingWeight(n));
    }
    public static int hammingWeight(int n) {
        String s=Integer.toBinaryString(n);
        char[] c=s.toCharArray();
        int num=0;
        for (char value : c) {
            if (value == '1')
                num++;
        }
        return num;
    }
}
