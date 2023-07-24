package LinkedList;/*
 * public class ListNode {
 *   int val;
 *   ListNode next = null;
 *   public ListNode(int val) {
 *     this.val = val;
 *   }
 * }
 */

public class BM12 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head ListNode类 the head node
     * @return ListNode类
     */
    public static ListNode sortInList(ListNode head) {
        if (head == null)
            return null;
        ListNode dummyNode = new ListNode(Integer.MIN_VALUE);
        dummyNode.next = null;
        while (head != null) {
            ListNode next = head.next;
            insert(dummyNode, head);
            head = next;
        }
        return dummyNode.next;
    }

    private static void insert(ListNode dummyNode, ListNode node) {
        ListNode dummy_bak = dummyNode;
        ListNode pre = null;
        while (dummy_bak != null) {
            if (node.val > dummy_bak.val) {
                if (dummy_bak.next == null) {
                    dummy_bak.next = node;
                    node.next = null;
                    break;
                } else {
                    pre = dummy_bak;
                    dummy_bak = dummy_bak.next;
                }
            } else if (node.val < dummy_bak.val) {
                pre.next = node;
                node.next = dummy_bak;
                break;
            }
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(-100);
//        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(1);
//        node1.next = node2;
//        node2.next = node3;
        node1.next = null;
        ListNode result = sortInList(node1);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}