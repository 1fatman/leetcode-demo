package com.dq.leetcode;

import java.util.*;

/**
 * @author daquan
 * @version 1.0
 * @date 2020/2/2 22:14
 * <p> 账户合并
 * Q:给定一个列表 accounts，每个元素 accounts[i] 是一个字符串列表，
 * 其中第一个元素 accounts[i][0] 是 名称 (name)，其余元素是 emails 表示该帐户的邮箱地址。
 * 现在，我们想合并这些帐户。如果两个帐户都有一些共同的邮件地址，则两个帐户必定属于同一个人。
 * 请注意，即使两个帐户具有相同的名称，它们也可能属于不同的人，因为人们可能具有相同的名称。
 * 一个人最初可以拥有任意数量的帐户，但其所有帐户都具有相同的名称。
 * 合并帐户后，按以下格式返回帐户：每个帐户的第一个元素是名称，其余元素是按顺序排列的邮箱地址。
 * accounts 本身可以以任意顺序返回。
 */
public class FirstQuestionDemo {

    public static void main(String[] args) {

        List<List<String>> accounts = new ArrayList<>();

        List<String> john = new ArrayList<>();
        john.add("John");
        john.add("johnsmith@mail.com");
        john.add("john00@mail.com");

        List<String> john2 = new ArrayList<>();
        john2.add("John");
        john2.add("johnnybravo@mail.com");

        List<String> john3 = new ArrayList<>();
        john3.add("John");
        john3.add("johnsmith@mail.com");
        john3.add("john_newyork@mail.com");

        List<String> mary = new ArrayList<>();
        mary.add("Mary");
        mary.add("mary@mail.com");

        accounts.add(john);
        accounts.add(john2);
        accounts.add(john3);
        accounts.add(mary);

        List<List<String>> lists = accountsMerge(accounts);
        for (List<String> list : lists) {
            System.out.println(list);
        }
    }

    /**
     * 筛选重复名字 合并account
     *
     * @param accounts
     * @return
     */
    final static List<List<String>> accountsMerge(List<List<String>> accounts) {

        Map<String, String> emailToName = new HashMap<>(16);
        Map<String, ArrayList<String>> graph = new HashMap<>(16);

        for (List<String> account : accounts) {
            String name = "";
            for (String email : account) {
                if (name == "") {
                    name = email;
                    continue;
                }
                graph.computeIfAbsent(email, x -> new ArrayList<>()).add(account.get(1));
                graph.computeIfAbsent(account.get(1), x -> new ArrayList<>()).add(email);
                emailToName.put(email, name);
            }
        }

        Set<String> seen = new HashSet();
        List<List<String>> ans = new ArrayList();
        for (String email : graph.keySet()) {
            if (!seen.contains(email)) {
                seen.add(email);
                Stack<String> stack = new Stack();
                stack.push(email);
                List<String> component = new ArrayList();
                while (!stack.empty()) {
                    String node = stack.pop();
                    component.add(node);
                    for (String nei : graph.get(node)) {
                        if (!seen.contains(nei)) {
                            seen.add(nei);
                            stack.push(nei);
                        }
                    }
                }
                Collections.sort(component);
                component.add(0, emailToName.get(email));
                ans.add(component);
            }
        }
        return ans;
    }

}
