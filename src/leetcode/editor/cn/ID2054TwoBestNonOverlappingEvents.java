package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

public class ID2054TwoBestNonOverlappingEvents {

    public static void main(String[] args) {
        Solution solution = new ID2054TwoBestNonOverlappingEvents().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        solution.maxTwoEvents(new int[][]{{1, 3, 2}, {4, 5, 2}, {2, 4, 3}});
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxTwoEvents(int[][] events) {
            //dp[k][n] = dp[k][n-1], dp[k-1][bs(n)] + v;
            Arrays.sort(events, Comparator.comparingInt(x -> x[1]));
            int n = events.length;
            int[][] dp = new int[2][n + 1];
            for (int i = 1; i <= n; i++) {
                dp[0][i] = Math.max(dp[0][i - 1], events[i - 1][2]);
            }
            for (int i = 1; i <= n; i++) {
                int beforeIdx = find(events, events[i - 1][0]) + 1;
                int c = Integer.MIN_VALUE;
                if (beforeIdx >= 1) {
                    c = events[i - 1][2] + dp[0][beforeIdx];
                }
                dp[1][i] = Math.max(dp[1][i - 1], c);
            }
            return Math.max(dp[0][n], dp[1][n]);
        }

        private int find(int[][] events, int x) {
            int l = 0;
            int r = events.length - 1;
            int target = x;
            //find last < x
            while (l < r - 1) {
                int mid = (l + r) / 2;
                int cur = events[mid][1];
                if (cur >= target) {
                    r = mid - 1;
                } else {
                    l = mid;
                }
            }
            if (events[r][1] < target) {
                return r;
            } else if (events[l][1] < target) {
                return l;
            } else {
                return -1;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 