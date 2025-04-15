package leetcode.editor.cn;

public class ID1955CountNumberOfSpecialSubsequences {

    public static void main(String[] args) {
        Solution solution = new ID1955CountNumberOfSpecialSubsequences().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public static final int MOD = 1_000_000_007;

        public int countSpecialSubsequences(int[] nums) {
            int[] dp = new int[3];
            for (int num : nums) {
                long zero = dp[0];
                long one = dp[1];
                long two = dp[2];
                if (num == 0) {
                    dp[0] = (int)(2 * zero + 1);
                    dp[0] %= MOD;
                } else if (num == 1) {
                    dp[1] = (int)((2 * one) % MOD + zero);
                    dp[1] %= MOD;
                } else {
                    dp[2] = (int)((2 * two) % MOD + one);
                    dp[2] %= MOD;
                }
            }
            return dp[2];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 