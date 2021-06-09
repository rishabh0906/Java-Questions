//    Code created by rishabh jain //

import java.util.*;
public class project1
{
      public static Scanner scn = new Scanner(System.in);

    public static void printZ() {
        System.out.println("*****");
        System.out.println("   *");                             //printZ
        System.out.println("  *");
        System.out.println(" *");
        System.out.println("*****");
    }

    public static void test() {                                   
        int n = 1256;                                       //print no.
        System.out.println(n);
    }

    public static void input_test() {
        int n = scn.nextInt();
        System.out.println("please, input a number: ");
        System.out.println(n);
    }

    public static void gradingSystem() {
        int marks = scn.nextInt();

        if (marks > 90) {
            System.out.println("excellent");                    //grading system
        } else if (marks > 80) {
            System.out.println("good");
        } else if (marks > 70) {
            System.out.println("fair");
        } else if (marks > 60) {
            System.out.println("meets expectations");
        } else {
            System.out.println("below par");
        }
    }

    public static void printOddEven(int num) {
        if (num % 2 == 0)
            System.out.println("even");
        else                                                                    //even odd
            System.out.println("odd");
    }

    public static void printMultiplesOddEven() {
        int count = scn.nextInt();
        for (int i = 1; i <= count; i++) {
            int num = scn.nextInt();
            printOddEven(num);
        }
    }

    public static void printTable(int num) {
        int multiply = 0;
        for (int i = 1; i <= 10; i++) {
            multiply = num * i;                                                             //tablePrint
            System.out.println(Integer.toString(num)+" X " + i + " = " + multiply);
        }
    }
    
    public static void printMulTable()
    {
        int n=scn.nextInt();
        for(int i=1;i<=n;i++)
        {
            printTable(i);  
        System.out.println();
        }
    }
    public static boolean isPrime(int n)
    {
         if(n==0||n==1)
         {
             return false;
         }
         for(int i=2;i*i<=n;i++)
         {
             if(n%i==0)
             {
                 return false;
             }
         }
         return true;
    }
    public static void rangePrime()
    {
        int a=scn.nextInt();
        int b=scn.nextInt();
        for(int i=a;i<=b;i++)
        {
            if(isPrime(i))
            {
                System.out.println(i);
            }
        }
    }

    public static void fib()
    {
        int n=scn.nextInt();

           int a=0;
           int b=1; 
           System.out.println(a);
           System.out.println(b);
        for(int i=2;i<n;i++)
        {
           int c=a+b;
           System.out.println(c);
           a=b;
           b=c;

        }
    }

    public static void count()
    {
        int n=scn.nextInt();

int len=0;
        while(n!=0)
        {
            n=n/10;
             len++;
        }
        System.out.println(len);
    }

    

    public static void main(String []args)
    {
       count();
    }
}