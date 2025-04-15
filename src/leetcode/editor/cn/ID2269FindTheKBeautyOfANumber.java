package leetcode.editor.cn;

public class ID2269FindTheKBeautyOfANumber {

    public static void main(String[] args) {
        Solution solution = new ID2269FindTheKBeautyOfANumber().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        solution.divisorSubstrings(240, 2);
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int divisorSubstrings(int num, int k) {
            int origin = num;
            int ret = 0;
            int window = 0;
            int base = 1;
            for (int i = 0; i < k; i++) {
                window += ((num % 10) * base);
                num /= 10;
                base *= 10;
            }
            if (window != 0 && origin % window == 0) {
                ret++;
            }
            base /= 10;
            while (num > 0) {
                window /= 10;
                window += ((num % 10) * base);
                num /= 10;
                if (window != 0 && origin % window == 0) {
                    ret++;
                }
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 