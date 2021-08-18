import java.util.*;

public class hashmap {

    private class Node {

        Integer key = null;
        Integer value = null;

        Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }

    LinkedList<Node>[] buckets;
    int TotalEle = 0;
    int bucketLen = 0;

    private void initialize(Integer size) {
        buckets = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            buckets[i] = new LinkedList<>();
        }
        this.bucketLen = size;
        this.TotalEle = 0;
    }

    public hashmap() {
        initialize(10);
    }

    public hashmap(int size) {
        initialize(size);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        int tempSize = this.TotalEle;
        for (int i = 0; i < this.bucketLen; i++) {
            LinkedList<Node> group = this.buckets[i];
            int size = group.size();
            while (size-- > 0) {

                Node node = group.removeFirst();
                sb.append(node.key + "=" + node.value);
                group.addLast(node);

                if (--tempSize != 0)
                    sb.append(",");
            }
        }
        sb.append("}");
        return sb.toString();
    }

    public ArrayList<Integer> keySet() {
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < this.bucketLen; i++) {
            LinkedList<Node> group = this.buckets[i];
            int size = group.size();
            while (size-- > 0) {
                Node node = group.removeFirst();
                ans.add(node.key);
                group.addLast(node);
            }
        }

        return ans;
    }

    private void rehash() {
        LinkedList<Node>[] temp = this.buckets;
        initialize((int) (this.bucketLen * 2)); // 1 <= factor <= 2

        for (int i = 0; i < temp.length; i++) {
            LinkedList<Node> group = temp[i];
            int size = group.size();
            while (size-- > 0) {
                Node node = group.removeFirst();
                put(node.key, node.value);
            }
        }
    }

    public Integer getOrDefault(Integer key, Integer defVal) {
        Integer val = get(key);
        return val != null ? val : defVal;
    }

    public void putIfAbsent(Integer key, Integer defaultVal) {
        boolean res = ContainsKey(key);
        LinkedList<Node> group = getGroup(key);
        if (!res) {
            group.addLast(new Node(key, defaultVal));
            this.TotalEle++;
        }
    }

    public void put(Integer key, Integer value) {
        boolean res = ContainsKey(key);
        LinkedList<Node> group = getGroup(key);
        if (res) {
            group.getFirst().value = value;
        } else {
            group.addLast(new Node(key, value));
            this.TotalEle++;
            double lambda = group.size() / (1.0 * this.bucketLen);

            if (lambda > 0.4)
                rehash();
        }

    }

    public Integer remove(Integer key) {

        boolean res = ContainsKey(key);
        LinkedList<Node> group = getGroup(key);
        if (res) {
            this.TotalEle--;
        }
        return res == true ? group.removeFirst().value : null;

    }

    public Integer get(Integer key) {
        boolean res = ContainsKey(key);
        LinkedList<Node> group = getGroup(key);

        return res == true ? group.getFirst().value : null;

    }

    public boolean ContainsKey(Integer key) {
        LinkedList<Node> group = getGroup(key);

        int gs = group.size();
        boolean res = false;
        while (gs-- > 0) {
            if (group.getFirst().key.equals(key)) {
                res = true;
                break;
            }
            group.addLast(group.removeFirst());

        }
        return res;
    }

    private LinkedList<Node> getGroup(Integer key) {
        int hc = getHashCode(key);

        return buckets[hc];
    }

    private int getHashCode(Integer key) {
        return Math.abs(key.hashCode()) % bucketLen;
    }

}