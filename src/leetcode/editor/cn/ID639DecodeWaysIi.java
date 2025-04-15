package leetcode.editor.cn;

public class ID639DecodeWaysIi {

    public static void main(String[] args) {
        Solution solution = new ID639DecodeWaysIi().new Solution();
        //19064
        System.out.println(solution.numDecodings("1*1*22*19"));
        StringBuilder sb = new StringBuilder();                //执行测试
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        final static int MOD = 1_000_000_007;

        public int numDecodings(String s) {
            long[] dp = new long[s.length() + 1];
            dp[0] = 1;
            for (int i = 1; i <= s.length(); i++) {
                char c = s.charAt(i - 1);
                if (i == 1) {
                    if (c == '0') {
                        continue;
                    }
                    if (c == '*') {
                        dp[i] = 9;
                    } else {
                        dp[i] = 1;
                    }
                    continue;
                }

                char d = s.charAt(i - 2);
                if (c == '*') {
                    dp[i] += (dp[i - 1] * 9);
                    if (d == '*') {
                        dp[i] += (dp[i - 2] * 15);
                    } else if (d == '1') {
                        dp[i] += (dp[i - 2] * 9);
                    } else if (d == '2') {
                        dp[i] += (dp[i - 2] * 6);
                    }
                } else if (c != '0') {
                    dp[i] += dp[i - 1];
                    if (d == '*') {
                        if (c <= '6') {
                            dp[i] += (dp[i - 2] * 2);
                        } else {
                            dp[i] += dp[i - 2];
                        }
                    } else if (d == '1') {
                        dp[i] += dp[i - 2];
                    } else if (d == '2') {
                        if (c <= '6') {
                            dp[i] += dp[i - 2];
                        }
                    }
                } else {
                    if (d == '*') {
                        dp[i] += (dp[i - 2] * 2);
                    } else if (d == '1') {
                        dp[i] += (dp[i - 2]);
                    } else if (d == '2') {
                        dp[i] += dp[i - 2];
                    }
                }
                dp[i] %= MOD;
            }
            return (int) dp[s.length()];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 