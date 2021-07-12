import java.util.*;

public class hashmap_basic{


public static void freqMap(String str)
{

HashMap<Character,Integer> mp=new HashMap<>();

for(int i=0;i<str.length();i++)
{
    char ch=str.charAt(i);
    if(mp.containsKey(ch))
    {
        mp.put(ch,mp.get(ch)+1);
    }
    else
    {
        mp.put(ch,1);
    }
}

for(char ch:mp.keySet())
{
    System.out.println(ch+"->"+mp.get(ch));
}

}

public static void freqMap2(String str)
{
    HashMap<Character,ArrayList<Integer>> mp=new HashMap<>();
    for(int i=0;i<str.length();i++)
{
    char ch=str.charAt(i);
    if(mp.containsKey(ch))
    {
        ArrayList<Integer> arr= mp.get(ch);
        arr.add(i);
        mp.put(ch,arr);
    }
    else
    {
        ArrayList<Integer> arr=new ArrayList<>();
        arr.add(i);
        mp.put(ch,arr);
    }
}

for(char ch:mp.keySet())
{
    System.out.println(ch+"->"+mp.get(ch));
}


}

public static void FindIntersection(int []a,int n,int []b,int m)
{
    
    HashMap<Integer,Integer> mp=new HashMap<>();
    
    for(int i=0;i<n;i++)
    {
        if(mp.containsKey(a[i]))
        {
            continue;
        }
        mp.put(a[i],1);
    }
    
    for(int i=0;i<m;i++)
    {
        if(mp.containsKey(b[i])&&mp.get(b[i])==1)
        {
            System.out.println(b[i]);
            mp.put(b[i],0);
        }
    }
}


 public static void findIntersection2(int []arr1,int []arr2)
    {
        HashMap<Integer,Integer> mp=new HashMap<>();
        
        for(int i=0;i<arr1.length;i++)
        {
            if(!mp.containsKey(arr1[i]))
              mp.put(arr1[i],0);
              
            mp.put(arr1[i],mp.get(arr1[i])+1);
        }
        
        for(int i=0;i<arr2.length;i++)
        {
            if(mp.containsKey(arr2[i])&&mp.get(arr2[i])>0)
            {
                System.out.println(arr2[i]);
                mp.put(arr2[i],mp.get(arr2[i])-1);
            }
        }
    }


    public static void longestConsecutiveChain(int []arr,int n)
    {
         HashMap<Integer,Integer> mp= new HashMap<>();
    
    for(int i=0;i<n;i++)
    {
        if(mp.containsKey(arr[i]))
        {
            continue;
        }
        
        mp.put(arr[i],i);
    }
    
    int maxLen=0;
    int start=-1;
    for(int i=0;i<n;i++)
    {
        if(mp.containsKey(arr[i]))
        {
            int length=1;
            int ele=arr[i];
            int left=ele-1;
            int right=ele+1;
            int prev=i;
            
            while(mp.containsKey(left))
            {
                prev=mp.get(left);
               
                length++;
                mp.remove(left);
                 left--;
            }
            
            while(mp.containsKey(right))
            {
              
                length++;
                mp.remove(right);
                right++;
            }
            
            if(length>maxLen)
            {
                maxLen=length;
                start=prev;
            }
            else if(length==maxLen)
            {
                if(prev<start)
                {
                    start=prev;
                }
            }
            
            
        }
    }
    int ele=arr[start];
    for(int i=0;i<maxLen;i++)
    {
        System.out.println(ele++);
    }
    
    }

public static void main(String []args)
{
    freqMap("aseadjkhlrywiuhfsdlfhafljadladladal");
freqMap2("aseadjkhlrywiuhfsdlfhafljadladladal");
}


}