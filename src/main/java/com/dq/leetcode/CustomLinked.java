package com.dq.leetcode;

/**
 * @author daquan
 * @version V1.0
 * @date 2020/3/7
 * @Description: TODO
 */
public class CustomLinked<T> {

    private static class Node {
        Object value;
        Node prev = this;
        Node next = this;

        Node(Object v) {
            value = v;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }

    /**
     * 头节点
     */
    private Node head = new Node(null);

    /**
     * 链表大小
     */
    private int size;

    public boolean addFirst(Node node, Object o) {
        addAfter(new Node(o), head);
        return true;
    }

    public boolean addLast(Object o) {
        addBefore(new Node(0), head);
        return true;
    }

    public boolean add(Object o) {
        return addLast(o);
    }

    public boolean add(int index, Object o) {
        addBefore(new Node(o), getNode(index));
        return true;
    }

    private Node getNode(int index) {
        if (index < 0 || index >= size) {
            System.out.println("链表下标越界");
        }
        Node node = head.next;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    private void addAfter(Node newNode, Node node) {
        newNode.prev = node;
        newNode.next = node.next;
        newNode.next.prev = newNode;
        newNode.prev.next = newNode;
        size++;
    }

    private void addBefore(Node newNode, Node node) {
        newNode.next = node;
        newNode.prev = node.prev;
        newNode.next.prev = newNode;
        newNode.prev.next = newNode;
        size++;
    }

    @Override
    public String toString() {
        StringBuffer s = new StringBuffer();
        Node node = head;
        for (int i = 0; i < size; i++) {
            node = node.next;
            if (i > 0) {
                s.append("   ");
            }
            s.append(node.value);
        }
        return s.toString();
    }

    public boolean revise(int index, Object o) {
        reviseNode(new Node(o), getNode(index));
        return true;
    }

    public boolean remove(int index) {
        removeNode(getNode(index));
        return true;
    }

    public boolean removeFirst() {
        removeNode(head.next);
        return true;
    }

    public boolean removeLast() {
        removeNode(head.prev);
        return true;
    }

    private void reviseNode(Node newNode, Node node) {
        newNode.next = node.next;
        newNode.prev = node.prev;
        newNode.next.prev = newNode;
        newNode.prev.next = newNode;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = null;
        node.next = null;
        size--;
    }
}
