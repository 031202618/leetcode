package leetcode.editor.cn;

public class ID2708MaximumStrengthOfAGroup {

    public static void main(String[] args) {
        Solution solution = new ID2708MaximumStrengthOfAGroup().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        solution.maxStrength(new int[]{-1, -2, 7, -1, -7, -5, 0, -8});
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long maxStrength(int[] nums) {
            Long pos = null;
            Long neg = null;
            for (int num : nums) {
                Long posTmp = pos;
                Long negTmp = neg;
                if (num >= 0) {
                    if (posTmp == null) {
                        pos = (long) num;
                    } else {
                        pos = Math.max(pos, pos * num);
                        pos = Math.max(pos, num);
                    }
                    if (neg != null) {
                        neg = Math.min(negTmp * num, negTmp);
                    }
                } else {
                    if (neg == null) {
                        neg = (long) num;
                    } else {
                        neg = Math.min(neg, num);
                        if (pos != null) {
                            pos = Math.max(pos, negTmp * num);
                        } else {
                            pos = negTmp * num;
                        }
                    }
                    if (posTmp != null) {
                        neg = Math.min(neg, posTmp * num);
                    }
                }
            }
            if (pos != null) {
                return pos;
            }
            return neg;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 