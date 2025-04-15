package leetcode.editor.cn;

import java.util.Arrays;

public class ID3288LengthOfTheLongestIncreasingPath {

    public static void main(String[] args) {
        Solution solution = new ID3288LengthOfTheLongestIncreasingPath().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        solution.maxPathLength(new int[][]{{3, 1}, {2, 2}, {4, 1}, {0, 0}, {5, 3}}, 1);
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxPathLength(int[][] coordinates, int k) {
            int[] target = coordinates[k];
            int[] sortedCoordinates = Arrays.stream(coordinates).filter(x -> {
                        if (x[0] > target[0] && x[1] > target[1]) {
                            return true;
                        }
                        if (x[0] < target[0] && x[1] < target[1]) {
                            return true;
                        }
                        if(x[0] == target[0] && x[1] == target[1]){
                            return true;
                        }
                        return false;
                    }).sorted((x, y) -> x[0] == y[0] ? y[1] - x[1] : x[0] - y[0])
                    .map(x -> x[1])
                    .mapToInt(x -> x)
                    .toArray();
            int[] max = new int[coordinates.length + 1];
            int length = 1;
            max[length] = sortedCoordinates[0];
            for (int i = 1; i < sortedCoordinates.length; i++) {
                int num = sortedCoordinates[i];

                int l = 1;
                int r = length;
                while (l < r - 1) {
                    int mid = l + (r - l) / 2;
                    if (max[mid] < num) {
                        l = mid;
                    } else {
                        r = mid - 1;
                    }
                }
                if (max[r] < num) {
                    l = r + 1;
                } else {
                    if (max[l] < num) {
                        l = r;
                    }
                }
                if (l > length) {
                    length++;
                }
                max[l] = num;
            }

            return length;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 