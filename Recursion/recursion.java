import java.util.*;

//Recursion
// 1. Try to find subproblems(faith) ,Don't think about long terms ,think in baby steps and then go  for bigger problem
//2. code some 
// 3. make recursion tree (find pattern)
// finalise the code 

public class recursion
{

    public static Scanner scn=new Scanner(System.in);

public static void printInc(int a,int b)
{
if(a>b)
{
    return ;
}
System.out.print(a+" ");
printInc(a+1,b);

}
public static void printdec(int a,int b)
{
if(a>b)
{
    return ;
}

printdec(a+1,b);
System.out.print(a+" ");

}
public static void printIncdec(int a,int b)
{
if(a>b)
{
    return ;
}
System.out.print(b+" ");
printIncdec(a,b-1);
System.out.print(b+" ");

}

 // n = 5
    public static int recursionTree(int n) {
        if (n <= 1) {
            System.out.println("Base: " + n);
            return n + 1;
        }

        int count = 0;

        System.out.println("Pre: " + n);
        count += recursionTree(n - 1);

        System.out.println("In: " + n);
        count += recursionTree(n - 2);

        System.out.println("Post: " + n);

        return n + 3;
    }

    // n = 6
    public static int recursionTree2(int n) {
        if (n <= 1) {
            System.out.println("Base: " + n);
            return n + 1;
        }

        int count = 0;

        System.out.println("Pre: " + n);
        count += recursionTree2(n - 1);

        System.out.println("In1: " + n);
        count += recursionTree2(n - 2);

        System.out.println("In2: " + n);
        count += recursionTree2(n - 3);

        System.out.println("Post: " + n);
        return n + 3;
    }

    public static int fibo(int n) {
        if (n <= 1)
            return n;
        int count = 0;
        count += fibo(n - 1);
        count += fibo(n - 2);

        return count;
    }
    public static void main(String []args)
    {
       
        System.out.println(fibo(10));
    }
}