package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class ID1472DesignBrowserHistory {

    public static void main(String[] args) {
        BrowserHistory solution = new ID1472DesignBrowserHistory().new BrowserHistory("");
        StringBuilder sb = new StringBuilder();                //执行测试
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class BrowserHistory {

        Deque<String> back = new ArrayDeque<>();
        Deque<String> forward = new ArrayDeque<>();

        public BrowserHistory(String homepage) {
            back.addLast(homepage);
        }

        public void visit(String url) {
            back.addLast(url);
            forward.clear();
        }

        public String back(int steps) {
            for (int i = 0; i < steps && back.size() > 1; i++) {
                String last = back.removeLast();
                forward.addLast(last);
            }
            return back.peekLast();
        }

        public String forward(int steps) {
            String last = back.peekLast();
            for (int i = 0; i < steps && !forward.isEmpty(); i++) {
                last = forward.removeLast();
                back.addLast(last);
            }
            return last;
        }
    }

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
//leetcode submit region end(Prohibit modification and deletion)


} 