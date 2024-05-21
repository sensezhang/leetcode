package com.chehejia.letcode.lixiang;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串s和一组单词dict，在s中添加空格将s变成一个句子，使得句子中的每一个单词都是dict中的单词
 * 返回所有可能的结果
 * 例如：给定的字符串s ="nowcoderisbest",
 * dict = ["now", "nowcoder","coderis","is","best"]
 *
 * 返回的结果为["nowcoder is best", "now coderis best"]
 * @Description
 * @Author zhangwbin
 * @Date 2021/9/18 8:49 上午
 **/
public class Solution2 {

    public List<String> splitStr(String s, String[] dict) {
        List<String> results = new ArrayList<>();
        char[] chars = s.toCharArray();
        TreeNode treeNode = new TreeNode();
        for (String str : dict) {
            treeNode.insert(str);
        }
        dfs(results, chars, 0, treeNode, new StringBuffer());
        return results;
    }

    private void dfs(List<String> results, char[] chars, int i, TreeNode treeNode, StringBuffer sb) {
        if (i == chars.length) {
            results.add(sb.toString());
            return;
        }
        TreeNode curNode = treeNode;
        while (i < chars.length && curNode.containsKey(chars[i])) {
            curNode = curNode.getNode(chars[i]);
            i++;
            if (curNode.word != null) {
                int start = sb.length();
                sb.append(curNode.word);
                if (i != chars.length) {
                    sb.append(" ");
                }
                dfs(results, chars, i, treeNode, sb);
                sb.delete(start, sb.length());
            }
        }
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        List<String> lists = solution2.splitStr("nowcoderisbest", new String[]{"now", "nowcoder","coderis","is","best"});
        System.out.println(lists);
    }
}
class TreeNode{

    int len = 26;

    TreeNode[] tree;

    String word;

    public TreeNode(){
        tree = new TreeNode[len];
    }

    public void insert(String word) {
        char[] chars = word.toCharArray();
        TreeNode node = this;
        for (char a : chars) {
            if (node.containsKey(a)) {
                node = node.getNode(a);
            } else {
                node.tree[a - 'a'] = new TreeNode();
                node = node.tree[a - 'a'];
            }
        }
        node.word = word;
    }


    public boolean containsKey(char a) {
        return tree[a - 'a'] != null;
    }

    public TreeNode getNode(char a) {
        return tree[a - 'a'];
    }
}
