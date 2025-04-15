package leetcode.editor.cn;

import java.util.Arrays;

public class ID2430MaximumDeletionsOnAString {

    public static void main(String[] args) {
        Solution solution = new ID2430MaximumDeletionsOnAString().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        solution.deleteString("aaabaab");
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int deleteString(String s) {
            int[] dp = new int[s.length()];
            int[][] dp2 = new int[s.length() + 1][s.length() + 1];
            //dp[i][j] = dp[i-1][j-1] &&
            //a b c a b c
            //a b c a b c
            //dp[i][j] = dp[i+1][j+1] + s.charAt(i) == s.charAt(j)
            for (int i = s.length(); i >= 1; i--) {
                for (int j = s.length(); j >= i; j--) {
                    if(i == s.length()){
                        dp2[i][j] = 1;
                    }else if(j == s.length()){
                        dp2[i][j] = (s.charAt(i - 1) == s.charAt(j - 1) ? 1 : 0);
                    }else {
                        dp2[i][j] = dp2[i + 1][j + 1] + (s.charAt(i - 1) == s.charAt(j - 1) ? 1 : 0);
                    }
                }
            }
            Arrays.fill(dp, 1);
            for (int i = s.length() - 1; i >= 0; i--) {
                for (int j = i + 1; j < s.length(); j++) {
                    //a b c a b c
                    // j - i + 1
                    if (dp2[i + 1][j + 1] >= (j - i)) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }
            return dp[0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 