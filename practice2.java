import java.util.*;

public class practice2
{
    public static Scanner scn=new Scanner(System.in);



// public static int power(int x,int n)
// {
//     int res=1;
//     while(n!=0)
//     {
//         res*=x;
//         n--;
//     }
//     return res;
// }

// public static void subset(int []arr)
// {
//   for(int i=0;i<power(2,arr.length);i++)
//   {
//       for(int j=arr.length-1;j>=0;j--)
//       {
//           if((i&(1<<j))!=0)
//           {
//               System.out.print(arr[arr.length-j-1]+"\t");
//           }
//           else{
//               System.out.print("_\t");
//           }
//       }
//       System.out.println();
//   }


//  }

// public static int first(int []arr,int val)
// {
// int n=arr.length;
// int i=0,j=n-1;
// int first=-1;

// while(i<=j)
// {
//     int mid=(i+j)/2;
//     if(arr[mid]==val)
//     {
//         if(mid-1>=0&&arr[mid-1]==arr[mid])
//         {
//             j=mid-1;
//         }
//         else{
//             return mid;
//         }
//     }
//     else if(arr[mid]>val)
//     {
//         j=mid-1;
//     }
//     else
//     {
//         i=mid+1;
//     }
   
// }
//  return -1;
// }
// public static int last(int []arr,int val)
// {
// int n=arr.length;
// int i=0,j=n-1;
// int first=-1;

// while(i<=j)
// {
//     int mid=(i+j)/2;
//     if(arr[mid]==val)
//     {
//         if(mid+1<n&&arr[mid+1]==arr[mid])
//         {
//             i=mid+1;
//         }
//         else{
//             return mid;
//         }
//     }
//     else if(arr[mid]>val)
//     {
//         j=mid-1;
//     }
//     else
//     {
//         i=mid+1;
//     }
   
// }
//  return -1;
// }
// public static void firstandlast(int []arr,int val)
// {
//     int fi=first(arr,val);
//     int ls=last(arr,val);
//     System.out.println(fi+" "+ls);
// }

// public static int floor(int []arr,int val)
// {
// int n=arr.length;
// int i=0,j=n-1;
// int fl=-1;

// while(i<=j)
// {
//     int mid=(i+j)/2;
//     if(arr[mid]<=val)
//     {
//         fl=arr[mid];
//         i=mid+1;
//     }
//     else{
//         j=mid-1;
//     }
   
// }
//  return fl;
// }
// public static int ceil(int []arr,int val)
// {
// int n=arr.length;
// int i=0,j=n-1;
// int data=-1;

// while(i<=j)
// {
//     int mid=(i+j)/2;
//     if(arr[mid]>=val)
//     {
//         j=mid-1;
//         data=arr[mid];
//     }
//     else{
//         i=mid+1;
//     }
   
// }
//  return data;
// }
// public static void floorandceil(int []arr,int val)
// {
//     int fl=floor(arr,val);
//     int ce=ceil(arr,val);
//     System.out.println(fl+" "+ce);
// }



    public static void main(String []args) 
    {
      int n=scn.nextInt();
      int []arr=new int[n];
      for(int i=0;i<n;i++)
      {
          arr[i]=scn.nextInt();

      }
      int val=scn.nextInt();
      floorandceil(arr,val);
    }
}