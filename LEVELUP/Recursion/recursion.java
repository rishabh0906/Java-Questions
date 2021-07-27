import java.util.*;

public class recursion {

  public static void pppppp(int a) {
    System.out.println("I am Base case: " + a);
    return;
  }

  public static void ppppp(int a) {
    System.out.println("hi: " + a);
    pppppp(a + 1);
    System.out.println("Bye: " + a);
  }

  public static void pppp(int a) {
    System.out.println("hi: " + a);
    ppppp(a + 1);
    System.out.println("Bye: " + a);
  }

  public static void ppp(int a) {
    System.out.println("hi: " + a);
    pppp(a + 1);
    System.out.println("Bye: " + a);
  }

  public static void pp(int a) {
    System.out.println("hi: " + a);
    ppp(a + 1);
    System.out.println("Bye: " + a);
  }

  public static void p(int a) {
    System.out.println("hi: " + a);
    pp(a + 1);
    System.out.println("Bye: " + a);
  }

  public static void recursionPattern(int a, int b) {
    if (a == b) {
      System.out.println("I am Base case: " + a);
      return;
    }

    System.out.println("Hi" + a);
    recursionPattern(a + 1, b);
    System.out.println("Bye" + a);
  }

  public static void printIncreasing(int a, int b) {
    if (a == b) {
      System.out.print(a);
      return;
    }
    System.out.print(a + " ");
    printIncreasing(a + 1, b);
  }

  public static void printDecreasing(int a, int b) {
    if (a == b) {
      System.out.print(a + " ");
      return;
    }
    printDecreasing(a + 1, b);
    System.out.print(a + " ");
  }

  public static void printIncreasingDecreasing(int a, int b) {
    if (a == b) {
      System.out.print(a);
      return;
    }
    System.out.print(a + " ");
    printIncreasingDecreasing(a + 1, b);
    System.out.print(a + " ");
  }

  public static void oddEven(int a, int b) {
    if (a == b) {
      System.out.print(a + " ");
      return;
    }
    if (a % 2 == 1) {
      System.out.print(a + " ");
    }

    oddEven(a + 1, b);
    if (a % 2 == 0) {
      System.out.print(a + " ");
    }
  }

  public static int factorial(int n) {
    if (n <= 1) {
      return 1;
    }
    return n * factorial(n - 1);
  }

  public static int power(int a, int b) {
    if (b == 0) {
      return 1;
    }

    return a * power(a, b - 1);
  }

  // O(logn)
  public static int powerBtr(int a, int b) {
    if (b == 0) {
      return 1;
    }

    int res = powerBtr(a, b / 2);

    res *= res;

    return b % 2 == 1 ? (res * a) : res;
  }

  public static void printArray(int[] arr, int idx) {
    if (idx == arr.length) {
      return;
    }
    System.out.print(arr[idx] + " ");
    printArray(arr, idx + 1);
  }

  public static void printArrayReverse(int[] arr, int idx) {
    if (idx == arr.length) {
      return;
    }
    printArrayReverse(arr, idx + 1);
    System.out.print(arr[idx] + " ");
  }

  public static int maximum(int[] arr, int idx) {
    if (idx == arr.length) {
      return (int) -1e9;
    }

    int res = maximum(arr, idx + 1);

    return Math.max(res, arr[idx]);
  }

  public static int minimum(int[] arr, int idx) {
    if (idx == arr.length) {
      return (int) 1e9;
    }

    int res = minimum(arr, idx + 1);

    return Math.min(res, arr[idx]);
  }

  public static boolean find(int[] arr, int data, int idx) {
    if (idx == arr.length) {
      return false;
    }

    if (arr[idx] == data) {
      return true;
    }

    return find(arr, data, idx + 1);
  }

  public static int firstIndex(int[] arr, int data, int idx) {
    if (idx == arr.length) {
      return -1;
    }

    if (arr[idx] == data) {
      return idx;
    }

    return firstIndex(arr, data, idx + 1);
  }

  public static int lastIndex(int[] arr, int data, int idx) {
    if (idx == arr.length) {
      return -1;
    }

    int res = lastIndex(arr, data, idx + 1);

    if (res != -1) {
      return res;
    }

    if (arr[idx] == data) {
      return idx;
    }

    return -1;
  }

  public static int[] allIndex(int[] arr, int idx, int data, int count) {
    if (idx == arr.length) {
      int[] ans = new int[count];
      return ans;
    }

    if (arr[idx] == data) {
      count++;
    }
    int[] recAns = allIndex(arr, idx + 1, data, count);

    if (arr[idx] == data) {
      recAns[count - 1] = idx;
      count--;
    }

    return recAns;
  }

  public static ArrayList<String> subsequence(String str, int idx) {
    if (idx == str.length()) {
      ArrayList<String> base = new ArrayList<>();
      base.add("");
      return base;
    }

    ArrayList<String> ans1 = subsequence(str, idx + 1);
    ArrayList<String> recAns = new ArrayList<>(ans1);
    for (String subs : ans1) {
      recAns.add(str.charAt(idx) + subs);
    }
    return recAns;
  }

  public static int subsequence(
    String str,
    int idx,
    String psf,
    ArrayList<String> ans
  ) {
    if (idx == str.length()) {
      ans.add(psf);
      return 1;
    }

    int count = 0;
    count += subsequence(str, idx + 1, psf + str.charAt(idx), ans);
    count += subsequence(str, idx + 1, psf, ans);

    return count;
  }

  public static String[] nokiaKeys = {
    ".;",
    "abc",
    "def",
    "ghi",
    "jkl",
    "mno",
    "pqrs",
    "tu",
    "vwx",
    "yz",
  };

  public static int nokiaKeyPad(String str,int idx,String asf,ArrayList<String> ans) {
    if (idx == str.length()) {
      ans.add(asf);
      return 1;
    }

    int count = 0;

    char ch = str.charAt(idx);
    String map = nokiaKeys[ch - '0'];
    for (int i = 0; i < map.length(); i++) {
      count += nokiaKeyPad(str, idx + 1, asf + map.charAt(i), ans);
    }
    return count;
  }

  public static ArrayList<String> nokiaKeyPad2(String str,int idx)
  {
    if(idx==str.length())
    {
      ArrayList<String> ans=new ArrayList<>();
      ans.add("");
      return ans;
    }

    ArrayList<String> recAns=nokiaKeyPad2(str,idx+1);

    ArrayList<String> myAns=new ArrayList<>();
    String map=nokiaKeys[str.charAt(idx)-'0'];

    for(int i=0;i<map.length();i++)
    {
      for(String res:recAns)
       {
         myAns.add(map.charAt(i)+res);
       }
    }

    return myAns;

  }

   public static int stairPath(int n, String psf, ArrayList<String> ans) {

      if(n==0)
      {
         ans.add(psf);
        return 1;
      }


int count=0;
      for(int i=1;i<=3&&n-i>=0;i++)
      {
            count+=stairPath(n-i,psf+i,ans);
      }

      return count;

   }

   public static ArrayList<String> stairPath2(int n)
   {
                 if(n==0)
                 {
                   ArrayList<String> base=new ArrayList<>();
                   base.add("");
                   return base;
                 }
          
          ArrayList<String> ans=new ArrayList<>(); 
          for(int i=1;i<=3&&n-i>=0;i++)
          {
            ArrayList<String> recAns=stairPath2(n-i);

            for(String s:recAns)
            {
              ans.add(i+s);
            }

          }

          return ans;
   }

   public static int boardPath(int n, String psf, ArrayList<String> ans) {
         
         if(n==0)
         {
           ans.add(psf);
           return 1;
         }
    
        int count=0;
    for(int i=1;i<=6&&n-i>=0;i++)
    {
      count+=boardPath(n-i,psf+i,ans);
    }

    return count;

   }

   public static ArrayList<String> boardPath2(int n)
   {
     if(n==0)
     {
       ArrayList<String> base=new ArrayList<>();
       base.add("");
       return base;
     }

           ArrayList<String> ans=new ArrayList<>();
     for(int i=1;i<=6&&n-i>=0;i++)
     {
        ArrayList<String> recAns= boardPath2(n-i);

        for(String s:recAns)
        {
           ans.add(i+s);
        }
     }

     return ans;
   }

   public static int boardPath(int[] arr, int n, String asf,ArrayList<String> ans) {
            
            if(n==0)
            {
              ans.add(asf);
                return 1;
            }
           
           int count=0;
            for(int i=0;i<arr.length;i++)
            {
              if(n-arr[i]>=0)
              {
                  count+=boardPath(arr,n-arr[i],asf+arr[i],ans);
              }
            }

            return count;
     
   }

  public static int mazePath_HVD(int sr,int sc,int er,int ec,String psf,ArrayList<String> ans) {

            if(sr==er&&sc==ec)
            {
              ans.add(psf);
              return 1;
            }

            int count=0;
          if(sr+1<=er)
          {
            count+=mazePath_HVD(sr+1,sc,er,ec,psf+"V",ans);
          }

          if(sc+1<=ec)
          {
            count+=mazePath_HVD(sr,sc+1,er,ec,psf+"H",ans);
          }
          if(sr+1<=er&&sc+1<=ec)
          {
            count+=mazePath_HVD(sr+1,sc+1,er,ec,psf+"D",ans);
          }

          return count;
  }

  public static int mazePath_HVD_multi(int sr,int sc,int er,int ec,String psf,ArrayList<String> ans) {
            if(sr==er&&sc==ec)
            {
              ans.add(psf);
              return 1;
            }

            int count=0;

            for(int i=1;sr+i<=er;i++)
                count+=mazePath_HVD_multi(sr+i,sc,er,ec,psf+i+"V",ans);

           for(int i=1;sc+i<=ec;i++)
            count+=mazePath_HVD_multi(sr,sc+i,er,ec,psf+i+"H",ans);
  
          for(int i=1;sr+i<=er&&sc+i<=ec;i++)
            count+=mazePath_HVD_multi(sr+i,sc+i,er,ec,psf+i+"D",ans);
          

          return count;

  }


   public static int mazePath_HVD_multi(int sr, int sc, int er, int ec, String psf, ArrayList<String> ans, int[][] dir,
            String[] dirS) {
        if (sr == er && sc == ec) {
            ans.add(psf);
            return 1;
        }

        int count = 0;
        for (int d = 0; d < dir.length; d++) {
            for (int rad = 1; rad <= Math.max(er, ec); rad++) {
                int r = sr + rad * dir[d][0];
                int c = sc + rad * dir[d][1];

                if (r >= 0 && c >= 0 && r <= er && c <= ec) {
                    count += mazePath_HVD_multi(r, c, er, ec, psf + dirS[d] + rad, ans, dir, dirS);
                } else
                    break;
            }
        }

        return count;
    }

    public static void mazePath() {
        int[][] dir = { { 0, 1 }, { 1, 0 }, { 1, 1 } };
        String[] dirS = { "H", "V", "D" };

        ArrayList<String> ans = new ArrayList<>();
        System.out.println(mazePath_HVD_multi(0, 0, 2, 2, "", ans, dir, dirS));

        System.out.println(ans);
    }

  public static void main(String[] args) {
    int[] arr = { 2, 3, 4, 6, 3, 4, 5, 1 };
    // printIncreasing(1,10);
    // System.out.println();
    // printDecreasing(1,10);
    // System.out.println();
    // printIncreasingDecreasing(1,10);
    // System.out.println();
    //  oddEven(1,10);
    // System.out.println();
    // printArray(arr,0);
    // System.out.println();
    // printArrayReverse(arr,0);
    // System.out.println();

    // System.out.println(maximum(arr,0));

    // System.out.println( minimum(arr,0));

    // System.out.println( find(arr,5,0));

    // System.out.println();

    // System.out.println(firstIndex(arr,4,0));

    // System.out.println(  lastIndex(arr,5,0));
    // System.out.println(power(2,5));
    // System.out.println(factorial(10));
    //         System.out.print(powerBtr(3,9));

    // int []ans=allIndex(arr,0,5,0);
    // System.out.println(ans.length);
    // for(int i=0;i<ans.length;i++)
    // {
    //     System.out.println(ans[i]);
    // }
  
    // int count = subsequence("abc", 0, "", ans);

    //  ArrayList<String> ans  = nokiaKeyPad2("435",0);
    // System.out.print(ans );

    ArrayList<String> ans=new ArrayList<>();

   int count= mazePath_HVD_multi(1,1,5,5,"",ans);
    System.out.println(ans +""+ count);

    
  }
}
