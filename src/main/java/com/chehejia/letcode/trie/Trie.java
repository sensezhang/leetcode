package com.chehejia.letcode.trie;

import java.util.*;

/**
 * @Description
 * @Author zhangwbin
 * @Date 2021/8/23 10:07 上午
 **/
public class Trie {

    Map<String, Trie> map;

    boolean isEnd;

    /** Initialize your data structure here. */
    public Trie() {
        map = new HashMap<>();
    }

    /**
     * 查找所有的家庭成员，包括父和子
     */
    public List<String> getAllFamily(String node) {
        List<String> lists = new ArrayList<>();
        String[] nodes = node.split("\\.");
        Trie trie = this;
        List<String> line = new ArrayList<>();
        // 父节点
        for (int i = 0; i < nodes.length; i++) {
            if (trie.hasKey(nodes[i])) {
                trie = trie.getKey(nodes[i]);
                line.add(nodes[i]);
                if (trie.isEnd) {
                    lists.add(String.join(".", line));
                }
            } else {
                return lists;
            }
        }
        // 查找子节点
        dfs(trie, lists, line, 0);
        return lists;
    }

    private void dfs(Trie trie, List<String> lists, List<String> line, int level) {
        if (trie.isEnd && level != 0) {
            lists.add(String.join(".", line));
        }
        for (Map.Entry<String, Trie> map : trie.map.entrySet()) {
            line.add(map.getKey());
            dfs(map.getValue(), lists, line, level + 1);
            line.remove(map.getKey());
        }
    }

    private void remove(String word) {
        String[] nodes = word.split("\\.");
        Trie trie = this;
        for (int i = 0; i < nodes.length - 1; i++) {
            if (trie.hasKey(nodes[i])) {
                trie = trie.getKey(nodes[i]);
            } else {
                // 没有找到对应的节点，不做删除
                break;
            }
        }
        // 删除最后一个节点及其所有的子节点
        trie.map.remove(nodes[nodes.length - 1]);
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        String[] nodes = word.split("\\.");
        Trie trie = this;
        for (int i = 0; i < nodes.length; i++) {
            Trie next;
            if (trie.hasKey(nodes[i])) {
                next = trie.getKey(nodes[i]);
            } else {
                next = new Trie();
                trie.putKey(nodes[i], next);
            }
            trie = next;
        }
        trie.setEnd();
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        String[] nodes = word.split("\\.");
        Trie trie = this;
        for (int i = 0; i < nodes.length; i++) {
            if (trie.hasKey(nodes[i])) {
                trie = trie.getKey(nodes[i]);
            } else {
                return false;
            }
        }
        return true;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        String[] nodes = prefix.split("\\.");
        Trie curTrie = this;
        for (int i = 0; i < nodes.length; i++) {
            if (!curTrie.hasKey(nodes[i])) {
                return false;
            }
            curTrie = curTrie.getKey(nodes[i]);
        }
        return true;
    }

    private void setEnd() {
        isEnd = true;
    }

    public boolean getEnd() {
        return isEnd;
    }

    private void putKey(String a, Trie trie) {
        map.put(a, trie);
    }

    private boolean hasKey(String a) {
        return map.containsKey(a);
    }

    private Trie getKey(String a) {
        return map.get(a);
    }

    private static String str = "";
    public static void main(String[] args) {
        Trie trie = new Trie();
        //当前JVM占用的内存总数(M)
        double total = (Runtime.getRuntime().totalMemory()) / (1024.0 * 1024);
        //JVM空闲内存(M)
        double free = (Runtime.getRuntime().freeMemory()) / (1024.0 * 1024);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            String random = getRandom(i);
            if (i == 5000) {
                str = random;
            }
            trie.insert(random);
        }
        double used=(total-free);
        long end = System.currentTimeMillis();
        System.out.println("插入100000条样本数据，耗时：" + (end - start) + "ms，内存占用：" + used + "MB");
        List<String> stringList = trie.getAllFamily(str);
        System.out.println("查找耗时：" + (System.currentTimeMillis() - end) + "ms");
        System.out.println(str);
        System.out.println(stringList);
    }


    private static String getRandom(int i) {
        String s = "";
        Random random = new Random();
        for (int a = 0; a < 2 + random.nextInt(8); a++) {
            if (a != 0 && a % 2 == 0) {
                s += ".";
            }
            s += (char)('a' + random.nextInt(1+ (i % 26)));
        }
        return s;
    }
}
