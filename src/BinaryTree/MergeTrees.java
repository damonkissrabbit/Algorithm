package BinaryTree;

import java.util.LinkedList;

public class MergeTrees {
    public TreeNode mergeTreesRecursion(TreeNode root1, TreeNode root2) {
        if (root1 == null)
            return root2;
        if (root2 == null)
            return root1;
        TreeNode head = new TreeNode(root1.val + root2.val);
        head.left = mergeTreesRecursion(root1.left, root2.left);
        head.right = mergeTreesRecursion(root1.right, root2.right);
        return head;
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null)
            return root2;
        if (root2 == null)
            return root1;
        TreeNode head = new TreeNode(root1.val + root2.val);
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<TreeNode> queue1 = new LinkedList<>();
        LinkedList<TreeNode> queue2 = new LinkedList<>();
        queue.offer(head);
        queue1.offer(root1);
        queue2.offer(root2);
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();
            if (node1.left != null || node2.left != null) {
                if (node1.left != null && node2.left != null) {
                    node.left = new TreeNode(node1.left.val + node2.left.val);
                } else if (node1.left != null) {
                    node.left = node1.left;
                } else
                    node.left = node2.left;
            }
            if (node1.right != null || node2.right != null) {
                if (node1.right != null && node2.right != null) {
                    node.right = new TreeNode(node1.right.val + node.right.val);
                } else if (node1.right != null) {
                    node.right = node1.right;
                } else
                    node.right = node2.right;
            }
        }
        return head;
    }
}
