package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ID2502DesignMemoryAllocator {

    public static void main(String[] args) {
        Allocator solution = new ID2502DesignMemoryAllocator().new Allocator(10);
        StringBuilder sb = new StringBuilder();                //执行测试
        solution.allocate(1, 1);
        solution.allocate(1, 2);
        solution.allocate(1, 3);
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Allocator {

        boolean[] arr;
        Map<Integer, List<Integer>> map;
        List<int[]> availableMemory;

        public Allocator(int n) {
            this.arr = new boolean[n];
            this.map = new HashMap<>();
            build();
        }

        public int allocate(int size, int mID) {
            Integer fistAllocate = null;
            for (int[] memo : availableMemory) {
                if (memo[2] >= size) {
                    List<Integer> list = map.getOrDefault(mID, new ArrayList<>());
                    for (int i = 0; i < size; i++) {
                        arr[memo[0] + i] = true;
                        list.add(memo[0] + i);
                    }
                    map.put(mID, list);
                    fistAllocate = memo[0];
                    break;
                }
            }
            if (fistAllocate == null) {
                return -1;
            } else {
                build();
                return fistAllocate;
            }
        }

        public int freeMemory(int mID) {
            List<Integer> integers = map.get(mID);
            if (integers == null) {
                return 0;
            }

            map.remove(mID);
            for (Integer integer : integers) {
                arr[integer] = false;
            }

            build();
            return integers.size();
        }

        private void build() {
            availableMemory = new ArrayList<>();
            for (int i = 0; i < arr.length; ) {
                int nxt = i + 1;
                if (!arr[i]) {
                    int j = i + 1;
                    for (; j < arr.length; j++) {
                        if (arr[j]) {
                            break;
                        }
                    }
                    availableMemory.add(new int[]{i, j - 1, j - i});
                    nxt = j;
                }
                i = nxt;
            }
        }
    }

/**
 * Your Allocator object will be instantiated and called as such:
 * Allocator obj = new Allocator(n);
 * int param_1 = obj.allocate(size,mID);
 * int param_2 = obj.freeMemory(mID);
 */
//leetcode submit region end(Prohibit modification and deletion)


} 