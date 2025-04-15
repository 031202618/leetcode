package leetcode.editor.cn;

public class ID2680MaximumOr {

    public static void main(String[] args) {
        Solution solution = new ID2680MaximumOr().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long maximumOr(int[] nums, int k) {
            //1. nums[0] | nums[1] | nums[2] | ...
            //2. k << 1
            long[] suffix = new long[nums.length + 1];
            for (int i = nums.length - 1; i >= 0; i--) {
                if (i == nums.length - 1) {
                    suffix[i] = nums[i];
                } else {
                    suffix[i] = suffix[i + 1] | nums[i];
                }
            }
            long ret = 0;
            long prefix = 0;
            for (int i = 0; i < nums.length; i++) {
                long cur = nums[i];
                cur <<= k;
                ret = Math.max(ret, cur | prefix | suffix[i + 1]);
                prefix |= nums[i];
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 