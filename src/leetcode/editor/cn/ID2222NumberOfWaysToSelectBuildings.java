package leetcode.editor.cn;

public class ID2222NumberOfWaysToSelectBuildings {

    public static void main(String[] args) {
        Solution solution = new ID2222NumberOfWaysToSelectBuildings().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long numberOfWays(String s) {
            //0 --- 0
            //1 --- 1
            //2 --- 01
            //3 --- 10
            //4 --- 010
            //5 --- 101
            long[][] dp = new long[s.length()][6];
            long sum0 = 0;
            long sum1 = 0;
            long sum2 = 0;
            long sum3 = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (i == 0) {
                    dp[i][c - '0'] = 1;
                    sum0 += dp[i][0];
                    sum1 += dp[i][1];
                    sum2 += dp[i][2];
                    sum3 += dp[i][3];
                    continue;
                }
                if (c == '0') {
                    dp[i][0] = 1;
                    dp[i][3] = sum1;
                    dp[i][4] = sum2;
                } else {
                    dp[i][1] = 1;
                    dp[i][2] = sum0;
                    dp[i][5] = sum3;
                }
                sum0 += dp[i][0];
                sum1 += dp[i][1];
                sum2 += dp[i][2];
                sum3 += dp[i][3];
            }
            long cnt = 0;
            for (long[] integers : dp) {
                cnt += integers[4];
                cnt += integers[5];
            }
            return cnt;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 