package leetcode.editor.cn;

import java.util.Arrays;

public class ID1561MaximumNumberOfCoinsYouCanGet {

    public static void main(String[] args) {
        Solution solution = new ID1561MaximumNumberOfCoinsYouCanGet().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxCoins(int[] piles) {
            Arrays.sort(piles);
            int cnt = piles.length / 3;
            int last = piles.length - 2;
            int ret = 0;
            while (cnt-- > 0) {
                ret += piles[last];
                last -= 2;
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 