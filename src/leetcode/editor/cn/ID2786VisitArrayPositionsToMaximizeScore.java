package leetcode.editor.cn;

public class ID2786VisitArrayPositionsToMaximizeScore {

    public static void main(String[] args) {
        Solution solution = new ID2786VisitArrayPositionsToMaximizeScore().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        //1545
        System.out.println(solution.maxScore(new int[]{38, 92, 23, 30, 25, 96, 6, 71, 78, 77, 33, 23, 71, 48, 87, 77, 53, 28, 6, 20, 90, 83, 42, 21, 64, 95, 84, 29, 22, 21, 33, 36, 53, 51, 85, 25, 80, 56, 71, 69, 5, 21, 4, 84, 28, 16, 65, 7}, 52));
        //13
        System.out.println(solution.maxScore(new int[]{2, 3, 6, 1, 9, 2}, 5));
        //20
        System.out.println(solution.maxScore(new int[]{2, 4, 6, 8}, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long maxScore(int[] nums, int x) {
            Long odd = null;
            Long even = null;
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                boolean isOdd = (num & 1) != 0;
                if (i == 0) {
                    if (isOdd) {
                        odd = (long) num;
                    } else {
                        even = (long) num;
                    }
                    continue;
                }
                if (isOdd) {
                    //oddplus
                    if (odd != null) {
                        odd += (long) num;
                    }
                    if (even != null) {
                        if (odd != null) {
                            odd = Math.max(odd, even - x + num);
                        } else {
                            odd = even - x + num;
                        }
                    }
                } else {
                    if (even != null) {
                        even += (long) num;
                    }
                    if (odd != null) {
                        if (even != null) {
                            even = Math.max(even, odd - x + num);
                        } else {
                            even = odd - x + num;
                        }
                    }
                }
            }
            if(even == null){
                return odd;
            }
            if(odd == null){
                return even;
            }
            return Math.max(even, odd);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 