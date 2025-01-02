package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class ID1671MinimumNumberOfRemovalsToMakeMountainArray {

    public static void main(String[] args) {
        Solution solution = new ID1671MinimumNumberOfRemovalsToMakeMountainArray().new Solution();
        StringBuilder sb = new StringBuilder().append(solution.minimumMountainRemovals(new int[]{100, 92, 89, 77, 74, 66, 64, 66, 64}));                //执行测试
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumMountainRemovals(int[] nums) {
            int[] dp1 = calc(nums);
            ArrayList<Integer> integers = new ArrayList<>(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            Collections.reverse(integers);
            int[] dp2 = calc(integers.stream().mapToInt(i -> i).toArray());
            int min = Integer.MAX_VALUE;
            for (int left = 2; left < nums.length; left++) {
                int l = dp1[left];
                int r = dp2[nums.length - left + 1];
                if (l >= 2 && r >= 2) {
                    min = Math.min(min, nums.length - dp1[left] - dp2[nums.length - left + 1] + 1);
                }
            }
            return min;
        }

        private int[] calc(int[] nums) {
            int[] dp = new int[nums.length + 1];
            Arrays.fill(dp, 1);
            for (int i = 2; i <= nums.length; i++) {
                for (int j = 1; j < i; j++) {
                    if (nums[j - 1] < nums[i - 1]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }
            return dp;
        }

        private int[] calc2(int[] nums) {
            int[] arr = new int[nums.length + 1];
            int curLen = 1;
            arr[1] = nums[0];
            for (int i = 2; i <= nums.length; i++) {
                int val = nums[i - 1];
                if (val > arr[curLen]) {
                    arr[++curLen] = val;
                } else {
                    int l = 1;
                    int r = curLen;
                    while (l < r) {
                        int mid = l + (r - l) / 2;
                        if (arr[mid] > val) {

                        } else if (arr[mid] < val) {

                        } else {

                        }
                    }
                }
            }
            return arr;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 