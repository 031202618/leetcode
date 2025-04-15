package leetcode.editor.cn;

public class ID1745PalindromePartitioningIv {

    public static void main(String[] args) {
        Solution solution = new ID1745PalindromePartitioningIv().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        solution.checkPartitioning("abcbdd");
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkPartitioning(String s) {
            //dp[length][k] = dp[length-1][k-1], dp[length-2][k-1]
            //dp[k][length] = dp[k-1][length-1], dp[k-1][length-2]
            boolean[] dp = new boolean[s.length() + 1];
            boolean[][] dp2 = new boolean[s.length() + 1][s.length() + 1];
            for (int length = 1; length <= s.length(); length++) {
                for (int l = 1; l <= s.length(); l++) {
                    int r = l + length - 1;
                    if (r > s.length()) {
                        break;
                    }
                    if (length == 1) {
                        dp2[l][r] = true;
                    } else if (length == 2) {
                        dp2[l][r] = s.charAt(l - 1) == s.charAt(r - 1);
                    } else {
                        dp2[l][r] = dp2[l + 1][r - 1] && s.charAt(l - 1) == s.charAt(r - 1);
                    }
                }
            }
            if (allEqual(s)) {
                return true;
            }
            dp[0] = true;
            for (int i = 0; i < 3; i++) {
                if (i > 0) {
                    dp[0] = false;
                }
                for (int j = s.length(); j >= 1; j--) {
                    dp[j] = false;
                    for (int k = j; k >= 1 && !dp[j]; k--) {
                        if (dp2[k][j]) {
                            dp[j] |= dp[k - 1];
                        }
                    }
                }
            }
            return dp[s.length()];
        }

        public boolean allEqual(String s) {
            char[] charArray = s.toCharArray();
            for (int i = 1; i < charArray.length; i++) {
                if (charArray[i] != charArray[i - 1]) return false;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 