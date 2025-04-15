package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ID1713MinimumOperationsToMakeASubsequence {

    public static void main(String[] args) {
        Solution solution = new ID1713MinimumOperationsToMakeASubsequence().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        solution.minOperations(new int[]{5, 1, 3}, new int[]{9, 4, 2, 3, 4});
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minOperations(int[] target, int[] arr) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 1; i <= target.length; i++) {
                map.put(target[i - 1], i);
            }
            int[] newArr = Arrays.stream(arr).boxed().map(x -> map.get(x)).filter(x -> x != null).mapToInt(x -> x).toArray();
            return target.length - maxLength(newArr);

        }

        public int maxLength(int[] nums) {
            if(nums.length == 0) return 0;
            int length = Arrays.stream(nums).max().getAsInt();
            BT b = new BT(new int[length + 1]);
            for (int num : nums) {
                int find = b.search(num - 1);
                b.update(num, find + 1);
            }
            return b.search(length);
        }

        class BT {
            int[] arr;

            public BT(int[] arr) {
                this.arr = arr;
            }

            public int search(int num) {
                int max = 0;
                while (num > 0) {
                    max = Math.max(max, arr[num]);
                    num &= num - 1;
                }
                return max;
            }

            public void update(int x, int val) {
                while (x < arr.length) {
                    arr[x] = Math.max(val, arr[x]);
                    x += x & -x;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 