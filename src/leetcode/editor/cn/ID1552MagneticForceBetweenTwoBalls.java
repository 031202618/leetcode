package leetcode.editor.cn;

import java.util.Arrays;

public class ID1552MagneticForceBetweenTwoBalls {

    public static void main(String[] args) {
        Solution solution = new ID1552MagneticForceBetweenTwoBalls().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        solution.maxDistance(new int[]{79, 74, 57, 22}, 4);
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxDistance(int[] position, int m) {
            m--;
            Arrays.sort(position);
            int[] arr = new int[position.length - 1];
            for (int i = 1; i < position.length; i++) {
                arr[i - 1] = position[i] - position[i - 1];
            }
            int upper = Arrays.stream(position).max().getAsInt();
            int lower = Arrays.stream(arr).min().getAsInt();
            while (lower < upper - 1) {
                int mid = lower + (upper - lower) / 2;
                if (verify(mid, arr, m)) {
                    lower = mid;
                } else {
                    upper = mid - 1;
                }
            }
            if (verify(upper, arr, m)) {
                return upper;
            }
            return lower;
        }

        public boolean verify(int v, int[] arr, int m) {
            int l = 0;
            while (m > 0) {
                int tmp = 0;
                while (l < arr.length && tmp < v) {
                    tmp += arr[l++];
                }
                if (tmp < v) {
                    return false;
                }
                m--;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 