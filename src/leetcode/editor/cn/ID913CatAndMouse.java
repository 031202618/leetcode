package leetcode.editor.cn;

public class ID913CatAndMouse {

    public static void main(String[] args) {
        Solution solution = new ID913CatAndMouse().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        solution.catMouseGame(new int[][]{{5, 6}, {3, 4}, {6}, {1, 4, 5}, {1, 3, 5}, {0, 3, 4, 6}, {0, 2, 5}});
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] g;
        Integer[][][] memo;
        boolean[][][] visited;

        public int catMouseGame(int[][] graph) {
            g = graph;
            memo = new Integer[graph.length][graph.length][2];
            visited = new boolean[graph.length][graph.length][2];
            int dfs = dfs(1, 2, 0, "");
            return switch (dfs) {
                case 0 -> 1;
                case 1 -> 0;
                default -> 2;
            };
        }

        public int dfs(int x, int y, int step, String before) {
            if (x == 0) {
                return 0;
            }
            if (x == y) {
                return 2;
            }
            if (memo[x][y][step] != null) {
                return memo[x][y][step];
            }
            visited[x][y][step] = true;
            // 0: mouse, 1: not win, 2: cat
            int ret;
            int dfs;
            if (step == 0) {
                ret = 2;
                for (int nxt : g[x]) {
                    if (!visited[nxt][y][1]) {
                        dfs = dfs(nxt, y, 1, before);
                    } else {
                        dfs = 1;
                    }
                    ret = Math.min(ret, dfs);
                    if (x == 3 && y == 6 && dfs == 1) {
                        for (int i = 0; i < g.length; i++) {
                            for (int j = 0; j < g.length; j++) {
                                if (visited[i][j][0]) {
                                    System.out.print(i + " " + j + " 0;");
                                }
                                if (visited[i][j][1]) {
                                    System.out.print(i + " " + j + " 1;");
                                }
                            }
                            System.out.println();
                        }
                        System.out.println(nxt);
                    }
                }
            } else {
                ret = 0;
                for (int nxt : g[y]) {
                    if (nxt == 0) {
                        continue;
                    }
                    if (!visited[x][nxt][0]) {
                        dfs = dfs(x, nxt, 0, before);
                    } else {
                        dfs = 1;
                    }
                    ret = Math.max(ret, dfs);
                }
            }
            memo[x][y][step] = ret;
            visited[x][y][step] = false;
            System.out.println(before + ":" + ret);
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 