import java.util.*;

/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
public class BM7 {

    public ListNode EntryNodeOfLoop(ListNode pHead) {
//        HashSet<ListNode> visited = new HashSet<>();
//        while (pHead != null){
//            if (visited.contains(pHead)){
//                return pHead;
//            }
//            visited.add(pHead);
//            pHead = pHead.next;
//        }
//        return null;
        if (pHead == null)
            return null;

        ListNode slow = pHead;
        ListNode fast = pHead;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }

        if (fast == null || fast.next == null) return null;

        fast = pHead;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
