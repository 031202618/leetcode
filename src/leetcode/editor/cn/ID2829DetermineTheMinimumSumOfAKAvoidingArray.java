package leetcode.editor.cn;

public class ID2829DetermineTheMinimumSumOfAKAvoidingArray {

    public static void main(String[] args) {
        Solution solution = new ID2829DetermineTheMinimumSumOfAKAvoidingArray().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        System.out.println(solution.minimumSum(2, 6));
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumSum(int n, int k) {
            int v = ((k - 1) / 2) * ((n + 1) - (k - (k - 1) / 2));
            return n * (n + 1) / 2 + (v >= 0 ? v : 0);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 