package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricalBinaryTree {

    boolean recursion(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null || root1.val != root2.val)
            return false;
        return recursion(root1.left, root2.right) && recursion(root1.right, root2.left);
    }

    public boolean isSymmetricalRecursion(TreeNode root) {
        return recursion(root, root);
    }

    public boolean isSymmetrical(TreeNode root) {
        if (root == null)
            return true;
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.offer(root.left);
        q2.offer(root.right);
        while (!q1.isEmpty() && !q2.isEmpty()) {
            TreeNode left = q1.poll();
            TreeNode right = q2.poll();
            if (left == null && right == null)
                continue;
            if (left == null || right == null || left.val != right.val)
                return false;
            q1.offer(left.left);
            q1.offer(left.right);
            q2.offer(right.right);
            q2.offer(right.left);
        }
        return true;
    }
}
