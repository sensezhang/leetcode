package com.chehejia.letcode;

/**
 * 寻找旋转点
 * @Author: zhangwbin
 * @Date: 2020/6/11
 */
public class FindTurnIndex {

  public int findTurnIndex(int[] nums) {
    // 如果数组为空或最左边的元素小于等于最右边的元素，说明数组是单调递增的，或者只有一个元素，没有找到旋转的位置，返回-1
    if (nums == null || nums[0] <= nums[nums.length - 1]) {
      return -1;
    }
    int left = 0;
    int right = nums.length - 1;
    // 开始二分查找
    while (left <= right) {
      int mid = (left + right) / 2;
      // 如果中间元素位置是0，说明数组最多只有2个元素，如果右边元素比左边元素小，说明右边元素是旋转点
      if (mid == 0 && nums[mid + 1] < nums[mid]) {
        return mid + 1;
      }
      // 因为二分查找只能接近左临界点，右临界点不会到头，所以可以直接判断如果中间大于左边，
      // 并且中间大于右边，说明中间这个位置是数组最大值的位置，旋转点是mid+1
      else if ((mid - 1 >= 0 && nums[mid] > nums[mid - 1]) && (mid + 1 <= nums.length - 1
          && nums[mid] > nums[mid + 1])) {
        return mid + 1;
      } else if (nums[0] < nums[mid]) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    FindTurnIndex findTurnIndex = new FindTurnIndex();
    int[] nums = new int[]{2,3,1};
    int index = findTurnIndex.findTurnIndex(nums);
    System.out.println("期望结果：2，实际结果：" + index);
    nums = new int[]{4, 5, 6, 7, 0, 1, 2};
    index = findTurnIndex.findTurnIndex(nums);
    System.out.println("期望结果：4，实际结果：" + index);
    nums = new int[]{7, 0};
    index = findTurnIndex.findTurnIndex(nums);
    System.out.println("期望结果：1，实际结果：" + index);
  }
}
