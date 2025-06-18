package leetcode.editor.cn;

public class ID2176CountEqualAndDivisiblePairsInAnArray {

    public static void main(String[] args) {
        Solution solution = new ID2176CountEqualAndDivisiblePairsInAnArray().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countPairs(int[] nums, int k) {
            int cnt = 0;
            for (int i = 0; i < nums.length; i++) {
                for (int j = i - 1; j >= 0; j--) {
                    if (nums[i] == nums[j] && (i * j) % k == 0) {
                        cnt++;
                    }
                }
            }
            return cnt;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 