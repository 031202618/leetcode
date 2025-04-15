package leetcode.editor.cn;

public class ID2911MinimumChangesToMakeKSemiPalindromes {

    public static void main(String[] args) {
        Solution solution = new ID2911MinimumChangesToMakeKSemiPalindromes().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        System.out.println(solution.minimumChanges("edaswf", 1));
        System.out.println(solution.minimumChanges("acba", 2));
        System.out.println(solution.minimumChanges("abcac", 2));
        System.out.println(solution.minimumChanges("abcdef", 2));
        System.out.println(solution.minimumChanges("aabbaa", 3));

        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumChanges(String s, int k) {
            int[][] cost = new int[s.length() + 1][s.length() + 1];
            int sLen = s.length();
            char[] ch = s.toCharArray();
            for (int i = 1; i <= sLen; i++) {
                for (int j = i; j <= sLen; j++) {
                    if (i == j) {
                        cost[i][j] = Integer.MAX_VALUE / 2;
                        continue;
                    }
                    int subLen = j - i + 1;
                    int min = Integer.MAX_VALUE;
                    int max = 0;
                    for (int len = 1; len < subLen; len++) {
                        if (subLen % len == 0) {
                            int diff = 0;
                            for (int l = i; l < i + len; l++) {
                                StringBuilder sb = new StringBuilder();
                                int cur = l;
                                while (cur <= j) {
                                    sb.append(ch[cur - 1]);
                                    cur += len;
                                }
                                int l1 = 0;
                                int r1 = sb.length() - 1;
                                while (l1 < r1) {
                                    if (sb.charAt(l1++) != sb.charAt(r1--)) {
                                        diff++;
                                    }
                                }
                            }
                            min = Math.min(min, diff);
                        }
                    }
                    cost[i][j] = min;
                }
            }
            int[] dp = new int[s.length() + 1];
            for (int i = 1; i <= sLen; i++) {
                dp[i] = cost[1][i];
            }
            for (int i = 2; i <= k; i++) {
                for (int j = s.length(); j >= 1; j--) {
                    dp[j] = Integer.MAX_VALUE / 2;
                    for (int l = j; l >= i; l--) {
                        dp[j] = Math.min(dp[j], dp[l - 1] + cost[l][j]);
                    }
                }
            }
            return dp[s.length()];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 