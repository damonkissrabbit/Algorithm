package LinkedList;/*
 * public class ListNode {
 *   int val;
 *   ListNode next = null;
 *   public ListNode(int val) {
 *     this.val = val;
 *   }
 * }
 */

import java.util.ArrayList;
import java.util.Collections;

public class BM12_1 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head ListNode类 the head node
     * @return ListNode类
     */
    public static ListNode sortInList(ListNode head) {
        if (head == null)
            return null;
        ArrayList<Integer> numbers = new ArrayList<>();
        while (head != null) {
            numbers.add(head.val);
            head = head.next;
        }
        Collections.sort(numbers);
        ListNode dummyNode = new ListNode(-1);
        ListNode tmp = dummyNode;
        dummyNode.next = null;
        for (Integer number : numbers) {
            ListNode node = new ListNode(number);
            tmp.next = node;
            tmp = node;
            tmp.next = null;
        }
        return dummyNode.next;
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