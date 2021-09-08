import java.util.HashSet;

public class Leetcode {

    public boolean canConvertString(String s, String t, int k) {

        if (s.length() != t.length())
            return false;

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {

            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            if (ch1 < ch2) {

                int diff1 = ch2 - ch1;
                int diff2 = ch2 - ch1 + 26;
                if (diff1 > k || set.contains(diff1) || diff2 > k || set.contains(diff2)) {
                    return false;
                } else if (diff1 <= k && !set.contains(diff1)) {
                    set.add(diff1);
                } else if (diff2 <= k && !set.contains(diff2)) {
                    set.add(diff2);
                }
            } else if (ch2 < ch1) {

                int diff2 = ch1 - ch2 + 26;

                if (diff2 > k || set.contains(diff2))
                    return false;

                set.add(diff2);
            }
        }

        return false;

    }

}
