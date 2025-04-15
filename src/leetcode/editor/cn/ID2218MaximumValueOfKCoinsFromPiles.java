package leetcode.editor.cn;

import java.util.Arrays;
import java.util.List;

public class ID2218MaximumValueOfKCoinsFromPiles {

    public static void main(String[] args) {
        Solution solution = new ID2218MaximumValueOfKCoinsFromPiles().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        solution.maxValueOfCoins(List.of(List.of(1, 100, 3), List.of(7, 8, 9)), 2);
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxValueOfCoins(List<List<Integer>> piles, int k) {
            // a b c
            // d e
            // dp[i][k] = dp[i-1][k-1] + p[i], dp[i-1][k-2] + p[1] + p[2], ... dp[i-1][k-arr[i]]
            int[] dp = new int[k + 1];
            Arrays.fill(dp, Integer.MIN_VALUE);
            dp[0] = 0;
            for (List<Integer> pile : piles) {
                int[] prefix = new int[pile.size() + 1];
                for (int i = 1; i <= pile.size(); i++) {
                    prefix[i] = prefix[i - 1] + pile.get(i - 1);
                }
                for (int i = k; i >= 0; i--) {
                    for (int j = 1; j <= pile.size() && i - j >= 0; j++) {
                        if (dp[i - j] != Integer.MIN_VALUE) {
                            dp[i] = Math.max(dp[i], prefix[j] + dp[i - j]);
                        }
                    }
                }
            }
            return dp[k];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 