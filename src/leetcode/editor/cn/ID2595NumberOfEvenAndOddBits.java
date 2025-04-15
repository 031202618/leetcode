package leetcode.editor.cn;

public class ID2595NumberOfEvenAndOddBits {

    public static void main(String[] args) {
        Solution solution = new ID2595NumberOfEvenAndOddBits().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] evenOddBit(int n) {
            int even = 0;
            int odd = 0;
            boolean e = true;
            while (n > 0) {
                if ((n & 1) == 1) {
                    if (e) {
                        even++;
                    } else {
                        odd++;
                    }
                }
                e = !e;
                n >>= 1;
            }
            return new int[]{even, odd};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 