package leetcode.editor.cn;

import java.util.Arrays;

public class ID1278PalindromePartitioningIii {

    public static void main(String[] args) {
        Solution solution = new ID1278PalindromePartitioningIii().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        solution.palindromePartition("abc", 2);
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int calc(String s, int l, int r) {
            int n = 0;
            while (l < r) {
                if (s.charAt(l++) != s.charAt(r--)) {
                    n++;
                }
            }
            return n;
        }

        public int palindromePartition(String s, int k) {
            // "abcdefgh" 3
            int[][] dp = new int[k + 1][s.length() + 1];
            int[][] cost = new int[s.length() + 1][s.length() + 1];
            for (int i = 1; i <= s.length(); i++) {
                for (int j = i; j <= s.length(); j++) {
                    cost[i][j] = calc(s, i - 1, j - 1);
                }
            }
            //dp[i][j] = min dp[i-1][j-x]
            Arrays.fill(dp[0], Integer.MAX_VALUE / 2);
            dp[0][0] = 0;
            for (int i = 1; i <= k; i++) {
                Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
                for (int j = 1; j <= s.length(); j++) {
                    for (int l = j; l >= 1; l--) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][l - 1] + cost[l][j]);
                    }
                }
            }
            return dp[k][s.length()];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 