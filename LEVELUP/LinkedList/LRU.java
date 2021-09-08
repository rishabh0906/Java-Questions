import java.util.HashMap;

public class LRU {

    public class Node {

        int key, value;
        Node prev, next;

        Node(int key, int value) {

            this.key = key;
            this.value = value;
        }
    }

    HashMap<Integer, Node> map = new HashMap<>();

    private Node head = null;
    private Node tail = null;
    private int maxCap;
    private int size = 0;

    public LRU(int capacity) {

        this.maxCap = capacity;
    }

    private void addLast(Node node) {
        if (this.size == 0) {
            this.head = this.tail = node;
        } else {
            this.tail.next = node;
            node.prev = this.tail;
            this.tail = node;
        }

        this.size++;
    }

    private void makeRecent(Node node) {

        remove(node);
        addLast(node);

    }

    private void remove(Node node) {

        Node prev = node.prev;
        Node forw = node.next;
        if (prev != null && forw != null) {
            prev.next = forw;
            forw.prev = prev;
            node.next = null;
            node.prev = null;
        } else if (prev == null && forw != null) {

            this.head = forw;
            node.next = null;
            forw.prev = null;
        } else if (prev != null && forw == null) {
            this.tail = prev;
            prev.next = null;
            node.prev = null;

        } else
            this.head = this.tail = null;

        this.size--;

    }

    public int get(int appname) {

        if (!map.containsKey(appname))
            return -1;

        Node node = map.get(appname);
        makeRecent(node);
        return node.value;

    }

    public void put(int appname, int state) {

        if (map.containsKey(appname)) {
            Node node = map.get(appname);
            node.value = state;
            makeRecent(node);
        } else {
            Node node = new Node(appname, state);
            if (this.size == this.maxCap) {
                map.remove(this.head.key);
                remove(this.head);
            }
            map.put(appname, node);
            addLast(node);

        }

    }

}