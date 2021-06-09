import java.util.*;
public class practice
{
public static Scanner scn=new Scanner(System.in);


//     public static int[] digitSct(long n)
// {
//     int []freq=new int[10];
//     while(n>0)
//     {
//         long  rem=(long) n%10;
//         freq[(int)rem]++;
//         n=n/10;
//     }

//     return freq;
// }
// public static int frqQuery(int []freq,int d)
// {

//     return freq[d];
// }

public static int decimalToany(int n,int b)
{
    //decimal to any base
    int res=0;
    int power=1;
    while(n>0)
    {
        int rem=n%b;
        res=res+power*rem;
        power=power*10;
        n/=b;

    }
    return res;
}
    public static int anyTodecimal(int n,int b)
    {

        //any base to decimal//
           int res=0;
           int power=1;
           while(n>0)
           {
               int rem=n%10;
               res=res+rem*power;
               power=power*b;
               n/=10;
           }
           return res;
    }
    public static int anyBaseAdd(int n1,int n2,int b)
    {
        //any Base Addition//
        int res=0;
        int power=1;
        int carry=0;
        while(n1>0||n2>0||carry!=0)
        {
                  int d1=n1%10;
                  int d2=n2%10;
                  int sum=(d1+d2+carry);
                  carry=sum/b;
                  res=res+power*(sum%b); 
                  power*=10;
                  n1/=10;
                  n2/=10;
        }
        return res;
    }
    public static int anyBaseSub(int n,int m,int b)
{
    int power=1;
    int res=0;
    int borrow=0;
    while(n>0)
    {
        int d1=n%10;
        int d2=m%10;
        int subt=d1-d2-borrow;
        if(subt<0)
        {
            subt+=b;
            borrow=1;
        }
        else
        {
            borrow=0;
        }
        res+=power*subt;
        power*=10;
        n/=10;
        m/=10;
    }
    return res;
} 

public static int mul(int n1,int dig,int b)
{
int res=0;
int power=1;
int carry=0;
    while(n1>0||carry!=0)
    {
        int d=n1%10;
                int sum=(carry+dig*d);
                n1/=10;
                carry=sum/b;
                res+=power*(sum%b);
                power*=10;
    }
    return res;
}

public static int anyBaseMul(int n1,int n2,int b)
{
    int power=1;
    int res=0;
    while(n2>0)
    {
        int curr_res=mul(n1,n2%10,b);
        n2/=10;
        curr_res=curr_res*power;
        power*=10;
         res=anyBaseAdd(res,curr_res,b);
        
    }
    return res;
}

public static void subarray(int []arr)
{
    for(int i=0;i<arr.length;i++)
    {
        for(int j=i;j<arr.length;j++)
        {
            for(int k=i;k<=j;k++)
            {
                System.out.print(arr[k]+" ");
            }
            System.out.println();
        }
        
    }
}
    public static void main(String[] args) {
       int n = scn.nextInt();
       int []arr=new int[n];
       for(int i=0;i<n;i++)
       {
           arr[i]=scn.nextInt();
       }
       subarray(arr);

    }
}