package leetcode.editor.cn;

public class ID63UniquePathsIi {

    public static void main(String[] args) {
        Solution solution = new ID63UniquePathsIi().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            //dp[i][j]: 走到i,j的方案
            //dp[i][j] = dp[i-1][j] + dp[i][j-1]
//            if(obstacleGrid[0][0] == 1 || obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1){
//                return 0;
//            }
            int[] dp = new int[obstacleGrid[0].length];
            dp[0] = 1;
            for (int[] ob : obstacleGrid) {
                for (int i = 0; i < ob.length; i++) {
                    if (i != 0 && ob[i] != 1) {
                        dp[i] += dp[i - 1];
                    }
                    if(ob[i] == 1){
                        dp[i] = 0;
                    }
                }
            }
            return dp[obstacleGrid[0].length - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 