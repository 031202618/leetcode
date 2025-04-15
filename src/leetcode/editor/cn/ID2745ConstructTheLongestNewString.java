package leetcode.editor.cn;

public class ID2745ConstructTheLongestNewString {

    public static void main(String[] args) {
        Solution solution = new ID2745ConstructTheLongestNewString().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestString(int x, int y, int z) {
            int[][][][] dp = new int[x + 1][y + 1][z + 1][2];
            for (int i = 0; i <= x; i++) {
                for (int j = 0; j <= y; j++) {
                    for (int k = 0; k <= z; k++) {
                        if (i > 0) {
                            dp[i][j][k][0] = dp[i - 1][j][k][1] + 1;
                        }
                        if(j > 0){
                            dp[i][j][k][1] = Math.max(dp[i][j][k][1], dp[i][j - 1][k][0] + 1);
                        }
                        if(k > 0){
                            dp[i][j][k][1] = Math.max(dp[i][j][k][1], dp[i][j][k - 1][1] + 1);
                        }
                    }
                }
            }
            return Math.max(dp[x][y][z][0], dp[x][y][z][1]) << 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 