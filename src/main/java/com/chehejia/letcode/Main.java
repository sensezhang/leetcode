package com.chehejia.letcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public int[] getLongArray(int[] input) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(input);
        int maxLon = 1;
        for (int i = 0; i < input.length - 1;) {
            int count = 1;
             List<Integer> list1 = new ArrayList<>();
            while (input[i + 1] - input[i] == 1) {
                count++;
                list1.add(input[i]);
                list1.add(input[i + 1]);
                i++;
            }
            if (maxLon < count) {
                list = list1;
                maxLon = count;
            }
            i++;
        }
        int[] output = new int[list.size()];
        for (int i = 0 ; i < list.size(); i++) {
            output[i] = list.get(i);
        }
        return output;
    }
    public static void main(String[] args) {
      Main m = new Main();
       int[] result = m.getLongArray(new int[]{100, 4, 200, 5, 3, 2});
       System.out.println(Arrays.toString(result));
    }
}