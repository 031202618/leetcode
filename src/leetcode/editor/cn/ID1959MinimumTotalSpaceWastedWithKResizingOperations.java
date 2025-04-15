package leetcode.editor.cn;

import java.util.Arrays;

public class ID1959MinimumTotalSpaceWastedWithKResizingOperations {

    public static void main(String[] args) {
        Solution solution = new ID1959MinimumTotalSpaceWastedWithKResizingOperations().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        //10
//        System.out.println(solution.minSpaceWastedKResizing(new int[]{10, 20}, 0));
        //10
        System.out.println(solution.minSpaceWastedKResizing(new int[]{10, 20, 30}, 1));
        //15
        System.out.println(solution.minSpaceWastedKResizing(new int[]{10, 20, 15, 30, 20}, 2));
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minSpaceWastedKResizing(int[] nums, int k) {
            int[] dp = new int[nums.length + 1];
            int[] dp2 = new int[nums.length + 1];
            int max = Integer.MIN_VALUE;
            int sum = 0;
            int cnt = 0;
            for (int i = 1; i <= nums.length; i++) {
                max = Math.max(max, nums[i - 1]);
                sum += nums[i - 1];
                cnt++;
                dp[i] = max * cnt - sum;
            }
            for (int i = 1; i <= k; i++) {
                Arrays.fill(dp2, Integer.MAX_VALUE / 2);
                for (int j = 1; j <= nums.length; j++) {
                    max = Integer.MIN_VALUE;
                    sum = 0;
                    cnt = 0;
                    for (int l = j; l >= 1; l--) {
                        max = Math.max(max, nums[l - 1]);
                        sum += nums[l - 1];
                        cnt++;
                        dp2[j] = Math.min(dp2[j], dp[l - 1] + max * cnt - sum);
                    }
                }
                System.arraycopy(dp2, 0, dp, 0, dp2.length);
            }
//            for (int i = 1; i <= k; i++) {
//                Arrays.fill(dp2, Integer.MAX_VALUE / 2);
//                max = Integer.MIN_VALUE;
//                sum = 0;
//                cnt = 0;
//                int minimum = Integer.MAX_VALUE / 2;
//                for (int j = 1; j <= nums.length; j++) {
//                    max = Math.max(max, nums[j - 1]);
//                    sum += nums[j - 1];
//                    cnt++;
//                    minimum = Math.min(minimum, dp[j - 1] + max * cnt - sum);
//                    dp2[j] = minimum;
//                }
//                System.arraycopy(dp2, 0, dp, 0, dp2.length);
//            }
            return dp[nums.length];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 