package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ID2463MinimumTotalDistanceTraveled {

    public static void main(String[] args) {
        Solution solution = new ID2463MinimumTotalDistanceTraveled().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        solution.minimumTotalDistance(new ArrayList<>(List.of(0, 4, 6)), new int[][]{{2, 2}, {6, 2}});
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
            Arrays.sort(factory, (a, b) -> a[0] - b[0]);
            Integer[] r = robot.toArray(Integer[]::new);
            Arrays.sort(r);
            int m = r.length;

            long[] f = new long[m + 1];
            Arrays.fill(f, Long.MAX_VALUE / 2);
            f[0] = 0;
            for (int[] fa : factory) {
                for (int j = m; j > 0; j--) {
                    long cost = 0;
                    for (int k = 1; k <= Math.min(j, fa[1]); k++) {
                        cost += Math.abs(r[j - k] - fa[0]);
                        f[j] = Math.min(f[j], f[j - k] + cost);
                    }
                }
            }
            return f[m];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 