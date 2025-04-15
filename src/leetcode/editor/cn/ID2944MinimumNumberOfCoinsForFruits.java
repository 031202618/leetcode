package leetcode.editor.cn;

import java.util.Arrays;

public class ID2944MinimumNumberOfCoinsForFruits {

    public static void main(String[] args) {
        Solution solution = new ID2944MinimumNumberOfCoinsForFruits().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        //66
        //63
        solution.minimumCoins(new int[]{14, 37, 37, 38, 24, 15, 12});
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumCoins(int[] prices) {
            //get [i + 1, i + i] , i start from 1.
            //dp[i][0] = dp[i + 1] ... dp[i + i]
            int n = prices.length;
            int[] dp = new int[n + 1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[n] = prices[n - 1];
            for (int i = n - 1; i > 0; i--) {
                dp[i] = prices[i - 1] + (i + i + 1 > n ? 0 : dp[i + i + 1]);
                for (int j = i + 1; j <= Math.min(i + i, n); j++) {
                    dp[i] = Math.min(dp[i], dp[j] + prices[i-1]);
                }
            }
            return dp[1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 