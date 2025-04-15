package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ID2008MaximumEarningsFromTaxi {

    public static void main(String[] args) {
        Solution solution = new ID2008MaximumEarningsFromTaxi().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long maxTaxiEarnings(int n, int[][] rides) {
            long[] dp = new long[n + 1];
            List<int[]>[] group = new ArrayList[n + 1];
            Arrays.setAll(group, i -> new ArrayList<>());
            for (int[] ride : rides) {
                group[ride[1]].add(ride);
            }
            Arrays.fill(dp, Long.MIN_VALUE);
            dp[0] = 0;
            for (int i = 1; i <= n; i++) {
                dp[i] = dp[i - 1];
                List<int[]> last = group[i];
                for (int[] ints : last) {
                    dp[i] = Math.max(dp[i], dp[ints[0]] + ints[2] + ints[1] - ints[0]);
                }
            }
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 