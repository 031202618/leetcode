package leetcode.editor.cn;

public class ID3097ShortestSubarrayWithOrAtLeastKIi {

    public static void main(String[] args) {
        Solution solution = new ID3097ShortestSubarrayWithOrAtLeastKIi().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        solution.minimumSubarrayLength(new int[]{2, 1, 8}, 10);
        System.out.println(314 | 192);
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumSubarrayLength(int[] nums, int k) {
            int ans = Integer.MAX_VALUE;
            int left = 0;
            int bottom = 0;
            int rightOr = 0;
            for (int right = 0; right < nums.length; right++) {
                rightOr |= nums[right];
                while (left <= right && (nums[left] | rightOr) >= k) {
                    ans = Math.min(ans, right - left + 1);
                    left++;
                    if (bottom < left) {
                        // 重新构建一个栈
                        for (int i = right - 1; i >= left; i--) {
                            nums[i] |= nums[i + 1];
                        }
                        bottom = right;
                        rightOr = 0;
                    }
                }
            }
            return ans == Integer.MAX_VALUE ? -1 : ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 