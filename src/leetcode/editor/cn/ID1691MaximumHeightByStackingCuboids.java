package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

public class ID1691MaximumHeightByStackingCuboids {

    public static void main(String[] args) {
        Solution solution = new ID1691MaximumHeightByStackingCuboids().new Solution();
        //[[92,47,83],[75,20,87],[68,12,83],[12,85,15],[16,24,47],[69,65,35],[96,56,93],[89,93,11],[86,20,41],[69,77,12],[83,80,97],[90,22,36]]
        StringBuilder sb = new StringBuilder();                //执行测试
        solution.maxHeight(new int[][]{{92, 47, 83}, {75, 20, 87}, {68, 12, 83}, {12, 85, 15}, {16, 24, 47}, {69, 65, 35}, {96, 56, 93}, {89, 93, 11}, {86, 20, 41}, {69, 77, 12}, {83, 80, 97}, {90, 22, 36}});
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxHeight2(int[][] cuboids) {
            int n = cuboids.length;
            for (int[] v : cuboids) {
                Arrays.sort(v);
            }
            Arrays.sort(cuboids, (a, b) -> (a[0] + a[1] + a[2]) - (b[0] + b[1] + b[2]));
            int ans = 0;
            int[] dp = new int[n];
            for (int i = 0; i < n; i++) {
                dp[i] = cuboids[i][2];
                for (int j = 0; j < i; j++) {
                    if (cuboids[i][0] >= cuboids[j][0] &&
                            cuboids[i][1] >= cuboids[j][1] &&
                            cuboids[i][2] >= cuboids[j][2]) {
                        dp[i] = Math.max(dp[i], dp[j] + cuboids[i][2]);
                    }
                }
                ans = Math.max(ans, dp[i]);
            }
            return ans;
        }

        int[] dp;

        public int maxHeight(int[][] cuboids) {
            dp = new int[cuboids.length];
            for (int[] cuboid : cuboids) {
                Arrays.sort(cuboid);
            }
            int ret = 0;
            Arrays.sort(cuboids, Comparator.comparingInt(x -> x[0]));
            ret = getRet(cuboids, ret);
            return ret;
        }

        private int getRet(int[][] cuboids, int ret) {
            for (int i = 0; i < cuboids.length; i++) {
                int max = 0;
                for (int j = 0; j < i; j++) {
                    if (cuboids[j][0] <= cuboids[i][0] && cuboids[j][1] <= cuboids[i][1] && cuboids[j][2] <= cuboids[i][2]) {
                        max = Math.max(max, dp[j]);
                    }
                }
                dp[i] = max + cuboids[i][2];
                ret = Math.max(ret, dp[i]);
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 