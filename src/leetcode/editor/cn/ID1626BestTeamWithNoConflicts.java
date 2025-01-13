package leetcode.editor.cn;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ID1626BestTeamWithNoConflicts {

    public static void main(String[] args) {
        Solution solution = new ID1626BestTeamWithNoConflicts().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        solution.bestTeamScore(new int[]{4, 5, 6, 5}, new int[]{2, 1, 2, 1});
        System.out.println(sb);
    }

    public int bestTeamScore(int[] scores, int[] ages) {
        int[] array = IntStream.range(0, ages.length).mapToObj(x -> x).sorted((x, y) -> scores[x] != scores[y] ? scores[x] - scores[y] : ages[x] - ages[y]).mapToInt(x -> x).toArray();
        int[] maxi = new int[1010];
        for (int i = 0; i < array.length; i++) {
            int idx = array[i];
            int age = ages[idx];
            int score = scores[idx];
            int sum = getSum(age, maxi);
            update(age, sum + score, maxi);
        }
        return Arrays.stream(maxi).max().orElse(0);
    }

    private void update(int i, int x, int[] maxi) {
        while (i < maxi.length) {
            maxi[i] = Math.max(maxi[i], x);
            i += (i & -i);
        }
    }


    private static int getSum(int x, int[] trie) {
        int idx;
        idx = x;
        int sum = 0;
        while (idx > 0) {
            sum = Math.max(sum, trie[idx]);
            idx &= (idx - 1);
        }
        return sum;
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int bestTeamScore(int[] scores, int[] ages) {
            int[] sortedScores = IntStream.range(0, scores.length).boxed().sorted((x, y) -> ages[x] == ages[y] ? scores[x] - scores[y] : ages[x] - ages[y]).map(x -> scores[x]).mapToInt(x -> x).toArray();
            int length = Arrays.stream(scores).max().getAsInt() + 1;
            Bit bit = new Bit(new int[length]);
            for (int i = 0; i < scores.length; i++) {
                int search = bit.search(sortedScores[i]);
                bit.update(sortedScores[i], search + sortedScores[i]);
            }
            return bit.search(length - 1);
        }

        public class Bit {
            int[] arr;

            public Bit(int[] arr) {
                this.arr = arr;
            }

            public void update(int i, int val) {
                while (i < arr.length) {
                    arr[i] = Math.max(arr[i], val);
                    i += (i & -i);
                }
            }

            public int search(int r) {
                int maxi = 0;
                while (r > 0) {
                    maxi = Math.max(maxi, arr[r]);
                    r &= r - 1;
                }
                return maxi;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 