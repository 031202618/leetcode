package leetcode.editor.cn;

public class ID2264Largest3SameDigitNumberInString {

    public static void main(String[] args) {
        Solution solution = new ID2264Largest3SameDigitNumberInString().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String largestGoodInteger(String num) {
            char[] charArray = num.toCharArray();
            Character max = null;
            for (int i = 0; i < charArray.length - 2; i++) {
                if (charArray[i] == charArray[i + 1] && charArray[i] == charArray[i + 2]) {
                    if (max == null) {
                        max = charArray[i];
                    } else {
                        max = max > charArray[i] ? max : charArray[i];
                    }
                }
            }
            return max == null ? "" : max + "" + max + max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 