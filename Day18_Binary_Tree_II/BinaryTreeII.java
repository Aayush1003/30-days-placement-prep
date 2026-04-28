import java.util.*;

/**
 * Day 18 — Binary Tree Part II
 */
public class BinaryTreeII {
    static class TreeNode {
        int val; TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    // 1. Level Order Traversal
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                level.add(node.val);
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            result.add(level);
        }
        return result;
    }

    // 2. Height
    public static int height(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    // 3. Diameter
    static int diameter;
    public static int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        heightForDiameter(root);
        return diameter;
    }
    private static int heightForDiameter(TreeNode node) {
        if (node == null) return 0;
        int lh = heightForDiameter(node.left), rh = heightForDiameter(node.right);
        diameter = Math.max(diameter, lh + rh);
        return 1 + Math.max(lh, rh);
    }

    // 4. Is Balanced
    public static boolean isBalanced(TreeNode root) {
        return checkBalance(root) != -1;
    }
    private static int checkBalance(TreeNode node) {
        if (node == null) return 0;
        int lh = checkBalance(node.left); if (lh == -1) return -1;
        int rh = checkBalance(node.right); if (rh == -1) return -1;
        if (Math.abs(lh - rh) > 1) return -1;
        return 1 + Math.max(lh, rh);
    }

    // 5. LCA
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }

    // 6. Identical Trees
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2); root.right = new TreeNode(3);
        root.left.left = new TreeNode(4); root.left.right = new TreeNode(5);

        System.out.println("Level Order: " + levelOrder(root));
        System.out.println("Height: " + height(root)); // 3
        System.out.println("Diameter: " + diameterOfBinaryTree(root)); // 3
        System.out.println("Balanced: " + isBalanced(root)); // true
    }
}
