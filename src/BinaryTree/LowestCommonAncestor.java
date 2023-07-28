package BinaryTree;

public class LowestCommonAncestor {
    public static int lowestCommonAncestor (TreeNode root, int p, int q) {
        if (root == null)
            return 0;
        int minNum = Math.min(p, q);
        int maxNum = Math.max(p, q);
        if (minNum <= root.val && root.val <= maxNum)
            return root.val;
        else if (minNum > root.val)
            return lowestCommonAncestor(root.right, p, q);
        else if (maxNum < root.val)
            return lowestCommonAncestor(root.left, p, q);
        return 0;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(11111);
        TreeNode b = new TreeNode(222);
        TreeNode c = new TreeNode(33333);
        TreeNode d = new TreeNode(99);
        a.left = b;
        a.right = c;
        b.left = d;
        System.out.println(lowestCommonAncestor(a, 222, 99));
    }
}
