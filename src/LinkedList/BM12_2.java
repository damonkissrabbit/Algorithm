package LinkedList;/*
 * public class ListNode {
 *   int val;
 *   ListNode next = null;
 *   public ListNode(int val) {
 *     this.val = val;
 *   }
 * }
 */

public class BM12_2 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head ListNode类 the head node
     * @return ListNode类
     */
    public static ListNode sortInList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;

        ListNode left = sortInList(head);
        ListNode right = sortInList(tmp);

        ListNode tmpHead = new ListNode(-1);
        ListNode dummyNode = tmpHead;

        while (left != null && right != null) {
            if (left.val < right.val) {
                dummyNode.next = left;
                left = left.next;
            } else {
                dummyNode.next = right;
                right = right.next;
            }
            dummyNode = dummyNode.next;
        }
        dummyNode.next = left != null ? left : right;
        return tmpHead.next;
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(-100);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        ListNode result = sortInList(node1);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}