package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ID3306CountOfSubstringsContainingEveryVowelAndKConsonantsIi {

    public static void main(String[] args) {
        Solution solution = new ID3306CountOfSubstringsContainingEveryVowelAndKConsonantsIi().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        System.out.println(solution.countOfSubstrings("aeioqq", 1));
        System.out.println(solution.countOfSubstrings("aeiou", 0));
        System.out.println(solution.countOfSubstrings("ieaouqqieaouqq", 1));
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public long count2(String word, int m) {
            Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
            int n = word.length(), consonants = 0;
            long res = 0;
            Map<Character, Integer> occur = new HashMap<>();
            int j = 0;
            for (int i = 0; i < n; i++) {
                while (j < n && (consonants < m || occur.size() < 5)) {
                    char ch = word.charAt(j);
                    if (vowels.contains(ch)) {
                        occur.put(ch, occur.getOrDefault(ch, 0) + 1);
                    } else {
                        consonants++;
                    }
                    j++;
                }
                if (consonants >= m && occur.size() == 5) {
                    res += n - j + 1;
                }
                char left = word.charAt(i);
                if (vowels.contains(left)) {
                    occur.put(left, occur.get(left) - 1);
                    if (occur.get(left) == 0) {
                        occur.remove(left);
                    }
                } else {
                    consonants--;
                }
            }
            return res;
        }

        public long countOfSubstrings2(String word, int k) {
            return count(word, k) - count(word, k + 1);
        }


        Set<Character> yy = Set.of('a', 'e', 'i', 'o', 'u');

        public long countOfSubstrings(String word, int k) {
            return count(word, k) - count(word, k + 1);
        }

        public boolean verify(int[] count) {
            for (Character c : yy) {
                if (count[c - 'a'] < 1) {
                    return false;
                }
            }
            return true;
        }

        public long count(String word, int k) {
            long ret = 0;
            int l = 0;
            int r = -1;
            int[] count = new int[26];
            int tmpK = 0;
            while (l < word.length()) {
                while ((!verify(count) || tmpK < k) && r + 1 < word.length()) {
                    char c = word.charAt(++r);
                    count[c - 'a']++;
                    if (!yy.contains(c)) tmpK++;
                }
                if (verify(count) && tmpK >= k) {
                    ret += (word.length() - r);
                }
                char c = word.charAt(l);
                count[c - 'a']--;
                if (!yy.contains(c)) tmpK--;
                l++;
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 