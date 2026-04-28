import java.util.*;

/**
 * Day 14 — Advanced Stack & Queue Problems
 */
public class StackQueueAdvanced {

    // 1. LRU Cache
    static class LRUCache {
        class Node {
            int key, value;
            Node prev, next;
            Node(int k, int v) { key = k; value = v; }
        }
        int capacity;
        Map<Integer, Node> map = new HashMap<>();
        Node head = new Node(0, 0), tail = new Node(0, 0);

        LRUCache(int capacity) {
            this.capacity = capacity;
            head.next = tail;
            tail.prev = head;
        }
        public int get(int key) {
            if (!map.containsKey(key)) return -1;
            Node node = map.get(key);
            remove(node);
            insertAfterHead(node);
            return node.value;
        }
        public void put(int key, int value) {
            if (map.containsKey(key)) remove(map.get(key));
            if (map.size() == capacity) { remove(tail.prev); }
            Node node = new Node(key, value);
            insertAfterHead(node);
        }
        private void remove(Node node) {
            map.remove(node.key);
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        private void insertAfterHead(Node node) {
            map.put(node.key, node);
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }
    }

    // 2. Largest Rectangle in Histogram
    public static int largestRectangleArea(int[] heights) {
        int n = heights.length, maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= n; i++) {
            int h = (i == n) ? 0 : heights[i];
            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;
    }

    // 3. Sliding Window Maximum
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1)
                deque.pollFirst();
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i])
                deque.pollLast();
            deque.addLast(i);
            if (i >= k - 1) result[i - k + 1] = nums[deque.peekFirst()];
        }
        return result;
    }

    // 4. Min Stack
    static class MinStack {
        Stack<Long> stack = new Stack<>();
        long min;
        public void push(int val) {
            if (stack.isEmpty()) { stack.push(0L); min = val; }
            else { stack.push((long) val - min); if (val < min) min = val; }
        }
        public void pop() {
            long top = stack.pop();
            if (top < 0) min -= top;
        }
        public int top() {
            long top = stack.peek();
            return (int) (top < 0 ? min : top + min);
        }
        public int getMin() { return (int) min; }
    }

    // 5. Rotten Oranges (BFS)
    public static int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) queue.add(new int[]{i, j});
                else if (grid[i][j] == 1) fresh++;
            }
        if (fresh == 0) return 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        int time = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rotted = false;
            for (int q = 0; q < size; q++) {
                int[] cell = queue.poll();
                for (int[] d : dirs) {
                    int nr = cell[0]+d[0], nc = cell[1]+d[1];
                    if (nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]==1) {
                        grid[nr][nc] = 2;
                        queue.add(new int[]{nr, nc});
                        fresh--;
                        rotted = true;
                    }
                }
            }
            if (rotted) time++;
        }
        return fresh == 0 ? time : -1;
    }

    public static void main(String[] args) {
        // LRU Cache
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1); cache.put(2, 2);
        System.out.println("LRU get(1): " + cache.get(1)); // 1
        cache.put(3, 3);
        System.out.println("LRU get(2): " + cache.get(2)); // -1 (evicted)

        // Largest Rectangle
        System.out.println("\nLargest Rect: " + largestRectangleArea(new int[]{2,1,5,6,2,3})); // 10

        // Sliding Window Max
        System.out.println("Sliding Max: " + Arrays.toString(
            maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3))); // [3,3,5,5,6,7]

        // Rotten Oranges
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println("Rotten Oranges: " + orangesRotting(grid)); // 4
    }
}
