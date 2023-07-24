package BinaryTree;

import java.util.ArrayList;
import java.util.Stack;

public class InOrder {
    public static void inorderRecursion(TreeNode root) {
        if (root == null)
            return;
        if (root.left != null)
            inorderRecursion(root.left);
        System.out.println(root.val);
        if (root.right != null)
            inorderRecursion(root.right);
    }

    public static int[] inorder(TreeNode root) {
        if (root == null)
            return new int[0];
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();
        while (root !=null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            result.add(node.val);
            root = node.right;
        }
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(9);
        TreeNode b = new TreeNode(11);
        TreeNode c = new TreeNode(3);
        a.left = b;
        a.right = c;
        b.left = null;
        b.right = null;
        c.right = null;
        c.left = null;
        int[] result = inorder(a);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
