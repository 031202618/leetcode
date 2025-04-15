package leetcode.editor.cn;

import java.util.Arrays;

public class ID2767PartitionStringIntoMinimumBeautifulSubstrings {

    public static void main(String[] args) {
        Solution solution = new ID2767PartitionStringIntoMinimumBeautifulSubstrings().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        solution.minimumBeautifulSubstrings("1011");
        System.out.println(Integer.toBinaryString((int) Math.pow(5, 6)));
        System.out.println(sb);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        static String[] pow;

        static {
            pow = new String[8];
            int base = 1;
            for (int i = 0; i <= 7; i++) {
                pow[i] = Integer.toBinaryString(base);
                base *= 5;
            }
        }

        public int minimumBeautifulSubstrings(String s) {
            int[] dp = new int[s.length() + 1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;
            for (int i = 1; i <= s.length(); i++) {
                for (String str : pow) {
                    int l = i - str.length();
                    if (l < 0) {
                        break;
                    }
                    if (s.substring(l, i).equals(str) && dp[i - str.length()] != Integer.MAX_VALUE) {
                        dp[i] = Math.min(dp[i], dp[i - str.length()] + 1);
                    }
                }
            }
            return dp[s.length()] == Integer.MAX_VALUE ? -1 : dp[s.length()];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 