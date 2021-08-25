package com.chehejia.letcode.dp;

import java.util.Arrays;

/**
 * @Author: zhangwbin
 * @Date: 2020/7/9
 */
public class SolutionM17_13 {

  public int respace(String[] dictionary, String sentence) {
    Trie trie = new Trie();
    for (int i = 0; i < dictionary.length; i++) {
      trie.insert(dictionary[i]);
    }
    int len = sentence.length();
    int[] dp = new int[len + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;
    int last = -1;
    for (int j = 0; j < len; j++) {
      dp[j + 1] = dp[j] + 1;
      char a = sentence.charAt(j);
      // 如果单词结尾找到了，就往前找最长的单词头
      if (trie.hasKey(a)) {
        Trie trie1 = trie;
        int wordLen = j;
        while (wordLen > last) {
          trie1 = trie1.getKey(sentence.charAt(wordLen));
          if (trie1 == null) {
            break;
          } else {
            if (trie1.getEnd()) {
              dp[j + 1] = Math.min(dp[wordLen], dp[j + 1]);
            }
          }
          wordLen--;
        }
      }
    }
    return dp[len] == Integer.MAX_VALUE ? 0 : dp[len];
  }

  public static void main(String[] args) {
    SolutionM17_13 solutionM17_13 = new SolutionM17_13();
    String[] dic = new String[]{"looked", "just", "like", "her", "brother"};
    String str = "jesslookedjustliketimherbrother";
    int count = solutionM17_13.respace(dic, str);
    System.out.println(count);
  }

}

// 倒排trie
class Trie {

  boolean isEnd;
  int R = 26;
  Trie[] tries;

  public Trie() {
    tries = new Trie[R];
  }


  public void insert(String word) {
    int len = word.length();
    Trie trie = this;
    for (int i = len - 1; i >= 0; i--) {
      char a = word.charAt(i);
      Trie next;
      if (trie.hasKey(a)) {
        next = trie.getKey(a);
      } else {
        next = new Trie();
        trie.putKey(a, next);
      }
      trie = next;
    }
    trie.setEnd();
  }

  public boolean searchProfix(String word) {
    Trie trie = this;
    for (int i = 0; i < word.length(); i++) {
      char a = word.charAt(i);
      if (trie.hasKey(a)) {
        trie = trie.getKey(a);
      } else {
        return false;
      }
    }
    return true;
  }

  public void setEnd() {
    isEnd = true;
  }

  public boolean getEnd() {
    return isEnd;
  }

  public void putKey(char a, Trie trie) {
    tries[a - 'a'] = trie;
  }

  public boolean hasKey(char a) {
    return tries[a - 'a'] != null;
  }

  public Trie getKey(char a) {
    return tries[a - 'a'];
  }
}
