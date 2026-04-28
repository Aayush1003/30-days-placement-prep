import java.util.*;

/**
 * Day 22 — Mixed Problems
 */
public class MixedProblems {

    // 1. Median in a Stream (Two Heaps)
    static class MedianFinder {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // left half
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // right half

        public void addNum(int num) {
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
            if (minHeap.size() > maxHeap.size()) maxHeap.add(minHeap.poll());
        }
        public double findMedian() {
            if (maxHeap.size() > minHeap.size()) return maxHeap.peek();
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
    }

    // 2. K-th Largest in Unsorted Array (QuickSelect)
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) minHeap.poll();
        }
        return minHeap.peek();
    }

    // 3. K-th Largest in Stream
    static class KthLargest {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int k;
        KthLargest(int k, int[] nums) {
            this.k = k;
            for (int n : nums) add(n);
        }
        public int add(int val) {
            minHeap.add(val);
            if (minHeap.size() > k) minHeap.poll();
            return minHeap.peek();
        }
    }

    // 4. Distinct Numbers in Window
    public static List<Integer> distinctInWindow(int[] arr, int k) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.merge(arr[i], 1, Integer::sum);
            if (i >= k) {
                int out = arr[i - k];
                map.put(out, map.get(out) - 1);
                if (map.get(out) == 0) map.remove(out);
            }
            if (i >= k - 1) result.add(map.size());
        }
        return result;
    }

    // 5. Flood Fill
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) return image;
        fill(image, sr, sc, image[sr][sc], color);
        return image;
    }
    private static void fill(int[][] image, int r, int c, int oldColor, int newColor) {
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length) return;
        if (image[r][c] != oldColor) return;
        image[r][c] = newColor;
        fill(image, r+1, c, oldColor, newColor);
        fill(image, r-1, c, oldColor, newColor);
        fill(image, r, c+1, oldColor, newColor);
        fill(image, r, c-1, oldColor, newColor);
    }

    public static void main(String[] args) {
        // Median in Stream
        MedianFinder mf = new MedianFinder();
        mf.addNum(1); mf.addNum(2);
        System.out.println("Median: " + mf.findMedian()); // 1.5
        mf.addNum(3);
        System.out.println("Median: " + mf.findMedian()); // 2.0

        // K-th Largest
        System.out.println("2nd Largest: " + findKthLargest(new int[]{3,2,1,5,6,4}, 2)); // 5

        // Distinct in Window
        System.out.println("Distinct(k=3): " + distinctInWindow(new int[]{1,2,1,3,4,2,3}, 3));

        // Flood Fill
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        floodFill(image, 1, 1, 2);
        System.out.println("Flood Fill: " + Arrays.deepToString(image));
    }
}
