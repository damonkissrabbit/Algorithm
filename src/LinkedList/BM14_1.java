package LinkedList;/*
 * public class ListNode {
 *   int val;
 *   ListNode next = null;
 *   public ListNode(int val) {
 *     this.val = val;
 *   }
 * }
 */

public class BM14_1 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param head ListNode类 
     * @return ListNode类
     */
    public static ListNode oddEvenList(ListNode head) {
        if (head == null)
            return null;
        // 偶数
        ListNode even = head.next;
        // 奇数
        ListNode odd = head;
        ListNode evenHead = even;
        while(even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(6);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(7);
//        ListNode node6 = new ListNode(6);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
//        node5.next = node6;
        node2.next=null;
        ListNode result = oddEvenList(node1);
        while(result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}