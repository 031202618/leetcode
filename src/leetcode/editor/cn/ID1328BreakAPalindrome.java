package leetcode.editor.cn;

public class ID1328BreakAPalindrome {

    public static void main(String[] args) {
        Solution solution = new ID1328BreakAPalindrome().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        System.out.println(solution.breakPalindrome("ba"));
        System.out.println(solution.breakPalindrome("ab"));
        System.out.println(solution.breakPalindrome("aca"));
        System.out.println(solution.breakPalindrome("cac"));
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String breakPalindrome(String palindrome) {
            if (palindrome.length() <= 1) return "";
            // 都为a 则替换第一个为b
            // 不都为a 则找到第一个非a 替换为a 且 奇数不能换中间
            char[] charArray = palindrome.toCharArray();
            boolean allA = true;
            for (char c : charArray) {
                if (c != 'a') {
                    allA = false;
                    break;
                }
            }
            if (allA) {
                charArray[charArray.length - 1] = 'b';
                return new String(charArray);
            }
            boolean cg = false;
            for (int i = 0; i < charArray.length; i++) {
                if (charArray[i] != 'a') {
                    if ((charArray.length & 1) == 0 || i != charArray.length / 2) {
                        cg = true;
                        charArray[i] = 'a';
                        break;
                    }
                }
            }
            if (cg) {
                return new String(charArray);
            }
            charArray[charArray.length - 1] = 'b';
            return new String(charArray);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 