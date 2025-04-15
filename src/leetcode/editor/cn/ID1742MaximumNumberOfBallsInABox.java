package leetcode.editor.cn;

public class ID1742MaximumNumberOfBallsInABox {

    public static void main(String[] args) {
        Solution solution = new ID1742MaximumNumberOfBallsInABox().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countBalls(int lowLimit, int highLimit) {
            int[] cnt = new int[100];
            int max = 0;
            for (int i = lowLimit; i <= highLimit; i++) {
                max = Math.max(++cnt[calc(i)], max);
            }
            return max;
        }

        public int calc(int num) {
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 