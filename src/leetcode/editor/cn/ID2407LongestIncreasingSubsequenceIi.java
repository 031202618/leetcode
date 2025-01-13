package leetcode.editor.cn;

import java.util.Arrays;

public class ID2407LongestIncreasingSubsequenceIi {

    public static void main(String[] args) {
        Solution solution = new ID2407LongestIncreasingSubsequenceIi().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        solution.lengthOfLIS(new int[]{4, 2, 1, 4, 3, 4, 5, 8, 15}, 3);
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLIS(int[] nums, int k) {
            int maxi = Arrays.stream(nums).max().getAsInt() + 1;
            Bit bt = new Bit(new int[maxi], new int[maxi]);
            for (int num : nums) {
                int l = Math.max(num - k, 1);
                int r = num - 1;
                int query = bt.query(l, r);
                bt.update(num, query + 1);
            }
            return bt.query(1, maxi - 1);
        }

        class Bit {
            int[] ori;
            int[] trie;

            public Bit(int[] ori, int[] trie) {
                this.ori = ori;
                this.trie = trie;
            }

            public int query(int l, int r) {
                int ret = ori[r];
                while (l <= r) {
                    int prev = r & (r - 1);
                    if (prev < l) {
                        ret = Math.max(ret, ori[r--]);
                    } else {
                        ret = Math.max(ret, trie[r]);
                        r = prev;
                    }
                }
                return ret;
            }

            public void update(int x, int val) {
                ori[x] = val;
                while (x < trie.length) {
                    trie[x] = Math.max(trie[x], val);
                    x += x & -x;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 