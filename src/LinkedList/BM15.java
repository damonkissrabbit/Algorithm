package LinkedList;

import java.util.HashSet;

/*
 * public class ListNode {
 *   int val;
 *   ListNode next = null;
 *   public ListNode(int val) {
 *     this.val = val;
 *   }
 * }
 */

public class BM15 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head ListNode类
     * @return ListNode类
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;
        ListNode pre = null;
        ListNode dummyNode = head;
        HashSet<Integer> numbers = new HashSet<>();
        while (head != null) {
            ListNode next = head.next;
            if (numbers.contains(head.val)){
                pre.next = head.next;
            } else {
                numbers.add(head.val);
                pre = head;
            }
            head = next;
        }
        return dummyNode;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(6);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
//        node1.next = null;
        ListNode result = deleteDuplicates(node1);
        while(result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}