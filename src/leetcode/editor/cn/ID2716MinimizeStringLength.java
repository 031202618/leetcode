package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.cn.util.*;

public class ID2716MinimizeStringLength{ 	

    public static void main(String[] args) { 		
        Solution solution = new ID2716MinimizeStringLength().new Solution(); 		
        StringBuilder sb = new StringBuilder(); 		 		//执行测试 		 		
        System.out.println(sb);		 	
    } 
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimizedStringLength(String s) {
        int[] arr = new int[26];
        for (char c : s.toCharArray()) {
            arr[c - 'a'] = 1;
        }
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 

} 