package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.cn.util.*;

public class ID3083ExistenceOfASubstringInAStringAndItsReverse{ 	

    public static void main(String[] args) { 		
        Solution solution = new ID3083ExistenceOfASubstringInAStringAndItsReverse().new Solution(); 		
        StringBuilder sb = new StringBuilder(); 		 		//执行测试 		 		
        System.out.println(sb);		 	
    } 
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isSubstringPresent(String s) {
        char[] charArray = s.toCharArray();
        Set<Integer> set = new HashSet<>();
        for(int i = 1; i < charArray.length; i++){
            set.add((charArray[i-1] - 'a') * 26 + charArray[i] - 'a');
        }
        charArray = new StringBuilder(s).reverse().toString().toCharArray();
        for(int i = 1; i < charArray.length; i++){
            if(set.contains((charArray[i-1] - 'a') * 26 + charArray[i] - 'a')){
                return true;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 

} 