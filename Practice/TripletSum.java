import java.util.*;

public class TripletSum
{

public static void swap(int []arr,int i,int j)
{
    int temp=arr[i];
    arr[i]=arr[j];
    arr[j]=temp;
}

public static int partition(int []arr,int si,int ei,int pvt)
{
    swap(arr,pvt,ei);
    int p=si-1;
   int itr=si;
    while(itr<=ei)
    {
        if(arr[itr]<=arr[ei])
        {
            swap(arr,itr,++p);
        }
        itr++;
    }

    return p;
}

public static void quicksort(int []arr,int si,int ei)
{
    if(si>ei)
    {
        return ;
    }
    int p=partition(arr,si,ei,ei);

    quicksort(arr,si,p-1);
    quicksort(arr,p+1,ei);
}

public static void pairSum(int []arr,int si,int ei,int target,int a,ArrayList<int[]> ans)
{
    int l=si;
    int r=ei;
     while(l<r)
    {
        if(arr[l]+arr[r]==target)
        {

                ans.add(new int[]{a,arr[l],arr[r]});                        
            l++;
            r--;
            
        }
        else if(arr[l]+arr[r]<target)
        {
            l++;
        }
        else{
            r--;
        }
    }
}

public static void Triplesum(int []arr,int target)
{
    quicksort(arr,0,arr.length-1);
ArrayList<int[]> ans=new ArrayList<>();
for(int i=0;i<arr.length;i++)
{
    int l=i+1;
    int r=arr.length-1;
    pairSum(arr,l,r,target-arr[i],arr[i],ans);

}

for(int[] a: ans)
{
    System.out.println(a[0]+","+a[1]+","+a[2]);
}

}

public static void main(String[]args)
{

int []arr={-2,-3,7,5,8,15,3,2,9,10,19};

Triplesum(arr,25);
for(int i=0;i<arr.length;i++)
{
    System.out.print(arr[i]+" ");
}

}

}