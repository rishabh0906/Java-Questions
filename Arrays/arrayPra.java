// import java.util.*;

// public class arrayPra {
//     public static Scanner scn = new Scanner(System.in);

//     public static void test1(int n) {
//         // type[] nameOfArray = new type[size]; with default value 0.
//         int[] arr = new int[n];
//         for (int i = 0; i < n; i++) {
//             System.out.println(arr[i]);
//         }
//     }

//     public static void display1(int[] arr) {
//         int n = arr.length;
//         for (int i = 0; i < n; i++) {
//             System.out.print(arr[i] + " "); // get
//         }
//     }

//     public static void display2(int[] arr) {

//         // forEach loop used for :
//         // 1. only for get, if you try to set value ypu get a beutifull error.
//         // 2. automatically increment by 1
//         // 3. always in forward direction
//         // 4. range of loop : [0 , n - 1]

//         for (int ele : arr) {
//             System.out.print(ele + " ");
//         }
//     }

//     public static void input1(int[] arr) {
//         int n = arr.length;
//         for (int i = 0; i < n; i++) {
//             arr[i] = scn.nextInt(); // set
//         }
//     }

//     public static int[] input2(int n) {
//         int[] arr = new int[n];
//         for (int i = 0; i < n; i++) {
//             arr[i] = scn.nextInt(); // set
//         }

//         return arr;
//     }

//     public static int maximum(int[] arr){

//         int res=(int) (-1e9);
//         for(int ele : arr)
//         {
//             if(res<ele)
//             {
//                 res=ele;
//             }


//         }
//            return res;
//     }

//     public static int minimum(int[] arr){
// int res=(int ) 1e9;
// for(int ele :arr)
// {
//     if(ele<res)
//     {
//         res=ele;
//     }
// }
// return res;
//     }

//     // if you found return index, otherwise return -1.
//     public static int find(int[] arr,int data){
//         for(int i=0;i<arr.length;i++)
//         {
//             if(arr[i]==data)
//             {
//                 return i;
//             }
//         }
//         return -1;

//     }
//     public static void reverse(int []arr,int i,int j)
//     {
//         int low=0,high=arr.length-1;
//         while(low<high)
//         {
//             int temp=arr[low];
//             arr[low]=arr[high];
//             arr[high]=temp;
//             low++;
//             high--;
//         }
//     }
// public static int[] inverse(int []arr)
// {
//     int []temp=new int[arr.length];

//     for(int i=0;i<arr.length;i++)
//     {
//         temp[arr[i]]=i;
//     }

//     return temp;
// }

// public static int[] rotate(int []arr,int k)
// {
//     int n=arr.length;                             
//     k=k%n;                                       
//     if(k<0)
//     {
//         k+=n;                                     
//     }                                                  

//     int []temp=new int[n];
//     for(int i=0;i<n;i++)
//     {
//         temp[(i+k)%n]=arr[i];
//     }
//     return temp;
// }
// public static void rotate2(int []arr,int k)
// {
//     int n=arr.length;
//     k%=n;
//     if(k<0)
//     {
//         k+=n;
//     }
// // rotation of array optimize//
//  //  let A is first part (0,r-1)
//  // let B is second part (r,n-1)
//  // whole array= AB
//  //1. reverse whole array
//  // whole array '=B'A'
//  //2. reverse part array A and B 
//  // seperately   (B')'(A')'=BA 
//  // complexity - time : O(n)  space : O(1)

// reverse(arr,0,n-1);
// reverse(arr,0,k-1);
// reverse(arr,k,n-1);

// }


// public static void sumofArray(int []arr1,int []arr2)
// {
//     int n=arr1.length;
//     int m=arr2.length;
//     int []ans=new int[Math.max(n,m)];

//     reverse(arr1,0,n-1);
//     reverse(arr2,0,m-1);
//     int i=0,j=0;
//     int carry=0,k=0;
//     while(i<n&&j<m)
//     {
//         int sum=(arr1[i]+arr2[j]+carry);
//          carry=sum/10;
//           ans[k]=sum%10;
//          i++;
//          j++;
//          k++;
//     }
//     while(i<n)
//     {
//         int sum=arr1[i]+carry;
//         carry=sum/10;
//         ans[k]=sum%10;
//         i++;
//         k++;
//     }
//     while(j<m)
//     {
//         int sum=arr2[j]+carry;
//         carry=sum/10;
//         ans[k]=sum%10;
//         j++;
//         k++;

//     }

//     reverse(ans,0,ans.length-1);
//     if(carry==1)
//     {
//         System.out.print(1+" ");
       
//     }
//      for( k=0;k<ans.length;k++)
//         {
//             System.out.print(ans[k]+" ");
//         }


// }

// public static void subtractArr(int []arr1,int []arr2)
// {
//     int n=arr1.length;
//     int m=arr2.length;
//     int []ans=new int[Math.max(n,m)];

//     int i=n-1,j=m-1,k=Math.max(n,m)-1;
// int borrow=0;
//     while(i>=0&&j>=0)
//     {
//       int subt=arr1[i]-arr2[j]-borrow;
//       if(subt<0)
//       {
//           borrow=1;
//           subt+=10;
//       }   
//       ans[k]=subt;
//       k--;
//       i--;
//       j--;

//     }
//     while(i>=0)
//     {
//         int subt=arr1[i]-borrow;
//         if(subt<0)
//         {
//             subt+=10;
//             borrow=1;
//         }
//         ans[k]=subt;
//         k--;
//         i--;
//     }
//     while(j>=0)
//     {
//         int subt=arr2[j]-borrow;
//         if(subt<0)
//         {
//             subt+=10;
//             borrow=1;
//         }
//         ans[k]=subt;
//         k--;
//         j--;
//     }
    
//     for( i=0;i<ans.length;i++)
//     {
//          System.out.print(ans[i]+" ");
//     }

// }
  
// public static int[] digitSct(long n)
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


//     public static void main(String[] args) {
//        long n = scn.nextLong();
//         int []query=new int[scn.nextInt()];
//         for(int i=0;i<query.length;i++)
//         {
//             query[i]=scn.nextInt();
//         }
//      int []freq=digitSct(n);
// for(int i=0;i<query.length;i++)
// {
//     System.out.print(frqQuery(freq,query[i])+" ");
// }

//     }
// }