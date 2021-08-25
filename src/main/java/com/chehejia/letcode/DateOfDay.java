package com.chehejia.letcode;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @Author: zhangwbin
 * @Date: 2020/4/5
 */
public class DateOfDay {

  public int dayOfYear(String date) {
    Calendar calendar = Calendar.getInstance();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    try {
      calendar.setTime(dateFormat.parse(date));
      return calendar.get(Calendar.DAY_OF_YEAR);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return 0;
  }
}
