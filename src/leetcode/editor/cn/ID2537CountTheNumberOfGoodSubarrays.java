package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class ID2537CountTheNumberOfGoodSubarrays {

    public static void main(String[] args) {
        Solution solution = new ID2537CountTheNumberOfGoodSubarrays().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        solution.countGood(new int[]{2, 1, 3, 1, 2, 2, 3, 3, 2, 2, 1, 1, 1, 3, 1}, 11);
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long countGood(int[] nums, int k) {
            long ret = 0;
            int l = 0, r = 0;
            int curK = 0;
            Map<Integer, Integer> map = new HashMap<>();
            while (l < nums.length) {
                while (curK < k && r < nums.length) {
                    Integer orDefault = map.getOrDefault(nums[r], 0);
                    curK += orDefault;
                    map.put(nums[r], orDefault + 1);
                    r++;
                }
                if (curK >= k) {
                    ret += (nums.length - r + 1);
                }
                int x = map.get(nums[l]) - 1;
                curK -= x;
                map.put(nums[l], x);
                l++;
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 