package leetcode.editor.cn;

public class ID3290MaximumMultiplicationScore {

    public static void main(String[] args) {
        Solution solution = new ID3290MaximumMultiplicationScore().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        solution.maxScore(new int[]{3, 2, 5, 6}, new int[]{2, -6, 4, -5, -3, 2, -7});
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long maxScore(int[] a, int[] b) {
            long a1 = Long.MIN_VALUE;
            long a2 = Long.MIN_VALUE;
            long a3 =Long.MIN_VALUE;
            long a4 =Long.MIN_VALUE;
            for (int i = 1; i <= b.length; i++) {
                long tmp1 = (long)a[0] * b[i - 1];
                long tmp2 = (long)a[1] * b[i - 1];
                long tmp3 = (long)a[2] * b[i - 1];
                long tmp4 = (long)a[3] * b[i - 1];
                if (i >= 4) {
                    a4 = Math.max(a4, a3 + tmp4);
                }
                if (i >= 3) {
                    a3 = Math.max(a3, a2 + tmp3);
                }
                if (i >= 2) {
                    a2 = Math.max(a2, a1 + tmp2);
                }
                a1 = Math.max(a1, tmp1);
            }
            return a4;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 