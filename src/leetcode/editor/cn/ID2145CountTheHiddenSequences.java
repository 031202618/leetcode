package leetcode.editor.cn;

public class ID2145CountTheHiddenSequences {

    public static void main(String[] args) {
        Solution solution = new ID2145CountTheHiddenSequences().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numberOfArrays(int[] differences, int lower, int upper) {
            long max = 0;
            long min = 0;
            long base = 0;
            for (int difference : differences) {
                base += difference;
                min = Math.min(min, base);
                max = Math.max(max, base);
            }
            long diff = lower - min;
            max += diff;
            return (int)Math.max(upper - max + 1, 0);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 