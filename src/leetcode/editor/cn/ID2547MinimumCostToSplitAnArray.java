package leetcode.editor.cn;

import java.util.Arrays;

public class ID2547MinimumCostToSplitAnArray {

    public static void main(String[] args) {
        Solution solution = new ID2547MinimumCostToSplitAnArray().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minCost(int[] nums, int k) {
            int[][] len = new int[nums.length][nums.length];
            for (int i = 0; i < nums.length; i++) {
                int[] set = new int[nums.length + 1];
                set[nums[i]] = 1;
                int total = 0;
                for (int j = i + 1; j < nums.length; j++) {
                    if (set[nums[j]] == 1) {
                        total += 2;
                    } else if (set[nums[j]] > 1) {
                        total++;
                    }
                    set[nums[j]]++;
                    len[i][j] = total;
                }
            }
            int[] dp = new int[nums.length + 1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;
            for (int i = 1; i <= nums.length; i++) {
                for (int j = i; j >= 1; j--) {
                    dp[i] = Math.min(dp[i], len[j - 1][i - 1] + k + dp[j - 1]);
                }
            }
            return dp[nums.length];
        }


    }
//leetcode submit region end(Prohibit modification and deletion)


} 