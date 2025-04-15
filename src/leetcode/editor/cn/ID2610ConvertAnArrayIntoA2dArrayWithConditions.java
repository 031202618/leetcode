package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ID2610ConvertAnArrayIntoA2dArrayWithConditions {

    public static void main(String[] args) {
        Solution solution = new ID2610ConvertAnArrayIntoA2dArrayWithConditions().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> findMatrix(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> res = new ArrayList<>();
            int r = 0;
            for (int i = 0; i < nums.length; i++) {
                if (i == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    res.add(list);
                    continue;
                }
                if (nums[i] == nums[i - 1]) {
                    r++;
                } else {
                    r = 0;
                }
                if (res.size() <= r) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    res.add(list);
                } else {
                    res.get(r).add(nums[i]);
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 