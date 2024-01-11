package day4_Spiralmatrix;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 */
public class Solution15 {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> res = new ArrayList<Integer>();
        int startRow = 0;
        int endRow = matrix.length - 1;
        int startCol = 0;
        int endCol = matrix[0].length - 1;

        while (startRow <= endRow && startCol <= endCol) {
            // 从左到右遍历上边界
            for (int j = startCol; j <= endCol; j++) {
                res.add(matrix[startRow][j]);
            }

            // 从上到下遍历右边界
            for (int i = startRow + 1; i <= endRow; i++) {
                res.add(matrix[i][endCol]);
            }

            // 确保存在下边界
            if (startRow < endRow) {
                // 从右到左遍历下边界
                for (int j = endCol - 1; j >= startCol; j--) {
                    res.add(matrix[endRow][j]);
                }
            }

            // 确保存在左边界
            if (startCol < endCol) {
                // 从下到上遍历左边界
                for (int i = endRow - 1; i > startRow; i--) {
                    res.add(matrix[i][startCol]);
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
