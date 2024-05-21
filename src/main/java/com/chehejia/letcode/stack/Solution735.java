package com.chehejia.letcode.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @Description
 * @Author zhangwenbin1
 * @Date 2022/7/13 9:09 AM
 **/
public class Solution735 {

    public int[] asteroidCollision(int[] asteroids) {
        int left = 0;
        int right = 1;
        Deque<Integer> deque = new ArrayDeque<>();
        while (left >= 0 && right < asteroids.length) {
            int v1 = asteroids[left];
            int v2 = asteroids[right];
            if ((v1 > 0 && v2 > 0)||(v1 < 0 && v2 < 0)) {
                deque.push(v1);
                if (right == asteroids.length - 1) {
                    deque.push(v2);
                }
                left = right;
                right++;
            } else if (v1 > 0 && v2 < 0) {
                if (Math.abs(v1) == Math.abs(v2)) {
                    if (!deque.isEmpty()) {
                        deque.poll();
                    }
                    right++;
                    left--;
                } else if (Math.abs(v1) > Math.abs(v2)) {
                    deque.push(v1);
                    right++;
                } else if (Math.abs(v1) < Math.abs(v2)) {
                    left--;
                    if (!deque.isEmpty()) {
                        deque.poll();
                    }
                }
            } else if (v1 < 0 && v2 > 0) {
                deque.push(v1);
                if (right == asteroids.length - 1) {
                    deque.push(v2);
                }
                left = right;
                right++;
            }
            if (left < 0) {
                left = right;
                right++;
            }
        }
        int[] res = new int[deque.size()];
        int i = 0;
        while (!deque.isEmpty()) {
            res[i++] = deque.pollLast();
        }
        return res;
    }

    public static void main(String[] args) {
        Solution735 solution735 = new Solution735();
        int[] a = solution735.asteroidCollision(new int[]{-2,-2,1,-1});
        System.out.println(Arrays.toString(a));
//        int[] b = solution735.asteroidCollision(new int[]{-2,-2,1,1});
//        System.out.println(Arrays.toString(b));
//        int[] c = solution735.asteroidCollision(new int[]{5,10,-5});
//        System.out.println(Arrays.toString(c));
//        int[] d = solution735.asteroidCollision(new int[]{8, -8});
//        System.out.println(Arrays.toString(d));
//        int[] e = solution735.asteroidCollision(new int[]{10,2,-5});
//        System.out.println(Arrays.toString(e));
//        int[] f = solution735.asteroidCollision(new int[]{-2,1,-2,-2});
//        System.out.println(Arrays.toString(f));
//        int[] g = solution735.asteroidCollision(new int[]{-2,1,-1,-2});
//        System.out.println(Arrays.toString(g));
//        int[] h = solution735.asteroidCollision(new int[]{-2,2,-1,-2});
//        System.out.println(Arrays.toString(h));
    }

}
