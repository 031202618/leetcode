package leetcode.editor.cn;

import java.util.Arrays;

public class ID1478AllocateMailboxes {

    public static void main(String[] args) {
        Solution solution = new ID1478AllocateMailboxes().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int calc(int[] houses, int l, int r) {
            int mid = l + (r - l) / 2;
            int dis = 0;
            for (int i = l; i <= r; i++) {
                dis += Math.abs(houses[mid] - houses[i]);
            }
            return dis;
        }

        public int minDistance(int[] houses, int k) {
            //h1 . h2 , h3 . h4
            //dp[k][n] = dp[k-1][n-1], dp[k-1][n-2], dp[k-1][n-3]...
            //dp[n] = min dp[n-1], dp[n-2], ...dp[n-x] + midDis x
            int[] dp = new int[houses.length + 1];
            Arrays.sort(houses);
            int[][] dis = new int[houses.length + 1][houses.length + 1];
            for (int i = 1; i <= houses.length; i++) {
                for (int j = i; j <= houses.length; j++) {
                    dis[i][j] = calc(houses, i - 1, j - 1);
                }
            }
            Arrays.fill(dp, Integer.MAX_VALUE / 2);
            dp[0] = 0;
            for (int loop = 0; loop < k; loop++) {
                for (int i = houses.length; i > 0; i--) {
                    for (int j = i; j > 0; j--) {
                        dp[i] = Math.min(dp[i], dp[j - 1] + dis[j][i]);
                    }
                }
            }
            return dp[houses.length];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 