package leetcode.editor.cn;

public class ID1963MinimumNumberOfSwapsToMakeTheStringBalanced {

    public static void main(String[] args) {
        Solution solution = new ID1963MinimumNumberOfSwapsToMakeTheStringBalanced().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        System.out.println(solution.minSwaps("]]][[["));
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minSwaps(String s) {
            int stack = 0;
            int r = s.length() - 1;
            int swapCount = 0;
            for (int i = 0; i < s.length() && i < r; i++) {
                char c = s.charAt(i);
                if (c == '[') {
                    stack++;
                } else {
                    if (stack == 0) {
                        //find r
                        while (s.charAt(r) != '[') {
                            r--;
                        }
                        r--;
                        swapCount++;
                        stack++;
                    } else {
                        stack--;
                    }
                }
            }
            return swapCount;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 