package leetcode.editor.cn;

public class ID2239FindClosestNumberToZero {

    public static void main(String[] args) {
        Solution solution = new ID2239FindClosestNumberToZero().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findClosestNumber(int[] nums) {
            if(nums.length == 0) return 0;
            int ret = nums[0];
            for (int num : nums) {
                if (Math.abs(num) < Math.abs(ret)) {
                    ret = num;
                } else if (Math.abs(num) == Math.abs(ret)) {
                    ret = Math.max(ret, num);
                }
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 