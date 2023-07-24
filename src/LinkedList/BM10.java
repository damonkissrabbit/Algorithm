package LinkedList;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class BM10 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode head1 = pHead1, head2 = pHead2;
        while (head1 != head2) {
            // 两个指针分别走完当前链表后，再冲两一个链表重新开始走，知道相遇
            // 当他们走的步数刚好相等时候，两个指针第一次相遇。
            head1 = head1 == null ? pHead2 : head1.next;
            head2 = head2 == null ? pHead1 : head2.next;
        }
        return head1;
    }
}
