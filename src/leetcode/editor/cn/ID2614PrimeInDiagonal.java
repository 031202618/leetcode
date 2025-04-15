package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ID2614PrimeInDiagonal {

    public static void main(String[] args) {
        Solution solution = new ID2614PrimeInDiagonal().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        solution.diagonalPrime(new int[][]{});
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public static boolean[] ss;

        static {
            ss = new boolean[5_000_000];
            Arrays.fill(ss, true);
            ss[0] = false;
            ss[1] = false;
            for (int i = 2; i < ss.length; i++) {
                if (ss[i]) {
                    for (int j = 2; j * i < ss.length; j++) {
                        ss[j * i] = false;
                    }
                }
            }
        }

        public int diagonalPrime(int[][] nums) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < nums[i].length; j++) {
                    if (i == j || i == nums.length - j - 1) {
                        list.add(nums[i][j]);
                    }
                }
            }
            int defaultValue = 0;
            return list.stream().filter(x -> ss[x]).max(Integer::compareTo).orElse(defaultValue);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 