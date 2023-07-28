package BinaryTree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class LowestCommonAncestorInCommonBinaryTree {
    /**
     * 利用层次遍历将 o1, o2 以及他们的父节点都添加到hash表里面
     * 然后从下往上找他们的第一个公共父节点
     *
     * @param root
     * @param o1
     * @param o2
     * @return
     */
    public int lowestCommonAncestor(TreeNode root, int o1, int o2) {
        HashMap<Integer, Integer> parent = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        parent.put(root.val, Integer.MIN_VALUE);
        queue.add(root);
        while (!parent.containsKey(o1) || !parent.containsKey(o2)) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                parent.put(node.left.val, node.val);
                queue.add(node.left);
            }
            if (node.right != null) {
                parent.put(node.right.val, node.val);
                queue.add(node.right);
            }
        }
        HashSet<Integer> ancestors = new HashSet<>();
        while (parent.containsKey(o1)) {
            ancestors.add(o1);
            o1 = parent.get(o1);
        }
        while (!ancestors.contains(o2))
            o2 = parent.get(o2);
        return o2;
    }

    TreeNode helper(TreeNode root, int o1, int o2) {
        if (root == null || root.val == o1 || root.val == o2)
            return root;
        TreeNode left = helper(root.left, o1, o2);
        TreeNode right = helper(root.right, o1, o2);
        if (left == null)
            return right;
        if (right == null)
            return left;
        return root;
    }

    public int lowestCommonAncestorRecursion(TreeNode root, int o1, int o2) {
        return helper(root, o1, o2).val;
    }
}
