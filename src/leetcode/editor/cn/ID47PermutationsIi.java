package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ID47PermutationsIi {

    public static void main(String[] args) {
        Solution solution = new ID47PermutationsIi().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        solution.permuteUnique(new int[]{1, 1, 2});
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<List<Integer>> ret;
        int[] nums;

        public List<List<Integer>> permuteUnique(int[] nums) {
            Arrays.sort(nums);
            ret = new ArrayList<>();
            this.nums = nums;
            dfs(0, nums.length, 0, new ArrayList<>());
            return ret;
        }

        public void dfs(int step, int n, int bit, List<Integer> tmp) {
            if (step == n) {
                ret.add(new ArrayList<>(tmp));
            }
            //1 2 2 2 3
            for (int i = 0; i < n; i++) {
                if (i > 0 && (bit & (1 << (i - 1))) == 0 && nums[i] == nums[i - 1] || ((bit & (1 << i)) != 0)) {
                    continue;
                }
                tmp.add(nums[i]);
                dfs(step + 1, n, bit | (1 << i), tmp);
                tmp.removeLast();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 