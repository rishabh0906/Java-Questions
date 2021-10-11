
import java.util.*;

public class practice {

    public static Scanner scn = new Scanner(System.in);

    public static void solve() {

        int n, h;
        n = scn.nextInt();
        h = scn.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();

        }

        Arrays.sort(arr);
        int max = arr[n - 1];
        int sec_max = arr[n - 2];

        long count = 2 * (h / (max + sec_max)) + (h % (max + sec_max) != 0 ? (h % (max + sec_max) <= max ? 1 : 2) : 0);

        System.out.println(count);
    }

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

    public static void main(String[] args) {

        int t;
        t = scn.nextInt();
        while (t-- > 0) {
            solve();
        }

    }

}