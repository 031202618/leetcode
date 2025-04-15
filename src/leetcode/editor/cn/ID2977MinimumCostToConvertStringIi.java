package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ID2977MinimumCostToConvertStringIi {

    static int[][] cost1;
    static long[][] cost3;

    public static void main(String[] args) {
        Solution solution = new ID2977MinimumCostToConvertStringIi().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        long l = solution.minimumCost("fjybg", "apyyt",
                new String[]{"bg", "xr", "cc", "ip", "vq", "po", "ym", "rh", "vw", "lf", "lo", "ee", "qv", "yr", "f", "w", "i", "u", "g", "a", "e", "f", "s", "r", "p", "j", "o", "g", "i", "u"},
                new String[]{"xr", "cc", "ip", "vq", "po", "ym", "rh", "vw", "lf", "lo", "ee", "qv", "yr", "yt", "w", "i", "u", "g", "a", "e", "f", "s", "r", "p", "a", "o", "g", "i", "u", "p"},
                new int[]{97733, 90086, 87125, 85361, 75644, 46301, 21616, 79538, 52507, 95884, 79353, 61127, 58665, 96031, 95035, 12116, 41158, 91096, 47819, 88522, 25493, 80186, 66981, 87597, 56691, 86820, 89031, 99954, 41271, 39699});
        System.out.println(l);
        System.out.println(sb);
        Solution2 solution2 = new ID2977MinimumCostToConvertStringIi().new Solution2();
        solution2.minimumCost("fjybg", "apyyt",
                new String[]{"bg", "xr", "cc", "ip", "vq", "po", "ym", "rh", "vw", "lf", "lo", "ee", "qv", "yr", "f", "w", "i", "u", "g", "a", "e", "f", "s", "r", "p", "j", "o", "g", "i", "u"},
                new String[]{"xr", "cc", "ip", "vq", "po", "ym", "rh", "vw", "lf", "lo", "ee", "qv", "yr", "yt", "w", "i", "u", "g", "a", "e", "f", "s", "r", "p", "a", "o", "g", "i", "u", "p"},
                new int[]{97733, 90086, 87125, 85361, 75644, 46301, 21616, 79538, 52507, 95884, 79353, 61127, 58665, 96031, 95035, 12116, 41158, 91096, 47819, 88522, 25493, 80186, 66981, 87597, 56691, 86820, 89031, 99954, 41271, 39699}
        );

        for (int i = 0; i < Math.min(cost1.length, cost3.length); i++) {
            for (int j = 0; j < Math.min(cost1[i].length, cost3[i].length); j++) {
                if (cost1[i][j] != cost3[i][j]) {
                    System.out.println(i + "---" + j);
                }
            }
        }
    }

    class Node {
        Node[] son = new Node[26];
        int sid = -1; // 字符串的编号
    }

    class Solution2 {
        private Node root = new Node();
        private int sid = 0;

        public long minimumCost(String source, String target, String[] original, String[] changed, int[] cost) {
            // 初始化距离矩阵
            int m = cost.length;
            int[][] dis = new int[m * 2][m * 2];
            for (int i = 0; i < dis.length; i++) {
                Arrays.fill(dis[i], Integer.MAX_VALUE / 2);
                dis[i][i] = 0;
            }
            for (int i = 0; i < cost.length; i++) {
                int x = put(original[i]);
                int y = put(changed[i]);
                dis[x][y] = Math.min(dis[x][y], cost[i]);
            }

            // Floyd 求任意两点最短路
            for (int k = 0; k < sid; k++) {
                for (int i = 0; i < sid; i++) {
                    if (dis[i][k] == Integer.MAX_VALUE / 2) {
                        continue;
                    }
                    for (int j = 0; j < sid; j++) {
                        dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
                    }
                }
            }

            for (int i = 0; i < sid; i++) {
                for (int j = 0; j < sid; j++) {
                    if (dis[i][j] == Integer.MAX_VALUE / 2) {
                        dis[i][j] = -1;
                    }
                    System.out.print(dis[i][j] + " ");
                }
                System.out.println();
                cost1 = dis;
            }


            char[] s = source.toCharArray();
            char[] t = target.toCharArray();
            int n = s.length;
            long[] f = new long[n + 1];
            for (int i = n - 1; i >= 0; i--) {
                // 不修改 source[i]
                f[i] = s[i] == t[i] ? f[i + 1] : Long.MAX_VALUE / 2;
                Node p = root, q = root;
                for (int j = i; j < n; j++) {
                    p = p.son[s[j] - 'a'];
                    q = q.son[t[j] - 'a'];
                    if (p == null || q == null) {
                        break;
                    }
                    if (p.sid < 0 || q.sid < 0) {
                        continue;
                    }
                    // 修改从 i 到 j 的这一段
                    int d = dis[p.sid][q.sid];
                    if (d < Integer.MAX_VALUE / 2) {
                        f[i] = Math.min(f[i], d + f[j + 1]);
                    }
                }
            }
            return f[0] < Long.MAX_VALUE / 2 ? f[0] : -1;
        }

        private int put(String s) {
            Node o = root;
            for (char b : s.toCharArray()) {
                int i = b - 'a';
                if (o.son[i] == null) {
                    o.son[i] = new Node();
                }
                o = o.son[i];
            }
            if (o.sid < 0) {
                o.sid = sid++;
            }
            return o.sid;
        }
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        long[][] minCost;
        Map<String, Integer> strMap;

        public long minimumCost(String source, String target, String[] original, String[] changed, int[] cost) {
            strMap = new HashMap<>();
            int idx = 0;
            for (int i = 0; i < original.length; i++) {
                if (!strMap.containsKey(original[i])) {
                    strMap.put(original[i], idx++);
                }
                if (!strMap.containsKey(changed[i])) {
                    strMap.put(changed[i], idx++);
                }
            }
            buildMinCost(original, changed, cost);
            long[] dp = new long[source.length() + 1];
            Arrays.fill(dp, Long.MAX_VALUE / 2);
            dp[0] = 0;
            for (int i = 1; i <= source.length(); i++) {
                if (source.charAt(i - 1) == target.charAt(i - 1)) {
                    dp[i] = dp[i - 1];
                }
                for (String ori : original) {
                    if (eq(source, i - 1, ori)) {
                        String tar = target.substring(i - ori.length(), i);
                        if (!strMap.containsKey(tar)) {
                            continue;
                        }
                        long cost_ = minCost[strMap.get(ori)][strMap.get(tar)];
                        if (cost_ != -1) {
                            dp[i] = Math.min(dp[i], dp[i - ori.length()] + cost_);
                        }
                    }
                }
            }
            return dp[source.length()] == Long.MAX_VALUE / 2 ? -1 : dp[source.length()];
        }

        public boolean eq(String source, int lastIdx, String cmp) {
            for (int i = lastIdx, j = cmp.length() - 1; j >= 0; i--, j--) {
                if (i < 0 || source.charAt(i) != cmp.charAt(j)) {
                    return false;
                }
            }
            return true;
        }

        public void buildMinCost(String[] original, String[] changed, int[] cost) {
            minCost = new long[strMap.size()][strMap.size()];
            for (int i = 0; i < strMap.size(); i++) {
                Arrays.fill(minCost[i], Long.MAX_VALUE / 2);
                minCost[i][i] = 0;
            }
            for (int i = 0; i < original.length; i++) {
                int oIdx = strMap.get(original[i]);
                int cIdx = strMap.get(changed[i]);
                minCost[oIdx][cIdx] = Math.min(cost[i], minCost[oIdx][cIdx]);
            }

            //dp[k][i][j] = dp[k-1][i][j], dp[k-1][i][k] + dp[k-1][k][j].
            // dp[i][j] = min dp[i][j], dp[i][k] + cost[k][j];
            for (int k = 0; k < strMap.size(); k++) {
                for (int i = 0; i < strMap.size(); i++)
                    for (int j = 0; j < strMap.size(); j++) {
                        if (minCost[i][k] != Long.MAX_VALUE / 2) {
                            minCost[i][j] = Math.min(minCost[i][j], minCost[i][k] + minCost[k][j]);
                        }
                    }
            }

            for (int i = 0; i < strMap.size(); i++) {
                for (int j = 0; j < strMap.size(); j++) {
                    if (minCost[i][j] == Long.MAX_VALUE / 2) {
                        minCost[i][j] = -1;
                    }
//                    System.out.print(minCost[i][j] + " ");
                }
//                System.out.println();
            }
//            cost3 = minCost;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 