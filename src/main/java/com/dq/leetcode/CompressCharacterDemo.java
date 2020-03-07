package com.dq.leetcode;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author daquan
 * @version 1.0
 * @date 2020/2/1 14:11
 * Q:统计字符出现的次数
 */
public class CompressCharacterDemo {
    public static void main(String[] args) {
        compressCharacter("acackssdsdsdsdacascazcaccasdlllsdadacas");
    }

    final static void compressCharacter(String str) {
        // 分割字符串
        String[] strings = str.split("");
        int len = strings.length;
        TreeMap<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < len; i++) {
            if (!map.containsKey(strings[i])) {
                map.put(strings[i], 1);
            } else {
                // 获取字符的出现的次数
                int count = map.get(strings[i]) + 1;
                map.put(strings[i], count);
            }
        }
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
