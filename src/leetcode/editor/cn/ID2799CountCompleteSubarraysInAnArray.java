package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ID2799CountCompleteSubarraysInAnArray {

    public static void main(String[] args) {
        Solution solution = new ID2799CountCompleteSubarraysInAnArray().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countCompleteSubarrays(int[] nums) {
            int ret = 0;
            int l = 0, r = 0;
            int standard = (int) Arrays.stream(nums).distinct().count();
            Map<Integer, Integer> map = new HashMap<>();
            while (l < nums.length) {
                while (r < nums.length && map.size() < standard) {
                    map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
                    r++;
                }
                if (map.size() == standard) {
                    ret += (nums.length - r + 1);
                }
                int v = map.get(nums[l]);
                if (v > 1) {
                    map.put(nums[l], v - 1);
                } else {
                    map.remove(nums[l]);
                }
                l++;
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 