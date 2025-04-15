package leetcode.editor.cn;

import java.util.Arrays;

public class ID3077MaximumStrengthOfKDisjointSubarrays {

    public static void main(String[] args) {
        Solution solution = new ID3077MaximumStrengthOfKDisjointSubarrays().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        System.out.println(solution.maximumStrength(new int[]{1, 2, 3, -1, 2}, 3));
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long maximumStrength(int[] nums, int k) {
            //dp[k][n] = max(dp[k][n-1], dp[k-1][n-x] + sum() * (k))
            long[] prefix = new long[nums.length + 2];
            for (int i = nums.length; i >= 1; i--) {
                prefix[i] = prefix[i + 1] + nums[i - 1];
            }
            long[] dp1 = new long[nums.length + 2];
            long[] dp2;
            for (int i = 1; i <= k; i++) {
                dp2 = new long[nums.length + 2];
                Arrays.fill(dp2, Long.MIN_VALUE / 2);
                long basic;
                if ((i & 1) == 1) {
                    basic = i;
                } else {
                    basic = -i;
                }
                long max = Long.MIN_VALUE;
                for (int j = nums.length - i + 1; j > 0; j--) {
                    max = Math.max(max, dp1[j + 1] - basic * prefix[j + 1]);
                    dp2[j] = Math.max(dp2[j + 1], basic * prefix[j] + max);
                }
                dp1 = dp2;
            }
            return dp1[1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 