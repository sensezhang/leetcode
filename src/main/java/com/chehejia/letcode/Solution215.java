package com.chehejia.letcode;

/**
 * 数组中第K个最大的元素
 * 不是第K个不同的元素
 * [3, 2, 1, 5, 6, 4] k = 2
 * 输出5
 * [3, 2, 3, 1, 2, 4, 5, 5, 6] k = 4
 * 输出4
 * @Author: zhangwbin
 * @Date: 2020/6/29
 */
public class Solution215 {

  public int findKthLargest(int[] nums, int k) {
    int len = nums.length;
    int left = 0;
    int right = len - 1;

    //转换一下目标值的下标
    int target = len - k;
    while (true) {
      int index = partition(nums, left, right);
      if (index == target) {
        return nums[index];
      } else if (index < target) {
        left = index + 1;
      } else {
        right = index - 1;
      }
    }
  }

  /**
   * 在数组nums的子区间[left ,right] 执行partition操作，返回nums[left]排序以后应该在的位置
   * 所有左边的元素都小于该值，所有右边的元素都大于该值
   * @param nums
   * @param left
   * @param right
   * @return
   */
  private int partition(int[] nums, int left, int right) {
    int i = left;
    int valt = nums[left];
    for (int j = left + 1; j <= right; j++) {
      if (nums[j] < valt) {
        i++;
        swap(nums, i, j);
      }
    }
    swap(nums, i, left);
    return i;
  }

  private void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }

  public static void main(String[] args) {
    Solution215 solution215 = new Solution215();
    int result = solution215.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4);
    System.out.println(result);
  }

}
