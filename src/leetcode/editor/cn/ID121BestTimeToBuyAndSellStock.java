package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.cn.util.*;

public class ID121BestTimeToBuyAndSellStock{ 	

    public static void main(String[] args) { 		
        Solution solution = new ID121BestTimeToBuyAndSellStock().new Solution(); 		
        StringBuilder sb = new StringBuilder(); 		 		//执行测试 		 		
        System.out.println(sb);		 	
    } 
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return maxProfit;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 

} 