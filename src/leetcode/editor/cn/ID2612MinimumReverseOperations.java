package leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

public class ID2612MinimumReverseOperations {

    public static void main(String[] args) {
        Solution solution = new ID2612MinimumReverseOperations().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        System.out.println(solution.minReverseOperations(4, 2, new int[]{}, 4));
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean valid(int pos, Set<Integer> ban, int max) {
            return pos >= 0 && pos < max && !ban.contains(pos);
        }

        public int[] minReverseOperations(int n, int p, int[] banned, int k) {
            int cnt = 0;
            int[] res = new int[n];
            Set<Integer> ban = Arrays.stream(banned).boxed().collect(Collectors.toSet());
            Arrays.fill(res, -1);
            Queue<Integer> q = new LinkedList<>();
            q.add(p);
            ban.add(p);
            while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    Integer poll = q.poll();
                    res[poll] = cnt;
                    for (int j = 0; j <= k; j++) {
                        if (poll - j < 0) {
                            break;
                        }
                        if (poll + k - j - 1 >= n) {
                            continue;
                        }
                        int tmp = k - 1 - 2 * j;
                        if (tmp <= 0) {
                            break;
                        }
                        int r = poll + tmp;
                        if (valid(r, ban, n)) {
                            ban.add(r);
                            q.add(r);
                        }
                    }
                    for (int j = 0; j <= k; j++) {
                        if (poll + j >= n) {
                            break;
                        }
                        //x      poll + j
                        // poll + j  + 1  - k== x
                        if (poll + j + 1 - k < 0) {
                            continue;
                        }
                        int tmp = k - 1 - 2 * j;
                        if (tmp <= 0) {
                            break;
                        }
                        int r = poll - tmp;
                        if (valid(r, ban, n)) {
                            ban.add(r);
                            q.add(r);
                        }
                    }
                }
                cnt++;
            }
            return res;
        }
    }


//leetcode submit region end(Prohibit modification and deletion)


} 