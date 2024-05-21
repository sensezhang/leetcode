package com.chehejia.letcode;

/**
 * @Description
 * @Author zhangwenbin1
 * @Date 2022/8/22 10:21 AM
 **/
public class Solution1344 {
//    public double angleClock(int hour, int minutes, int second) {
//        // 时针走一格是5°
//        // 分针每走一格的度数是6°
//        // 秒针每走一格是6°
//        double hourOneAngle = 30;
//        double minutesOneAngle = 6;
//        double minutesAngle = (minutes + second / 60) * minutesOneAngle;
//
//        double hourAngle = ((hour % 12) + (minutes / 60.0) + (second / 3600.0)) * hourOneAngle;
//        double angle = Math.abs(hourAngle - minutesAngle);
//        return Math.min(angle, 360 - angle);
//    }

    public double angleClock(int hour, int minutes, int second) {
        //时针的角度
        double r1=hour*30+(double)minutes/60*30 + (double)second/3600*30;
        double r2=(minutes + (second / 60.0)) *6;
        return Math.min(Math.abs(r1-r2),Math.abs(360-Math.abs(r1-r2)));
    }
    public static void main(String[] args) {
        Solution1344 solution1344 = new Solution1344();
        System.out.println(solution1344.angleClock(14, 57, 20));
    }
}
