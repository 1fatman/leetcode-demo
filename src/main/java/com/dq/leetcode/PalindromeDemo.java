package com.dq.leetcode;

/**
 * @author daquan
 * @version V1.0
 * @date 2020/3/8
 * @Description: TODO
 * Q:判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 */
public class PalindromeDemo {

    /**
     * 字符串解法
     *
     * @param num
     * @return
     */
    public static final boolean isPalindrome(Integer num) {
        String reverse = new StringBuffer(num + "").reverse().toString();
        return reverse.equals(num + "");
    }

    /**
     * 数学解法：通过取整和取余操作获取整数中对应的数字进行比较。
     *
     * @param num
     * @return
     */
    public static final boolean isPalindrome2(Integer num) {
        if (num < 0) {
            return false;
        }
        int div = 1;
        final int temp = 10;
        while (num / div >= temp) {
            div *= temp;
        }
        while (num > 0) {
            int left = num / div;
            int right = num % temp;
            if (left != right) {
                return false;
            }
            num = (num % div) / temp;
            div /= 100;
        }
        return true;
    }

    /**
     * 巧妙解法：反转一半数字
     * 回文有奇数偶数
     * 奇数需要除以10取整
     *
     * @param num
     * @return
     */
    public static final boolean isPalindrome3(Integer num) {
        // 魔法值
        final int temp = 10;
        // 处理临界情况 负数不可能为回文
        boolean res = num < 0 || (num % temp == 0 && num != 0);
        if (res) {
            return false;
        }
        int revertedNumber = 0;
        while (num > revertedNumber) {
            revertedNumber = revertedNumber * temp + num % temp;
            num /= temp;
        }

        // num = revertedNumber / temp; 说明:回文数12321,num = 12 ,revertedNumber = 123, 奇数回文，除以10取整 等于12,返回true
        return num == revertedNumber || num == revertedNumber / temp;
    }

}
