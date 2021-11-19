import java.util.HashMap;

class SlidingWindow {

    public int lengthOfLongestSubstring(String s) {

        int start = 0, end = 0;
        int count = 0;
        int[] hash = new int[256];

        int max = 0;
        while (end < s.length()) {

            hash[s.charAt(end)]++;
            if (hash[s.charAt(end)] == 2) {
                count++;
            }

            while (count > 0) {

                if (hash[s.charAt(start)] == 2) {

                    count--;
                }
                hash[s.charAt(start)]--;
                start++;
            }

            max = Math.max(max, end - start + 1);
            end++;
        }

        return max;

    }

    public int lengthOfLongestSubstringTwoDistinct(String s) {

        int start = 0, end = 0;
        int n = s.length();
        int[] hash = new int[26];
        int distinct = 0;
        int max = 0;
        while (end < n) {

            if (hash[s.charAt(end) - 'a'] == 0) {
                distinct++;
            }
            hash[s.charAt(end) - 'a']++;

            while (distinct > 2) {

                if (hash[s.charAt(start) - 'a'] == 1) {
                    distinct--;
                }
                hash[s.charAt(start)]--;
                start++;

            }
            max = Math.max(max, end - start + 1);

            end++;

        }

        return max;

    }

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int start = 0, end = 0;
        int n = s.length();
        int[] hash = new int[128];
        int distinct = 0;
        int max = 0;
        while (end < n) {

            if (hash[s.charAt(end)] == 0) {
                distinct++;
            }
            hash[s.charAt(end)]++;

            while (distinct > k) {

                if (hash[s.charAt(start)] == 1) {
                    distinct--;
                }
                hash[s.charAt(start)]--;
                start++;

            }
            max = Math.max(max, end - start + 1);

            end++;

        }

        return max;

    }

    // leetcode 76
    public String minWindow(String s, String t) {

        int n = t.length();
        int m = s.length();
        int[] hash = new int[128];

        for (int i = 0; i < n; i++) {
            hash[t.charAt(i)]++;
        }

        int end = 0;
        int start = 0;
        int need = n;
        int min = (int) 1e9;
        int Sidx = 0;
        int Eidx = 0;
        while (end < m) {

            hash[s.charAt(end)]--;
            if (hash[s.charAt(end)] >= 0) {
                need--;
            }

            while (need == 0) {
                if (end - start + 1 < min) {
                    min = end - start + 1;
                    Sidx = start;
                    Eidx = end;
                }

                hash[s.charAt(start)]++;
                if (hash[s.charAt(start)] > 0)
                    need++;

                start++;
            }
            end++;
        }

        return min == (int) 1e9 ? "" : s.substring(Sidx, Eidx + 1);

    }

    public int subarrayWithAtmostKDistinct(int[] nums, int k) {

        int start = 0;
        int end = 0;
        int count = 0;
        int distinct = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (end < nums.length) {

            if (!map.containsKey(nums[end])) {
                distinct++;
            }
            map.put(nums[end], map.getOrDefault(nums[end], 0) + 1);
            while (distinct > k) {

                if (map.get(nums[start]) == 1) {
                    distinct--;
                }
                map.put(nums[start], map.get(nums[start]) - 1);
                start++;
            }

            if (distinct <= k) {
                count += end - start + 1;
            }
            end++;

        }
        return count;
    }
   // exactly k = atmost k - atmost (k-1)            important
    public int subarraysWithKDistinct(int[] nums, int k) {

        return subarrayWithAtmostKDistinct(nums, k) - subarrayWithAtmostKDistinct(nums, k - 1);
    }
}
