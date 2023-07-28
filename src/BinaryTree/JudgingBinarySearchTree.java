package BinaryTree;

import java.util.Stack;

public class JudgingBinarySearchTree {

    private static int pre = Integer.MIN_VALUE;

    public static boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        if (!isValidBST(root.left))
            return false;
        if (root.val < pre)
            return false;
        pre = root.val;
        return isValidBST(root.right);
    }

    public static boolean isValidBSTStack(TreeNode root) {
        if (root == null)
            return true;
        int pre = Integer.MIN_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            if (pre > node.val)
                return false;
            pre = node.val;
            root = node.right;
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1111);
        TreeNode b = new TreeNode(222);
        TreeNode c = new TreeNode(3333);
        TreeNode d = new TreeNode(99);
        a.left = b;
        a.right = c;
        b.left = d;
        System.out.println(isValidBSTStack(a));
    }
}
