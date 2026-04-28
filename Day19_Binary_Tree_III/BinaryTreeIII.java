import java.util.*;

/**
 * Day 19 — Binary Tree Part III
 */
public class BinaryTreeIII {
    static class TreeNode {
        int val; TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    // 1. Maximum Path Sum
    static int maxSum;
    public static int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        maxGain(root);
        return maxSum;
    }
    private static int maxGain(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(maxGain(node.left), 0);
        int right = Math.max(maxGain(node.right), 0);
        maxSum = Math.max(maxSum, node.val + left + right);
        return node.val + Math.max(left, right);
    }

    // 2. Build Tree from Inorder + Preorder
    public static TreeNode buildTreePreIn(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
        return buildPreIn(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }
    private static TreeNode buildPreIn(int[] pre, int preL, int preR, int[] in, int inL, int inR, Map<Integer, Integer> map) {
        if (preL > preR || inL > inR) return null;
        TreeNode root = new TreeNode(pre[preL]);
        int inRoot = map.get(root.val);
        int leftSize = inRoot - inL;
        root.left = buildPreIn(pre, preL+1, preL+leftSize, in, inL, inRoot-1, map);
        root.right = buildPreIn(pre, preL+leftSize+1, preR, in, inRoot+1, inR, map);
        return root;
    }

    // 3. Build Tree from Inorder + Postorder
    public static TreeNode buildTreePostIn(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
        return buildPostIn(postorder, 0, postorder.length-1, inorder, 0, inorder.length-1, map);
    }
    private static TreeNode buildPostIn(int[] post, int poL, int poR, int[] in, int inL, int inR, Map<Integer, Integer> map) {
        if (poL > poR || inL > inR) return null;
        TreeNode root = new TreeNode(post[poR]);
        int inRoot = map.get(root.val);
        int leftSize = inRoot - inL;
        root.left = buildPostIn(post, poL, poL+leftSize-1, in, inL, inRoot-1, map);
        root.right = buildPostIn(post, poL+leftSize, poR-1, in, inRoot+1, inR, map);
        return root;
    }

    // 4. Symmetric Tree
    public static boolean isSymmetric(TreeNode root) {
        return root == null || isMirror(root.left, root.right);
    }
    private static boolean isMirror(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        return a.val == b.val && isMirror(a.left, b.right) && isMirror(a.right, b.left);
    }

    // 5. Flatten BT to Linked List (preorder)
    public static void flatten(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode prev = curr.left;
                while (prev.right != null) prev = prev.right;
                prev.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println("Max Path Sum: " + maxPathSum(root)); // 42

        TreeNode sym = new TreeNode(1);
        sym.left = new TreeNode(2); sym.right = new TreeNode(2);
        sym.left.left = new TreeNode(3); sym.left.right = new TreeNode(4);
        sym.right.left = new TreeNode(4); sym.right.right = new TreeNode(3);
        System.out.println("Symmetric: " + isSymmetric(sym)); // true
    }
}
