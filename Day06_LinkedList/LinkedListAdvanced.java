/**
 * Day 6 — Advanced LinkedList Problems
 */
public class LinkedListAdvanced {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    // 1. Intersection Point of Two LLs
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB;
        while (a != b) {
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }
        return a;
    }

    // 2. Detect Cycle
    public static boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    // 3. Reverse in Groups of K
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        int count = 0;
        while (temp != null && count < k) { temp = temp.next; count++; }
        if (count < k) return head;

        ListNode prev = null, curr = head;
        for (int i = 0; i < k; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head.next = reverseKGroup(curr, k);
        return prev;
    }

    // 4. Palindrome Check
    public static boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode rev = reverse(slow.next);
        ListNode p1 = head;
        while (rev != null) {
            if (p1.val != rev.val) return false;
            p1 = p1.next;
            rev = rev.next;
        }
        return true;
    }

    // 5. Starting Point of Loop
    public static ListNode detectCycleStart(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }

    // 6. Rotate LinkedList by K
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        int len = 1;
        ListNode tail = head;
        while (tail.next != null) { tail = tail.next; len++; }
        k = k % len;
        if (k == 0) return head;
        tail.next = head; // make circular
        ListNode newTail = head;
        for (int i = 1; i < len - k; i++) newTail = newTail.next;
        ListNode newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }

    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    static ListNode createList(int[] arr) {
        ListNode dummy = new ListNode(0), tail = dummy;
        for (int v : arr) { tail.next = new ListNode(v); tail = tail.next; }
        return dummy.next;
    }

    static void printList(ListNode h) {
        while (h != null) { System.out.print(h.val + (h.next != null ? " → " : "")); h = h.next; }
        System.out.println();
    }

    public static void main(String[] args) {
        // Reverse in K groups
        ListNode l = createList(new int[]{1,2,3,4,5});
        System.out.print("Reverse K=2: "); printList(reverseKGroup(l, 2));

        // Palindrome
        ListNode p = createList(new int[]{1,2,3,2,1});
        System.out.println("Palindrome: " + isPalindrome(p));

        // Rotate
        ListNode r = createList(new int[]{1,2,3,4,5});
        System.out.print("Rotate K=2: "); printList(rotateRight(r, 2));
    }
}
