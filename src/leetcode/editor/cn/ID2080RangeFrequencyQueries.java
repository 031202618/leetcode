package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ID2080RangeFrequencyQueries {

    public static void main(String[] args) {
//        Solution solution = new ID2080RangeFrequencyQueries().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class RangeFreqQuery {

        List<Integer>[] list;

        public RangeFreqQuery(int[] arr) {
            int maxi = Arrays.stream(arr).max().getAsInt();
            list = new ArrayList[maxi + 1];
            for (int i = 0; i < arr.length; i++) {
                List<Integer> integers = list[arr[i]];
                if (integers == null) {
                    list[arr[i]] = new ArrayList<>();
                    integers = list[arr[i]];
                }
                integers.add(i);
            }
        }

        public int query(int left, int right, int value) {
            if(value >= this.list.length){
                return 0;
            }
            List<Integer> list = this.list[value];
            if (list == null || list.isEmpty()) {
                return 0;
            }
            // leftIdx >= left
            int l = 0;
            int r = list.size() - 1;
            while (l < r) {
                int mid = (l + r) / 2;
                int v = list.get(mid);
                if (v == left) {
                    l = mid;
                    break;
                } else if (v > left) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            int leftIdx = l;
            // rightIdx <= right
            l = 0;
            r = list.size() - 1;
            while (l < r - 1) {
                int mid = (l + r) / 2;
                int v = list.get(mid);
                if (v == right) {
                    l = mid;
                    break;
                } else if (v < right) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            int rightIdx;
            if (list.get(r) <= right) {
                rightIdx = r;
            } else {
                rightIdx = l;
            }
            Integer lv = list.get(leftIdx);
            Integer rv = list.get(rightIdx);
            if (lv >= left && lv <= right) {
                return rightIdx - leftIdx + 1;
            }
            if (rv >= left && rv <= right) {
                return rightIdx - leftIdx + 1;
            }
            return 0;
        }
    }

/**
 * Your RangeFreqQuery object will be instantiated and called as such:
 * RangeFreqQuery obj = new RangeFreqQuery(arr);
 * int param_1 = obj.query(left,right,value);
 */
//leetcode submit region end(Prohibit modification and deletion)


} 