import java.util.*;

public class pattern
{
public static Scanner scn= new Scanner(System.in);
     
     public static void pattern1()
     {
         int n=scn.nextInt();
int nst=n;
         for(int row=1;row<=n;row++)
         {
             for(int cst=1;cst<=nst;cst++)             
             {
System.out.print("*");
             }
             nst--;
             System.out.println();
         }
     }
     public static void pattern2()
     {
            int n=scn.nextInt();
            int nst=1;
            int nsp=n-1;
            for(int row=1;row<=n;row++)
            {
                for(int csp=1;csp<=nsp;csp++)
                {
                    System.out.print("\t");
                }
                for(int cst=1;cst<=nst;cst++)
                {
                    System.out.print("*\t");
                }
                nst++;
                nsp--;
                System.out.println();
            }
     }
     public static void pattern3()
{
     int n=scn.nextInt();
    int nst=1;
    int nsp=n/2;
    for(int row=1;row<=n;row++)
    {
        for(int csp=1;csp<=nsp;csp++)
        {
            System.out.print("\t");
        }
        for(int cst=1;cst<=nst;cst++)
        {
            System.out.print("*\t");
        }
        if(row<=n/2)
        {
            nst+=2;
            nsp--;
        }
        else
        {
            nst-=2;
            nsp++;
        }
        System.out.println();
    }
}
 public static void pattern4()
{
     int n=scn.nextInt();
    int nst=(n+1)/2;
    int nsp=1;
    for(int row=1;row<=n;row++)
    {
        
        for(int cst=1;cst<=nst;cst++)
        {
            System.out.print("*\t");
        }
        for(int csp=1;csp<=nsp;csp++)
        {
            System.out.print("\t");
        }
         for(int cst=1;cst<=nst;cst++)
        {
            System.out.print("*\t");
        }
        if(row<=n/2)
        {
            nsp+=2;
            nst--;
        }
        else
        {
            nsp-=2;
            nst++;
        }
        System.out.println();
    }
}

 public static void pattern5()
{
     int n=scn.nextInt();
    int nst=1;
    int nsp=n/2;
    int val=1;
    for(int row=1;row<=n;row++)
    {
        for(int csp=1;csp<=nsp;csp++)
        {
            System.out.print("\t");
        }
        val=row;
        if(row>n/2+1)
        {
            val=n-row+1;
        }
        for(int cst=1;cst<=nst;cst++)
        {
            System.out.print((char) ('a'+val-1)+"\t");
            if(cst<=nst/2)
            {
                val++;
            }
            else{
                val--;
            }
            
        }
        if(row<=n/2)
        {
            nst+=2;
            nsp--;
        }
        else
        {
            nst-=2;
            nsp++;
        }
        System.out.println();
    }
}

public static void pattern6()
{
    int n=scn.nextInt();
    for(int i=1;i<=n;i++)
    {
        for(int j=1;j<=i;j++)
        {
            if(i==j)
            {
                System.out.print("*\t");
            }
            else{
                System.out.print("\t");
            }
        }
        System.out.println();
    }
}

public static void pattern7()
{
    int n=scn.nextInt();
    for(int i=1;i<=n;i++)
    {
        for(int j=1;j<=n;j++)
        {
            if(i+j==n+1)
            {
                System.out.print("*\t");
            }
            else{
                System.out.print("\t");
            }
        }
        System.out.println();
    }
}

  public static void pattern8()
{
     int n=scn.nextInt();
    int nst=1;
    int nsp=n/2;
    for(int row=1;row<=n;row++)
    {
        for(int csp=1;csp<=nsp;csp++)
        {
            System.out.print("\t");
        }
        for(int cst=1;cst<=nst;cst++)
        {
            if(cst==1||cst==nst) 
               System.out.print("*\t");
            else
               System.out.print("\t");   
        }
        if(row<=n/2)
        {
            nst+=2;
            nsp--;
        }
        else
        {
            nst-=2;
            nsp++;
        }
        System.out.println();
    }
}
 
 public static void pascalTriangle()
 {
     int n=scn.nextInt();

     for(int i=0;i<n;i++)
     {
         int C=1;
         for(int j=0;j<=i;j++)
         {
             if(j==0||i==j)
             {
                 System.out.print(1+ "\t");
                 
             }
             else{
                      C=(C*(i-j+1))/j;
                      System.out.print(C+"\t");

             }
         }
         System.out.println();
     }
 }

public static void pattern9()
{
    int n=scn.nextInt();
    int nsp=2*n-3;
    int nst=1;

    for(int row=1;row<=n;row++)
    {
for(int cst1=1;cst1<=nst;cst1++)
{
    System.out.print(cst1+"\t");
}
for(int csp=1;csp<=nsp;csp++)
    {
        System.out.print("\t");
    }
    if(row==n)
    {
        nst--;
    }
   for(int cst2=nst;cst2>=1;cst2--)
   {
       System.out.print(cst2+"\t");
   } 
   nst++;
   nsp-=2;
   System.out.println();
    }
}

public static void pattern10()
{
    int n=scn.nextInt();
    int nst=1;
   int nsp=n/2;
    for(int row=1;row<=n;row++)
    {
        for(int csp=1;csp<=nsp;csp++)
        {
            if(row==n/2+1)
            {
                System.out.print("*\t");
            }
            else{
                  System.out.print("\t");
            }
        }

        for(int cst=1;cst<=nst;cst++)
        {
            System.out.print("*\t");
        }

        if(row<=n/2)
        {
            nst++;
        }
        else{
            nst--;
        }
        System.out.println();
    }
}

public static void pattern11()
{
    int n=scn.nextInt();
    int nst=n;
    int nsp=0;
    for(int row=1;row<=n;row++)
    {
        for(int csp=1;csp<=nsp;csp++)
        {
            System.out.print("\t");
        }
        for(int cst=1;cst<=nst;cst++)
        {

                 if(cst==1||cst==nst||row==1)
                 {
                     System.out.print("*\t");
                     continue;
                     
                 }
                if(row<=n/2)
                {
                    System.out.print("\t");
                }
                else{
                     System.out.print("*\t");
                
                } 
        }
        if(row<=n/2)
        {
            nst-=2;
            nsp++;
        }
        else{
            nst+=2;
            nsp--;
        }
        System.out.println();
    }
}

public static void pattern12()
{
    int n=scn.nextInt();
    for(int i=1;i<=n;i++)
      {
          for(int j=1;j<=n;j++)
          {
              if(((i==1&&j<(n/2+1))||(i==n&&(j>n/2+1))||j==n/2+1)||
              ((j==1&&i>(n/2+1))||(j==n&&(i<n/2+1))||i==n/2+1))
              {
                  System.out.print("*\t");
              }
              else{
                  System.out.print("\t");
              }
              
             

          }
           System.out.println();
      }
    
    }

    public static void pattern13()
    {

        int n=scn.nextInt();
        

        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if((j==1||j==n)||(i>n/2&&(i==j||i+j==n+1)))
                {
                    System.out.print("*\t");
                }
                else{
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }
    public static void main(String []args)
    {
pattern11();
pattern12();
pattern13();
    }
}