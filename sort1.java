import java.util.*;

public class sort1
{
    public Scanner scn=new Scanner(System.in);

  public static void swap(int []arr,int x,int y)
  {
      int temp=arr[x];
      arr[x]=arr[y];
      arr[y]=temp;
  }
public static void sort01(int []arr)
   {
     
     int low=0;
     for(int i=0;i<arr.length;i++)
     {
         if(arr[i]==0)
         {
             swap(arr,i,low);
             low++;
            
         }
     }
   }
   public static void sort012(int []arr)
   {

    int i=0;
    int low=-1;
    int high=arr.length;
    while(i<high)
    {
        if(arr[i]==0)
        {
            swap(arr,++low,i);
        }
        else if(arr[i]==2)
        {
            swap(arr,--high,i);
           continue;
        }
        i++;
    }

   }
   public static int [] mergeSorted(int []A,int []B)
   {
       int i=0,j=0;
       int []res=new int[A.length+B.length];
       int k=0;
       while(i<A.length&&j<B.length)
       {
           if(A[i]<B[j])
           {
               res[k++]=A[i];
               i++;
           }
           else{
               res[k++]=B[j];
               j++;
           }
       }
       while(i<A.length)
       {
           res[k++]=A[i++];
       }
       while(j<B.length)
       {
           res[k++]=B[j++];
       }
       return res;
   }
public static void BubbleSort(int []arr)
{
    
    int n=arr.length;
    for(int l=n-1;l>=0;l--)
    {
        boolean swap=false;
        for(int i=1;i<=l;i++)
        {
            if(arr[i]<arr[i-1])
            {
                swap(arr,i,i-1);
                swap=true;
            }
          
        }
        if(!swap)
        {
            break;
        }
       
    }
    for(int i=0;i<n;i++)
    {
        System.out.print(arr[i]+" ");
    }

}

public static void SelectionSort(int []arr)
{
    for(int i=0;i<arr.length;i++)
    {
        for(int j=i+1;j<arr.length;j++)
        {
            if(arr[j]<arr[i])
            {
                swap(arr,i,j);
            }
        }
    }
}
public static void InsertionSort(int []arr)
{
    for(int i=0;i<arr.length;i++)
    {
        int j=i;
        while(j>0&&arr[j-1]>arr[j])
        {
              swap(arr,j-1,j);
              j--;
        }
    }

}

public  static void partitionArray(int []arr,int data)
{
    int pivot=0;
    for(int i=0;i<arr.length;i++)
    {
        if(arr[i]<=data)
        {
            swap(arr,pivot,i);
            pivot++;
        }
    }

}
public static void partitionArray2(int []arr,int idx)
{
    int pivot=arr[idx];
    int n=arr.length;
  swap(arr,idx,n-1);
  int ptr=0;
  for(int i=0;i<n-1;i++)
  {
      if(arr[i]<=pivot)
      {
          swap(arr,ptr,i);
          ptr++;
      }
  }
  swap(arr,ptr,n-1);
  
}
 public static void main(String []args)
    {
     int []arr={454,54,34,21,34,21,32,45};
    //  sort012(arr);
    //  for(int i=0;i<arr.length;i++)
    //  {
    //     System.out.print(arr[i]+" ");
    //  }
  
//   int []A={1,2,3,4,5,6};
//   int []B={4,5,6,7,8,9,10,11};
//   int []res=mergeSorted(A,arr);
//   for(int i=0;i<res.length;i++)
//   {
//       System.out.print(res[i]+" ");
//   }
partitionArray2(arr,6);
for(int i=0;i<arr.length;i++)
{
    System.out.print(arr[i]+" ");
}

    }
}