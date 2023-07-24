package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrder {
    public static void postOrderRecursion(TreeNode root) {
        if (root == null)
            return;
        if (root.left != null)
            postOrderRecursion(root.left);
        if (root.right != null)
            postOrderRecursion(root.right);
        System.out.println(root.val);
    }

    public static int[] postOrder(TreeNode root) {
        if (root == null)
            return new int[0];
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            if (node.right == null || node.right == pre){
                list.add(node.val);
                pre = node;
            } else {
                stack.push(node);
                root = node.right;
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(99);
        TreeNode b = new TreeNode(88);
        TreeNode c = new TreeNode(3);
        a.left = b;
        a.right = c;
        b.left = null;
        b.right = null;
        c.right = null;
        c.left = null;
//        postOrderRecursion(a);
        int[] result = postOrder(a);
        for (int re : result) {
            System.out.println(re);
        }
    }
}
