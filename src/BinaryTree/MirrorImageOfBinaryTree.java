package BinaryTree;

import java.util.Stack;

public class MirrorImageOfBinaryTree {
    public static TreeNode Mirror(TreeNode root) {
        if (root == null)
            return null;
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        Mirror(root.left);
        Mirror(root.right);
        return root;
    }

    public static TreeNode mirrorStack(TreeNode root) {
        if (root == null)
            return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node  = stack.pop();
            if (node.left != null)
                stack.push(node.left);
            if (node.right != null)
                stack.push(node.right);
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(111);
        TreeNode b = new TreeNode(222);
        TreeNode c = new TreeNode(333);
        TreeNode d = new TreeNode(999);
        a.left = b;
        a.right = c;
        b.left = d;

        TreeNode result = Mirror(a);
        System.out.println(result.right.right.val);
    }
}
