package com.chehejia.letcode.binary.search;

/**
 * @Description
 * @Author zhangwbin
 * @Date 2021/11/4 2:04 下午
 **/
public class Solution367 {

    public boolean isPerfectSquare(int num) {
//        int low = 1;
//        int hight = num;
//        long b = (long) num;
//        while (low <= hight) {
//            int mid = low + ((hight - low) >> 1);
//            long a = (long) (mid * mid);
//            if (b == a) {
//                return true;
//            } else if (b > a) {
//                low = mid + 1;
//            } else {
//                hight = mid - 1;
//            }
//        }
//        return false;
        long left = 0;
        long right = num;
        while (left <= right) {
            long mid = (left + right) / 2;
            long result = mid * mid;
            if (result == num) {
                return true;
            } else if (result < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution367 solution367 = new Solution367();
        solution367.isPerfectSquare(16);
    }
}
