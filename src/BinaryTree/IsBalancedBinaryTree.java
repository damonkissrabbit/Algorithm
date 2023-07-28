package BinaryTree;


public class IsBalancedBinaryTree {

    public static int getDepth(TreeNode root){
        if (root == null)
            return 0;
        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }

    public static boolean IsBalanced_Solution (TreeNode root) {
        if(root == null)
            return true;
//        if (Math.abs(getDepth(root.left) - getDepth(root.right)) > 1)
//            return false;
//        return  IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right) && Math.abs(getDepth(root.left) -getDepth(root.right)) < 2;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1111);
        TreeNode b = new TreeNode(222);
        TreeNode c = new TreeNode(333);
        TreeNode d = new TreeNode(999);
        a.left = b;
        a.right = c;
        b.left = d;
        System.out.println(IsBalanced_Solution(a));
    }
}
