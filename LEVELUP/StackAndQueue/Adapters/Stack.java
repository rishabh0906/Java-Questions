package Adapters;
public class Stack {

    private class Node {
        int val = 0;
        Node next = null;

        Node(int val) {
            this.val = val;
        }
    }

    private Node head;
    private int size;

    Stack() {
        initialize();
    }

    private void initialize() {
        this.head = null;
        this.size = 0;
    }

    private void StackIsEmptyException() throws Exception {
        if (this.size == 0) {
            throw new Exception("StackIsEmptyException");
        }
    }

    public int Size() {

        return this.size;
    }

    public boolean IsEmpty() {

        return this.size == 0;
    }

    private void addFirst(Node node) {

        if (this.head == null) {
            this.head = this.tail = node;
        } else {
            node.next = this.head;
            this.head = node;
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

        addFirst(new Node(value));
    }

    public int peek() throws Exception {
        StackIsEmptyException();

        return this.head.val;
    }

    public int pop() throws Exception {
        StackIsEmptyException();

        return removeFirst().val;
    }

}