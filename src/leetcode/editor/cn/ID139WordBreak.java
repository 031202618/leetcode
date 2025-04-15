package leetcode.editor.cn;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ID139WordBreak {

    public static void main(String[] args) {
        Solution solution = new ID139WordBreak().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            boolean[] dp = new boolean[s.length() + 1];
            Set<String> dict = new HashSet<>();
            int maxLen = 0;
            for (String string : wordDict) {
                dict.add(new StringBuilder(string).reverse().toString());
                maxLen = Math.max(maxLen, string.length());
            }
            dp[0] = true;
            for (int i = 1; i <= s.length(); i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < maxLen && i - j > 0; j++) {
                    sb.append(s.charAt(i - j - 1));
                    if (dict.contains(sb.toString())) {
                        dp[i] |= dp[i - j - 1];
                    }
                }
            }
            return dp[s.length()];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 