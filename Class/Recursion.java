import java.util.ArrayList;

public class Recursion {

    public static ArrayList<String> subsequences(String str, int idx) {
        
        if(idx==str.length()){
            ArrayList<String> base=new ArrayList<>();
            base.add("");

            return base;
        }

        ArrayList<String> rec_ans = subsequences(str, idx + 1);
        int size = rec_ans.size();

        for (int i = 0; i < size; i++) {
            String s = rec_ans.get(i);
            String new_str = str.charAt(idx) + s;
            rec_ans.add(new_str);
        }

        return rec_ans;

    }

    public static void main(String[] args) {
        
        System.out.println(subsequences("abcd", 0));
    }
}
