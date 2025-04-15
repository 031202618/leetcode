package leetcode.editor.cn;

import java.util.Arrays;

public class ID1363LargestMultipleOfThree {

    public static void main(String[] args) {
        Solution solution = new ID1363LargestMultipleOfThree().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        solution.largestMultipleOfThree(new int[]{5, 2, 3});
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String largestMultipleOfThree(int[] digits) {
            int n = digits.length;
            Arrays.sort(digits); // 对数组进行排序

            // f[i][j] 表示前i个数字中，模3余j的最大长度
            int[][] f = new int[n + 1][3];
            f[0][1] = Integer.MIN_VALUE;
            f[0][2] = Integer.MIN_VALUE;

            // 动态规划填表
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < 3; ++j) {
                    f[i + 1][j] = Math.max(f[i][j], f[i][(j + digits[i]) % 3] + 1);
                }
            }

            // 如果最终模3余0的最大长度为0，说明没有解
            if (f[n][0] == 0) return "";

            // 根据路径还原
            StringBuilder res = new StringBuilder();
            for (int i = n, j = 0; i > 0; i--) {
                if (f[i][j] == f[i - 1][(j + digits[i - 1]) % 3] + 1) {
                    res.append(digits[i - 1]);
                    j = (j + digits[i - 1]) % 3;
                }
            }

            // 如果结果以'0'开头，说明结果为0
            if (res.charAt(0) == '0') return "0";

            return res.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 