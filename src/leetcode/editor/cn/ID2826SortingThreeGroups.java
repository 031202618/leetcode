package leetcode.editor.cn;

import java.util.Arrays;
import java.util.List;

public class ID2826SortingThreeGroups {

    public static void main(String[] args) {
        Solution solution = new ID2826SortingThreeGroups().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        System.out.println(solution.minimumOperations(List.of(1, 3, 2, 1, 3, 3)));
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumOperations(List<Integer> nums) {
            int[] dp = new int[4];
            for (Integer num : nums) {
                for (int i = num; i >= 0; i--) {
                    dp[num] = Math.max(dp[num], dp[i] + 1);
                }
            }
            return nums.size() - Arrays.stream(dp).max().getAsInt();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 