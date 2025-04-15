package leetcode.editor.cn;

import java.util.List;

public class ID624MaximumDistanceInArrays {

    public static void main(String[] args) {
        Solution solution = new ID624MaximumDistanceInArrays().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxDistance(List<List<Integer>> arrays) {
            int max = Integer.MIN_VALUE;
            int beforeMax = Integer.MIN_VALUE;
            for (List<Integer> array : arrays) {
                Integer last = array.getFirst();
                if (beforeMax != Integer.MIN_VALUE) {
                    max = Math.max(max, Math.abs(beforeMax - last));
                }
                beforeMax = Math.max(beforeMax, array.getLast());
            }
            beforeMax = Integer.MIN_VALUE;
            for (int i = arrays.size() - 1; i >= 0; i--) {
                List<Integer> array = arrays.get(i);
                Integer last = array.getFirst();
                if (beforeMax != Integer.MIN_VALUE) {
                    max = Math.max(max, Math.abs(beforeMax - last));
                }
                beforeMax = Math.max(beforeMax, array.getLast());
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 