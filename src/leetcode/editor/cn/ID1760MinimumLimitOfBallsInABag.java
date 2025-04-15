package leetcode.editor.cn;

import java.util.Arrays;

public class ID1760MinimumLimitOfBallsInABag {

    public static void main(String[] args) {
        Solution solution = new ID1760MinimumLimitOfBallsInABag().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        solution.minimumSize(new int[]{7, 17}, 2);
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int[] arr;
        int op;

        public int minimumSize(int[] nums, int maxOperations) {
            this.arr = nums;
            this.op = maxOperations;
            int l = 1;
            int r = Arrays.stream(nums).max().getAsInt();
            while (l < r) {
                int mid = l + (r - l) / 2;
                boolean verify = check(mid);
                if (verify) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            return l;
        }

        boolean check(int v) {
            int o = 0;
            for (int x : arr) {
                int add = (x + v - 1) / v - 1;
                o += add;
                if (o > op) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 