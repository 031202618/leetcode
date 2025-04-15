package leetcode.editor.cn;

public class ID2278PercentageOfLetterInString {

    public static void main(String[] args) {
        Solution solution = new ID2278PercentageOfLetterInString().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int percentageLetter(String s, char letter) {
            char[] charArray = s.toCharArray();
            int up = 0;
            int down = 0;
            for (char c : charArray) {
                if (c == letter) {
                    up++;
                }
                down++;
            }
            return up *100 / down;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 