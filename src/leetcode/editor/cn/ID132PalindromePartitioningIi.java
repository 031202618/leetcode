package leetcode.editor.cn;

import java.util.Arrays;

public class ID132PalindromePartitioningIi {

    public static void main(String[] args) {
        Solution solution = new ID132PalindromePartitioningIi().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minCut(String s) {
            int[] dp = new int[s.length() + 1];
            boolean[][] fine = new boolean[s.length()][s.length()];
            for (int i = 1; i <= s.length(); i++) {
                for (int j = 0; j < s.length(); j++) {
                    int left = j;
                    int right = j + i - 1;
                    if (right >= s.length()) {
                        break;
                    }
                    if (s.charAt(left) == s.charAt(right)) {
                        if (right - left > 1) {
                            fine[left][right] |= fine[left + 1][right - 1];
                        } else {
                            fine[left][right] = true;
                        }
                    }
                }
            }
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = -1;
            dp[1] = 0;
            for (int i = 1; i <= s.length(); i++) {
                for (int j = i - 1; j >= 0; j--) {
                    if (fine[j][i - 1]) {
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
            }
            return dp[s.length()];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 