package com.chehejia.letcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description
 * @Author zhangwbin
 * @Date 2021/12/28 10:07 上午
 **/
public class solution472 {

    public static void main(String[] args) {
        solution472 solution472 = new solution472();
        solution472.findAllConcatenatedWordsInADict(new String[]{"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"});
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Trie trie = new Trie();
        Arrays.sort(words, (o1, o2) -> o1.length() - o2.length());
        List<String> ans = new ArrayList<>();
        for (String str : words) {
            if (trie.search(str.toCharArray(), 0, str.length())) {
                ans.add(str);
            }
            trie.insert(str);
        }
        return ans;
    }


}
class Trie{
    int n = 26;
    Trie[] tries;
    boolean isEnd;
    String word;

    public Trie(){
        tries = new Trie[n];
        isEnd = false;
    }

    public void insert(String word) {
        char[] cs = word.toCharArray();
        Trie trie = this;
        for (char a : cs) {
            if (trie.contains(a)) {
                trie = trie.get(a);
            } else {
                trie = trie.add(a);
            }
        }
        trie.isEnd = true;
        trie.word = word;
    }

    public boolean search(char[] cs, int start, int end) {
        if (start == end) {
            return true;
        }
        Trie trie = this;
        while (start < end) {
            if (!trie.contains(cs[start])) {
                return false;
            }
            trie = trie.get(cs[start]);
            start++;
            if (trie.isEnd) {
                if(search(cs, start, end)) {
                    return true;
                }
            }
        }
        return trie.isEnd;
    }

    private boolean contains(char a) {
        return tries[a - 'a'] != null;
    }

    private Trie get(char a) {
        return tries[a - 'a'];
    }

    private Trie add(char a) {
        Trie next = new Trie();
        tries[a - 'a'] = next;
        return next;
    }
}
