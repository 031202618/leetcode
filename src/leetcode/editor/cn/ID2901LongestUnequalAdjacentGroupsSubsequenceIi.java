package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ID2901LongestUnequalAdjacentGroupsSubsequenceIi {

    public static void main(String[] args) {
        Solution solution = new ID2901LongestUnequalAdjacentGroupsSubsequenceIi().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        System.out.println(solution.getWordsInLongestSubsequence(new String[]{"abd", "bab", "bc", "ac", "acd"}, new int[]{3, 5, 3, 3, 4}));
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //        1 <= n == words.length == groups.length <= 1000
//1 <= words[i].length <= 10
//1 <= groups[i] <= n
//words 中的字符串 互不相同 。
//words[i] 只包含小写英文字母。
        public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
            List<Pair>[] pairs = new ArrayList[11];
            Arrays.setAll(pairs, i -> new ArrayList<>());
            for (int i = 0; i < words.length; i++) {
                int l = words[i].length();
                pairs[l].add(new Pair(words[i], groups[i]));
            }
            List<String> res = Collections.emptyList();
            for (List<Pair> pair : pairs) {
                List<String> tmp = calc(pair);
                if (tmp.size() > res.size()) {
                    res = tmp;
                }
            }
            return res.reversed();
        }

        public List<String> calc(List<Pair> pairs) {
            Pair[] pArr = pairs.toArray(new Pair[0]);
            int len = pArr.length;
            int[] dp = new int[len + 1];
            Arrays.fill(dp, 1);
            int maxi = 1;
            for (int i = 2; i <= len; i++) {
                Pair pair = pArr[i - 1];
                String s = pair.s;
                int g = pair.group;
                for (int j = i - 1; j >= 1; j--) {
                    Pair nxt = pArr[j - 1];
                    String ns = nxt.s;
                    int ng = nxt.group;
                    if (ng != g && disSatisfy(s, ns)) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                maxi = Math.max(maxi, dp[i]);
            }

            List<String> res = new ArrayList<>();
            int upGroup = -1;
            String upStr = null;
            for (int i = len; i > 0; i--) {
                if (maxi == dp[i] && upGroup != pArr[i - 1].group) {
                    if (upStr == null || disSatisfy(upStr, pArr[i - 1].s)) {
                        res.add(pArr[i - 1].s);
                        upGroup = pArr[i - 1].group;
                        maxi--;
                        upStr = pArr[i - 1].s;
                    }
                }
            }
            return res;
        }

        public boolean disSatisfy(String s, String s2) {
            int diff = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != s2.charAt(i)) {
                    diff++;
                }
                if (diff > 1) {
                    return false;
                }
            }
            return diff == 1;
        }

        record Pair(String s, int group) {
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 