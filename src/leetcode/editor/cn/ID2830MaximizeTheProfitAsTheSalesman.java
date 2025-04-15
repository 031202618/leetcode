package leetcode.editor.cn;

import java.util.Comparator;
import java.util.List;

public class ID2830MaximizeTheProfitAsTheSalesman {

    public static void main(String[] args) {
        Solution solution = new ID2830MaximizeTheProfitAsTheSalesman().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        solution.maximizeTheProfit(5, List.of(List.of(0, 0, 1), List.of(0, 2, 2), List.of(1, 3, 2)));
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maximizeTheProfit(int n, List<List<Integer>> offers) {
            offers.sort(Comparator.comparingInt(o -> o.get(1)));
            List<Integer> yList = offers.stream().map(x -> x.get(1)).toList();
            int[] dp = new int[offers.size() + 1];
            for (int i = 1; i <= offers.size(); i++) {
                // not choose
                dp[i] = dp[i - 1];
                // choose
                List<Integer> integers = offers.get(i - 1);
                Integer x = integers.getFirst();

                //find last v <= x
                int l = 0;
                int r = yList.size() - 1;
                while (l < r - 1) {
                    int mid = l + (r - l) / 2;
                    Integer v = yList.get(mid);
                    if (v >= x) {
                        r = mid - 1;
                    } else {
                        l = mid;
                    }
                }
                if (yList.get(r) < x) {
                    dp[i] = Math.max(dp[i], dp[r + 1] + integers.get(2));
                } else if (yList.get(l) < x) {
                    dp[i] = Math.max(dp[i], dp[l + 1] + integers.get(2));
                } else {
                    dp[i] = Math.max(dp[i], integers.get(2));
                }
            }
            return dp[offers.size()];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 