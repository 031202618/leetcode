package leetcode.editor.cn;

public class ID2472MaximumNumberOfNonOverlappingPalindromeSubstrings {

    public static void main(String[] args) {
        Solution solution = new ID2472MaximumNumberOfNonOverlappingPalindromeSubstrings().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        solution.maxPalindromes("abaccdbbd", 3);
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxPalindromes(String s, int k) {
            boolean[][] dp = new boolean[s.length()][s.length()];
            for (int i = 1; i <= s.length(); i++) {
                for (int j = 0; j < s.length(); j++) {
                    int l = j;
                    int r = j + i - 1;
                    if (r >= s.length()) {
                        break;
                    }
                    if (l == r) {
                        dp[l][r] = true;
                    } else if (l == r - 1) {
                        dp[l][r] = s.charAt(l) == s.charAt(r);
                    } else {
                        dp[l][r] = dp[l + 1][r - 1] && s.charAt(l) == s.charAt(r);
                    }
                }
            }
            int[] dp2 = new int[s.length()];
            for (int i = k - 1; i < s.length(); i++) {
                if (i >= 1) {
                    dp2[i] = dp2[i - 1];
                }
                for (int j = k; i - j + 1 >= 0; j++) {
                    int l = i - j + 1;
                    if (dp[l][i]) {
                        if (l >= 1) {
                            dp2[i] = Math.max(dp2[i], dp2[l - 1] + 1);
                        } else {
                            dp2[i] = Math.max(dp2[i], 1);
                        }
                    }
                }
            }
            return dp2[s.length() - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 