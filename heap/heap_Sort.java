import java.util.*;

public class heap_Sort{


public static int[] heapSort(int []arr,boolean inc) throws Exception{
  heap pq=new heap(arr,inc);

int n=arr.length;
 for(int i=n-1;i>=0;i--)
 {
     arr[i]=pq.remove();
 }

 return arr;

}

public static  void main(String []args) throws Exception{

int []arr={5,34,342,21,23,23,43,23,432,32,21,-2,3,-9};

heapSort(arr,false);
for(int ele:arr)
{
    System.out.print(ele+" ");
}

}


}