package leetcode.editor.cn;

import java.util.Arrays;

public class ID960DeleteColumnsToMakeSortedIii {

    public static void main(String[] args) {
        Solution solution = new ID960DeleteColumnsToMakeSortedIii().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minDeletionSize(String[] strs) {
            int len = strs[0].length();
            int[] dp = new int[len + 1];
            Arrays.fill(dp, 1);
            int maxi = 1;
            for (int i = 2; i <= len; i++) {
                for (int j = 1; j < i; j++) {
                    if (allMatch(strs, j - 1, i - 1)) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                maxi = Math.max(dp[i], maxi);
            }
            return len - maxi;
        }

        public boolean allMatch(String[] strs, int i, int j) {
            for (String str : strs) {
                if (str.charAt(i) > str.charAt(j)) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 