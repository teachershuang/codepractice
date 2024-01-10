package com.teachershuang.RemovingElements;

/**
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 * 示例 2：
 * <p>
 * 输入：nums = [-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 */
public class Solution10 {
    public int[] sortedSquares(int[] nums) {
        int leftPointer = 0;
        int rightPointer = nums.length - 1;
        int i = nums.length - 1;
        int[] res = new int[nums.length];
        while (leftPointer <= rightPointer) {
            int num1 = nums[leftPointer] * nums[leftPointer];
            int num2 = nums[rightPointer] * nums[rightPointer];
            if (num1 >= num2) {
                res[i] = num1;
                leftPointer++;
            }else {
                res[i] = num2;
                rightPointer--;
            }
            i--;
        }
        return res;
    }
}
