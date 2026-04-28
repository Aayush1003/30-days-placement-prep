import java.util.*;

/**
 * Day 17 — Binary Tree Traversals & Views
 */
public class BinaryTreeProblems {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    // Inorder (Iterative)
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) { stack.push(curr); curr = curr.left; }
            curr = stack.pop();
            result.add(curr.val);
            curr = curr.right;
        }
        return result;
    }

    // Preorder (Iterative)
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return result;
    }

    // Postorder (Iterative using 2 stacks)
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> s1 = new Stack<>(), s2 = new Stack<>();
        s1.push(root);
        while (!s1.isEmpty()) {
            TreeNode node = s1.pop();
            s2.push(node);
            if (node.left != null) s1.push(node.left);
            if (node.right != null) s1.push(node.right);
        }
        while (!s2.isEmpty()) result.add(s2.pop().val);
        return result;
    }

    // Left View
    public static List<Integer> leftView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == 0) result.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return result;
    }

    // Top View (BFS + vertical order)
    public static List<Integer> topView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Object[]> queue = new LinkedList<>();
        queue.add(new Object[]{root, 0});
        while (!queue.isEmpty()) {
            Object[] pair = queue.poll();
            TreeNode node = (TreeNode) pair[0];
            int col = (int) pair[1];
            if (!map.containsKey(col)) map.put(col, node.val);
            if (node.left != null) queue.add(new Object[]{node.left, col - 1});
            if (node.right != null) queue.add(new Object[]{node.right, col + 1});
        }
        result.addAll(map.values());
        return result;
    }

    // Bottom View
    public static List<Integer> bottomView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Object[]> queue = new LinkedList<>();
        queue.add(new Object[]{root, 0});
        while (!queue.isEmpty()) {
            Object[] pair = queue.poll();
            TreeNode node = (TreeNode) pair[0];
            int col = (int) pair[1];
            map.put(col, node.val); // Overwrite = bottom view
            if (node.left != null) queue.add(new Object[]{node.left, col - 1});
            if (node.right != null) queue.add(new Object[]{node.right, col + 1});
        }
        result.addAll(map.values());
        return result;
    }

    public static void main(String[] args) {
        //       1
        //      / \
        //     2   3
        //    / \   \
        //   4   5   6
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2); root.right = new TreeNode(3);
        root.left.left = new TreeNode(4); root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        System.out.println("Inorder:   " + inorderTraversal(root));   // [4,2,5,1,3,6]
        System.out.println("Preorder:  " + preorderTraversal(root));  // [1,2,4,5,3,6]
        System.out.println("Postorder: " + postorderTraversal(root)); // [4,5,2,6,3,1]
        System.out.println("Left View: " + leftView(root));           // [1,2,4]
        System.out.println("Top View:  " + topView(root));            // [4,2,1,3,6]
        System.out.println("Bottom View: " + bottomView(root));       // [4,2,5,3,6]
    }
}
