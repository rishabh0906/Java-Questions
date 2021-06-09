import java.util.*;

public class MergeSort
{

public static int[] mergetwoSortedArrays(int []arr1,int []arr2)
{

    if(arr1.length==0||arr2.length==0)
    {
        return arr1.length==0?arr2:arr1;
    }
    int n=arr1.length;
    int m=arr2.length;
    int []temp=new int[n+m];

    int k=0;
    int i=0;
    int j=0;

    while(i<n&&j<m)
    {
        if(arr1[i]>arr2[j])
        {
            temp[k++]=arr2[j];
            j++;
        }
        else
        {
            temp[k++]=arr1[i];
            i++;
        }
    }

    while(i<n)
    {
        temp[k++]=arr1[i];
        i++;
    }
    while(j<m)
    {
        temp[k++]=arr2[j];
        j++;
    }

    return temp;
}

public static int[] mergesort(int []arr,int l,int r)
{
    if(l==r)
    {
        return new int[] {arr[l]};
    }

    int mid=(l+r)/2;
    int []left=mergesort(arr,l,mid);
    int []right=mergesort(arr,mid+1,r);
    int []mergedArray=mergetwoSortedArrays(left,right);

    return mergedArray;

   
}


public static void main(String []args)
{
    int []arr={13,54,67,-6,45,-3,24,76,-76,23,-76,35,-10};
    //-76 -76 -10 -6 -3 13 23 24 35 45 54 67 76 
    int n=arr.length;
     arr=mergesort(arr,0,n-1);

     for(int i=0;i<n;i++)
     {
         System.out.print(arr[i]+" ");
     }
}


}