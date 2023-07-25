package BinaryTree;

import com.sun.jmx.remote.internal.ArrayQueue;
import sun.reflect.generics.tree.Tree;

import java.util.*;

public class PrintBinaryTreeInZigzagOrder {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param pRoot TreeNode类
     * @return int整型ArrayList<ArrayList <>>
     */
    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null)
            return result;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(pRoot);
        int level = 0;
        while (!queue.isEmpty()) {
            ArrayList<Integer> row = new ArrayList<>();
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if (level % 2 == 0){
                    if (node.right != null)
                        queue.add(node.right);
                    if (node.left != null)
                        queue.add(node.left);
                }else {
                    if (node.left != null)
                        queue.add(node.left);
                    if (node.right != null)
                        queue.add(node.right);
                }
                level += 1;
                row.add(node.val);
            }
            result.add(row);
        }
        return result;
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
        ArrayList<ArrayList<Integer>> result = Print(a);
        for (ArrayList<Integer> res : result) {
            System.out.println(res);
        }
    }
}
