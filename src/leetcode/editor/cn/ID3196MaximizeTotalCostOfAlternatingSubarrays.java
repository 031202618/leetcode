package leetcode.editor.cn;

public class ID3196MaximizeTotalCostOfAlternatingSubarrays {

    public static void main(String[] args) {
        Solution solution = new ID3196MaximizeTotalCostOfAlternatingSubarrays().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long maximumTotalCost(int[] nums) {
            //nums[i] >= 0 --- dp[i] = dp[i-1] + nums[i];
            // < 0 --- dp[i] = dp[i-2] - nums[i-1] + nums[i], dp[i];
            long[] dp = new long[nums.length + 1];
            for (int i = 1; i <= nums.length; i++) {
                dp[i] = dp[i - 1] + nums[i - 1];
                if (i >= 2 && nums[i - 1] < 0) {
                    dp[i] = Math.max(dp[i], dp[i - 2] + nums[i - 2] - nums[i - 1]);
                }
            }
            return dp[nums.length];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 