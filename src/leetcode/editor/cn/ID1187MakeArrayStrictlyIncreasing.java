package leetcode.editor.cn;

import java.util.Arrays;

public class ID1187MakeArrayStrictlyIncreasing {

    public static void main(String[] args) {
        Solution solution = new ID1187MakeArrayStrictlyIncreasing().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        solution.makeArrayIncreasing(new int[]{1, 5, 3, 6, 7}, new int[]{1, 6, 3, 3});
        System.out.println(sb);
    }

    public int makeArrayIncreasing(int[] a, int[] b) {
        Arrays.sort(b);
        int n = a.length, m = 0;
        for (int i = 1; i < b.length; ++i)
            if (b[m] != b[i])
                b[++m] = b[i]; // 原地去重
        ++m;
        var f = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int x = i < n ? a[i] : Integer.MAX_VALUE;
            int k = lowerBound(b, m, x);
            int res = k < i ? Integer.MIN_VALUE : 0; // 小于 a[i] 的数全部替换
            if (i > 0 && a[i - 1] < x) // 无替换
                res = Math.max(res, f[i - 1]);
            for (int j = i - 2; j >= i - k - 1 && j >= 0; --j)
                if (b[k - (i - j - 1)] > a[j])
                    // a[j+1] 到 a[i-1] 替换成 b[k-(i-j-1)] 到 b[k-1]
                    res = Math.max(res, f[j]);
            f[i] = res + 1; // 把 +1 移到这里，表示 a[i] 不替换
        }
        return f[n] < 0 ? -1 : n + 1 - f[n];
    }

    // 见 https://www.bilibili.com/video/BV1AP41137w7/
    private int lowerBound(int[] nums, int right, int target) {
        int left = -1; // 开区间 (left, right)
        while (left + 1 < right) { // 区间不为空
            // 循环不变量：
            // nums[left] < target
            // nums[right] >= target
            int mid = (left + right) >>> 1;
            if (nums[mid] < target)
                left = mid; // 范围缩小到 (mid, right)
            else
                right = mid; // 范围缩小到 (left, mid)
        }
        return right;
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