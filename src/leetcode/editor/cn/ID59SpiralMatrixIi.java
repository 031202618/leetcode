package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class ID59SpiralMatrixIi {

    public static void main(String[] args) {
        Solution solution = new ID59SpiralMatrixIi().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        solution.generateMatrix(4);
        List<Integer> list = new ArrayList<>();
        System.out.println(list.contains(null));
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] generateMatrix(int n) {
            if (n == 1) return new int[][]{{1}};
            int first = 1;
            int v = 1;
            boolean odd = ((n & 1) == 1);
            int[][] matrix = new int[n][n];
            int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            int step = 0;
            while (true) {
                int go = n - first;
                int row = step;
                int col = step;
                if (go <= 0) {
                    if (odd) {
                        matrix[row][col] = v;
                    }
                    break;
                }
                for (int i = 0; i < 4; i++) {
                    int[] di = dir[i];
                    for (int j = 0; j < go; j++) {
                        matrix[row][col] = v++;
                        row += di[0];
                        col += di[1];
                    }
                }
                first += 2;
                step++;
            }
            return matrix;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 