package day2_RemovingElements;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 示例 2:
 *
 * 输入: nums = [0]
 * 输出: [0]
 */
public class Solution08 {

    public void moveZeroes(int[] nums) {
        int fastPointer = 0, slowPointer = 0;
        while (fastPointer < nums.length) {
//            nums[slowPointer] = nums[fastPointer];
            if (nums[fastPointer] != 0) {
                nums[slowPointer] = nums[fastPointer];
                slowPointer++;
            }
            fastPointer++;
        }
        while (slowPointer < nums.length){
            nums[slowPointer] = 0;
            slowPointer++;
        }
    }


}
