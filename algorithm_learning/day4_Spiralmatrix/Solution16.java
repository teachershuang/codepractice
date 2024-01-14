package day4_Spiralmatrix;

/**
 * 给定一个二维数组 array，请返回「螺旋遍历」该数组的结果。
 * <p>
 * 螺旋遍历：从左上角开始，按照 向右、向下、向左、向上 的顺序 依次 提取元素，然后再进入内部一层重复相同的步骤，直到提取完所有元素。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：array = [[1,2,3],[8,9,4],[7,6,5]]
 * 输出：[1,2,3,4,5,6,7,8,9]
 * 示例 2：
 * <p>
 * 输入：array  = [[1,2,3,4],[12,13,14,5],[11,16,15,6],[10,9,8,7]]
 * 输出：[1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16]
 */
public class Solution16 {
    public int[] spiralArray(int[][] matrix) {
        if ((matrix == null || matrix.length == 0) || (matrix.length == 1 && matrix[0].length == 0)) {
            return new int[0];
        }
        int[] res = new int[matrix.length * matrix[0].length];
        int startRow = 0;
        int endRow = matrix.length - 1;
        int startCol = 0;
        int endCol = matrix[0].length - 1;
        int count = 0;

        while (startRow <= endRow && startCol <= endCol) {
            // 从左到右遍历上边界
            for (int j = startCol; j <= endCol; j++) {
                res[count] = matrix[startRow][j];
                count++;
            }

            // 从上到下遍历右边界
            for (int i = startRow + 1; i <= endRow; i++) {
                res[count] = matrix[i][endCol];
                count++;
            }

            // 确保存在下边界
            if (startRow < endRow) {
                // 从右到左遍历下边界
                for (int j = endCol - 1; j >= startCol; j--) {
                    res[count] = matrix[endRow][j];
                    count++;
                }
            }

            // 确保存在左边界
            if (startCol < endCol) {
                // 从下到上遍历左边界
                for (int i = endRow - 1; i > startRow; i--) {
                    res[count] = matrix[i][startCol];
                    count++;
                }
            }

            startRow++;
            endRow--;
            startCol++;
            endCol--;
        }

        return res;
    }
}
