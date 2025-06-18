package leetcode.editor.cn;

import java.util.Arrays;

public class ID2962CountSubarraysWhereMaxElementAppearsAtLeastKTimes {

    public static void main(String[] args) {
        Solution solution = new ID2962CountSubarraysWhereMaxElementAppearsAtLeastKTimes().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long countSubarrays(int[] nums, int k) {
            int maxNum = Arrays.stream(nums).max().getAsInt();
            int l = 0, r = 0;
            int curNum = 0;
            long ret = 0;
            while (l < nums.length) {
                while (r < nums.length && curNum < k) {
                    if (nums[r] == maxNum) {
                        curNum++;
                    }
                    r++;
                }
                if (curNum == k) {
                    ret += (nums.length - r + 1);
                }
                if (nums[l] == maxNum) {
                    curNum--;
                }
                l++;
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 