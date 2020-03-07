package com.dq.leetcode;

/**
 * @author daquan
 * @version 1.0
 * @date 2020/2/2 23:25
 */
public class IntReverseDemo {

    public final static int reverse(int x) {
        int n = 0;
        while (x != 0) {
            n = n * 10 + x % 10;
            x = x / 10;
        }
        return n == n ? n : 0;
    }

    public static void main(String[] args) {
        int res = reverse(120);
        System.out.println(res);
    }
}
