package leetcode.editor.cn;

public class ID3305CountOfSubstringsContainingEveryVowelAndKConsonantsI {

    public static void main(String[] args) {
        Solution solution = new ID3305CountOfSubstringsContainingEveryVowelAndKConsonantsI().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        System.out.println(solution.countOfSubstrings("aeioqq", 1));
        System.out.println(solution.countOfSubstrings("aeiou", 0));
        System.out.println(solution.countOfSubstrings("ieaouqqieaouqq", 1));
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean verify(char c) {
            return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
        }
        

        public int countOfSubstrings(String word, int k) {
            int ret = 0;
            int l = 0;
            int r = 0;
            int[] arr = new int[26];
            int kTarget = 0;
            while (r < word.length() && kTarget < k) {
                char c = word.charAt(r);
                arr[c - 'a']++;
                r++;
                if (!verify(c)) {
                    kTarget++;
                }
            }

            while (l < word.length() && kTarget == k) {
                if (arr[0] >= 1 && arr['e' - 'a'] >= 1 && arr['i' - 'a'] >= 1 && arr['o' - 'a'] >= 1 && arr['u' - 'a'] >= 1) {
                    ret++;
                }
                r++;
                while (r < word.length()) {
                    char c = word.charAt(r);
                    if (verify(c)) {
                        r++;
                        arr[c - 'a']++;
                        if (arr[0] >= 1 && arr['e' - 'a'] >= 1 && arr['i' - 'a'] >= 1 && arr['o' - 'a'] >= 1 && arr['u' - 'a'] >= 1) {
                            ret++;
                        }
                    } else {
                        r--;
                        break;
                    }
                }
                l++;
                while (l <= r && kTarget == k && l < word.length()) {
                    char c = word.charAt(l);
                    if (verify(c)) {
                        l++;
                        arr[c - 'a']--;
                        if (arr[0] >= 1 && arr['e' - 'a'] >= 1 && arr['i' - 'a'] >= 1 && arr['o' - 'a'] >= 1 && arr['u' - 'a'] >= 1) {
                            ret++;
                        }
                    } else {
                        l++;
                        kTarget--;
                    }
                }
                if (r < word.length()) {
                    r++;
                    kTarget++;
                }
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 