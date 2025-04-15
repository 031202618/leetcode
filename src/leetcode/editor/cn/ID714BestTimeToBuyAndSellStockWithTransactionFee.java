package leetcode.editor.cn;

public class ID714BestTimeToBuyAndSellStockWithTransactionFee {

    public static void main(String[] args) {
        Solution solution = new ID714BestTimeToBuyAndSellStockWithTransactionFee().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices, int fee) {
            // dp[i][0] = dp[i-1][1] + prices[i] - fee, dp[i-1][0]
            // dp[i][1] = dp[i-1][1], dp[i-1][0] - prices[i];

            //j == 0, dp[i][j] = dp[i-1][j+1], dp[i-1][j]
            //j == 1, dp[i][j] = dp[i-1][j], dp[i-1][j-1]
            int notHave = 0;
            int have = Integer.MIN_VALUE;
            for (int price : prices) {
                if (have != Integer.MIN_VALUE) {
                    notHave = Math.max(notHave, have + price - fee);
                }
                have = Math.max(have, notHave - price);
            }
            return notHave;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 