import java.util.*;

public class TargetSum{


public static void swap(int []arr,int i,int j)
{
    int temp=arr[i];
    arr[i]=arr[j];
    arr[j]=temp;
}

public static int partition(int []arr,int si,int ei,int idx)
{
    swap(arr,ei,idx);

    int itr=si;
    int p=si-1;
    while(itr<=ei)
    {
        if(arr[itr]<=arr[ei])
        {
            swap(arr,++p,itr);
        }
        itr++;
    }

    return p;
}

public static void quickSort(int []arr,int si,int ei)
{
    if(si>ei)
    {
        return;
    }
int p=partition(arr,si,ei,ei);

quickSort(arr,si,p-1);
quickSort(arr,p+1,ei);

}

    // time  O(nlong(n))
public static void TargetPairSum(int []arr,int sum)
{
  
// Arrays.sort(arr);     
quickSort(arr,0,arr.length-1);
    
    int l=0;
    int r=arr.length-1;
    while(l<=r)
    {
             

             if(arr[l]+arr[r]==sum)
             {
                 System.out.println(arr[l]+","+arr[r]);
                 l++;
                 r--;
             }
             else if(arr[l]+arr[r]>sum)
             {
                 r--;
             }
             else{
                 l++;
             }
    }
}



public static void main(String[]args)
{
    int []B={4,5,6,7,8,9,10,11};
    TargetPairSum(B,13);
}

}