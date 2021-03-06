import java.util.*;

public class HashMapQuestions {

    // 128
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> map = new HashSet<>();
        for (int ele : nums)
            map.add(ele);

        int len = 0;
        for (int ele : nums) {
            if (!map.contains(ele))
                continue;

            int prev = ele - 1, next = ele + 1;
            map.remove(ele);
            while (map.contains(prev))
                map.remove(prev--);
            while (map.contains(next))
                map.remove(next++);

            len = Math.max(len, next - prev - 1);
        }

        return len;
    }

    // 781
    public int numRabbits(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = arr.length, ans = 0;

        for (int ele : arr) {
            if (!map.containsKey(ele)) {
                ans += 1 + ele;
                map.put(ele, 1);
            } else {
                map.put(ele, map.get(ele) + 1);
            }

            if (map.get(ele) == ele + 1)
                map.remove(ele);
        }

        return ans;

    }

    // 1218
    public int longestSubsequence(int[] arr, int d) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;
        for (int ele : arr) {
            map.put(ele, map.getOrDefault(ele - d, 0) + 1);
            maxLen = Math.max(maxLen, map.get(ele));
        }

        return maxLen;

    }

    // 1424
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        HashMap<Integer, LinkedList<Integer>> map = new HashMap<>();

        int maxDiag = 0;
        int len = 0;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                int idx = i + j;
                map.putIfAbsent(idx, new LinkedList<>());
                map.get(idx).addFirst(nums.get(i).get(j)); // map[idx].push_front(ele);

                maxDiag = Math.max(maxDiag, idx);
                len++;
            }
        }

        int[] ans = new int[len];
        int idx = 0;
        for (int i = 0; i <= maxDiag; i++) {
            LinkedList<Integer> list = map.get(i);
            while (list.size() != 0) {
                ans[idx++] = list.removeFirst();
            }
        }

        return ans;

    }

    // 1027
    public int longestArithSeqLength(int[] A) {
        int n = A.length;
        HashMap<Integer, Integer>[] dp = new HashMap[n];

        for (int i = 0; i < n; i++)
            dp[i] = new HashMap<>();

        int len = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                int diff = A[i] - A[j];
                int currLen = dp[i].getOrDefault(diff, 0);
                int newLen = dp[j].getOrDefault(diff, 1) + 1;

                dp[i].put(diff, Math.max(currLen, newLen));
                len = Math.max(len, dp[i].get(diff));
            }
        }

        return len;
    }

    // 954
    public boolean canReorderDoubled(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int N = arr.length;
        Integer[] ARR = new Integer[N];
        for (int i = 0; i < N; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            ARR[i] = arr[i];
        }

        Arrays.sort(ARR, (a, b) -> {
            return Math.abs(a) - Math.abs(b);
        });

        for (Integer ele : ARR) {
            if (map.get(ele) == 0)
                continue;
            if (map.getOrDefault(2 * ele, 0) <= 0)
                return false;

            map.put(ele, map.get(ele) - 1);
            map.put(2 * ele, map.get(2 * ele) - 1);
        }

        return true;
    }

    // 295
    class MedianFinder {

        private PriorityQueue<Integer> maxpq = new PriorityQueue<>((a, b) -> {
            return b - a;
        });
        private PriorityQueue<Integer> minpq = new PriorityQueue<>();

        public MedianFinder() {

        }

        public void addNum(int num) {
            if (maxpq.size() == 0 || num <= maxpq.peek())
                maxpq.add(num);
            else
                minpq.add(num);

            if (maxpq.size() - minpq.size() == 2)
                minpq.add(maxpq.remove());
            if (maxpq.size() - minpq.size() == -1)
                maxpq.add(minpq.remove());
        }

        public double findMedian() {
            if (maxpq.size() == minpq.size())
                return (maxpq.peek() + minpq.peek()) / 2.0;
            else
                return maxpq.peek() * 1.0;
        }
    }

    // 127
    class pair {

        String str = null;
        int height = 0;

        pair(String str, int height) {
            this.str = str;
            this.height = height;
        }
    }

    public int ladderLength_01(String beginWord, String endWord, List<String> wordList) {

        HashSet<String> map = new HashSet<>();

        LinkedList<pair> queue = new LinkedList<>();
        queue.addLast(new pair(beginWord, 1));
        map.add(beginWord);
        while (queue.size() != 0) {

            pair p = queue.removeFirst();

            if (p.str.equals(endWord))
                return p.height;

            for (String str : wordList) {

                int count = 0;
                for (int i = 0; i < str.length(); i++) {
                    if (str.charAt(i) != p.str.charAt(i))
                        count++;
                }
                if (count == 1 && map.contains(str) == false) {
                    map.add(str);
                    queue.addLast(new pair(str, p.height + 1));
                }

            }
        }

        return 0;

    }

    public int ladderLength_02(String beginWord, String endWord, List<String> wordList) {

        HashSet<String> vis = new HashSet<>();
        HashSet<String> map = new HashSet<>();
        for (String str : wordList)
            map.add(str);
        LinkedList<pair> queue = new LinkedList<>();
        queue.addLast(new pair(beginWord, 1));
        vis.add(beginWord);
        while (queue.size() != 0) {

            pair p = queue.removeFirst();

            if (p.str.equals(endWord))
                return p.height;

            for (int i = 0; i < 26; i++) {

                char ch = (char) (i + 'a');

                for (int j = 0; j < p.str.length(); j++) {

                    StringBuilder sb = new StringBuilder(p.str);
                    char temp = sb.charAt(j);
                    sb.setCharAt(j, ch);
                    if (map.contains(sb.toString()) && vis.contains(sb.toString()) == false) {
                        vis.add(sb.toString());
                        queue.addLast(new pair(sb.toString(), p.height + 1));
                    }

                    sb.setCharAt(j, temp);
                }
            }

        }

        return 0;

    }

    public String kthLargestNumber(String[] nums, int k) {

        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
            if (a.length() != b.length())
                return a.length() - b.length();

            for (int i = 0; i < a.length(); i++) {
                if (b.charAt(i) < a.charAt(i))
                    return 1;
                else if (a.charAt(i) < b.charAt(i))
                    return -1;
            }

            return 0;

        });

        for (int i = 0; i < nums.length; i++) {

            pq.add(nums[i]);

            if (pq.size() > k)
                pq.remove();

        }

        while (pq.size() != 0)
            System.out.print(pq.remove() + " ");
        return "";

    }

    class RandomizedSet {

        HashMap<Integer, Integer> map;
        ArrayList<Integer> list;

        public RandomizedSet() {
            this.map = new HashMap<>();
        }

        public boolean insert(int val) {
            if (map.containsKey(val))
                return false;

                list.add(val);
                map.putIfAbsent(val, list.size());

            return true;

        }

        public boolean remove(int val) {

            if (map.containsKey(val) == false)
                return false;

            int idx=map.get(val);
            int lidx=list.size()-1;
            list.set(idx, list.get(lidx));
            list.remove(list.size()-1);
            map.put(list.get(idx),idx);
            map.remove(val);

            return true;

        }

        public int getRandom() {
            Random rand = new Random();

            int idx = rand.nextInt(list.size());

            return list.get(idx);

        }

        // 447
    public int numberOfBoomerangs(int[][] points) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0, n = points.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;
                int dis = distance(points, i, j);
                map.put(dis, map.getOrDefault(dis, 0) + 1);
            }

            for (int ele : map.values()) {
                ans += ele * (ele - 1);
            }

            map.clear();
        }

        return ans;
    }

    public int distance(int[][] points, int i, int j) {
        int x = (points[j][0] - points[i][0]);
        int y = (points[j][1] - points[i][1]);

        return x * x + y * y;
    }

    // 149
    public int maxPoints(int[][] points) {
        HashMap<String, Integer> map = new HashMap<>();
        int ans = 0, n = points.length;
        for (int i = 0; i < n; i++) {
            int overlap = 0, max = 0;
            for (int j = i + 1; j < n; j++) {
                int xdiff = points[j][0] - points[i][0];
                int ydiff = points[j][1] - points[i][1];

                int gcd = gcd(xdiff, ydiff);

                xdiff /= gcd;
                ydiff /= gcd;

                String s = xdiff + "@" + ydiff;
                map.put(s, map.getOrDefault(s, 0) + 1);
                max = Math.max(map.get(s), max);
            }

            ans = Math.max(max + 1, ans);
            map.clear();
        }

        return ans;
    }

    public int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
    }
}
