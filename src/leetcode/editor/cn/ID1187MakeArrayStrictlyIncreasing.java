package leetcode.editor.cn;

import java.util.Arrays;

public class ID1187MakeArrayStrictlyIncreasing {

    public static void main(String[] args) {
        Solution solution = new ID1187MakeArrayStrictlyIncreasing().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        solution.makeArrayIncreasing(new int[]{1, 5, 3, 6, 7}, new int[]{1, 6, 3, 3});
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int[][] count;

        public int makeArrayIncreasing(int[] arr1, int[] arr2) {
            int[] dp = new int[arr1.length + 2];
            Arrays.sort(arr2);
            count = new int[arr2.length][arr2.length];
            for (int i = 0; i < arr2.length; i++) {
                for (int j = i; j < arr2.length; j++) {
                    if (j == i) {
                        count[i][j] = 1;
                        continue;
                    }
                    if (arr2[j] > arr2[j - 1]) {
                        count[i][j] = count[i][j - 1] + 1;
                    } else {
                        count[i][j] = count[i][j - 1];
                    }
                }
            }
            int[] newArr = new int[arr1.length + 2];
            newArr[0] = -1;
            newArr[arr1.length + 1] = Integer.MAX_VALUE;
            for (int i = 1; i <= arr1.length; i++) {
                newArr[i] = arr1[i - 1];
            }
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;
            for (int i = 1; i < newArr.length; i++) {
                for (int j = 0; j < i; j++) {
                    boolean valid;
                    int cnt = i - j - 1;
                    if (cnt == 0) {
                        valid = true;
                    } else {
                        int gapL = newArr[j];
                        int gapR = newArr[i];
                        valid = valid(arr2, gapL, gapR, cnt);
                    }
                    if (newArr[j] < newArr[i] && dp[j] != Integer.MAX_VALUE && valid) {
                        dp[i] = Math.min(dp[i], dp[j] + cnt);
                    }
                }
            }
            return dp[dp.length - 1] == Integer.MAX_VALUE ? -1 : dp[dp.length - 1];
        }

        public boolean valid(int[] arr, int gapL, int gapR, int cnt) {
            //第一个大于 gapL的pos
            //第一个小于 gapR的pos
            //两者距离只差是否大于等于cnt.
            int l;
            int r;
            l = 0;
            r = arr.length - 1;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (arr[mid] > gapL) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            if (arr[l] <= gapL) {
                return false;
            }
            int posL = l;

            l = 0;
            r = arr.length - 1;
            while (l < r - 1) {
                int mid = l + (r - l) / 2;
                if (arr[mid] >= gapR) {
                    r = mid - 1;
                } else {
                    l = mid;
                }
            }
            int posR;
            if (arr[r] < gapR) {
                posR = r;
            } else if (arr[l] < gapR) {
                posR = l;
            } else {
                return false;
            }
            return count[posL][posR] >= cnt;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 