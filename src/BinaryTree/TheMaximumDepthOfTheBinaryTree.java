package BinaryTree;

import java.util.ArrayDeque;

public class TheMaximumDepthOfTheBinaryTree {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param root TreeNode类
     * @return int整型
     */
    public static int maxDepthLevelOrder(TreeNode root) {
        if (root == null)
            return 0;
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.pop();
                if (node.right != null)
                    queue.add(node.right);
                if (node.left != null)
                    queue.add(node.left);
            }
            level += 1;
        }
        return level;
    }

    public static int recursionMaxDepth(TreeNode root){
        if (root == null)
            return 0;
        // dfs，先递归左子结点，再递归右子结点，最后求出每一子树的深度的最大值
        return Math.max(recursionMaxDepth(root.left), recursionMaxDepth(root.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(10);
        TreeNode b = new TreeNode(20);
        TreeNode c = new TreeNode(30);
        TreeNode d = new TreeNode(50);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = null;
        c.right = null;
        c.left = null;
        d.left = null;
        d.right = null;
        int result = maxDepthLevelOrder(a);
        System.out.println(result);
    }
}
