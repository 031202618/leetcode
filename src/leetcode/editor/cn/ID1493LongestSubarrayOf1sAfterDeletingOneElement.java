package leetcode.editor.cn;

public class ID1493LongestSubarrayOf1sAfterDeletingOneElement {

    public static void main(String[] args) {
        Solution solution = new ID1493LongestSubarrayOf1sAfterDeletingOneElement().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestSubarray(int[] nums) {
            //nums[i]: 1 / nums[i] : 0
            // 0 ---》 dp[i][0] = 0; dp[i][1] = dp[i-1][0];
            // 1 ---》 dp[i][0] = dp[i-1][0] + 1; dp[i][1] = dp[i-1][1] + 1
            int zero = 0;
            int one = 0;
            int ret = 0;
            for (int i = 0; i < nums.length; i++) {
                if(nums[i] == 0){
                    one = zero;
                    zero = 0;
                }else{
                    zero++;
                    one++;
                }
                ret = Math.max(ret, one);
            }
            return Math.min(ret, nums.length - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 