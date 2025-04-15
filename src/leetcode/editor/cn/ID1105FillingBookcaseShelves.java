package leetcode.editor.cn;

import java.util.Arrays;

public class ID1105FillingBookcaseShelves {

    public static void main(String[] args) {
        Solution solution = new ID1105FillingBookcaseShelves().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        solution.minHeightShelves(new int[][]{{7, 3}, {8, 7}, {2, 7}, {2, 5}}, 10);
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minHeightShelves(int[][] books, int shelfWidth) {
            int[] dp = new int[books.length + 1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;
            for (int i = 1; i <= books.length; i++) {
                int width = 0;
                int height = 0;
                for (int j = i; j >= 1; j--) {
                    int[] book = books[j - 1];
                    width += book[0];
                    height = Math.max(height, book[1]);
                    if (width > shelfWidth) {
                        break;
                    }
                    dp[i] = Math.min(dp[i], height + dp[j - 1]);
                }
            }
            return dp[books.length];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 