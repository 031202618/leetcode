package leetcode.editor.cn;

import java.util.Arrays;
import java.util.List;

public class ID2826SortingThreeGroups {

    public static void main(String[] args) {
        Solution solution = new ID2826SortingThreeGroups().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumOperations(List<Integer> nums) {
            int[] dp = new int[nums.size() + 1];
            Arrays.fill(dp, 1);
            dp[0] = 0;
            int ret = 1;
            for (int i = 2; i <= nums.size(); i++) {
                for (int j = 1; j < i; j++) {
                    if (nums.get(j-1) <= nums.get(i-1)) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                        ret = Math.max(ret, dp[i]);
                    }
                }
            }
            return nums.size() - ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 