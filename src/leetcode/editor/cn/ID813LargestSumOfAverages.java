package leetcode.editor.cn;

public class ID813LargestSumOfAverages {

    public static void main(String[] args) {
        Solution solution = new ID813LargestSumOfAverages().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        solution.largestSumOfAverages(new int[]{1, 2, 3, 4, 5, 6, 7}, 4);
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double largestSumOfAverages(int[] nums, int k) {
            // k-1
            //dp[j] = dp[j - 1], dp[j-2], dp[j-3]...dp[k-1]
            double[] dp = new double[nums.length + 1];
            double prefixSum = 0;
            for (int i = 1; i <= nums.length; i++) {
                prefixSum += nums[i - 1];
                dp[i] = prefixSum / i;
            }
            for (int i = 2; i <= k; i++) {
                for (int j = nums.length; j >= 1; j--) {
                    double r = 0;
                    for (int l = 0; j - l >= i; l++) {
                        r += nums[j - l - 1];
                        dp[j] = Math.max(dp[j], dp[j - l - 1] + r / (l + 1));
                    }
                }
            }
            return dp[nums.length];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 