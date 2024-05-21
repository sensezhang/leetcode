package com.chehejia.letcode.array;

import java.util.Arrays;

/**
 * @Description
 * @Author zhangwbin
 * @Date 2021/12/26 3:08 下午
 **/
public class Sort1 {
    public static void main(String[] args) {
        int[] arr = new int[]{3,1,5,7,4,10,8};
        Sort1 sort1 = new Sort1();
        sort1.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private void sort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len  -  i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }
}
