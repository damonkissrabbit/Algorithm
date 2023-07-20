import java.util.*;

/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class BM6 {
    public boolean hasCycle(ListNode head) {
//        if (head == null){
//            return false;
//        }
//
//        ListNode slow = head;
//        ListNode fast = head;
//
//        while (slow != null && fast != null) {
//            slow = slow.next;
//            if (fast.next != null) {
//                fast = fast.next.next;
//            }else{
//                return false;
//            }
//            if (slow == fast){
//                return true;
//            }
//        }
//        return false;
//        ListNode pos = head;
        HashSet<ListNode> visited = new HashSet<>();
        while (head != null) {
            if (visited.contains(head)){
                return true;
            }else {
                visited.add(head);
            }
            head = head.next;
        }
        return false;
    }
}