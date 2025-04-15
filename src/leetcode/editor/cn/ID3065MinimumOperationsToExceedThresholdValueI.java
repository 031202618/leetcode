package leetcode.editor.cn;

public class ID3065MinimumOperationsToExceedThresholdValueI {

    public static void main(String[] args) {
        Solution solution = new ID3065MinimumOperationsToExceedThresholdValueI().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minOperations(int[] nums, int k) {
            int cnt = 0;
            for (int num : nums) {
                cnt += (num < k) ? 1 : 0;
            }
            return cnt;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 