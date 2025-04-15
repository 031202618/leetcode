package leetcode.editor.cn;

public class ID3095ShortestSubarrayWithOrAtLeastKI {

    public static void main(String[] args) {
        Solution solution = new ID3095ShortestSubarrayWithOrAtLeastKI().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试 		 		
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumSubarrayLength(int[] nums, int k) {
            int ret = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length; i++) {
                int cur = 0;
                for (int j = i; j < nums.length; j++) {
                    cur |= nums[j];
                    if (cur >= k) {
                        ret = Math.min(ret, j - i + 1);
                        break;
                    }
                }
            }
            return ret == Integer.MAX_VALUE ? -1 : ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 