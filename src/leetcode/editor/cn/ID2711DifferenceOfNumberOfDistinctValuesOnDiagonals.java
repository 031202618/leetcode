package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ID2711DifferenceOfNumberOfDistinctValuesOnDiagonals {

    public static void main(String[] args) {
        Solution solution = new ID2711DifferenceOfNumberOfDistinctValuesOnDiagonals().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        solution.differenceOfDistinctValues(new int[][]{{1, 2, 3}, {3, 1, 5}, {3, 2, 1}});
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] map;
        int r;
        int c;
        int[][] ret;

        public void calc(int x, int y) {
            List<Integer> list = new ArrayList<>();
            Set<Integer> set = new HashSet<>();
            while (x < r && y < c) {
                set.add(map[x][y]);
                list.add(set.size());
                x++;
                y++;
            }
            x--;
            y--;
            int curSize = list.size() - 2;
            set = new HashSet<>();
            while (x >= 0 && y >= 0) {
                ret[x][y] = Math.abs((curSize >= 0 ? list.get(curSize) : 0) - set.size());
                set.add(map[x][y]);
                x--;
                y--;
                curSize--;
            }
        }

        public int[][] differenceOfDistinctValues(int[][] grid) {
            map = grid;
            r = grid.length;
            c = grid[0].length;
            ret = new int[r][c];
            for (int i = 0; i < r; i++) {
                calc(i, 0);
            }

            for (int i = 0; i < c; i++) {
                calc(0, i);
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 