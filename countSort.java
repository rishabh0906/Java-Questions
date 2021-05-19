import java.util.*;

public class countSort
{

    //Generic countSort //
      public static int[] countSortwithneg(int []arr)
      {
          int mn=(int) 1e9;
          int mx=(int) -1e9;
           
           for(int ele:arr)
           {
               mx=Math.max(mx,ele);
               mn=Math.min(mn,ele);
           }
   
            int range=mx-mn+1;
           int []freq=new int[range];

           for(int ele:arr)
           {
               freq[-mn+ele]++;
           }
         int k=0;
           for(int i=0;i<range;i++)
           {
               for(int j=0;j<freq[i];j++)
               {
                   arr[k++]=i+mn;
               }
           }
        return arr;

      }


      public static int[] countsort(int []arr)
      {
          int maxele=0;
          for(int ele:arr)
          {
                if(ele>maxele)
                {
                    maxele=ele;
                }
          }

          int []frequency=new int[maxele+1];

          for(int ele:arr)
          {
              frequency[ele]++;
          }
int k=0;
          for(int i=0;i<=maxele;i++)
          {
              for(int j=0;j<frequency[i];j++)
              {
                  arr[k++]=i;
              }
          }

          return arr;
      }
          
          public static int[][] StableCountSort(int [][]mat)
          {
              
              int maxele=0;
              for(int []arr:mat)
              {
                  maxele=Math.max(maxele,arr[0]);
              }

              int []freq=new int[maxele+1];

              for(int []arr:mat)
              {
                  freq[arr[0]]++;
              }

              for(int i=1;i<=maxele;i++)
              {
                   freq[i]+=freq[i-1];
              }
              int [][]ans=new int[mat.length][2];
              for(int i=mat.length-1;i>=0;i--)
              {
                     int ele=mat[i][0];
                     ans[freq[ele]-1][0]=ele;
                     ans[freq[ele]-1][1]=mat[i][1];
                     freq[ele]--;
              
              }
              return ans;


          }

    public static void main(String []args)
    {
                //    int []arr={1,4,5,3,5,4,6,7,6,6,9,10,4,7,5,4,3,2};
                //    arr=countSortwithneg(arr);
                //    for(int ele:arr)
                //    {
                //        System.out.print(ele+" ");
                //    }

              int [][]mat={{1,2},{4,5},{1,5},{6,7},{4,3},{5,7},{3,5},{2,4},{3,6},{6,1},{1,6}};
              mat=StableCountSort(mat);
              for(int []a:mat)
              {
                  System.out.println(a[0]+","+a[1]);
              }


    }
}