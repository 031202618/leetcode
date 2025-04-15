package leetcode.editor.cn;

public class ID1186MaximumSubarraySumWithOneDeletion {

    public static void main(String[] args) {
        Solution solution = new ID1186MaximumSubarraySumWithOneDeletion().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumSum(int[] arr) {
            int n = arr[0];
            int y = 0;
            if (arr.length == 1) return arr[0];
            int ret = arr[0];
            for (int i = 1; i < arr.length; i++) {
                int x = arr[i];
                int tmpN = n;
                int tmpY = y;
                n = Math.max(tmpN + x, x);
                y = Math.max(tmpY + x, tmpN);
                ret = Math.max(ret, y);
                ret = Math.max(ret, n);
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 