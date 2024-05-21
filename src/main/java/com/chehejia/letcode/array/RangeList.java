package com.chehejia.letcode.array;

import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * @Description
 * @Author zhangwenbin1
 * @Date 2022/5/14 10:31 PM
 **/
class RangeList {
    /**
     * Adds a range to the list
     * @param {Array<number>} range - Array of two integers that specify
    beginning and end of range.
     */
    private SortedSet<Integer[]> ans;
    public RangeList() {
        ans = new TreeSet<>((o1, o2) -> o1[0] - o2[0]);
    }
    public void add(Integer[] range) {
        if (CollectionUtils.isEmpty(ans)) {
            ans.add(range);
            return;
        }
        List<Integer[]> removeList = new ArrayList<>();
        for (Integer[] a : ans) {
            // 如果新插入的最小值比当前最大还大，跳过
            if (a[1] < range[0]) {
                continue;
            } else if (a[0] <= range[1]) {
                // 如果新插入的值的最大值大于等于当前最小值，说明需要合并区间
                range[0] = Math.min(a[0], range[0]);
                range[1] = Math.max(a[1], range[1]);
                if (range[0] == a[0] && range[1] == a[1]) {
                    return;
                }
                if (range[0] == a[0] && range[1] > a[1]) {
                    removeList.add(a);
                }
            }
        }
        if (!removeList.isEmpty()) {
            ans.removeAll(removeList);
        }
        ans.add(range);
    }
    /**
     * Removes a range from the list
     * @param {Array<number>} range - Array of two integers that specify
    beginning and end of range.
     */
    public void remove(Integer[] range) {
        int m = range[0];
        int n = range[1];
        List<Integer[]> res = new ArrayList<>();
        List<Integer[]> remove = new ArrayList<>();
        for (Integer[] a : ans) {
            int left = a[0];
            int right = a[1];
            if(left < m && right > m && right <= n) {
                // 当前最小值小于删除最小值，当前最大值大于删除最小值，当前最大值小于删除最大值
                res.add(new Integer[]{left, m});
                remove.add(a);
            } else if(left < m && right > n) {
                remove.add(a);
                res.add(new Integer[]{left, m});
                res.add(new Integer[]{n, right});
            } else if(left >= m && left <= n && right > n) {
                remove.add(a);
                res.add(new Integer[]{n, right});
            } else if (left >= m && right <= n) {
                remove.add(a);
            }
        }
        if (!remove.isEmpty()) {
            ans.removeAll(remove);
        }
        ans.addAll(res);
    }
    /**
     * Prints out the list of ranges in the range list
     */
    public void print() {
        // TODO: implement this
        for (Integer[] a : ans) {
            System.out.print(Arrays.toString(a) + " ");
        }
    }

    public static void main(String[] args) {
        RangeList rangeList = new RangeList();
        rangeList.add(new Integer[]{1, 5});
        rangeList.print();
        System.out.println("");
        rangeList.add(new Integer[]{10, 20});
        rangeList.print();
        System.out.println("");
        rangeList.add(new Integer[]{20, 20});
        rangeList.print();
        System.out.println("");
        rangeList.add(new Integer[]{20, 21});
        rangeList.print();
        System.out.println("");
        rangeList.add(new Integer[]{2, 4});
        rangeList.print();
        System.out.println("");
        rangeList.add(new Integer[]{3, 8});
        rangeList.print();
        System.out.println("");
        rangeList.remove(new Integer[]{10, 10});
        rangeList.print();
        System.out.println("");
        rangeList.remove(new Integer[]{10, 11});
        rangeList.print();
        System.out.println("");
        rangeList.remove(new Integer[]{15, 17});
        rangeList.print();
        System.out.println("");
        rangeList.remove(new Integer[]{3, 19});
        rangeList.print();
    }
}
//}
//// Example run
//const rl = new RangeList();
//        rl.add([1, 5]);
//        rl.print();
//// Should display: [1, 5)
//        rl.add([10, 20]);
//        rl.print();
//// Should display: [1, 5) [10, 20)
//        rl.add([20, 20]);
//        rl.print();
//// Should display: [1, 5) [10, 20)
//        rl.add([20, 21]);
//        rl.print();
//// Should display: [1, 5) [10, 21)
//        rl.add([2, 4]);
//        rl.print();
//// Should display: [1, 5) [10, 21)
//        rl.add([3, 8]);
//        rl.print();
//// Should display: [1, 8) [10, 21)
//        rl.remove([10, 10]);
//        rl.print();
//// Should display: [1, 8) [10, 21)
//        rl.remove([10, 11]);
//        rl.print();
//// Should display: [1, 8) [11, 21)
//        rl.remove([15, 17]);
//        rl.print();
//// Should display: [1, 8) [11, 15) [17, 21)
//        rl.remove([3, 19]);
//        rl.print();
//// Should display: [1, 3) [19, 21)
