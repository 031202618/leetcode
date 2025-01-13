package leetcode.editor.cn;

public class ID1964FindTheLongestValidObstacleCourseAtEachPosition {

    public static void main(String[] args) {
        Solution solution = new ID1964FindTheLongestValidObstacleCourseAtEachPosition().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试'
        sb.append(solution.longestObstacleCourseAtEachPosition(new int[]{2, 2, 1}));
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int[] length;
        int r;

        public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
            int[] res = new int[obstacles.length];
            length = new int[obstacles.length + 1];
            r = 1;
            for (int i = 0; i < obstacles.length; i++) {
                int obstacle = obstacles[i];
                if (i == 0) {
                    length[1] = obstacle;
                    res[0] = 1;
                } else {
                    int index = find(obstacle);
                    if (index > r) {
                        r++;
                    }
                    length[index] = obstacle;
                    res[i] = index;
                }
            }
            return res;
        }

        public int find(int obstacle) {
            // x > obstacle
            int l = 1;
            int tmpR = r;
            while (l < tmpR) {
                int mid = l + (tmpR - l) / 2;
                if (length[mid] > obstacle) {
                    tmpR = mid;
                } else {
                    l = mid + 1;
                }
            }
            if (length[l] <= obstacle) {
                l++;
            }
            return l;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 