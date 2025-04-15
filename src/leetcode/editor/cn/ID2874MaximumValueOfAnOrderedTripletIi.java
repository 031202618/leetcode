package leetcode.editor.cn;

public class ID2874MaximumValueOfAnOrderedTripletIi {

    public static void main(String[] args) {
        Solution solution = new ID2874MaximumValueOfAnOrderedTripletIi().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        solution.maximumTripletValue(new int[]{12, 6, 1, 2, 7});
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long maximumTripletValue(int[] nums) {
            //(nums[i] - nums[j]) * nums[k]
            long ret = 0;
            int n = nums.length;
            int[][] back = new int[n][2];
            back[n - 1][0] = nums[n - 1];
            back[n - 1][1] = nums[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                back[i][0] = Math.min(back[i + 1][0], nums[i]);
                back[i][1] = Math.max(back[i + 1][1], nums[i]);
            }
            int max = nums[0];
            int min = nums[0];
            for (int i = 1; i < n - 1; i++) {
                int l1 = max - nums[i];
                int l2 = min - nums[i];
                int[] arr1 = {l1, l2};
                int r1 = back[i + 1][0];
                int r2 = back[i + 1][1];
                int[] arr2 = {r1, r2};
                for (int x : arr1) {
                    for (int y : arr2) {
                        ret = Math.max(ret, (x) * (long) y);
                    }
                }
                max = Math.max(max, nums[i]);
                min = Math.min(min, nums[i]);
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 