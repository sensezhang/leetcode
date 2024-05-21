package com.chehejia.letcode;

import java.util.Calendar;

/**
 * @Description
 * @Author zhangwbin
 * @Date 2021/12/23 8:57 上午
 **/
public class Solution1154 {

    public int dayOfYear(String date) {
        String[] str = date.split("-");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, Integer.parseInt(str[0]));
        calendar.set(Calendar.MONTH, Integer.parseInt(str[1]) - 1);
        calendar.set(Calendar.DATE, Integer.parseInt(str[2]));
        return calendar.get(Calendar.DAY_OF_YEAR);
    }

    public static void main(String[] args) {
        Solution1154 solution1154 = new Solution1154();
        int days = solution1154.dayOfYear("2004-03-01");
        System.out.println(days);
    }
}
