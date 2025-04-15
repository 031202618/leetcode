package leetcode.editor.cn;

import java.util.Arrays;

public class ID1473PaintHouseIii {

    public static void main(String[] args) {
        Solution solution = new ID1473PaintHouseIii().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        //12
        System.out.println(solution.minCost(new int[]{0, 0, 0, 1}, new int[][]{{1, 5}, {4, 1}, {1, 3}, {4, 4}}, 4, 2, 4));
        //9
        System.out.println(solution.minCost(new int[]{0, 0, 0, 0, 0}, new int[][]{{1, 10}, {10, 1}, {10, 1}, {1, 10}, {5, 1}}, 5, 2, 3));
        //11
        System.out.println(solution.minCost(new int[]{0, 2, 1, 2, 0}, new int[][]{{1, 10}, {10, 1}, {10, 1}, {1, 10}, {5, 1}}, 5, 2, 3));
        //5
        System.out.println(solution.minCost(new int[]{0, 0, 0, 0, 0}, new int[][]{{1, 10}, {10, 1}, {1, 10}, {10, 1}, {1, 10}}, 5, 2, 5));
        //-1
        System.out.println(solution.minCost(new int[]{3, 1, 2, 3}, new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}, {1, 1, 1}}, 4, 3, 3));

        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
            final int DEFAULT_RET = -1;
            int[][] dp = new int[m + 1][n + 1];
            //dp[1][1], dp[2][1]
            int forceColor = 0;
            for (int i = 1; i <= m; i++) {
                Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
                int color = houses[i - 1];
                if (forceColor == 0) {
                    if (color == 0) {
                        for (int j = 1; j <= n; j++) {
                            dp[i][j] = dp[i - 1][j] + cost[i - 1][j - 1];
                        }
                    } else {
                        dp[i][color] = dp[i - 1][color];
                        forceColor = color;
                    }
                } else {
                    if (color == 0) {
                        dp[i][forceColor] = dp[i - 1][forceColor] + cost[i - 1][forceColor - 1];
                    } else if (color == forceColor) {
                        dp[i][forceColor] = dp[i - 1][forceColor];
                    }
                }
            }
            for (int loop = 1; loop < target; loop++) {
                for (int i = m; i >= 1; i--) {
                    Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
                    int curCost = 0;
                    int curH = houses[i - 1];
                    //有颜色
                    if (curH != 0) {
                        for (int j = i; j > 1; j--) {
                            if (houses[j - 1] == curH) {
                            } else if (houses[j - 1] == 0) {
                                curCost += cost[j - 1][curH - 1];
                            } else {
                                break;
                            }
                            for (int k = 1; k <= n; k++) {
                                if (k == curH) {
                                    continue;
                                }
                                dp[i][curH] = Math.min(dp[i][curH], dp[j - 1][k] + curCost);
                            }
                        }
                    } else {
                        //无颜色
                        for (int k = 1; k <= n; k++) {
                            curH = k;
                            curCost = 0;
                            for (int j = i; j > 1; j--) {
                                if (houses[j - 1] == curH) {
                                } else if (houses[j - 1] == 0) {
                                    curCost += cost[j - 1][curH - 1];
                                } else {
                                    break;
                                }
                                for (int l = 1; l <= n; l++) {
                                    if (l == curH) {
                                        continue;
                                    }
                                    dp[i][curH] = Math.min(dp[i][curH], dp[j - 1][l] + curCost);
                                }
                            }
                        }
                    }
                }
            }
            int ret = Integer.MAX_VALUE / 2;
            for (int i = 1; i <= n; i++) {
                ret = Math.min(ret, dp[m][i]);
            }
            return ret == Integer.MAX_VALUE / 2 ? DEFAULT_RET : ret;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


} 