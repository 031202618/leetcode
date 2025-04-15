package leetcode.editor.cn;

import java.util.Arrays;

public class ID2588CountTheNumberOfBeautifulSubarrays {

    public static void main(String[] args) {
        Solution solution = new ID2588CountTheNumberOfBeautifulSubarrays().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        solution.beautifulSubarrays(new int[]{4, 3, 1, 2, 4});
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public long beautifulSubarrays(int[] nums) {
            long ret = 0;
            int[] cache = new int[1100_010];
            cache[0] = 1;
            // 0 1 ---> 1
            // 0 0 ---> 0
            // 1 1 ---> 0
            int base = 0;
            for (int num : nums) {
                base ^= num;
                ret += cache[base];
                cache[base]++;
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 