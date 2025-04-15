package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class ID1656DesignAnOrderedStream {

    public static void main(String[] args) {
        OrderedStream solution = new ID1656DesignAnOrderedStream().new OrderedStream(1);
        StringBuilder sb = new StringBuilder();                //执行测试
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class OrderedStream {

        String[] list;

        int pos;

        public OrderedStream(int n) {
            list = new String[n + 1];
            pos = 1;
        }

        public List<String> insert(int idKey, String value) {
            list[idKey] = value;
            List<String> result = new ArrayList<>();
            while (pos < list.length) {
                String s = list[pos];
                if (s == null) {
                    break;
                }
                pos++;
                result.add(s);
            }
            return result;
        }
    }

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */
//leetcode submit region end(Prohibit modification and deletion)


} 