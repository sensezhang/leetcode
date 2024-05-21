package com.chehejia.letcode.trie;

class MagicDictionary {

    public static void main(String[] args) {
        MagicDictionary ma = new MagicDictionary();
        ma.buildDict(new String[]{"hello", "leetcode"});
        boolean a = ma.search("hhllo");
        System.out.println(a);
    }
    DicTree dicTree;

    public MagicDictionary() {
        dicTree = new DicTree();
    }
    
    public void buildDict(String[] dictionary) {
        for (String s : dictionary) {
            dicTree.insert(s);
        }
    }
    
    public boolean search(String searchWord) {
        char[] cs = searchWord.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            int index = cs[i] - 'a';
            for (int j = 0; j < 26; j++) {
                if (index == j) {
                    continue;
                }
                cs[i] = (char) (j + 'a');
                if (dicTree.search(cs)) {
                    return true;
                }
            }
            cs[i] = (char) (index + 'a');
            
        }
        return false;
    }
}
class DicTree{
    DicTree[] node;
    boolean isEnd = false;
    public DicTree() {
        node = new DicTree[26];
    }

    public boolean search(char[] cs) {
        DicTree dic = this;
        for (int i = 0; i < cs.length; i++) {
            if (dic.contiansKey(cs[i])) {
                dic = dic.getDicTree(cs[i]);
            } else {
                return false;
            }
        }
        return dic.isEnd;
    }

    public void insert(String s) {
        char[] cs = s.toCharArray();
        DicTree dic = this;
        for (int i = 0; i < cs.length; i++) {
            if (dic.contiansKey(cs[i])) {
                dic = dic.getDicTree(cs[i]);
            } else {
                dic = dic.insertDicTree(cs[i]);
            }
        }
        dic.isEnd = true;
    }

    public boolean contiansKey(char a) {
        return node[a - 'a'] != null;
    }

    public DicTree getDicTree(char a) {
        return node[a - 'a'];
    }

    public DicTree insertDicTree(char a) {
        DicTree dicTree = new DicTree();
        node[a - 'a'] = dicTree;
        return dicTree;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */