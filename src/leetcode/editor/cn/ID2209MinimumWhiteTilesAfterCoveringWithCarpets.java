package leetcode.editor.cn;

public class ID2209MinimumWhiteTilesAfterCoveringWithCarpets {

    public static void main(String[] args) {
        Solution solution = new ID2209MinimumWhiteTilesAfterCoveringWithCarpets().new Solution();
        solution.minimumWhiteTiles("11111", 2, 3);
        StringBuilder sb = new StringBuilder();                //执行测试
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) {
            //dp[s][n] = dp[s-1][n] + isWhite?, dp[s-carpetLen][n-1]
            char[] charArray = floor.toCharArray();
            int[] prefix = new int[floor.length() + 1];
            for (int i = 1; i <= charArray.length; i++) {
                prefix[i] = prefix[i - 1] + (charArray[i - 1] == '1' ? 1 : 0);
            }
            int[][] dp = new int[charArray.length][numCarpets + 1];
            for (int i = 0; i < charArray.length; i++) {
                for (int j = 1; j <= numCarpets; j++) {
                    if (i == 0) {
                        if (prefix[1] == 1) {
                            dp[i][j] = 1;
                        }
                        continue;
                    }
                    //not choose
                    dp[i][j] = dp[i - 1][j];
                    //choose
                    if (i - carpetLen >= 0) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - carpetLen][j - 1] + prefix[i + 1] - prefix[i - carpetLen + 1]);
                    } else {
                        dp[i][j] = prefix[i + 1];
                    }
                }
            }
            return prefix[floor.length()] - dp[floor.length() - 1][numCarpets];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 