package com.dq.datastructure;

import java.util.BitSet;
import java.util.Enumeration;
import java.util.Stack;
import java.util.Vector;

/**
 * @author daquan
 * @version 1.0
 * @date 2020/2/1 14:50
 * Q:Java数据结构:
 * 枚举（Enumeration），位集合（BitSet），向量（Vector），栈（Stack）
 * 字典（Dictionary），哈希表（Hashtable），属性（Properties）
 * 集合框架:动态数组，链表，树，哈希表
 */
public class DataStructureDemo {
    public static void main(String[] args) {
        /**
         * 枚举
         * 应用场景:输出Vector元素
         */
        Enumeration<String> days;
        Vector<String> dayNames = new Vector<>();
        dayNames.add("周一");
        dayNames.add("周二");
        dayNames.add("周三");
        dayNames.add("周四");
        dayNames.add("周五");
        dayNames.add("周六");
        dayNames.add("周日");
        days = dayNames.elements();
        // hasMoreElements() 是否有更多元素 类似Iterator
        while (days.hasMoreElements()) {
            String day = days.nextElement();
            System.out.println(day);
        }

        /**
         * 位集合
         */
        // 可以指定大小，位初始默认为0
        BitSet bitSet = new BitSet(16);
        // 在对应的下标位置设置值
        bitSet.set(15);
        int length = bitSet.length();
        System.out.println(bitSet);
        System.out.println(length);

        /**
         * 向量
         * 和ArrayList相似
         * 不同:
         * 1.Vector是同步访问的
         * 2.Vector包含了许多传统的方法，这些方法不属于集合框架
         */
        Vector<String> vector = new Vector<>(16);
        // capacity() 返回该向量的当前容量 16
         System.out.println(vector.capacity());

         /**
         * 栈（Stack）
         * 是Vector的一个子类，实现了标准的后进先出的栈
         */
        Stack stack = new Stack();
        stack.push("hello world");
        stack.push("hello world!");
        System.out.println(stack.peek());
        int i = stack.search("hello world");
        System.out.println(i);
        /**
         * 字典（Dictionary）
         * 和Map相似
         * 已过时
         */

        /**
         * 哈希表（Hashtable）
         * 是Dictionary的具体实现
         * 和HashMap类似，但支持同步
         */

        /**
         * Properties类
         * 继承于Hashtable
         */
    }
}
