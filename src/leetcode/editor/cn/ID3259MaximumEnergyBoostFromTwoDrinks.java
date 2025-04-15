package leetcode.editor.cn;

public class ID3259MaximumEnergyBoostFromTwoDrinks {

    public static void main(String[] args) {
        Solution solution = new ID3259MaximumEnergyBoostFromTwoDrinks().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
            //dp[i][0] = dp[i-1][0] + a[i], dp[i-1][2] + a[i]
            //dp[i][1] = dp[i-1][1] + b[i], dp[i-1][2] + b[i]
            //dp[i][2] = dp[i-1][2], dp[i-1][0], dp[i-1][1]
            long t0 = 0;
            long t1 = 0;
            long t2 = 0;
            long tmpT0 = t0;
            long tmpT1 = t1;
            int len = energyDrinkA.length;
            for (int i = 0; i < len; i++) {
                int a = energyDrinkA[i];
                int b = energyDrinkB[i];
                tmpT0 = t0;
                tmpT1 = t1;
                t0 = Math.max(t0 + a, t2 + a);
                t1 = Math.max(t1 + b, t2 + b);
                t2 = Math.max(Math.max(tmpT0, tmpT1), t2);
            }
            return Math.max(t0, t1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 