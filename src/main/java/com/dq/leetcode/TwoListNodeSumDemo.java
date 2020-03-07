package com.dq.leetcode;

import com.dq.entity.ListNode;

/**
 * @author daquan
 * @version 1.0
 * @date 2020/2/3 22:30
 */
public class TwoListNodeSumDemo {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        // 创建两个链表
        ListNode l1 = new ListNode();
        // 不能用这个节点去往下加数据
        // 必须有一个指针去往第一个节点上去加数据
        l1.next = new ListNode(5);
        // 第二个链表
        ListNode l2 = new ListNode();
        l2.next = new ListNode(5);
        l2.next = new ListNode(3);
        ListNode re = addTwoNumbers(l1, l2);
        while (re != null) {
            System.out.println(re.val);
            re = re.next;
        }
    }
}