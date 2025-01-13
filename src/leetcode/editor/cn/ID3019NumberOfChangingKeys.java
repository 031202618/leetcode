package leetcode.editor.cn;

public class ID3019NumberOfChangingKeys {

    public static void main(String[] args) {
        Solution solution = new ID3019NumberOfChangingKeys().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countKeyChanges(String s) {
            int cnt = 0;
            char[] chs = s.toCharArray();
            int gap = 'a' - 'A';
            for (int i = 1; i < chs.length; i++) {
                if (Math.abs(chs[i] - chs[i - 1]) != gap && chs[i] != chs[i - 1]) {
                    cnt++;
                }
            }
            return cnt;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 