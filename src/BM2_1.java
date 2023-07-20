/*
 * public class ListNode {
 *   int val;
 *   ListNode next = null;
 *   public ListNode(int val) {
 *     this.val = val;
 *   }
 * }
 */

public class BM2_1 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head ListNode类
     * @param m    int整型
     * @param n    int整型
     * @return ListNode类
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode before = dummyNode;

        for (int i = 0; i < m - 1; i++) {
            before = before.next;
        }

        ListNode leftNode = before.next;
        ListNode leftNode_next;
        int i = 0;
        while (i < n - m) {
            leftNode_next = leftNode.next;
            leftNode.next = leftNode_next.next;
            leftNode_next.next = before.next;
            before.next = leftNode_next;
            i += 1;
        }

        return dummyNode.next;
    }
}