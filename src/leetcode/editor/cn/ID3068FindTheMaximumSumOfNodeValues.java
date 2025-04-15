package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

public class ID3068FindTheMaximumSumOfNodeValues {

    public static void main(String[] args) {
        Solution solution = new ID3068FindTheMaximumSumOfNodeValues().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        solution.maximumValueSum(new int[]{1, 2, 1}, 3, new int[][]{{0, 1}, {0, 2}});
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long maximumValueSum(int[] nums, int k, int[][] edges) {
            long[][] cg = new long[nums.length][2];
            for (int i = 0; i < nums.length; i++) {
                cg[i][0] = nums[i];
                cg[i][1] = (nums[i] ^ k) - (long)nums[i];
            }
            Arrays.sort(cg, Comparator.comparingLong(x -> x[1]));
            long sum = 0;
            int i = cg.length - 1;
            for (; i >= 1; i -= 2) {
                long cgSum = cg[i][1] + cg[i - 1][1];
                if (cgSum > 0) {
                    sum += (cgSum + (cg[i][0] + cg[i - 1][0]));
                } else {
                    break;
                }
            }
            for (; i >= 0; i--) {
                sum += cg[i][0];
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 