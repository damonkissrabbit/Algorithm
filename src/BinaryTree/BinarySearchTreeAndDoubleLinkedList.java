package BinaryTree;


/*
 * Require:
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。当转化完成以后，
 * 树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继
 */

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Stack;

public class BinarySearchTreeAndDoubleLinkedList {


    public static TreeNode Convert(TreeNode root) {
        if (root == null)
            return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = new TreeNode(2);
        TreeNode dummyNode = pre;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            node.left = pre;
            pre.right = node;
            pre = node;
            root = node.right;
        }
        TreeNode result = dummyNode.right;
        result.left = null;
        dummyNode.right = null;
        return result;
    }

    private static TreeNode head = null;
    private static TreeNode pre = null;

    public static TreeNode convertRecursion(TreeNode root) {
        if (root == null)
            //中序递归，叶子为空则返回
            return null;
        //首先递归到最左最小值
        convertRecursion(root.left);
        //找到最小值，初始化head与pre
        if (pre == null) {
            head = root;
            pre = root;
        }
        //当前节点与上一节点建立连接，将pre设置为当前值
        else {
            pre.right = root;
            root.left = pre;
            pre = root;
        }
        System.out.println(root.val);
        convertRecursion(root.right);
        return head;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(8);
        TreeNode b = new TreeNode(10);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(5);
        TreeNode e = new TreeNode(20);
        a.left = b;
        a.right = c;
        b.left = d;
        c.left = e;
        TreeNode result = Convert(a);
        TreeNode result_recursion = convertRecursion(a);
        while (result != null) {
            System.out.println(result.val);
            result = result.right;
        }
        System.out.println("-------------------------------------------------");
//        while (result_recursion != null) {
//            System.out.println(result_recursion.val);
//            result_recursion = result_recursion.right;
//        }
    }
}
