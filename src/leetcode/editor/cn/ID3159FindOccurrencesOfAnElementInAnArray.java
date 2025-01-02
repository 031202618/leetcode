package leetcode.editor.cn;

public class ID3159FindOccurrencesOfAnElementInAnArray {

    public static void main(String[] args) {
        Solution solution = new ID3159FindOccurrencesOfAnElementInAnArray().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
            int[] arr = new int[nums.length + 1];
            int idx = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == x) {
                    arr[++idx] = i;
                }
            }
            int[] ret = new int[queries.length];
            for(int i = 0; i < queries.length; i++){
                int target = queries[i];
                if(target > idx){
                    ret[i] = -1;
                }else{
                    ret[i] = arr[target];
                }
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 