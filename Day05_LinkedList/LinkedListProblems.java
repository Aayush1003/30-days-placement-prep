/**
 * Day 5 — Linked List Problems
 * All 6 problems with a common ListNode class
 */
public class LinkedListProblems {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    // ========== 1. Reverse LinkedList (Iterative) ==========
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null, current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    // Reverse LinkedList (Recursive)
    public static ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = reverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    // ========== 2. Find Middle of LinkedList ==========
    public static ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // ========== 3. Merge Two Sorted Linked Lists ==========
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        tail.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }

    // ========== 4. Remove N-th Node from End ==========
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;

        // Move fast n+1 steps ahead
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Move both until fast reaches end
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Remove the node
        slow.next = slow.next.next;
        return dummy.next;
    }

    // ========== 5. Delete a Given Node (O(1)) ==========
    public static void deleteNode(ListNode node) {
        // Copy next node's data and delete next node
        node.val = node.next.val;
        node.next = node.next.next;
    }

    // ========== 6. Add Two Numbers as LinkedList ==========
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry > 0) {
            int sum = carry;
            if (l1 != null) { sum += l1.val; l1 = l1.next; }
            if (l2 != null) { sum += l2.val; l2 = l2.next; }

            carry = sum / 10;
            tail.next = new ListNode(sum % 10);
            tail = tail.next;
        }

        return dummy.next;
    }

    // ========== Utility Methods ==========
    static ListNode createList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        for (int val : arr) {
            tail.next = new ListNode(val);
            tail = tail.next;
        }
        return dummy.next;
    }

    static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" → ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // 1. Reverse
        System.out.println("=== Reverse LinkedList ===");
        ListNode list1 = createList(new int[]{1, 2, 3, 4, 5});
        System.out.print("Original: "); printList(list1);
        list1 = reverseList(list1);
        System.out.print("Reversed: "); printList(list1);

        // 2. Find Middle
        System.out.println("\n=== Find Middle ===");
        ListNode list2 = createList(new int[]{1, 2, 3, 4, 5});
        System.out.println("Middle: " + middleNode(list2).val); // 3

        // 3. Merge Sorted
        System.out.println("\n=== Merge Two Sorted Lists ===");
        ListNode l1 = createList(new int[]{1, 3, 5});
        ListNode l2 = createList(new int[]{2, 4, 6});
        System.out.print("Merged: "); printList(mergeTwoLists(l1, l2));

        // 4. Remove Nth from End
        System.out.println("\n=== Remove 2nd from End ===");
        ListNode list4 = createList(new int[]{1, 2, 3, 4, 5});
        list4 = removeNthFromEnd(list4, 2);
        System.out.print("Result: "); printList(list4); // 1→2→3→5

        // 5. Add Two Numbers
        System.out.println("\n=== Add Two Numbers ===");
        ListNode n1 = createList(new int[]{2, 4, 3}); // 342
        ListNode n2 = createList(new int[]{5, 6, 4}); // 465
        System.out.print("Sum: "); printList(addTwoNumbers(n1, n2)); // 7→0→8 (807)
    }
}
