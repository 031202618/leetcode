package leetcode.editor.cn;

import java.util.Arrays;

public class ID1262GreatestSumDivisibleByThree {

    public static void main(String[] args) {
        Solution solution = new ID1262GreatestSumDivisibleByThree().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        solution.maxSumDivThree(new int[]{3, 6, 5, 1, 8});
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maxSumDivThree(int[] nums) {
            int[] dp = new int[3];
            Arrays.fill(dp, Integer.MIN_VALUE);
            for (int num : nums) {
                int mod = num % 3;
                int[] tmp = Arrays.copyOf(dp, 3);
                for (int i = 0; i < 3; i++) {
                    int target = (mod + i) % 3;
                    if(tmp[i] != Integer.MIN_VALUE) {
                        dp[target] = Math.max(dp[target], tmp[i] + num);
                    }
                }
                dp[mod] = Math.max(dp[mod], num);
            }
            return dp[0] == Integer.MIN_VALUE ? 0 : dp[0];
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


} 