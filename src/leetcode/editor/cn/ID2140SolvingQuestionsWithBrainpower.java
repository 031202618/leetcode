package leetcode.editor.cn;

public class ID2140SolvingQuestionsWithBrainpower {

    public static void main(String[] args) {
        Solution solution = new ID2140SolvingQuestionsWithBrainpower().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long mostPoints(int[][] questions) {
            // dp[i] = dp[i+1], d|p[i+v+1]
            int n = questions.length;
            long[] dp = new long[n + 1];
            dp[n] = questions[n - 1][0];
            for (int i = n - 1; i > 0; i--) {
                int nxt = questions[i-1][1] + i + 1;
                long nxtV = ((nxt <= n) ? dp[nxt] : 0) + questions[i - 1][0];
                dp[i] = Math.max(dp[i + 1], nxtV);
            }
            return dp[1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 