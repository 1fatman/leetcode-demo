package com.dq.leetcode;

import lombok.extern.slf4j.Slf4j;

/**
 * @author daquan
 * @version V1.0
 * @date 2020/3/24
 * @Description: TODO 快排
 */
@Slf4j
public class QuickSort {

    public static final void quickSort(int[] num, int left, int right) {
        //如果left等于right，即数组只有一个元素，直接返回
        if (left >= right) {
            return;
        }
        //设置最左边的元素为基准值
        int key = num[left];
        //数组中比key小的放在左边，比key大的放在右边，key值下标为i
        int i = left;
        int j = right;
        while (i < j) {
            //j向左移，直到遇到比key小的值
            while (num[j] >= key && i < j) {
                j--;
            }
            //i向右移，直到遇到比key大的值
            while (num[i] <= key && i < j) {
                i++;
            }
            //i和j指向的元素交换
            if (i < j) {
                int temp = num[i];
                num[i] = num[j];
                num[j] = temp;
            }
        }
        num[left] = num[i];
        num[i] = key;
        quickSort(num, left, i - 1);
        quickSort(num, i + 1, right);

    }


    /**
     * StringBuffer与StringBuilder区别？
     * 相同：
     * 1.都是可变字符串
     * 2.都继承了AbstractStringBuilder抽象类
     * 不同：
     * 1.StringBuffer是线程安全的，因为StringBuffer暴露的方法都是用Synchronized修饰的,并且每个方法都添加了缓冲区
     * 2.StringBuilder是线程不安全的
     *
     * @param arr
     * @return
     */
    public static final String arrToString(int[] arr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i : arr) {
            stringBuilder.append(i + " ");
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        // quickSort(new int[]{1}, 0, 1);
        int[] arr = new int[]{
                1, 3, 2, 5, 7, 5, 6, 10, 6
        };
        quickSort(arr, 0, arr.length - 1);
        //输出
        String s = arrToString(arr);
        System.out.println(s);
    }

}
