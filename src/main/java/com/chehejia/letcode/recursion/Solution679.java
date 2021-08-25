package com.chehejia.letcode.recursion;

/**
 * @Author: zhangwbin
 * @Date: 2020/8/22
 */
public class Solution679 {

  public boolean judgePoint24(int[] nums) {
    Double[] doNums = new Double[nums.length];
    for (int i = 0; i < nums.length; i++) {
      doNums[i] = (double) nums[i];
    }
    return solve(doNums);
  }

  private boolean solve(Double[] doNums) {
    if (doNums.length == 1) {
      return doNums[0] >= 23.99 && doNums[0] <= 24.01;
    }
    for (int i = 0; i < doNums.length - 1; i++) {
      for (int j = i + 1; j < doNums.length; j++) {
        boolean isSolve = false;
        Double[] temp = new Double[doNums.length - 1];

        System.arraycopy(doNums, 0, temp, 0, j);
        System.arraycopy(doNums, j, temp, j, temp.length);

        temp[i] = doNums[i] + doNums[j];
        isSolve = isSolve || solve(temp);
        temp[i] = doNums[i] - doNums[j];
        isSolve = isSolve || solve(temp);
        temp[i] = doNums[j] - doNums[i];
        isSolve = isSolve || solve(temp);
        temp[i] = doNums[i] * doNums[j];
        isSolve = isSolve || solve(temp);
        temp[i] = doNums[i] / doNums[j];
        isSolve = isSolve || solve(temp);
        temp[i] = doNums[j] / doNums[i];
        isSolve = isSolve || solve(temp);

        if (isSolve) {
          return true;
        }
      }
    }
    return false;
  }
}
