package leetcode.editor.cn;

import java.util.PriorityQueue;
import java.util.Queue;

public class ID3066MinimumOperationsToExceedThresholdValueIi {

    public static void main(String[] args) {
        Solution solution = new ID3066MinimumOperationsToExceedThresholdValueIi().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minOperations(int[] nums, int k) {
            //min(x, y) * 2 + max(x, y)
            Queue<Long> queue = new PriorityQueue<>();
            for (int num : nums) {
                queue.add((long)num);
            }
            int cnt = 0;
            while (!queue.isEmpty()) {
                long poll = queue.poll();
                if(poll >= k){
                    return cnt;
                }
                cnt++;
                long poll1 = queue.poll();
                queue.offer(Math.min(poll, poll1) * 2 + Math.max(poll1, poll));
            }
            return cnt;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 