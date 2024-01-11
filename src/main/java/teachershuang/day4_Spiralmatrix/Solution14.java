package teachershuang.day4_Spiralmatrix;

/**
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：[[1]]
 */
public class Solution14 {
    public int[][] generateMatrix(int n) {
        //有点复杂，在遇到这种需要多个循环的情况中，需要确定循环的边界值，从每一次螺旋，每一个边都要具有相同的数量
        int loopTime = 1;
        int[][] res = new int[n][n];
        int start = 0;
        int count = 1;
        int i,j;
        while (loopTime <= n / 2){
            for (j = start; j < n - loopTime; j++){
                res[start][j] = count;
                count++;
            }
            for (i = start; i < n - loopTime; i++){
                res[i][j] = count;
                count++;
            }
            for (;j > start; j--){
                res[i][j] = count;
                count++;
            }
            for (;i > start; i--){
                res[i][j] = count;
                count++;
            }
            start++;
            loopTime++;
        }
        if (n % 2 == 1) {
            res[n/2][n/2] = n*n;
        }
        return res;
    }
}
