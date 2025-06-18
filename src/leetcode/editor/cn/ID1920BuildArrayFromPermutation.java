package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.cn.util.*;

public class ID1920BuildArrayFromPermutation{ 	

    public static void main(String[] args) { 		
        Solution solution = new ID1920BuildArrayFromPermutation().new Solution(); 		
        StringBuilder sb = new StringBuilder(); 		 		//执行测试 		 		
        System.out.println(sb);		 	
    } 
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] buildArray(int[] nums) {
        int[] ret = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ret[i] = nums[nums[i]];
        }
        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 

} 