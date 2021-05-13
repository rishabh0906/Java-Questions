import java.util.*;

public class string
{

public static Scanner scn=new Scanner(System.in);

public static boolean pallindrome(String str,int si,int ei)
{
int i=si,j=ei;
while(i<=j)
{
    if(str.charAt(i)!=str.charAt(j))
    {
       return false;
    }
    i++;
    j--;
}

return true;

}

public static void palliSub(String str)
{

    for(int i=0;i<str.length();i++)
    {
        for(int j=i;j<str.length();j++)
        {
            
            if(pallindrome(str,i,j)==true)
            {
                String temp=str.substring(i,j+1);         //substring function take O(n) time in worst case 
                System.out.println(temp);                 //  So it's recommend to minimise its use
            }
        }
    }
}


public static void compression1(String str)
{
    // String res="";
    // for(int i=0;i<str.length()-1;i++)
    // {
    //  if(str.charAt(i)!=str.charAt(i+1))
    //  {                                                           //messy code and long code
    //      res+=str.charAt(i);
    //  }
    // }
    // res+=str.charAt(str.length()-1);
    // System.out.println(res);
int n=str.length();
    String res=str.charAt(0)+"";
    int i=1;
    while(i<n)
    {
           while(i<n&&res.charAt(res.length()-1)==str.charAt(i))               //short code 
               i++;
           
           if(i<n)
               res+=str.charAt(i);
           i++;
    }
    System.out.println(res);
    
}


public static void compression2(String str)
{
    int count=1;
    String res="";
    for(int i=0;i<str.length()-1;i++)
    {
        if(str.charAt(i)==str.charAt(i+1))
        {
            count++;
        }
        else
        { 
            if(count>1)
            {
            res+=str.charAt(i)+""+count;
            }
            else
            {
                res+=str.charAt(i);
            }
            count=1;

        }
    }
    if(count>1)
    {
    res+=str.charAt(str.length()-1)+""+count;
    }
    else
    {
        res+=str.charAt(str.length()-1);
    }
    System.out.println(res);
}


public static int counthi(String str)
{
    int count=0;
    int i=0;
    
    while(i<str.length()-1)
    {
               if(str.charAt(i)=='h'&&str.charAt(i+1)=='i')
               {
                   count++;
                   i+=2;
               }
               else{
                  
                   i++;
               }
    }
    return count;
}

public static int counthit(String str)
{
     int count=0;
    int i=0;
    while(i<str.length()-2)
    {
               if(str.charAt(i)=='h'&&str.charAt(i+1)=='i'&&str.charAt(i+2)=='t')
               {
                   count++;
                   i+=3;
               }
               else{
                   i++;
               }
    }
    return count;
}

public static void hiwtohit(String str)
{
    int count1=counthi(str);
    int count2=counthit(str);
    System.out.println(count1-count2);
}

public static void removehi(String str)
{
       int i=0;
    String res="";
    while(i<str.length()-1)
    {
               if(str.charAt(i)=='h'&&str.charAt(i+1)=='i')
               {
                   
                   i+=2;
               }
               else{
                  res+=str.charAt(i);
                   i++;
               }
    }
    System.out.println(res);
    
}
public static void StringBasic()
{
    StringBuilder sb=new StringBuilder();
    sb.append("a");
    sb.append("bcd");

    sb.setCharAt(2,'q');
    System.out.println(sb.toString());
}

public static char toggle(char c)
{
      if(c>='a'&&c<='z')
      {
          int diff=c-'a';
          return (char)(diff+'A');
      }
      
          int diff=c-'A';
          return (char)(diff+'a');
      
}

public static void toggleCase(String str)
{
    StringBuilder sb=new StringBuilder(str);

    for(int i=0;i<sb.length();i++)
    {
        char c=toggle(sb.charAt(i));
        sb.setCharAt(i,c);
    }
    System.out.println(sb.toString());
}
public static void diffString(String str)
{
    StringBuilder sb=new StringBuilder(str);
 StringBuilder res=new StringBuilder();
    for(int i=0;i<sb.length()-1;i++)
    {
             char fi=sb.charAt(i);
             char si=sb.charAt(i+1);
             int diff=si-fi;
             res.append(fi);
             res.append(diff);

    }
   res.append(sb.charAt(sb.length()-1));
    System.out.println(res.toString());
}

public static void main( String []args)
{
String str=scn.nextLine();
diffString(str);
}

}