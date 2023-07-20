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

public class BM4 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param pHead1 ListNode类
     * @param pHead2 ListNode类
     * @return ListNode类
     */
    public ListNode Merge(ListNode pHead1, ListNode pHead2) {
//        if (pHead1 == null)
//            return pHead2;
//        if (pHead2 == null)
//            return pHead1;
//        ListNode dummyNode = new ListNode(-1);
//        ListNode result = dummyNode;
//        while (pHead1 != null && pHead2 != null){
//            if (pHead1.val < pHead2.val){
//                result.next = pHead1;
//                pHead1 = pHead1.next;
//            } else {
//                result.next = pHead2;
//                pHead2 = pHead2.next;
//            }
//            result = result.next;
//        }
//        result.next = (pHead1 != null) ? pHead1 : pHead2;
//        return dummyNode.next;
        if (pHead1 == null || pHead2 == null) {
            return pHead1 != null ? pHead1 : pHead2;
        }
        if (pHead1.val <= pHead2.val) {
            pHead1.next = Merge(pHead1.next, pHead2);
            return pHead1;
        } else {
            pHead2.next = Merge(pHead1, pHead2.next);
            return pHead2;
        }
    }
}