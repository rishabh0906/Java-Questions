
import java.util.*;

public class practice {
    public static Scanner scn = new Scanner(System.in);

    public static void armstrongNo() {
        for (int i = 100; i < 1000; i++) {

            int num = i;
            int sum = 0;
            while (num > 0) {
                sum += (num % 10) * (num % 10) * (num % 10);
                num /= 10;
            }

            if (sum == i) {
                System.out.println(i);
            }
        }
    }

    public static void fibonacci(int n) {

        int a = 0, b = 1;

        System.out.print(a + " " + b + " ");

        for (int i = 3; i <= n; i++) {

            int c = a + b;
            a = b;
            b = c;
            System.out.print(c + " ");
        }

    }

    public static int reverse(int num) {

        int temp = num;
        int rev = 0;
        while (temp > 0) {
            rev = rev * 10 + temp % 10;
            temp /= 10;
        }
        return rev;
    }

    public static int factorial(int n) {
        if (n <= 1)
            return n;

        return n * factorial(n - 1);
    }

    public static void main(String[] args) {

        armstrongNo();
       System.out.println( factorial(23));
        reverse(343233);
        fibonacci(45);


    }

}
