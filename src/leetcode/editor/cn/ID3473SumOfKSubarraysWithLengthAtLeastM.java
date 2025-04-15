package leetcode.editor.cn;

import java.util.Arrays;

public class ID3473SumOfKSubarraysWithLengthAtLeastM {

    public static void main(String[] args) {
        Solution solution = new ID3473SumOfKSubarraysWithLengthAtLeastM().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSum(int[] nums, int k, int m) {
            //dp[k][n] = dp[k][n-1], dp[k-1][n-m], dp[k-1][n-m-1]...
            int n = nums.length;
            int[] dp = new int[n + 1];

            int[] prefix = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                prefix[i] = prefix[i - 1] + nums[i - 1];
            }

            int[] dp2 = new int[n + 1];

            for (int i = 1; i <= k; i++) {

                Arrays.fill(dp2, Integer.MIN_VALUE / 2);
                int mx = Integer.MIN_VALUE / 2;
                // n -(k - i) * m ==  + x
                for (int j = m * i; j <= n - (k - i) * m; j++) {
                    mx = Math.max(mx, dp[j - m] - prefix[j - m]);
                    dp2[j] = Math.max(dp2[j - 1], prefix[j] + mx);
                }
                System.arraycopy(dp2, 0, dp, 0, dp.length);
            }

            return dp[n];
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


} 