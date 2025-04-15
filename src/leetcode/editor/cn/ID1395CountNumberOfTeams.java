package leetcode.editor.cn;

public class ID1395CountNumberOfTeams {

    public static void main(String[] args) {
        Solution solution = new ID1395CountNumberOfTeams().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numTeams(int[] rating) {
            // 3 1 2 4
            // dp[i][0, 1][1, 2]
            int[][][] dp = new int[rating.length][2][3];
            int ret = 0;
            for (int i = 0; i < rating.length; i++) {
                for(int j = 0; j < i; j++){
                    if(rating[j] < rating[i]){
                        dp[i][0][1]++;
                        dp[i][0][2] += dp[j][0][1];
                    }
                }

                for(int j = 0; j < i; j++){
                    if(rating[j] > rating[i]){
                        dp[i][1][1]++;
                        dp[i][1][2] += dp[j][1][1];
                    }
                }

                ret += dp[i][0][2];
                ret += dp[i][1][2];
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 