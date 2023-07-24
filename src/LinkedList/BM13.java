package LinkedList;

import java.util.ArrayList;

/*
 * public class ListNode {
 *   int val;
 *   ListNode next = null;
 *   public ListNode(int val) {
 *     this.val = val;
 *   }
 * }
 */

public class BM13 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head ListNode类 the head
     * @return bool布尔型
     */
    public static boolean isPail(ListNode head) {
        if (head == null)
            return false;
        ArrayList<Integer> numbers = new ArrayList<>();
        while (head != null) {
            numbers.add(head.val);
            head = head.next;
        }
        int i = 0, j = numbers.size() - 1;
        while (i < j) {
            if (!numbers.get(i).equals(numbers.get(j)))
                return false;
            i++;
            j--;
        }
        return true;
    }
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = null;
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        System.out.println(isPail(node1));
    }
}