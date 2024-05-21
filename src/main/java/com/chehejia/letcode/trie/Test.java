package com.chehejia.letcode.trie;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Description 
 * @Author zhangwenbin1
 * @Date 2022/3/16 9:31 AM
 **/
public class Test {

    List<String> lists = new ArrayList<>();
    private static String str = "";

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        Test test = new Test();
        for (int i = 0; i < 1000000; i++) {
            String random = getRandom(i);
            test.lists.add(random);
            if (i == 5000) {
                str = random;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("插入100000条样本数据，耗时：" + (end - start) + "ms");
        List<String> stringList = test.getAllFamily(str);
        System.out.println("查找耗时：" + (System.currentTimeMillis() - end) + "ms");
        System.out.println(str);
        System.out.println(stringList);
    }

    private List<String> getAllFamily(String str) {
        List<String> l = new ArrayList<>();
        for (String s : lists) {
            if (s.startsWith(str + ".") || s.equals(str)) {
                l.add(s);
            }
        }
        return l;
    }

    private static String getRandom(int i) {
        String s = "";
        Random random = new Random();
        for (int a = 0; a < 2 + random.nextInt(30); a++) {
            if (a != 0 && a % 5 == 0) {
                s += ".";
            }
            s += (char)('a' + random.nextInt(1+ (i % 26)));
        }
        return s;
    }
}
