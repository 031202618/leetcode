package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ID3297CountSubstringsThatCanBeRearrangedToContainAStringI {

    public static void main(String[] args) {
        Solution solution = new ID3297CountSubstringsThatCanBeRearrangedToContainAStringI().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        solution.validSubstringCount("bcca", "abc");
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long validSubstringCount(String word1, String word2) {
            int[] window = new int[27];
            Set<Character> set = new HashSet<>();
            int[] counts = new int[27];
            for (char c : word2.toCharArray()) {
                counts[c - 'a'] = 1;
            }
            for (char c : word2.toCharArray()) {
                window[c - 'a']++;
                set.add(c);
            }
            long ret = 0;
            int l = 0, r = 0;
            int w1L = word1.length();
            while (l < word1.length()) {
                while (!set.isEmpty() && r < word1.length()) {
                    char c = word1.charAt(r++);
                    if (counts[c - 'a'] == 1) {
                        window[c - 'a']--;
                    }
                    if (window[c - 'a'] == 0) {
                        set.remove(c);
                    }
                }
                if (set.isEmpty()) {
                    ret += (w1L - r + 1);
                }
                if (counts[word1.charAt(l) - 'a'] == 1) {
                    window[word1.charAt(l) - 'a']++;
                    if (window[word1.charAt(l) - 'a'] > 0) {
                        set.add(word1.charAt(l));
                    }
                }
                l++;
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 