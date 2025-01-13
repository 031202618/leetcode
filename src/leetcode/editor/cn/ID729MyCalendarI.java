package leetcode.editor.cn;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class ID729MyCalendarI {

    public static void main(String[] args) {
        MyCalendar solution = new ID729MyCalendarI().new MyCalendar();
        StringBuilder sb = new StringBuilder();                //执行测试
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyCalendar {

        TreeMap<Integer, Integer> map;

        public MyCalendar() {
            map = new TreeMap<>();
        }

        public boolean book(int startTime, int endTime) {
            if (map.containsKey(startTime)) {
                return false;
            }
            Integer floorV = Optional.ofNullable(map.floorEntry(startTime)).map(Map.Entry::getValue).orElse(null);
            Integer ceV = Optional.ofNullable(map.ceilingKey(startTime)).orElse(null);
            if ((floorV == null || floorV <= startTime) && (ceV == null || ceV >= endTime)) {
                map.put(startTime, endTime);
                return true;
            }
            return false;
        }
    }

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */
//leetcode submit region end(Prohibit modification and deletion)


} 