package com.chehejia.letcode.array;

import org.apache.logging.log4j.util.Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description
 * @Author zhangwbin
 * @Date 2021/11/24 10:23 上午
 **/
public class Solution423 {

    /**
     * z:0,w:2,u:4,g:8,x:6,t:3,f:5,s:7,o:1,n:9
     */
    public String originalDigits(String s) {
        List<Character[]> lists = new ArrayList<>();
        lists.add(new Character[]{'z','e','r','o'});
        lists.add(new Character[]{'o','n','e'});
        lists.add(new Character[]{'t','w','o'});
        lists.add(new Character[]{'t','h','r','e','e'});
        lists.add(new Character[]{'f', 'o', 'u', 'r'});
        lists.add(new Character[]{'f','i','v','e'});
        lists.add(new Character[]{'s','i','x'});
        lists.add(new Character[]{'s','e','v','e','n'});
        lists.add(new Character[]{'e','i','g','h','t'});
        lists.add(new Character[]{'n','i','n','e'});

        int[] nums = new int[]{0,2,4,8,6,3,5,7,1,9};
        int[] statics = new int[26];
        for (char a : s.toCharArray()) {
            statics[a - 'a']++;
        }
        int count = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            Character[] word = lists.get(nums[i]);
            int num = count;
            for (Character c : word) {
                num = Math.min(statics[c - 'a'], num);
            }
            num = num == count ? 0 : num;
            for (int j = 0; j < num; j++) {
                for (Character c : word) {
                    statics[c - 'a']--;
                }
                sb.append(nums[i]);
            }
        }
        char[] chars = sb.toString().toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static void main(String[] args) {
        Solution423 solution423 = new Solution423();
        String s = solution423.originalDigits("owoztneoer");
        System.out.println(s);
    }
}
