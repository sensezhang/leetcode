package com.chehejia.letcode.lixiang;

import java.util.Arrays;

/**
 * 给定一个int整数数组A及其大小n，请编写一个函数，找出索引m和n，只要将m和n之间的元素排好序，整个数组就是有序的。
 * 注意：n-m应该越小越好，即找出符合条件的最短序列。请返回一个二元组，元组的两个元素分别代表所求序列的起点和终点。(原序列位置从0开始标号,若原序列有序，返回[0,0])。要求A中元素均为正整数。
 *
 * 测试样例：
 * [1,4,6,5,9,10],6
 * 返回：[2,3]
 * @Description
 * @Author zhangwbin
 * @Date 2021/9/18 5:12 下午
 **/
public class Solution4 {

    public int[] resort(int[] a, int n) {
        int[] b = new int[n];
        System.arraycopy(a, 0, b, 0, n);
        Arrays.sort(b);
        int m = 0;
        int f = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] != b[i]) {
                m = i;
            }
        }
        for (int j = n - 1; j >=0; j--) {
            if (a[j] != b[j]) {
                f = j;
            }
        }
        return m > f ? new int[]{f, m} : new int[]{m, f};
    }

    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        int[] a = solution4.resort(new int[]{1,4,6,5,9,10}, 6);
        System.out.println(Arrays.toString(a));
    }
}
