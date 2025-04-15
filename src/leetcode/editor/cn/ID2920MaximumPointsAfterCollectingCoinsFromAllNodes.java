package leetcode.editor.cn;

import java.util.*;

public class ID2920MaximumPointsAfterCollectingCoinsFromAllNodes {

    public static void main(String[] args) {
        Solution solution = new ID2920MaximumPointsAfterCollectingCoinsFromAllNodes().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        System.out.println(1 << 13);
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int k;
        List<Integer>[] edges;
        int[] coins;
        Map<State, Integer> cache;


        public int maximumPoints(int[][] edges, int[] coins, int k) {
            this.k = k;
            this.edges = new List[coins.length];
            Arrays.setAll(this.edges, i -> new ArrayList<Integer>());
            for (int[] edge : edges) {
                int l = edge[0];
                int r = edge[1];
                this.edges[l].add(r);
                this.edges[r].add(l);
            }
            this.coins = coins;
            cache = new HashMap<>();
            return dfs(0, 0, new boolean[coins.length]);
        }

        public int dfs(int root, int shift, boolean[] visited) {
            if (visited[root]) return 0;
            if (shift >= 14) {
                return 0;
            }
            State state = new State(root, shift);
            if (cache.containsKey(state)) return cache.get(state);
            visited[root] = true;
            List<Integer> edge = edges[root];

            int basicRootValue = coins[root] >> shift;
            int retNotShift = basicRootValue - k;
            // try not shift.
            for (Integer e : edge) {
                retNotShift += dfs(e, shift, visited);
            }
            // try shift.
            int retShift = basicRootValue >> 1;
            for (Integer e : edge) {
                retShift += dfs(e, shift + 1, visited);
            }
            visited[root] = false;

            int max = Math.max(retNotShift, retShift);
            cache.put(state, max);
            return max;
        }

        public record State(int root, int shift) {
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 