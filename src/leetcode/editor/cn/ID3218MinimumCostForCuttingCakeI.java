package leetcode.editor.cn;

public class ID3218MinimumCostForCuttingCakeI {

    public static void main(String[] args) {
        Solution solution = new ID3218MinimumCostForCuttingCakeI().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
            return minimumCost(horizontalCut, 0, horizontalCut.length - 1, verticalCut, 0, verticalCut.length - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 