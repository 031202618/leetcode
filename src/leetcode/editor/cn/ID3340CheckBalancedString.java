package leetcode.editor.cn;

public class ID3340CheckBalancedString {

    public static void main(String[] args) {
        Solution solution = new ID3340CheckBalancedString().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isBalanced(String num) {
            char[] charArray = num.toCharArray();
            int sumOdd = 0;
            int sumEven = 0;
            for (int i = 0; i < charArray.length; i++) {
                int v = charArray[i] - '0';
                if ((i & 1) == 0) {
                    sumOdd += v;
                } else {
                    sumEven += v;
                }
            }
            return sumOdd == sumEven;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 