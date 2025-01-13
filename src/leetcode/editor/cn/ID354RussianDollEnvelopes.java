package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ID354RussianDollEnvelopes {

    public static void main(String[] args) {
        Solution solution = new ID354RussianDollEnvelopes().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
//        solution.maxEnvelopes(new int[][]{{1, 2}, {2, 3}, {3, 4}, {3, 5}, {4, 5}, {5, 5}, {5, 6}, {6, 7}, {7, 8}});
        solution.maxEnvelopes(new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}});
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxEnvelopes(int[][] envelopes) {
            Arrays.sort(envelopes, (x, y) -> x[0] == y[0] ? x[1] - y[1] : x[0] - y[0]);
            int length = 0;
            for (int[] envelope : envelopes) {
                length = Math.max(length, envelope[1]);
            }
            length++;
            Trie t = new Trie(new int[length]);
            for (int i = 0; i < envelopes.length; ) {
                int[] x = envelopes[i];
                int j = i;
                List<int[]> tmp = new ArrayList<>();
                for (; j < envelopes.length && envelopes[j][0] == x[0]; j++) {
                    int search = t.search(envelopes[j][1] - 1);
                    tmp.add(new int[]{envelopes[j][1], search + 1});
                }
                for (int[] ints : tmp) {
                    t.update(ints[0], ints[1]);
                }
                i = j;
            }
            return t.search(length - 1);
        }

        class Trie {
            int[] arr;

            public Trie(int[] arr) {
                this.arr = arr;
            }

            public int search(int r) {
                int ret = 0;
                while (r > 0) {
                    ret = Math.max(ret, arr[r]);
                    r &= r - 1;
                }
                return ret;
            }

            public void update(int x, int val) {
                while (x < arr.length) {
                    arr[x] = Math.max(arr[x], val);
                    x += x & -x;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 