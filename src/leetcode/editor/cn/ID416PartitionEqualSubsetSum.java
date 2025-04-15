package leetcode.editor.cn;

import java.util.Arrays;

public class ID416PartitionEqualSubsetSum {

    public static void main(String[] args) {
        Solution solution = new ID416PartitionEqualSubsetSum().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canPartition(int[] nums) {
            int sum = Arrays.stream(nums).sum();
            if ((sum & 1) == 1) {
                return false;
            }
            sum >>= 1;
            int maxi = 0;
            boolean[] dp = new boolean[sum + 1];
            dp[0] = true;
            for (int i = 0; i < nums.length; i++) {
                for (int j = Math.min(maxi + nums[i], sum); j >= nums[i]; j--) {
                    dp[j] |= dp[j - nums[i]];
                    if (dp[j]) {
                        maxi = Math.max(j, maxi);
                    }
                }
            }
            return dp[sum];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 