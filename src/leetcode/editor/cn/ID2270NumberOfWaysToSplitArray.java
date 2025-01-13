package leetcode.editor.cn;

public class ID2270NumberOfWaysToSplitArray {

    public static void main(String[] args) {
        Solution solution = new ID2270NumberOfWaysToSplitArray().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int waysToSplitArray(int[] nums) {
            long sum = 0;
            for (int num : nums) {
                sum += num;
            }
            long left = 0;
            int cnt = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                left += nums[i];
                // left >= sum - left
                if ((left << 1) >= sum) {
                    cnt++;
                }
            }
            return cnt;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 