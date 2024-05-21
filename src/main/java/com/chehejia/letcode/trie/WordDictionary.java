package com.chehejia.letcode.trie;

class WordDictionary {

    WordDictionary[] trie = null;
    boolean isEnd = false;

    public WordDictionary() {
        trie = new WordDictionary[26];
    }
    
    public void addWord(String word) {
        char[] cs = word.toCharArray();
        WordDictionary node = this;
        for (int i = 0; i < cs.length; i++) {
            char a = cs[i];
            if(node.trie[a - 'a'] == null) {
                node.trie[a - 'a'] = new WordDictionary();
            }
            node = node.trie[a - 'a'];
        }
        node.isEnd = true;
    }
    
    public boolean search(String word) {
        WordDictionary node = this;
        char[] cs = word.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            char a = cs[i];
            if (a != '.') {
                if (node.trie[a - 'a'] == null) {
                    return false;
                }
                node = node.trie[a - 'a'];
            } else {
                for (int j = 0; j < 26; j++) {
                    if (node.trie[j] != null) {
                        if (node.trie[j].search(word.substring(i + 1))) {
                            return true;
                        }
                    }
                }
                return false;
            }
        }
        return node.isEnd;
    }
    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("at");
        wordDictionary.addWord("and");
        wordDictionary.addWord("an");
        wordDictionary.addWord("add");
        System.out.println(wordDictionary.search("a"));
        System.out.println(wordDictionary.search(".at"));
        wordDictionary.addWord("bat");
        System.out.println(wordDictionary.search(".at"));
        System.out.println(wordDictionary.search("an."));
        System.out.println(wordDictionary.search("a.d."));
        System.out.println(wordDictionary.search("b."));
        System.out.println(wordDictionary.search("a.d"));
        System.out.println(wordDictionary.search("."));
    }

}


/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */