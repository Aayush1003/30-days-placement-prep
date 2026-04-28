import java.util.*;

/**
 * Day 21 — BST Part II
 */
public class BSTAdvanced {
    static class TreeNode {
        int val; TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    // 1. Floor in BST
    public static int floor(TreeNode root, int key) {
        int floor = -1;
        while (root != null) {
            if (root.val == key) return root.val;
            if (key > root.val) { floor = root.val; root = root.right; }
            else root = root.left;
        }
        return floor;
    }

    // Ceil in BST
    public static int ceil(TreeNode root, int key) {
        int ceil = -1;
        while (root != null) {
            if (root.val == key) return root.val;
            if (key < root.val) { ceil = root.val; root = root.left; }
            else root = root.right;
        }
        return ceil;
    }

    // 2. K-th Smallest (iterative inorder)
    public static int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) { stack.push(curr); curr = curr.left; }
            curr = stack.pop();
            if (--k == 0) return curr.val;
            curr = curr.right;
        }
        return -1;
    }

    // 3. BST Iterator
    static class BSTIterator {
        Stack<TreeNode> stack = new Stack<>();
        BSTIterator(TreeNode root) { pushAll(root); }
        public int next() { TreeNode node = stack.pop(); pushAll(node.right); return node.val; }
        public boolean hasNext() { return !stack.isEmpty(); }
        private void pushAll(TreeNode node) { while (node != null) { stack.push(node); node = node.left; } }
    }

    // 4. Serialize & Deserialize
    public static String serialize(TreeNode root) {
        if (root == null) return "null";
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }
    public static TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return buildTree(queue);
    }
    private static TreeNode buildTree(Queue<String> queue) {
        String val = queue.poll();
        if ("null".equals(val)) return null;
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = buildTree(queue);
        node.right = buildTree(queue);
        return node;
    }

    // 5. Largest BST in Binary Tree
    static int largestBSTSize;
    public static int largestBST(TreeNode root) {
        largestBSTSize = 0;
        largestBSTHelper(root);
        return largestBSTSize;
    }
    // Returns {size, min, max}; size = -1 if not BST
    private static int[] largestBSTHelper(TreeNode node) {
        if (node == null) return new int[]{0, Integer.MAX_VALUE, Integer.MIN_VALUE};
        int[] left = largestBSTHelper(node.left);
        int[] right = largestBSTHelper(node.right);
        if (left[0] != -1 && right[0] != -1 && node.val > left[2] && node.val < right[1]) {
            int size = left[0] + right[0] + 1;
            largestBSTSize = Math.max(largestBSTSize, size);
            return new int[]{size, Math.min(node.val, left[1]), Math.max(node.val, right[2])};
        }
        return new int[]{-1, 0, 0};
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3); root.right = new TreeNode(7);
        root.left.left = new TreeNode(2); root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6); root.right.right = new TreeNode(8);

        System.out.println("Floor(4.5): " + floor(root, 4)); // 4
        System.out.println("Ceil(4.5): " + ceil(root, 4));   // 4
        System.out.println("3rd Smallest: " + kthSmallest(root, 3)); // 4

        String serialized = serialize(root);
        System.out.println("Serialized: " + serialized);
        TreeNode deserialized = deserialize(serialized);
        System.out.println("Deserialized root: " + deserialized.val); // 5

        System.out.println("Largest BST size: " + largestBST(root)); // 7
    }
}
