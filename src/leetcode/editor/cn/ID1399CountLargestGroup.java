package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class ID1399CountLargestGroup {

    public static void main(String[] args) {
        Solution solution = new ID1399CountLargestGroup().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countLargestGroup(int n) {
            Map<Integer, Integer> map = new HashMap<>();
            int max = 0;
            for (int i = 1; i <= n; i++) {
                int tmp = i;
                int res = 0;
                while (tmp > 0) {
                    res += tmp % 10;
                    tmp /= 10;
                }
                map.put(res, map.getOrDefault(res, 0) + 1);
                max = Math.max(max, map.get(res));
            }
            int ans = 0;
            for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
                if(integerIntegerEntry.getValue() == max){
                    ans++;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 