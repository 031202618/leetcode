package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class ID2296DesignATextEditor {

    public static void main(String[] args) {
        TextEditor solution = new ID2296DesignATextEditor().new TextEditor();
        StringBuilder sb = new StringBuilder();                //执行测试
        solution.addText("leetcode");
        solution.deleteText(4);
        solution.addText("practice");
        solution.cursorRight(3);
        solution.cursorLeft(8);
        solution.deleteText(10);
        solution.cursorLeft(2);
        solution.cursorRight(6);
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class TextEditor {

        Deque<Character> stackLeft;
        Deque<Character> stackRight;

        public TextEditor() {
            stackLeft = new LinkedList<>();
            stackRight = new LinkedList<>();
        }

        public void addText(String text) {
            for (int i = 0; i < text.length(); i++) {
                stackLeft.addLast(text.charAt(i));
            }
        }

        public int deleteText(int k) {
            int cnt = 0;
            for (int i = 0; i < k && !stackLeft.isEmpty(); i++) {
                cnt++;
                stackLeft.removeLast();
            }
            return cnt;
        }

        public String cursorLeft(int k) {
            for (int i = 0; i < k && !stackLeft.isEmpty(); i++) {
                stackRight.addLast(stackLeft.removeLast());
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 10 && !stackLeft.isEmpty(); i++) {
                sb.append(stackLeft.peekLast());
                stackLeft.removeLast();
            }
            String res = sb.reverse().toString();
            for (int i = 0; i < res.length(); i++) {
                stackLeft.addLast(res.charAt(i));
            }
            return res;
        }

        public String cursorRight(int k) {
            for (int i = 0; i < k && !stackRight.isEmpty(); i++) {
                stackLeft.addLast(stackRight.removeLast());
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 10 && !stackLeft.isEmpty(); i++) {
                sb.append(stackLeft.peekLast());
                stackLeft.removeLast();
            }
            String res = sb.reverse().toString();
            for (int i = 0; i < res.length(); i++) {
                stackLeft.addLast(res.charAt(i));
            }
            return res;
        }
    }

/**
 * Your TextEditor object will be instantiated and called as such:
 * TextEditor obj = new TextEditor();
 * obj.addText(text);
 * int param_2 = obj.deleteText(k);
 * String param_3 = obj.cursorLeft(k);
 * String param_4 = obj.cursorRight(k);
 */
//leetcode submit region end(Prohibit modification and deletion)


} 