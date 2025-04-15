package leetcode.editor.cn;

public class ID2255CountPrefixesOfAGivenString {

    public static void main(String[] args) {
        Solution solution = new ID2255CountPrefixesOfAGivenString().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countPrefixes(String[] words, String s) {
            int cnt = 0;
            for (String word : words) {
                int wL = word.length();
                if (wL > s.length()) continue;
                int add = 1;
                for (int i = 0; i < wL; i++) {
                    if (s.charAt(i) != word.charAt(i)) {
                        add = 0;
                        break;
                    }
                }
                cnt += add;
            }
            return cnt;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 