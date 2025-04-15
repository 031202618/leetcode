package leetcode.editor.cn;

public class ID2873MaximumValueOfAnOrderedTripletI {

    public static void main(String[] args) {
        Solution solution = new ID2873MaximumValueOfAnOrderedTripletI().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long maximumTripletValue(int[] nums) {
            long ret = 0;
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    for (int k = j + 1; k < nums.length; k++) {
                        ret = Math.max((nums[i] - nums[j]) * (long)nums[k], ret);
                    }
                }
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 