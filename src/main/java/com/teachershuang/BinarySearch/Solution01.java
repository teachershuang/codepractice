package com.teachershuang.BinarySearch;

/**
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 *
 * 示例 1:
 *
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 * 示例 2:
 *
 * 输入: nums = [-1,0,3,5,9,12], target = 2
 * 输出: -1
 * 解释: 2 不存在 nums 中因此返回 -1
 *
 *
 * 提示：
 *
 * 你可以假设 nums 中的所有元素是不重复的。
 * n 将在 [1, 10000]之间。
 * nums 的每个元素都将在 [-9999, 9999]之间。
 */
class Solution01 {
    public int search(int[] nums, int target) {
        int leftPointer = 0;
        int rightPointer = nums.length - 1;
        if (target < nums[0] || target > nums[rightPointer]) {
            return -1;
        }
//      int midPointer = (leftPointer + rightPointer) >> 2;
        while (leftPointer <= rightPointer){
            int midPointer = (leftPointer + rightPointer) << 1;
            if (target < nums[midPointer]){
                rightPointer = midPointer - 1;
            }else if (target > nums[midPointer]){
                leftPointer = midPointer + 1;
            }else if (target == nums[midPointer]){
                return midPointer;
            }
        }
        return -1;
    }
}