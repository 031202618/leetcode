package leetcode.editor.cn;

import java.util.Arrays;

public class ID1335MinimumDifficultyOfAJobSchedule {

    public static void main(String[] args) {
        Solution solution = new ID1335MinimumDifficultyOfAJobSchedule().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        //7
        System.out.println(solution.minDifficulty(new int[]{6, 5, 4, 3, 2, 1}, 2));
        //-1
        System.out.println(solution.minDifficulty(new int[]{9, 9, 9}, 4));
        //3
        System.out.println(solution.minDifficulty(new int[]{1, 1, 1}, 3));
        //15
        System.out.println(solution.minDifficulty(new int[]{7, 1, 7, 1, 7, 1}, 3));
        //843
        System.out.println(solution.minDifficulty(new int[]{11, 111, 22, 222, 33, 333, 44, 444}, 6));
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minDifficulty(int[] jobDifficulty, int d) {
            //dp[d][l] = min(dp[d-1][l-1] + max(l) , dp[d-1][l-2] + max(l, l -1), dp[d-1][l-3] + max(l, l - 2)...)
            int[] dp = new int[jobDifficulty.length + 1];
            Arrays.fill(dp, Integer.MAX_VALUE / 2);
            dp[0] = 0;
            for (int i = 0; i < d; i++) {
                for (int j = jobDifficulty.length; j > 0; j--) {
                    int todayDifficulty = 0;
                    dp[j] = Integer.MAX_VALUE / 2;
                    for (int k = j - 1; k >= i; k--) {
                        todayDifficulty = Math.max(todayDifficulty, jobDifficulty[k]);
                        dp[j] = Math.min(dp[j], dp[k] + todayDifficulty);
                    }
                }
            }
            return dp[jobDifficulty.length] == Integer.MAX_VALUE / 2 ? -1 : dp[jobDifficulty.length];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 