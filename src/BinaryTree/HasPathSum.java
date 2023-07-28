package BinaryTree;

public class HasPathSum {
    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        if (root.left == null && root.right == null && root.val == sum)
            return true;

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public static boolean hasPathSumDfs(TreeNode root, int sum) {
        if (root == null)
            return false;
        return dfs(root, sum);
    }

    private static boolean dfs(TreeNode root, int sum) {
        if (root == null)
            return false;
        sum -= root.val;

        if (root.left == null && root.right == null && sum == 0)
            return true;

        return dfs(root.left, sum) || dfs(root.right, sum);
    }


    public static void main(String[] args) {
        TreeNode a = new TreeNode(8);
        TreeNode b = new TreeNode(10);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(5);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = null;
        c.right = null;
        c.left = null;
        d.left = null;
        d.right = null;
        System.out.println(hasPathSum(a, 11));
    }
}
