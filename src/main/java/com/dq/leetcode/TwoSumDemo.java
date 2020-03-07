package com.dq.leetcode;

import java.util.LinkedList;

/**
 * @author daquan
 * @date 2020-01-31 22:34:53
 * Q：给定一个数组nums和一个目标值target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标 注：不能利用数组中的重复元素
 */
public class TwoSumDemo {

    public static void main(String[] args) {
        // 冒泡
        bubbleSort(new int[]{1, 3, 2, 5, 4, 6, 9, 10, 15, 11, 12});

        // 两数之和
        int[] ints = twoSum(new int[]{1, 3, 2, 5, 4, 6, 9, 10, 15, 11, 12}, 22);
        for (int i : ints) {
            System.out.println(i);
        }
    }

    /**
     * A：冒泡排序
     *
     * @param arr 数组
     * @return
     */
    final static void bubbleSort(int arr[]) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
        for (int i : arr) {
            System.out.println(i);
        }
    }

    /**
     * A：给定target，返回arr中满足条件的元素下标
     *
     * @param arr    数组
     * @param target 目标值
     * @return
     */
    final static int[] twoSum(int arr[], int target) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                int temp = arr[i] + arr[j];
                if (temp == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("this arr not exits two sum equals to target");
    }

}

