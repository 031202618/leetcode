package leetcode.editor.cn;

public class ID1567MaximumLengthOfSubarrayWithPositiveProduct {

    public static void main(String[] args) {
        Solution solution = new ID1567MaximumLengthOfSubarrayWithPositiveProduct().new Solution();
        solution.getMaxLen(new int[]{1, 2, 3, 5, -6, 4, 0, 10});
        StringBuilder sb = new StringBuilder();                //执行测试
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int getMaxLen(int[] nums) {
            int a = 0;
            int b = 0;
            int maxi = 0;
            for (int num : nums) {
                if (num == 0) {
                    a = 0;
                    b = 0;
                } else if (num > 0) {
                    a++;
                    if (b > 0) {
                        b++;
                    }
                } else {
                    int tmp = b;
                    if (a > 0) {
                        b = a + 1;
                    } else {
                        b = 1;
                    }
                    if (tmp > 0) {
                        a = tmp + 1;
                    } else {
                        a = 0;
                    }
                }
                maxi = Math.max(maxi, a);
            }
            return maxi;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 