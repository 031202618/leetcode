package leetcode.editor.cn;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeSet;

public class ID855ExamRoom {

    public static void main(String[] args) {
        //[null,0,9,4,2,null,5]
        ExamRoom solution = new ID855ExamRoom().new ExamRoom(10);
        solution.seat();
        solution.seat();
        solution.seat();
        solution.seat();
        solution.leave(4);
        solution.seat();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class ExamRoom {

        Queue<int[]> queue = new PriorityQueue<>((x, y) -> (y[0] == x[0]) ? x[1] - y[1] : y[0] - x[0]);
        TreeSet<Integer> set = new TreeSet<>();

        int n;

        public ExamRoom(int n) {
            queue.add(new int[]{n * 2, -1, Integer.MAX_VALUE});
            set.add(-1);
            set.add(Integer.MAX_VALUE);
            this.n = n;
        }

        public int seat() {
            int[] poll = queue.poll();
            while (!set.contains(poll[1]) || !set.contains(poll[2])) {
                poll = queue.poll();
            }
            if (poll[1] == -1) {
                queue.add(new int[]{poll[0] - 1, 0, poll[2]});
                set.add(0);
                return 0;
            } else if (poll[2] == Integer.MAX_VALUE) {
                queue.add(new int[]{poll[0] - 1, poll[1], n - 1});
                set.add(n - 1);
                return n - 1;
            } else {
                int mid = (poll[1] + poll[2]) / 2;
                queue.add(new int[]{mid - poll[1] + 1, poll[1], mid});
                queue.add(new int[]{poll[2] - mid + 1, mid, poll[2]});
                set.add(poll[1]);
                set.add(poll[2]);
                set.add(mid);
                return mid;
            }
        }

        public void leave(int p) {
            Integer floor = set.floor(p);
            Integer ceiling = set.ceiling(p);
            if (floor == null) {
                floor = -1;
            }
            if (ceiling == null) {
                ceiling = Integer.MAX_VALUE;
            }
            int dist;
            if (floor == -1 && ceiling == Integer.MAX_VALUE) {
                dist = 2 * n;
            } else if (floor == -1) {
                dist = ceiling + 1;
            } else if (ceiling == Integer.MAX_VALUE) {
                dist = n - floor;
            } else {
                dist = floor - ceiling + 1;
            }
            queue.add(new int[]{dist, floor, ceiling});
            set.remove(p);
        }
    }

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(n);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */
//leetcode submit region end(Prohibit modification and deletion)


} 