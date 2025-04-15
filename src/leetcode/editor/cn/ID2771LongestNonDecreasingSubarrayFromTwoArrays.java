package leetcode.editor.cn;

public class ID2771LongestNonDecreasingSubarrayFromTwoArrays {

    public static void main(String[] args) {
        Solution solution = new ID2771LongestNonDecreasingSubarrayFromTwoArrays().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        solution.maxNonDecreasingLength(new int[]{4, 17, 1, 16, 7, 2}, new int[]{1, 4, 20, 10, 15, 18});
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxNonDecreasingLength(int[] nums1, int[] nums2) {
            int n1 = 1;
            int n2 = 1;
            int len = nums1.length;
            int ret = 1;
            for (int i = 0; i < len; i++) {
                if (i == 0) {
                    n1 = 1;
                    n2 = 1;
                    continue;
                }
                int t1 = nums1[i];
                int t2 = nums2[i];
                int t1Prev = nums1[i - 1];
                int t2Prev = nums2[i - 1];
                int tmpN1 = n1;
                int tmpN2 = n2;
                n1 = 1;
                n2 = 1;
                if (t1 >= t1Prev) {
                    n1 = tmpN1 + 1;
                }
                if (t1 >= t2Prev) {
                    n1 = Math.max(n1, tmpN2 + 1);
                }

                if (t2 >= t2Prev) {
                    n2 = tmpN2 + 1;
                }
                if (t2 >= t1Prev) {
                    n2 = Math.max(n2, tmpN1 + 1);
                }
                ret = Math.max(ret, n1);
                ret = Math.max(ret, n2);
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 