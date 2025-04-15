package leetcode.editor.cn;

public class ID1287ElementAppearingMoreThan25InSortedArray {

    public static void main(String[] args) {
        Solution solution = new ID1287ElementAppearingMoreThan25InSortedArray().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findSpecialInteger(int[] arr) {
            int last = -1;
            int cnt = 0;
            if (arr.length < 4) {
                return arr[0];
            }
            int target = arr.length / 4;
            for (int x : arr) {
                if (last == x) {
                    cnt++;
                    if (cnt > target) {
                        return x;
                    }
                } else {
                    last = x;
                    cnt = 1;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 