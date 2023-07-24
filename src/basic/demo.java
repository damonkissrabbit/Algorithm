package basic;


class ListNode {
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}

public class demo {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode ReverseList(ListNode head) {
        // write code here
//
//        if (head == null) {
//            return null;
//        }
//        ListNode pre = null;
//        ListNode next = null;
//
//        // 在操作的时候要保证链表不能断掉
//        while (head != null) {
//            next = head.next;
//            head.next = pre;
//            pre = head;
//            head = next;
//        }
//        return pre;

//        if (head == null){
//            return null;
//        }
//
//        Stack<ListNode> stack = new Stack<>();
//
//        while (head != null){
//            stack.push(head);
//            head = head.next;
//        }
////        if (stack.isEmpty()){
////            return null;
////        }
//        ListNode node = stack.pop();
//        // 为什么要dummy节点呢？ 因为最后要返回ListNode的头节点呀
//        ListNode dummy = node;
//        while (!stack.isEmpty()){
//            node.next = stack.pop();
//            node = node.next;
//        }
//        node.next = null;
//        return dummy;

        // double linked list
//        if (head == null) {
//            return null;
//        }
//        ListNode newNode = null;
//
//        while (head != null) {
//            ListNode temp = head.next;
//            head.next = newNode;
//            newNode = head;
//            head = temp;
//        }
//        return newNode;
        return reverseListInt(head, null);
    }

    // 递归的时候基本没有逻辑处理，当往回反弹的时候才开始处理，也就是从链表的尾端往前开始处理。
    // 修改过后在链表开始递归的时候开始往后处理，处理完之后直接返回递归的结果，这就是所谓的尾递归

    private ListNode reverseListInt(ListNode head, ListNode newHead) {
        if (head == null)
            return newHead;
        ListNode next = head.next;
        head.next = newHead;
        return reverseListInt(next, head);
    }
}