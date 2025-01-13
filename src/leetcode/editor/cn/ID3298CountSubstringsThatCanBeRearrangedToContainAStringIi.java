package leetcode.editor.cn;

public class ID3298CountSubstringsThatCanBeRearrangedToContainAStringIi {

    public static void main(String[] args) {
        Solution solution = new ID3298CountSubstringsThatCanBeRearrangedToContainAStringIi().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        solution.validSubstringCount("bcca", "abc");
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long validSubstringCount(String word1, String word2) {
            Integer[] target = new Integer[26];
            char[] charArray = word2.toCharArray();
            int cnt = 0;
            for (char c : charArray) {
                if (target[c - 'a'] == null) {
                    target[c - 'a'] = 0;
                    cnt++;
                }
                target[c - 'a']++;
            }
            int l = 0;
            int r = 0;
            char[] ch1 = word1.toCharArray();
            long ret = 0;
            while (r < ch1.length) {
                if (target[ch1[r] - 'a'] != null && target[ch1[r] - 'a'] == 1) {
                    cnt--;
                }
                if (target[ch1[r] - 'a'] != null) {
                    target[ch1[r] - 'a']--;
                }
                while (cnt == 0 && l <= r) {
                    ret += (ch1.length - r);
                    if (target[ch1[l] - 'a'] != null) {
                        if(target[ch1[l] - 'a'] == 0){
                            cnt++;
                        }
                        target[ch1[l] - 'a']++;
                    }
                    l++;

                }
                r++;
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 