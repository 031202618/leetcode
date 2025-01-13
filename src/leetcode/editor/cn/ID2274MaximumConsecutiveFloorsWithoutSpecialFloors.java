package leetcode.editor.cn;

import java.util.Arrays;

public class ID2274MaximumConsecutiveFloorsWithoutSpecialFloors {

    public static void main(String[] args) {
        Solution solution = new ID2274MaximumConsecutiveFloorsWithoutSpecialFloors().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试 		 		
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxConsecutive(int bottom, int top, int[] special) {
            Arrays.sort(special);
            int ret = 0;
            int last = bottom;
            for (int s : special) {
                ret = Math.max(ret, s - last);
                last = s + 1;
            }
            ret = Math.max(ret, top - last + 1);
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 