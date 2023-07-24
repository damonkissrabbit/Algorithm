package BinaryTree;


import java.util.Stack;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class PreOrderRecursion {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param root TreeNode类
     */
    public static void preorderTraversalRecursion(TreeNode root) {
        if (root == null)
            return;
        System.out.println(root.val);
        if (root.left != null)
            preorderTraversalRecursion(root.left);
        if (root.right != null)
            preorderTraversalRecursion(root.right);
    }

    public static void preorderTraversal(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
            System.out.println(node.val);
        }
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        a.left = b;
        a.right = c;
        b.left = null;
        b.right = null;
        c.right = null;
        c.left = null;
        preorderTraversal(a);
    }
}
