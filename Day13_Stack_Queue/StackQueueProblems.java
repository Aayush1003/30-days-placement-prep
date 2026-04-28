import java.util.*;

/**
 * Day 13 — Stack and Queue Problems
 */
public class StackQueueProblems {

    // 1. Stack using Queue (single queue)
    static class MyStack {
        Queue<Integer> queue = new LinkedList<>();
        public void push(int x) {
            queue.add(x);
            for (int i = 0; i < queue.size() - 1; i++)
                queue.add(queue.poll());
        }
        public int pop() { return queue.poll(); }
        public int top() { return queue.peek(); }
        public boolean empty() { return queue.isEmpty(); }
    }

    // 2. Queue using Stacks (amortized O(1))
    static class MyQueue {
        Stack<Integer> input = new Stack<>(), output = new Stack<>();
        public void push(int x) { input.push(x); }
        public int pop() { peek(); return output.pop(); }
        public int peek() {
            if (output.isEmpty())
                while (!input.isEmpty()) output.push(input.pop());
            return output.peek();
        }
        public boolean empty() { return input.isEmpty() && output.isEmpty(); }
    }

    // 3. Balanced Parentheses
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if (c == ')' && top != '(') return false;
                if (c == '}' && top != '{') return false;
                if (c == ']' && top != '[') return false;
            }
        }
        return stack.isEmpty();
    }

    // 4. Next Greater Element
    public static int[] nextGreaterElement(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i])
                stack.pop();
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }
        return result;
    }

    // 5. BFS of Graph
    public static List<Integer> bfs(int V, List<List<Integer>> adj) {
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);
            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Stack using Queue
        MyStack stack = new MyStack();
        stack.push(1); stack.push(2); stack.push(3);
        System.out.println("Stack top: " + stack.top()); // 3
        System.out.println("Stack pop: " + stack.pop()); // 3

        // Queue using Stack
        MyQueue queue = new MyQueue();
        queue.push(1); queue.push(2); queue.push(3);
        System.out.println("\nQueue peek: " + queue.peek()); // 1
        System.out.println("Queue pop: " + queue.pop());     // 1

        // Balanced Parentheses
        System.out.println("\n{[()]}: " + isValid("{[()]}"));   // true
        System.out.println("{[(])}: " + isValid("{[(])}"));     // false

        // Next Greater Element
        System.out.println("\nNGE: " + Arrays.toString(
            nextGreaterElement(new int[]{4, 5, 2, 10, 8}))); // [5,10,10,-1,-1]
    }
}
