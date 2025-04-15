package leetcode.editor.cn;

public class ID123BestTimeToBuyAndSellStockIii {

    public static void main(String[] args) {
        Solution solution = new ID123BestTimeToBuyAndSellStockIii().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        solution.maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4});
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            //dp[i][j][0] = dp[i-1][j-1][1] + prices[i], dp[i-1][j][0]
            //dp[i][j][1] = dp[i-1][j][1] , dp[i-1][j][0] - prices[i]
            int k = 2;

            int[][][] dp = new int[prices.length + 1][k + 1][2];
            for (int i = 1; i < prices.length + 1; i++) {
                for (int j = 0; j <= k; j++) {
                    dp[i][j][0] = Integer.MIN_VALUE;
                    dp[i][j][1] = Integer.MIN_VALUE;
                }
            }
            dp[1][0][1] = -prices[0];
            int ret = 0;
            for (int i = 2; i <= prices.length; i++) {
                for (int j = 0; j <= k; j++) {
                    if (j == 0) {
                        dp[i][j][0] = 0;
                        dp[i][j][1] = Math.max(dp[i - 1][j][1], -prices[i - 1]);
                    } else {
                        dp[i][j][0] = dp[i - 1][j][0];
                        if (dp[i - 1][j - 1][1] != Integer.MIN_VALUE) {
                            dp[i][j][0] = Math.max(dp[i][j][0], dp[i - 1][j - 1][1] + prices[i - 1]);
                        }
                        dp[i][j][1] = dp[i - 1][j][1];
                        if (dp[i - 1][j][0] != Integer.MIN_VALUE) {
                            dp[i][j][1] = Math.max(dp[i][j][1], dp[i - 1][j][0] - prices[i - 1]);
                        }
                    }
                    ret = Math.max(ret, dp[i][j][0]);
                }
            }

            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 