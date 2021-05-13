import java.util.*;

public class arrList
{
public static Scanner scn=new Scanner(System.in);

public static void swap(ArrayList<Integer> arr,int i,int j)
{
    int temp=arr.get(i);
    arr.set(i,arr.get(j));
    arr.set(j,temp);
}
 
 public static boolean isPrime(int n)
 {
     if(n==1)
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

public static void removeprime(ArrayList<Integer> arr)
{
    int i=arr.size()-1;
    while(i>=0)
    {
         if(isPrime(arr.get(i))==true)
         {
             arr.remove(arr.get(i));                                          //whenever remove data from array
         }                                                                    //always try from backside
         i--;
    }
    System.out.println(arr);

}

    public static void main(String []args)
    {
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i=0;i<15;i++)
        {
           
           int a=scn.nextInt();
            arr.add(a);
        }
        removeprime(arr);
    }
}