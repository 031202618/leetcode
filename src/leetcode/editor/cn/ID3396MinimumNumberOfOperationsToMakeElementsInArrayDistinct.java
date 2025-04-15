package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class ID3396MinimumNumberOfOperationsToMakeElementsInArrayDistinct {

    public static void main(String[] args) {
        Solution solution = new ID3396MinimumNumberOfOperationsToMakeElementsInArrayDistinct().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumOperations(int[] nums) {
            int[] arr = new int[101];
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                arr[num]++;
                if (arr[num] > 1) {
                    set.add(num);
                }
            }
            int loop = 0;
            int idx = 0;
            while (!set.isEmpty()) {
                for (int i = 0; i < 3 && idx < nums.length; i++, idx++) {
                    int v = arr[nums[idx]];
                    if (v <= 1) {
                        continue;
                    } else {
                        arr[nums[idx]]--;
                        if (arr[nums[idx]] <= 1) {
                            set.remove(nums[idx]);
                        }
                    }
                }
                loop++;
            }
            return loop;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 