import java.util.*;

public class project2
{
    public static Scanner scn=new Scanner(System.in);
    
    public static int power(int n)
    {
    int res=1;
    while(n!=0)
    {
        res*=10;
        n/=10;
    }
    return res;
    }

    public static void printdig()
    {
        int n=scn.nextInt();
    int pow=power(n);
        while(pow!=0)         // while(n!=0)  is wrong because it fails on test case where input is 10^x //
        {
            int ans=n/pow;
            n%=pow;
            pow/=10;
            System.out.println(ans);
            
        }
    }
public static int countdig(int n)
{
    int res=0;
    while(n!=0)
    {
        res++;
        n/=10;
        
    }
    return res;
}


    public static int rotate()
    {
        int n=scn.nextInt();
        int k=scn.nextInt();
        int count=countdig(n);
        k%=count;
        if(k<0)
        {
            k+=count;
        }
        
        int mul=1;
        int div=1;
        for(int i=1;i<=count;i++)
        {
            if(i<=k)
            {
                div*=10;
            }
            else
            {
                mul*=10;
            }

        }
               
int a=n%div;
int b=n/div;
        
        return(a*mul+b);


    }
    public static boolean pythagoreanTriplet(int a,int b,int c)
  {
      if(a>b)
      {
          if(a>c)
          {
              if(a*a==(b*b+c*c))
              {
                  return true;
              }
          }
          else
          {
              if(c*c==(b*b+a*a))
              {
                  return true;
              }
          }
      }
      else
      {
          if(b>c)
          {
              if(b*b==(a*a+c*c))
              {
                  return true;
              }
              else
              {
                  if(c*c==(a*a+b*b))
                  {
                      return true;
                  }
              }
          }
      }
      return false;
  }

public static void perfectSq(int n)               // bulb fluctuation problem
  {
        for(int i=1;i*i<=n;i++)
    {
        System.out.println(i*i);
    }
    
  }
    public static void main(String []args)
    {
         int ans=rotate ();
         System.out.println(ans);
    } 
} 