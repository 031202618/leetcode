package leetcode.editor.cn;

public class ID376WiggleSubsequence {

    public static void main(String[] args) {
        Solution solution = new ID376WiggleSubsequence().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int wiggleMaxLength(int[] nums) {
            int an = 1;
            int ap = 1;
            for (int i = 1; i < nums.length; i++) {
                int diff = nums[i] - nums[i - 1];
                if (diff > 0) {
                    ap = Math.max(an + 1, ap);
                } else if (diff < 0) {
                    an = Math.max(ap + 1, an);
                }
            }
            return Math.max(an, ap);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 