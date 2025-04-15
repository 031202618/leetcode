package leetcode.editor.cn;

public class ID1911MaximumAlternatingSubsequenceSum {

    public static void main(String[] args) {
        Solution solution = new ID1911MaximumAlternatingSubsequenceSum().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long maxAlternatingSum(int[] nums) {
            long odd = 0;
            long even = -1;
            for (int num : nums) {
                long tmpOdd = odd;
                long tmpEven = even;
                odd = Math.max(tmpEven + num, odd);
                odd = Math.max(num, odd);
                even = Math.max(tmpOdd - num, even);
            }
            return Math.max(even, odd);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 