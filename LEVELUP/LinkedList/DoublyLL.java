
public class DoublyLL {

    public static class ListNode {
        int val = 0;
        ListNode prev = null;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    private static ListNode head = null;
    private static ListNode tail = null;
    static int size = 0;

    public static void addFirst(int val) {
        ListNode node = new ListNode(val);
        if (head == null) {
            head = tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;

    }

    public static void addLast(int val) {
        ListNode node = new ListNode(val);
        if (head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;

    }

    public static int removeFirst() {
        if (size == 0) {

            return -1;
        }
        ListNode node = head;
        head = head.next;
        if (node.next != null) {
            node.next.prev = null;
            node.next = null;
        }
        size--;
        return node.val;

    }

    public static int removeLast() {
        if (size == 0) {

            return -1;
        }
        ListNode node = tail;
        tail = node.prev;
        if (node.prev != null) {

            node.prev.next = null;
            node.prev = null;
        }
        size--;
        return node.val;
    }

    public static int getLast() {
        if (size == 0)
            return -1;

        return head.val;
    }

    public static int getFirst() {
        if (size == 0)
            return -1;

        return tail.val;
    }

    public static int getAt(int index) {
        if (index < 0 || index >= size)
            return -1;
        ListNode curr = head;
        while (index-- > 0) {

            curr = curr.next;
        }

        return curr.val;

    }

    public static void addAt(int index, int value) {
        if (index < 0 || index > size)
            return;

        if (index == 0) {
            addFirst(value);
            return;
        } else if (index == size) {
            addLast(value);
            return;
        }

        ListNode curr = head;
        while (index-- > 0) {
            curr = curr.next;
        }
        ListNode node = new ListNode(value);
        ListNode prev = curr.prev;

        node.next = curr;
        curr.prev = node;
        prev.next = node;
        node.prev = prev;

    }

    public static int removeAt(int index) {

        if (index < 0 || index >= size)
            return -1;

        if (index == 0)
            return removeFirst();
        if (index == size - 1)
            return removeLast();

        ListNode curr = head;

        while (index-- > 0)
            curr = curr.next;

        ListNode prev = curr.prev;
        prev.next = curr.next;
        curr.next.prev = prev;
        curr.next = null;

        return curr.val;
    }
}