package com.chehejia.letcode.binary.tree;

class MapSum {

    Trie trie;

    public MapSum() {
        trie = new Trie();
    }
    
    public void insert(String key, int val) {
        trie.add(key, val);
    }
    
    public int sum(String prefix) {
        return trie.prefix(prefix);
    }

    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("apple", 3);
        System.out.println(mapSum.sum("app"));
        mapSum.insert("app", 2);
        System.out.println(mapSum.sum("ap"));
    }
}
class Trie{
    int val;
    
    Trie[] tries;
    
    private static final int len = 26;
    
    Trie() {
        tries = new Trie[len];
    }

    public void add(String s, int val) {
        char[] cs = s.toCharArray();
        Trie trie = this;
        for (int i = 0; i < cs.length; i++) {
            if (trie.containsKey(cs[i])) {
                trie = trie.getTrie(cs[i]);
            } else {
                trie = trie.addTrie(cs[i]);
            }
        }
        trie.val = val;
    }

    public int prefix(String s) {
        char[] cs = s.toCharArray();
        Trie trie = this;
         for (int i = 0; i < cs.length; i++) {
             if (trie.containsKey(cs[i])) {
                 trie = trie.getTrie(cs[i]);
             } else {
                 return 0;
             }
         }
         return dfs(trie);
    }
    
    private int dfs(Trie trie) {
        int ans = 0;
        if (trie == null) {
            return 0;
        }
        ans += trie.val;
        Trie[] tries = trie.tries;
        for (Trie trie1 : tries) {
            ans += dfs(trie1);
        }
        return ans;
    }

    private boolean containsKey(char a) {
        return tries[a - 'a'] != null;
    }

    private Trie getTrie(char a) {
        return tries[a - 'a'];
    }

    private Trie addTrie(char a) {
        Trie tmp = new Trie();
        tries[a - 'a'] = tmp;
        return tmp;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
