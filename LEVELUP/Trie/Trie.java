public class Trie {

    public class Node {

        Node[] children;
        boolean isEnd = false;

        Node() {
            children = new Node[26];
        }

    }

    Node root1 = new Node();

    public void insert(String word) {

        Node curr = root1;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (curr.children[ch - 'a'] == null) {
                curr.children[ch - 'a'] = new Node();
            }
        }

        curr.isEnd = true;
    }

    public boolean find(String word) {
        Node curr = root1;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (curr.children[ch - 'a'] == null) {
                return false;
            }
            curr = curr.children[ch - 'a'];
        }

        return curr.isEnd == true;
    }

    public boolean startsWith(String prefix) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (curr.children[ch - 'a'] == null) {
                return false;
            }
            curr = curr.children[ch - 'a'];
        }

        return true;
    }

    // Wildcard character 211
    class WordDictionary {

        class Trie {

            Trie[] children;
            boolean isEnd;

            Trie() {

                this.children = new Trie[26];
            }
        }

        Trie root;

        public WordDictionary() {
            root = new Trie();
        }

        public void addWord(String word) {
            Trie curr = root;

            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (curr.children[ch - 'a'] == null)
                    curr.children[ch - 'a'] = new Trie();

                curr = curr.children[ch - 'a'];
            }

            curr.isEnd = true;
        }

        public boolean search(String word, Trie root, int idx) {

            if (idx == word.length())
                return root.isEnd == true;
            char ch = word.charAt(idx);

            if (ch != '.' && root.children[ch - 'a'] != null)
                return search(word, root.children[ch - 'a'], idx + 1);
            else if (ch == '.') {

                boolean res = false;
                for (int i = 0; i < 26; i++) {

                    if (root.children[i] != null) {
                        res = res || search(word, root.children[i], idx + 1);
                    }
                }

                return res;
            }

            return false;

        }

        public boolean search(String word) {

            return search(word, root, 0);
        }
    }
/// find max Xor
    class Trie {

        Trie[] bits;

        Trie() {

            this.bits = new Trie[2];
        }
    }

    Trie root;

    public void add(int value) {
        Trie curr = root;
        for (int i = 30; i >= 0; i--) {

            int mask = (value & (1 << i)) != 0 ? 1 : 0;

            if (curr.bits[mask] == null) {
                curr.bits[mask] = new Trie();
            }

            curr = curr.bits[mask];
        }
    }

    public int search(int value) {
        Trie curr = root;
        int res = 0;
        for (int i = 30; i >= 0; i--) {

            int mask = (value & (1 << i)) != 0 ? 1 : 0;
            if (curr.bits[(mask + 1) % 2] != null) {
                res |= (1 << i);
                curr = curr.bits[(mask + 1) % 2];
            } else {
                curr = curr.bits[mask];
            }
        }

        return res;
    }

    public int findMaximumXOR(int[] nums) {
        root = new Trie();

        for (int val : nums) {
            add(val);
        }
        int max = 0;

        for (int val : nums) {
            max = Math.max(max, search(val));
        }

        return max;

    }

}
