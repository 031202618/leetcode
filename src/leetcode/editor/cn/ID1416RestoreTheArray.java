package leetcode.editor.cn;

public class ID1416RestoreTheArray {

    public static void main(String[] args) {
        Solution solution = new ID1416RestoreTheArray().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        //8
        System.out.println(solution.numberOfArrays("1317", 2000));
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        static final int MOD = 1_000_000_007;

        public int numberOfArrays(String s, int k) {
            //[110099], k = 998
            long[] dp = new long[s.length() + 1];
            dp[0] = 1;
            for (int i = 1; i <= s.length(); i++) {
                long base = 1;
                long last = 0;
                for (int j = 0; ; j++) {
                    if (i - j - 1 < 0) {
                        break;
                    }
                    int head = s.charAt(i - j - 1) - '0';
                    long ret = base * (head) + last;

                    last = ret;
                    if (ret > k || base > k) {
                        break;
                    }
                    if (head != 0) {
                        dp[i] += dp[i - j - 1];
                        dp[i] %= MOD;
                    }
                    base *= 10;
                }
            }
            return (int) dp[s.length()];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 