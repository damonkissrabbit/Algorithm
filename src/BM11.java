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

public class BM11 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param head1 ListNode类 
     * @param head2 ListNode类 
     * @return ListNode类
     */
    public static ListNode addInList (ListNode head1, ListNode head2) {
        if (head1 == null)
            return head2;
        if (head2 == null)
            return head1;
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        while (head1 != null){
            stack1.push(head1);
            head1 = head1.next;
        }
        while(head2 != null){
            stack2.push(head2);
            head2 = head2.next;
        }
        int tmp = 0;
        ListNode nHead = null;
        while (!stack1.isEmpty() || !stack2.isEmpty()){
            int value = tmp;
            if (!stack1.isEmpty()){
                value += stack1.pop().val;
            }
            if (!stack2.isEmpty()){
                value += stack2.pop().val;
            }
            tmp = value / 10;
            ListNode node = new ListNode(value % 10);
            node.next = nHead;
            nHead = node;
        }
        if (tmp > 0 ){
            ListNode node = new ListNode(tmp);
            node.next = nHead;
            nHead = node;
        }
        return nHead;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;

        ListNode newNode1 = new ListNode(0);
        newNode1.next = new ListNode(8);

        ListNode result  = addInList(node1, newNode1);

        while(result != null){
            System.out.println(result.val);
            result = result.next;
        }

    }
}