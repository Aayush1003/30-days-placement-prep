/**
 * Day 20 — BST Problems
 */
public class BSTProblems {
    static class TreeNode {
        int val; TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    // 1. Search in BST
    public static TreeNode searchBST(TreeNode root, int val) {
        while (root != null) {
            if (val == root.val) return root;
            root = val < root.val ? root.left : root.right;
        }
        return null;
    }

    // 2. Insert into BST
    public static TreeNode insertBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (val < root.val) root.left = insertBST(root.left, val);
        else root.right = insertBST(root.right, val);
        return root;
    }

    // 3. Construct BST from sorted array (balanced)
    public static TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length - 1);
    }
    private static TreeNode buildBST(int[] nums, int l, int r) {
        if (l > r) return null;
        int mid = (l + r) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = buildBST(nums, l, mid - 1);
        node.right = buildBST(nums, mid + 1, r);
        return node;
    }

    // 4. Validate BST
    public static boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private static boolean validate(TreeNode node, long min, long max) {
        if (node == null) return true;
        if (node.val <= min || node.val >= max) return false;
        return validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }

    // 5. LCA in BST
    public static TreeNode lcaBST(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val < root.val && q.val < root.val) root = root.left;
            else if (p.val > root.val && q.val > root.val) root = root.right;
            else return root;
        }
        return null;
    }

    // 6. Inorder Successor
    public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode successor = null;
        while (root != null) {
            if (p.val < root.val) { successor = root; root = root.left; }
            else root = root.right;
        }
        return successor;
    }

    // Inorder Predecessor
    public static TreeNode inorderPredecessor(TreeNode root, TreeNode p) {
        TreeNode predecessor = null;
        while (root != null) {
            if (p.val > root.val) { predecessor = root; root = root.right; }
            else root = root.left;
        }
        return predecessor;
    }

    static void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        int[] sorted = {1, 2, 3, 4, 5, 6, 7};
        TreeNode bst = sortedArrayToBST(sorted);
        System.out.print("BST Inorder: "); inorder(bst); System.out.println();
        System.out.println("Valid BST: " + isValidBST(bst)); // true
        System.out.println("Search 5: " + (searchBST(bst, 5) != null)); // true
        System.out.println("Search 8: " + (searchBST(bst, 8) != null)); // false
    }
}
