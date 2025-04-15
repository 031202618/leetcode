package leetcode.editor.cn;

public class ID2369CheckIfThereIsAValidPartitionForTheArray {

    public static void main(String[] args) {
        Solution solution = new ID2369CheckIfThereIsAValidPartitionForTheArray().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validPartition(int[] nums) {
            // aa/aaa/abc
            if (nums.length < 2) {
                return false;
            }
            boolean[] dp = new boolean[nums.length + 1];
            dp[0] = true;
            for (int i = 2; i <= nums.length; i++) {
                if (nums[i - 1] == nums[i - 2]) {
                    dp[i] |= dp[i - 2];
                    if (i >= 3 && nums[i - 2] == nums[i - 3]) {
                        dp[i] |= dp[i - 3];
                    }
                }
                if (i >= 3 && nums[i - 1] == nums[i - 2] + 1 && nums[i - 2] == nums[i - 3] + 1) {
                    dp[i] |= dp[i - 3];
                }
            }
            return dp[nums.length];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 