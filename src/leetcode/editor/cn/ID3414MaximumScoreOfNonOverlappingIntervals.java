package leetcode.editor.cn;

import java.util.*;

public class ID3414MaximumScoreOfNonOverlappingIntervals {

    public static void main(String[] args) {
        Solution solution = new ID3414MaximumScoreOfNonOverlappingIntervals().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        solution.maximumWeight(List.of(
                List.of(5, 8, 1),
                List.of(6, 7, 7),
                List.of(4, 7, 3),
                List.of(9, 10, 6),
                List.of(7, 8, 2),
                List.of(11, 14, 3),
                List.of(3, 5, 5)
        ));
        solution.maximumWeight(List.of(
                List.of(1, 3, 2),
                List.of(4, 5, 2),
                List.of(1, 5, 5),
                List.of(6, 9, 3),
                List.of(6, 7, 1),
                List.of(8, 9, 1)
        ));
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maximumWeight(List<List<Integer>> intervals) {
            int n = intervals.size();
            List<Tuple> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                List<Integer> interval = intervals.get(i);
                list.add(new Tuple(interval.get(0), interval.get(1), interval.get(2), i));
            }
            list.sort(Comparator.comparingInt(x -> x.e));
            Pair[][] dp = new Pair[n + 1][5];
            Arrays.setAll(dp[0], i -> new Pair(0, new ArrayList<>()));
            for (int i = 0; i <= n; i++) {
                dp[i][0] = new Pair(0, new ArrayList<>());
            }
            //dp[i][j] = dp[i-1][j], dp[i-x][j-1] + v
            for (int i = 1; i <= n; i++) {
                Tuple tuple = list.get(i - 1);
                for (int j = 1; j <= 4; j++) {
                    Pair pair1 = dp[i - 1][j];
                    dp[i][j] = new Pair(pair1.sum, new ArrayList<>(pair1.ids));

                    int target = tuple.s;
                    int l = 0;
                    int r = Math.max(i - 2, 0);
                    while (l < r - 1) {
                        int mid = l + (r - l) / 2;
                        int v = list.get(mid).e;
                        if (v >= target) {
                            r = mid - 1;
                        } else {
                            l = mid;
                        }
                    }
                    if (list.get(r).e < target) {
                        long nv = dp[r + 1][j - 1].sum + tuple.w;
                        List<Integer> ids = new ArrayList<>(dp[r + 1][j - 1].ids);
                        ids.add(tuple.i);
                        Collections.sort(ids);
                        if (nv > pair1.sum) {
                            dp[i][j] = new Pair(nv, ids);
                        } else if (nv == pair1.sum) {
                            boolean left = cmp(ids, pair1.ids);
                            if (!left) {
                                ids = new ArrayList<>(pair1.ids);
                            }
                            dp[i][j] = new Pair(nv, ids);
                        }
                    } else if (list.get(l).e < target) {
                        long nv = dp[l + 1][j - 1].sum + tuple.w;
                        List<Integer> ids = new ArrayList<>(dp[l + 1][j - 1].ids);
                        ids.add(tuple.i);
                        Collections.sort(ids);
                        if (nv > pair1.sum) {
                            dp[i][j] = new Pair(nv, ids);
                        } else if (nv == pair1.sum) {
                            boolean left = cmp(ids, pair1.ids);
                            if (!left) {
                                ids = new ArrayList<>(pair1.ids);
                            }
                            dp[i][j] = new Pair(nv, ids);
                        }
                    } else {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(tuple.i);
                        List<Integer> cmp = new ArrayList<>(pair1.ids);
                        if (tuple.w > pair1.sum) {
                            dp[i][j] = new Pair(tuple.w, ids);
                        } else if (tuple.w == pair1.sum) {
                            boolean left = cmp(ids, cmp);
                            if (!left) {
                                ids = cmp;
                            }
                            dp[i][j] = new Pair(tuple.w, ids);
                        }
                    }

                }
            }
            return dp[n][4].ids.stream().mapToInt(x -> x).toArray();
        }

        boolean cmp(List<Integer> a, List<Integer> b) {
            for (int i = 0; i < Math.min(a.size(), b.size()); i++) {
                int cmp = a.get(i) - b.get(i);
                if (cmp != 0) {
                    return cmp < 0;
                }
            }
            return a.size() - b.size() < 0;
        }

        record Tuple(int s, int e, int w, int i) {
        }

        record Pair(long sum, List<Integer> ids) {
        }


    }
//leetcode submit region end(Prohibit modification and deletion)


} 