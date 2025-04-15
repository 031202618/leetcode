package leetcode.editor.cn;

import java.util.Arrays;

public class ID2707ExtraCharactersInAString {

    public static void main(String[] args) {
        Solution solution = new ID2707ExtraCharactersInAString().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        solution.minExtraChar("leetscode", new String[]{"leet", "code", "leetcode"});
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minExtraChar(String s, String[] dictionary) {
            int[] dp = new int[s.length() + 1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;
            for (int i = 1; i <= s.length(); i++) {
                // not choose
                dp[i] = dp[i - 1] + 1;
                // choose
                for (String string : dictionary) {
                    int len = string.length();
                    int left = i - len;
                    if (left >= 0 && string.equals(s.substring(left, i))) {
                        dp[i] = Math.min(dp[i], dp[i - len]);
                    }
                }
            }
            return dp[s.length()];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 