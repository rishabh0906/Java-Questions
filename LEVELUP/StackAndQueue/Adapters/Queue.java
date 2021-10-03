package Adapters;

public class Queue {
    private class Node {
        int val = 0;
        Node next = null;

        Node(int val) {
            this.val = val;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    Queue() {
        initialize();
    }

    private void initialize() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    private void QueueIsEmptyException() throws Exception {
        if (this.size == 0) {
            throw new Exception("QueueIsEmptyException");
        }
    }

    public int Size() {

        return this.size;
    }

    public boolean IsEmpty() {

        return this.size == 0;
    }

    private void addLast(Node node) {

        if (this.head == null) {

            this.head = this.tail = node;
        } else {
            this.tail.next = node;
            this.tail = node;
        }
        this.size++;
    }

    private Node removeFirst() {

        if (this.head == null) {
            return null;
        }

        Node toRemove = this.head;
        Node node = this.head.next;
        this.head.next = null;
        this.head = node;
        this.size--;
        return toRemove;

    }

    public void push(int value) {

        addLast(new Node(value));
    }

    public int peek() throws Exception {
        QueueIsEmptyException();

        return this.head.val;
    }

    public int pop() throws Exception {
        QueueIsEmptyException();

        return removeFirst().val;
    }
}
