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

public class BM2 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head ListNode类
     * @param m    int整型
     * @param n    int整型
     * @return ListNode类
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // 添加一个 dummy节点来解决首节点的问题
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        // 将pre指向dummyNode；
        ListNode before = dummyNode;

        // 找到m前一个节点为pre
        for (int i = 0; i < m - 1; i++) {
            before = before.next;
        }

        // 将rightNode指向pre
        ListNode rightNode = before;
        // 找到m位置的节点，就是要反转链表的右边的节点
        for (int i = 0; i < n - m + 1; i++) {
            rightNode = rightNode.next;
        }
        // 要反转链表的左边节点
        ListNode leftNode = before.next;
        // 找到m后面的链表的首节点
        ListNode after = rightNode.next;

        // 将原链表断开
        before.next = null;
        rightNode.next = null;

        // 反转指定的列表
        reverseLinkedList(leftNode);

        // 将链表连接起来
        before.next = rightNode;
        leftNode.next = after;
        // 返回dummyNode的下一个节点
        return dummyNode.next;
    }

    // 反转整个链表
    private void reverseLinkedList(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null){
            ListNode cur_next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = cur_next;
        }
    }
}