import java.util.*;
public class LinkedList {

    private class Node {

        int val = 0;
        Node next = null;

        Node(int val) {
            this.val = val;
        }
    }

    private Node head = null;
    private Node tail = null;
    private int size = 0;

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        Node curr = head;
        while (curr != null) {
            sb.append(curr.val);

            if (curr.next != null) {
                sb.append("->");
            }
            curr = curr.next;
        }
        sb.append("]");
        return sb.toString();
    }

    // Carefully examine testCases in LinkedList
    // ========================================================================
    private void addFirstNode(Node node) {
        if (isEmpty()) {
            this.head = this.tail = node;
        } else {
            node.next = this.head;
            this.head = node;
        }
        this.size++;
    }

    public void addFirst(int data) {
        Node node = new Node(data);
        addFirstNode(node);
    }

    private void addLastNode(Node node) {
        if (isEmpty()) {
            this.head = this.tail = node;
        } else {
            this.tail.next = node;
            tail = node;
        }
        this.size++;
    }

    public void addLast(int data) {
        Node node = new Node(data);
        addLastNode(node);
    }

    private void addNodeAt(Node node, int idx) {
        if (idx == 0) {
            addFirstNode(node);
        } else if (this.size == idx) {
            addLastNode(node);
        } else {
            Node prevNode = getAtIndex(idx - 1);
            Node FwdNode = prevNode.next;
            prevNode.next = node;
            node.next = FwdNode;
            this.size++;
        }
    }

    public void addAt(int idx, int val) {
        if (idx < 0 || idx > this.size)
            return;

        Node node = new Node(val);
        addNodeAt(node, idx);
    }

    // ==========================================================================

    private Node removeFirstNode() {
        Node node = this.head;

        if (this.size == 1) {
            this.head = this.tail = null;
        } else {
            this.head = this.head.next;
            node.next = null;
        }
        this.size--;
        return node;
    }

    public int removeFirst() {
        if (isEmpty()) {
            return -1;
        }
        return removeFirstNode().val;
    }

    private Node removeLastNode() {
        Node node = this.tail;
        if (this.size == 1) {
            this.head = this.tail = null;
        } else {
            Node PrevNode = getAtIndex(this.size - 2);

            PrevNode.next = null;
            this.tail = PrevNode;
        }
        this.size--;
        return node;
    }

    public int removeLast() {
        if (isEmpty()) {
            return -1;
        }

        return removeLastNode().val;
    }

    private Node removeAtIndex(int idx) {
        if (idx == 0) {
            return removeFirstNode();
        } else if (idx == this.size - 1) {
            return removeLastNode();
        }

        Node prevNode = getAtIndex(idx - 1);
        Node node = prevNode.next;
        prevNode.next = node.next;
        node.next = null;
        this.size--;

        return node;
    }

    public int removeAt(int idx) {
        if (idx < 0 || idx >= this.size) {
            return -1;
        }

        return removeAtIndex(idx).val;

    }

    // ======================================================================

    private Node getFirstNode() {
        return this.head;
    }

    public int getFirst() {
        if (isEmpty()) {
            return -1;
        }

        return getFirstNode().val;
    }

    private Node getAtIndex(int idx) {
        Node curr = this.head;
        while (idx-- > 0) {
            curr = curr.next;
        }

        return curr;
    }

    public int getAt(int idx) {
        if (idx < 0 || idx >= this.size) {
            return -1;
        }

        return getAtIndex(idx).val;
    }

}
