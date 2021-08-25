package com.chehejia.letcode.array;

import java.util.Scanner;

public class Main{
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] cs = s.toCharArray();
       int maxx = 0;
       int maxy = 0;
         int index = 0;
         int maxPath = 0;
         while (index < cs.length) {
             if (cs[index] == '(') {
               int start = index;
                 while (true) {
                   if (cs[index++] == ')') {
                     String s2 = s.substring(start + 1, index - 1);
                     String[] arr = s2.split(",");
                     int x = 0;
                     int y = 0;
                     if (checkValid(arr)){
                       break;
                     } else {
                       x = Integer.parseInt(arr[0]);
                       y = Integer.parseInt(arr[1]);
                     }
                     if (maxPath < Math.pow(x, 2) + Math.pow(y, 2)) {
                       maxx = x;
                       maxy = y;
                     }
                     break;
                   }

                 }
             }
             index++;
         }
       System.out.println("(" + maxx +"," + maxy + ")");
     }

  private static boolean checkValid(String[] arr) {
       if (arr[0].charAt(0) == '0' || arr[1].charAt(0) == '0') {
         return true;
       }
       int x = Integer.parseInt(arr[0]);
       int y = Integer.parseInt(arr[1]);
       if (x <= 0 || x >= 1000 || y <= 0 || y >= 1000) {
         return true;
       }
    return false;
  }
}