package BinaryTree;

import java.util.*;

public class LevelOrder {
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    void traverse(TreeNode root, int depth) {
        if (root == null) {
            return;
        } else {
            if (result.size() < depth) {
                ArrayList<Integer> row = new ArrayList<>();
                row.add(root.val);
                result.add(row);
            } else {
                ArrayList<Integer> row = result.get(depth - 1);
                row.add(root.val);
            }
        }
        traverse(root.left, depth + 1);
        traverse(root.right, depth + 1);
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param root TreeNode类
     * @return int整型ArrayList<ArrayList <>>
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return result;
        traverse(root, 1);
        return result;
    }

}
