package LinkedList;

import java.util.Stack;

/*
 * public class ListNode {
 *   int val;
 *   ListNode next = null;
 *   public ListNode(int val) {
 *     this.val = val;
 *   }
 * }
 */

public class BM8 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param pHead ListNode类
     * @param k     int整型
     * @return ListNode类
     */
    public ListNode FindKthToTail(ListNode pHead, int k) {
//        ListNode fast = pHead;
//        ListNode slow = pHead;
//        for (int i = 0; i < k; i++) {
//            if (fast == null){
//                return null;
//            }
//            fast = fast.next;
//        }
//        while (fast != null) {
//            fast = fast.next;
//            slow = slow.next;
//        }
//        return slow;
        if (pHead == null) {
            return null;
        }
        Stack<ListNode> stack = new Stack<>();
        while (pHead != null) {
            stack.push(pHead);
            pHead = pHead.next;
        }
        int i = 0;
        while (!stack.isEmpty()) {
            ListNode popNode = stack.pop();
            i += 1;
            if (i == k){
                return popNode;
            }
        }
        return null;
    }
}