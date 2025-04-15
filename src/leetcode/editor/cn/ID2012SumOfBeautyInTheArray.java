package leetcode.editor.cn;

public class ID2012SumOfBeautyInTheArray {

    public static void main(String[] args) {
        Solution solution = new ID2012SumOfBeautyInTheArray().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        System.out.println(solution.sumOfBeauties(new int[]{35, 32, 27, 8, 55, 92, 98, 5, 8, 47, 47, 23, 32, 87, 4, 11, 15, 9, 4, 6}));
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int sumOfBeauties(int[] nums) {
            int[] suffixMin = new int[nums.length];
            suffixMin[nums.length - 1] = nums[nums.length - 1];
            for (int i = nums.length - 2; i >= 0; i--) {
                suffixMin[i] = Math.min(nums[i], suffixMin[i + 1]);
            }
            int prefixMax = nums[0];
            int ret = 0;
            for (int i = 1; i < nums.length - 1; i++) {
                if (nums[i] > nums[i - 1] && nums[i] < nums[i + 1]) {
                    ret += 1;
                    if (prefixMax < nums[i] && nums[i] < suffixMin[i + 1]) {
                        ret += 1;
                    }
                }
                prefixMax = Math.max(prefixMax, nums[i]);
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 