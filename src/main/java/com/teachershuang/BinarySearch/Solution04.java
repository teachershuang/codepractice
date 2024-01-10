package com.teachershuang.BinarySearch;

/**
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 * <p>
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 * <p>
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 4
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：x = 8
 * 输出：2
 * 解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
 */
public class Solution04 {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int leftPoint = 1;
        int rightPoint = x;
        while (leftPoint <= rightPoint) {
            int mid = (leftPoint + rightPoint) >> 1;
            if (mid <= x / mid && (mid + 1) > x / (mid + 1)) {
            return mid;
            } else if (mid < x/mid) {
                leftPoint = mid;
            }else{
                rightPoint = mid;
            }
        }
        return 0;
    }
}
