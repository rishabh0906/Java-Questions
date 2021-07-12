import java.util.*;
public class priority_queue{


public static void Int_minPQ() {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // by default min Priority Queue
        for (int i = 10; i >= 1; i--)
            pq.add(i * 10);

        while (pq.size() != 0)
            System.out.println(pq.remove());
    }

public static void Int_maxPQ() {
        // this - other, default behaviour.
        // other - this, reverse of default behaviour.
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            return b - a;
        });

        for (int i = 10; i >= 1; i--)
            pq.add(i * 10);

        while (pq.size() != 0)
            System.out.println(pq.remove());
    }

public static void matrixPQ(int[][] arr) {  
   PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
      return a[1]-b[1];
   });
      for(int []a:arr)
           pq.add(a);

       while(pq.size()!=0)
       {
           int []a=pq.remove();
           for(int i=0;i<a.length;i++)
           {
               System.out.print(a[i]+" ");
           }
           System.out.println();
       }    
  

    }

public static class mobilePhone {
        String Company = "";
        String Model = "";
        int Ram = 0;
        int Storage = 0;
        int BatteryBackup = 0;

        mobilePhone(String Company, String Model, int Ram, int Storage, int BatteryBackup) {
            this.Company = Company;
            this.Model = Model;
            this.Ram = Ram;
            this.Storage = Storage;
            this.BatteryBackup = BatteryBackup;
        }

        mobilePhone(){

        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            
            sb.append("Company: " + this.Company + "\n");
            sb.append("Model: " + this.Model + "\n");
            sb.append("Ram: " + this.Ram + "GB\n");
            sb.append("Storage: " + this.Storage + "GB\n");
            sb.append("BatteryBackup: " + this.BatteryBackup + "mAH\n");
            
            return sb.toString();
        }
    }
public static void mobilePhoneComp(mobilePhone []arr){
            PriorityQueue<mobilePhone> pq=new PriorityQueue<>((a,b)->{
                           if(a.Ram==b.Ram){
                               if(a.Storage==b.Storage){
                                   return b.BatteryBackup-a.BatteryBackup;
                                 }
                               return b.Storage-a.Storage;
                            }
                            return b.Ram-a.Ram;
            });

            for(int i=0;i<arr.length;i++)
            {
                pq.add(arr[i]);
            }

            while(pq.size()!=0)
            {
                System.out.println(pq.remove());
            }
        }

public static class pair{

 int val;
 int row;
 int col;

 pair(int val,int row,int col)
 {
    this.val=val;
    this.row=row;
    this.col=col;
 }

 }

public static void MergeK_Sorted(int [][]arr){
   int n=arr.length;
   int m= arr[0].length;
 PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->{
   return a.val-b.val;
   });
   for(int i=0;i<n;i++)
   {
       pq.add(new pair(arr[i][0],i,0));
   }

   while(pq.size()!=0)
   {

       pair top=pq.remove();
       System.out.print(top.val);

       if(top.col+1<m)
       {
        pq.add(new pair(arr[top.row][top.col+1],top.row,top.col+1));
       }
   }

 }
// Quite Complex for different size lists
 public static void MergeK_Sorted2(int [][]arr)
 {
   int n=arr.length;
   int m= arr[0].length;
 PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->{
        return arr[a/m][a%m]-arr[b/m][b%m];
   });
   for(int i=0;i<n;i++)
   {
       pq.add(i*m+0);
   }

   while(pq.size()!=0)
   {

       Integer top=pq.remove();
       System.out.print(arr[top/m][top%m]);

       if(top%m+1<m)
       {
        pq.add((top/m)*m+top%m+1);
       }
   }

 }

public static void main(String []args) {
 //Int_maxPQ();
 //  Int_minPQ();

 // int [][]arr={{2,8,5,6},
 //              {3,4,1,2},
 //              {1,0,2,3},
 //               {1,2,3,4}};

 //  matrixPQ(arr);

 mobilePhone []arr= new mobilePhone[6];
      arr[0]=new mobilePhone("Samsung","A72",6,128,5000);
     arr[1]=new mobilePhone("Samsung","M51",6,128,7000);
     arr[2]=new mobilePhone("OnePlus","Glacial Green",8,128,4300);
      arr[3]=new mobilePhone("OnePlus","NordN10",6,128,4300);
    arr[4]=new mobilePhone("iPhone11","S",8,64,4000);
   arr[5]=new mobilePhone("iphone12","Max",6,128,5000);
   mobilePhoneComp(arr);
   

 }


}