package com.teachershuang.BinarySearch;

/**
 * 给你一个正整数 num 。如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 * <p>
 * 完全平方数 是一个可以写成某个整数的平方的整数。换句话说，它可以写成某个整数和自身的乘积。
 * <p>
 * 不能使用任何内置的库函数，如  sqrt 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = 16
 * 输出：true
 * 解释：返回 true ，因为 4 * 4 = 16 且 4 是一个整数。
 * 示例 2：
 * <p>
 * 输入：num = 14
 * 输出：false
 * 解释：返回 false ，因为 3.742 * 3.742 = 14 但 3.742 不是一个整数。
 */
public class Solution05 {
    public boolean isPerfectSquare(int num) {
        if (num == 0){
            return true;
        }
        int left = 1;
        int right = num;
        while (left <= right){
            int mid = (left + right) >> 1;
            if (mid * mid == num){
                return true;
            }else if (mid < num/mid){
                left = mid + 1;
            }else if (mid > num/mid){
                right = mid - 1;
            }else {
                return false;
            }
        }
        return false;
    }
}
