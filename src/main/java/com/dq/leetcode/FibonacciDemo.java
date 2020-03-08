package com.dq.leetcode;

/**
 * @author daquan
 * @version V1.0
 * @date 2020/3/7
 * @Description: TODO
 * Q:斐波拉契数列（Fibonacci）
 */
public class FibonacciDemo {

    public static void main(String[] args) {
        int[] arr = new int[20];
        int len = arr.length;
        arr[0] = arr[1] = 1;
        for (int i = 2; i < len; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        System.out.println("斐波那契数列的前20项如下所示：");
        for (int i = 0; i < len; i++) {
            if (i % 5 == 0) {
                System.out.println();
            }
            System.out.print(arr[i] + "     ");
        }
    }
}
