import java.util.*;

/*
 * public class ListNode {
 *   int val;
 *   ListNode next = null;
 *   public ListNode(int val) {
 *     this.val = val;
 *   }
 * }
 */

public class BM9 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head ListNode类
     * @param n    int整型
     * @return ListNode类
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode slow = dummyNode;
        ListNode fast = dummyNode;
        ListNode slowPre = null;

        int i = 0;
        while (fast != null) {
            fast = fast.next;
            if (i < n) {
                i++;
            } else {
                slowPre = slow;
                slow = slow.next;
            }
        }
        assert slowPre != null;
        slowPre.next = slow.next;
        slow.next = null;
        return dummyNode.next;

//        for (int i = 0; i < n; i++) {
//            if (fast == null) {
//                return null;
//            }
//            fast = fast.next;
//        }
//
//        ListNode slowPre = slow;
//        while (fast != null) {
//            fast = fast.next;
//            slowPre = slow;
//            slow = slow.next;
//        }
//
//        slowPre.next = slow.next;
//        slow.next = null;
//        return dummyNode.next
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode listNode = removeNthFromEnd(node1, 5);
        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}