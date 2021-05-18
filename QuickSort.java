import java.util.*;

public class QuickSort{

public static void swap(int []arr,int i,int j)
{
    int temp=arr[i];
    arr[i]=arr[j];
    arr[j]=temp;
}

public static int partitionOnPivot(int []arr,int si,int ei,int pvt)
{
    swap(arr,pvt,ei);

int p=si-1;
int itr=si;
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
        return ;
    }
    
    int pvtInd=ei;
    int p=partitionOnPivot(arr,si,ei,pvtInd);

    quickSort(arr,si,p-1);
    quickSort(arr,p+1,ei);

}


//Kth largest element  in < O(nlog(n))    Approach : binary Search + QuickSort Technique

public static int quickSelect(int []arr,int si,int ei,int k)   
{
    if(si>ei)
    {
        return -1;
    }

    int p=partitionOnPivot(arr,si,ei,ei);

    if(p==arr.length-k)
    {
        return  arr[p];
    }
    else if(p<arr.length-k)
    {
        return quickSelect(arr,p+1,ei,k);
    }
    
    return    quickSelect(arr,si,p-1,k);
    

  
}

public static void main(String[]args )
{

int []arr={30,-43,-54,3,45,0,1,-6,45,-43,45,45,-65,12,-90};
int n=arr.length;

System.out.println(quickSelect(arr,0,n-1,9));
quickSort(arr,0,n-1);
for(int i=0;i<n;i++)
{
    System.out.print(arr[i]+" ");
}

}

}