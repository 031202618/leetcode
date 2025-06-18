package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.cn.util.*;

public class ID1295FindNumbersWithEvenNumberOfDigits{ 	

    public static void main(String[] args) { 		
        Solution solution = new ID1295FindNumbersWithEvenNumberOfDigits().new Solution(); 		
        StringBuilder sb = new StringBuilder(); 		 		//执行测试 		 		
        System.out.println(sb);		 	
    } 
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findNumbers(int[] nums) {
        int n = 0;
        for (int num : nums) {
            int d = 0;
            while(num > 0){
                d++;
                num /= 10;
            }
            if((d & 1) == 0){
                n++;
            }
        }
        return n;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
 

} 