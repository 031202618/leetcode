package leetcode.editor.cn;

import java.util.Arrays;

public class ID983MinimumCostForTickets {

    public static void main(String[] args) {
        Solution solution = new ID983MinimumCostForTickets().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        solution.mincostTickets(new int[]{1, 4, 6, 7, 8, 20}, new int[]{2, 7, 15});
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int mincostTickets(int[] days, int[] costs) {
            // days[i] , 365, 365, asc
            // cost[i] , 1000
            int total = days[days.length - 1];
            int[] dp = new int[total + 1];
            boolean[] set = new boolean[total + 1];
            for (int day : days) {
                set[day] = true;
            }
            Arrays.fill(dp, Integer.MAX_VALUE / 2);
            dp[0] = 0;
            //dp[i] = dp[i-1], dp[i-7], dp[i-30];
            for (int i = 1; i <= total; i++) {
                if (!set[i]) {
                    dp[i] = dp[i - 1];
                }
                dp[i] = Math.min(dp[i], dp[i - 1] + costs[0]);
                dp[i] = Math.min(dp[i], (i >= 7 ? dp[i - 7] : 0) + costs[1]);
                dp[i] = Math.min(dp[i], (i >= 30 ? dp[i - 30] : 0) + costs[2]);
            }
            return dp[total];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 