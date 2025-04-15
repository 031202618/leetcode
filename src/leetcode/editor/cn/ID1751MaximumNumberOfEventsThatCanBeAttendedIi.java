package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

public class ID1751MaximumNumberOfEventsThatCanBeAttendedIi {

    public static void main(String[] args) {
        Solution solution = new ID1751MaximumNumberOfEventsThatCanBeAttendedIi().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        System.out.println(solution.maxValue(new int[][]{{1, 2, 4}, {3, 4, 3}, {2, 3, 10}}, 2));
        System.out.println(solution.maxValue(new int[][]{{1, 1, 1}, {2, 2, 2}, {3, 3, 3}, {4, 4, 4}}, 3));
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxValue(int[][] events, int k) {
            // dp[k][n] = dp[k][n-1], dp[k-1][n-x]
            int n = events.length;
            Arrays.sort(events, Comparator.comparingInt(x -> x[1]));
            int[] dp1 = new int[n + 1];
            int[] dp2 = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                dp1[i] = Math.max(dp1[i - 1], events[i - 1][2]);
            }
            int ret = dp1[n];
            for (int loop = 2; loop <= k; loop++) {
                for (int i = 1; i <= n; i++) {

                    int l = 0;
                    int r = Math.max(i - 2, 0);
                    int target = events[i - 1][0];
                    while (l < r - 1) {
                        int m = (l + r) / 2;
                        int v = events[m][1];
                        if (v < target) {
                            l = m;
                        } else {
                            r = m - 1;
                        }
                    }

                    if (events[r][1] < target) {
                        dp2[i] = Math.max(dp2[i - 1], dp1[r + 1] + events[i - 1][2]);
                    } else if (events[l][1] < target) {
                        dp2[i] = Math.max(dp2[i - 1], dp1[l + 1] + events[i - 1][2]);
                    } else {
                        dp2[i] = dp2[i - 1];
                    }
                }
                ret = Math.max(ret, dp2[n]);
                for (int i = 0; i < dp2.length; i++) {
                    dp1[i] = dp2[i];
                    dp2[i] = Integer.MIN_VALUE;
                }
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 