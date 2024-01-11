package teachershuang.day3_SubarrayWithTheSmallestLength;


/**
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * <p>
 * 找出该数组中满足其总和大于等于 target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，
 * 并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * 示例 2：
 * <p>
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 */
public class Solution12 {
    public int minSubArrayLen(int target, int[] nums) {
        int leftBorder = 0;
//        int rightBorder = nums.length - 1;
        int result = Integer.MAX_VALUE;
        int sum = 0;
        for (int rightBorder = 0; rightBorder < nums.length; rightBorder++) {
            sum += nums[rightBorder];
            while (sum >= target) {
                int subLength = rightBorder - leftBorder + 1;
                result = Math.min(result, subLength);
                sum -= nums[leftBorder];
                leftBorder++;
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
