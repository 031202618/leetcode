package leetcode.editor.cn;

public class ID871MinimumNumberOfRefuelingStops {

    public static void main(String[] args) {
        Solution solution = new ID871MinimumNumberOfRefuelingStops().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        System.out.println(solution.minRefuelStops(100, 50, new int[][]{{25, 25}, {50, 50}}));
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minRefuelStops(int target, int startFuel, int[][] stations) {
            int n = stations.length;
            if (startFuel >= target) {
                return 0;
            }
            int[][] dp = new int[n + 1][n + 1];
            //dp[n][k] = Math.max(dp[n-1][k-1] + stations[n][1], dp[n-1][k])
            dp[0][0] = startFuel;
            int ret = Integer.MAX_VALUE;
            for (int i = 1; i <= n; i++) {
                dp[i][0] = startFuel;
                int pos = stations[i - 1][0];
                int fuel = stations[i - 1][1];
                for (int j = 1; j <= i; j++) {
                    dp[i][j] = dp[i - 1][j];
                    if (dp[i - 1][j - 1] >= pos) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + fuel);
                    }

                    if (dp[i][j] >= target) {
                        ret = Math.min(ret, j);
                    }
                }
            }
            return ret == Integer.MAX_VALUE ? -1 : ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 