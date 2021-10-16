
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

   



    public static void main(String[] args) {

        int t;
        t = scn.nextInt();
        while (t-- > 0) {
            solve();
        }

    }

}