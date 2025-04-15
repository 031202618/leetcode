package leetcode.editor.cn;

import java.util.Arrays;

public class IDLCP19UlBDOe {

    public static void main(String[] args) {
        Solution solution = new IDLCP19UlBDOe().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        solution.minimumOperations("rrryyyrryyyrr");
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumOperations(String leaves) {
            //rrryyrr  yrryryryrrryyyyyr
            //dp[0]: part1 --- y, dp[1]: part2 --- r, dp[2]: part3 ---y
            int[] dp = new int[3];
            Arrays.fill(dp, Integer.MAX_VALUE);
            char[] charArray = leaves.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                char c = charArray[i];
                int tmp0 = dp[0];
                int tmp1 = dp[1];
                if (c == 'r') {
                    if (dp[0] != Integer.MAX_VALUE) {
                        dp[1] = Math.min(dp[1], dp[0]) + 1;
                    }
                    if (tmp1 != Integer.MAX_VALUE) {
                        dp[2] = Math.min(tmp1, dp[2]);
                    }
                    if (dp[0] == Integer.MAX_VALUE) {
                        dp[0] = 0;
                    }
                } else {
                    if (tmp0 == Integer.MAX_VALUE) {
                        dp[0] = 1;
                    }
                    if (tmp0 != Integer.MAX_VALUE) {
                        dp[0]++;
                        dp[1] = Math.min(dp[1], tmp0);
                    }
                    if (tmp1 != Integer.MAX_VALUE) {
                        dp[2] = Math.min(tmp1, dp[2]) + 1;
                    }
                }
            }
            return dp[2];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 