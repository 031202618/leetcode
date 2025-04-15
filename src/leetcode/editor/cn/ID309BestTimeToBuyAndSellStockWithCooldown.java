package leetcode.editor.cn;

public class ID309BestTimeToBuyAndSellStockWithCooldown {

    public static void main(String[] args) {
        Solution solution = new ID309BestTimeToBuyAndSellStockWithCooldown().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            //dp[i][0] = dp[i-1][1] + prices[i-1]
            //dp[i][1] = dp[i-1][0], dp[i-1][1]
            //dp[i][2] = dp[i-1][2], dp[i-1][1] - prices[i-1]
            int[][] dp = new int[prices.length + 1][3];
            dp[0][0] = Integer.MIN_VALUE;
            dp[0][1] = 0;
            dp[0][2] = Integer.MIN_VALUE;
            for (int i = 1; i <= prices.length; i++) {
                dp[i][0] = Integer.MIN_VALUE;
                if (dp[i - 1][2] != Integer.MIN_VALUE) {
                    dp[i][0] = dp[i - 1][2] + prices[i - 1];
                }
                dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1]);
                dp[i][2] = dp[i - 1][2];
                if (dp[i - 1][1] != Integer.MIN_VALUE) {
                    dp[i][2] = Math.max(dp[i][2], dp[i - 1][1] - prices[i - 1]);
                }
            }
            return Math.max(dp[prices.length][0], dp[prices.length][1]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 