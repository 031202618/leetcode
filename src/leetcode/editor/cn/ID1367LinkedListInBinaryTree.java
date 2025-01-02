package leetcode.editor.cn;

import leetcode.editor.cn.util.ListNode;
import leetcode.editor.cn.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class ID1367LinkedListInBinaryTree {

    public static void main(String[] args) {
        Solution solution = new ID1367LinkedListInBinaryTree().new Solution();
        StringBuilder sb = new StringBuilder();                //执行测试
        System.out.println(sb);
    }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public boolean isSubPath(ListNode head, TreeNode root) {
            return dfs(head, root, new ArrayList<>());
        }

        public boolean dfs(ListNode head, TreeNode root, List<Integer> path) {
            if (root == null) {
                return cmp(path, head);
            }
            boolean res = false;
            path.add(root.val);
            res |= dfs(head, root.left, path);
            path.removeLast();
            path.add(root.val);
            res |= dfs(head, root.right, path);
            path.removeLast();
            return res;
        }

        public boolean cmp(List<Integer> a, ListNode b) {
            for(int i = 0; i < a.size(); i++) {
                ListNode start = b;
                if(a.get(i) == start.val){
                    start = start.next;
                    for(int j = 1; i + j < a.size(); j++) {
                        if (start == null) {
                            return true;
                        }
                        if(a.get(i + j) == start.val){
                            start = start.next;
                        }else{
                            break;
                        }
                    }
                    if(start == null){
                        return true;
                    }
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


} 