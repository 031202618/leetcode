package leetcode.editor.cn;

public class ID2111MinimumOperationsToMakeTheArrayKIncreasing {

    public static void main(String[] args) {
        Solution solution = new ID2111MinimumOperationsToMakeTheArrayKIncreasing().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int[] length;
        int r;

        public int kIncreasing(int[] arr, int k) {
            int sum = 0;
            length = new int[arr.length + 1];
            for (int i = 0; i < arr.length; i++) {
                if (i - k >= 0) {
                    break;
                }
                r = 1;
                length[r] = arr[i];
                int size = 1;
                for (int j = i + k; j < arr.length; j += k) {
                    size++;
                    int index = find(arr[j]);
                    if (index > r) {
                        r++;
                    }
                    length[index] = arr[j];
                }
                sum += (size - r);
            }
            return sum;
        }

        public int find(int x) {
            int tmpR = r;
            int l = 1;
            while (l < tmpR) {
                int mid = l + (tmpR - l) / 2;
                if (length[mid] > x) {
                    tmpR = mid;
                } else {
                    l = mid + 1;
                }
            }
            if (length[l] <= x) {
                l++;
            }
            return l;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 