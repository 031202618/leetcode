package leetcode.editor.cn;

public class ID91DecodeWays {

    public static void main(String[] args) {
        Solution solution = new ID91DecodeWays().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numDecodings(String s) {
            int[] dp = new int[s.length() + 1];
            dp[0] = 1;
            for (int i = 1; i <= s.length(); i++) {
                char c = s.charAt(i - 1);
                if (i == 1) {
                    if (c != '0') {
                        dp[i] = 1;
                    }
                    continue;
                }
                char d = s.charAt(i - 2);
                if (c != '0') {
                    dp[i] += dp[i - 1];
                }
                int num = (d - '0') * 10 + (c - '0');
                if (num >= 10 && num <= 26) {
                    dp[i] += dp[i - 2];
                }
            }
            return dp[s.length()];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 