package leetcode.editor.cn;

public class ID1594MaximumNonNegativeProductInAMatrix {

    public static void main(String[] args) {
        Solution solution = new ID1594MaximumNonNegativeProductInAMatrix().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        solution.maxProductPath(new int[][]{{-1, 3, 0}, {3, -2, 3}, {-1, 1, -4}});
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        static final int MOD = 1_000_000_007;

        Long[][][] cache;
        int[][] grid;
        int r;
        int c;

        public int maxProductPath(int[][] grid) {
            //dp[i][j][0] = Math.max(dp[i-1][j][0] * grid[i][j], dp[i][j-1][0] * grid[i][j], dp[i-1][j][1] * grid[i][j], .)
            //dp[i][j][1] = Math.min(dp[i-1][j][0] * grid[i][j], dp[i][j-1][0] * grid[i][j], dp[i-1][j][1] * grid[i][j], .)
            long[][] dp = new long[grid[0].length][2];
            dp[0][0] = dp[0][1] = grid[0][0];
            for (int i = 1; i < grid[0].length; i++) {
                dp[i][0] = dp[i][1] = (grid[0][i] * dp[i - 1][0]);
            }
            for (int i = 1; i < grid.length; i++) {
                dp[0][0] = dp[0][1] = dp[0][0] * grid[i][0];
                for (int j = 1; j < grid[i].length; j++) {
                    long a0 = dp[j][0] * grid[i][j];
                    long a1 = dp[j][1] * grid[i][j];
                    long b0 = dp[j - 1][0] * grid[i][j];
                    long b1 = dp[j - 1][1] * grid[i][j];
                    dp[j][0] = Math.min(Math.min(a0, a1), Math.min(b0, b1));
                    dp[j][1] = Math.max(Math.max(a0, a1), Math.max(b0, b1));
                }
            }
            long maxi = -1;
            maxi = Math.max(maxi, dp[grid[0].length - 1][1]);
            if (maxi == -1) {
                return -1;
            }
            return (int) (maxi % 1_000_000_007);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


} 