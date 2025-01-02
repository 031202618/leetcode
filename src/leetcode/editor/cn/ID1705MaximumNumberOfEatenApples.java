package leetcode.editor.cn;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class ID1705MaximumNumberOfEatenApples {

    public static void main(String[] args) {
        Solution solution = new ID1705MaximumNumberOfEatenApples().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        int i = solution.eatenApples(new int[]{1, 2, 3, 5, 2}, new int[]{3, 2, 1, 4, 2});
        sb.append(i);
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int eatenApples(int[] apples, int[] days) {
            Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(x -> x[0]));
            int ret = 0;
            for (int i = 0; i < apples.length; i++) {
                int apple = apples[i];
                int day = days[i];
                int effect = i + day - 1;
                queue.add(new int[]{effect, apple});
                while (!queue.isEmpty()) {
                    int[] poll = queue.poll();
                    if (poll[0] >= i && poll[1] > 0) {
                        ret++;
                        queue.add(new int[]{poll[0], poll[1] - 1});
                        break;
                    }
                }
            }
            int day = apples.length;
            while (!queue.isEmpty()) {
                int[] poll = queue.poll();
                if (poll[0] >= day && poll[1] > 0) {
                    ret++;
                    queue.add(new int[]{poll[0], poll[1] - 1});
                    break;
                }
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 