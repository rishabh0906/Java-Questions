import java.util.*;

public class Trie {
    class Node {

        Node[] children;
        boolean isEnd = false;

        Node() {

            this.children = new Node[26];
        }
    }

    Node root;

    public void insert(String word) {

        Node head = root;

        int i = 0;
        while (i < word.length()) {

            char ch = word.charAt(i);
            if (head.children[ch - 'a'] == null)
                head.children[ch - 'a'] = new Node();

            head = head.children[ch - 'a'];
            i++;
        }

        head.isEnd = true;
    }

    // *********************************************************************************
    // */
    class pair {
        int length = 0;
        String str;
    }

    public pair dfs(Node root) {

        Node[] children = root.children;
        pair myPair = new pair();
        for (int i = 0; i < 26; i++) {
            if (children[i] != null && children[i].isEnd == true) {
                pair recAns = dfs(children[i]);
                if (recAns.length + 1 > myPair.length) {
                    myPair.length = recAns.length + 1;
                    myPair.str = (char) (i + 'a') + recAns.str;
                }
            }
        }

        return myPair;

    }

    public String longestWord(String[] words) {
        this.root = new Node();
        for (String word : words) {
            insert(word);
        }

        String ans = dfs(this.root).str;
        return ans;
    }

    // *************************************************************************************
    // */

    public void dfs(Node root, List<String> asf, String prefix) {

        if (root.isEnd&&asf.size()<3) {
            asf.add(prefix);
        }

        for (int i = 0; i < 26; i++) {

            if (root.children[i] != null) {
                dfs(root, asf, prefix + (char) (i + 'a'));
            }
        }

    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {

        List<List<String>> ans = new ArrayList<>();

        root = new Node();

        for (String str : products) {
            insert(str);
        }

        String prefix = "";
        for (int i = 0; i < searchWord.length(); i++) {
            char ch = searchWord.charAt(i);
            prefix = prefix + ch;
            List<String> asf = new ArrayList<>();
            if (root.children[ch - 'a'] != null) {
                root = root.children[ch - 'a'];
                dfs(root, asf, prefix);
            }

            ans.add(asf);

        }

        return ans;

    }
    
}
